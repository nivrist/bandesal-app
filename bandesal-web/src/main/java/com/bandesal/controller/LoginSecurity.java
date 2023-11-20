/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bandesal.controller;

import com.bandesal.dto.DataDetail;
import com.bandesal.dto.RequestBlogReader;
import com.bandesal.dto.RequestBlogs;
import com.bandesal.dto.RequestReaders;
import com.bandesal.dto.ResponseServicesData;
import com.bandesal.entities.BandesalBlogs;
import com.bandesal.entities.BandesalBlogsReaders;
import com.bandesal.entities.BandesalBlogsReadersId;
import com.bandesal.entities.BandesalReaders;
import com.bandesal.utils.Utils;
import ejb.BandesalBlogsFacadeLocal;
import ejb.BandesalBlogsReadersFacadeLocal;
import ejb.BandesalReadersFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.security.core.session.SessionRegistry;

/**
 *
 * @author irvin_monterroza
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Named(value = "loginSecurity")
@SessionScoped
public class LoginSecurity extends Utils implements Serializable {

    @EJB
    private BandesalBlogsReadersFacadeLocal bandesalBlogsReadersFacade;

    @EJB
    private BandesalReadersFacadeLocal bandesalReadersFacade;

    @EJB
    private BandesalBlogsFacadeLocal bandesalBlogsFacade;
    
    
    

    /**
     * Creates a new instance of LoginSecurity
     */
    private String formUser;
    private String formPassword;
    private String readers_name;

    @PostConstruct
    public void init() {
        clearReaders();
        clearBlogs();
        clearBlogsReaders();
    }

    public LoginSecurity() {
    }

    public String ingresar() {

        try {

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
            dispatcher.forward(request, response);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException | ServletException e) {

        }
        return null;
    }
    private SessionRegistry sessionRegistry;

    public void logOut() {
        try {

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/logout");
            dispatcher.forward(request, response);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (ServletException | IOException ex) {
        }

    }

    private ResponseServicesData responseServicesDataReaders;
    private DataDetail selectionReaders;

    public String saveReaders() {
        String verbo = "POST";
        int pk = (selectionReaders.getId() == 0 ? 0 : selectionReaders.getId());
        RequestReaders request = RequestReaders.builder()
                .name(readers_name)
                .id(pk)
                .build();
        ResponseServicesData map = requestJson(getBaseUrl() + "/api/save-readers", verbo, request, RequestReaders.class);
        if (map.isSuccess()) {
            addSimpleMessages(map.getMessage());
            clearReaders();
        } else {
            addSimpleMessagesError(map.getMessage());
        }

        return null;
    }
    
    
     public String eliminarReaders() {
        try {
            
            if(selectionReaders.getId()==0){
                addSimpleMessagesError("Debe de seleccionar un regsitro.");
                return null;
            }
            
            BandesalReaders reader = new BandesalReaders();
            reader = bandesalReadersFacade.find(selectionReaders.getId());
            bandesalReadersFacade.remove(reader);
            addSimpleMessages("Reader eliminado con exito.");
            clearReaders();
        } catch (EJBException ex) {
            addSimpleMessagesError("Se genero un error al intentar eliminar el registro , verifique que el registro no tengo ninguna relaciona antes de eliminar");
        } catch(Exception ex){
            addSimpleMessagesError("Se genero un error al intentar eliminar el registro");
        }

        return null;
    }
    

    public String clearReaders() {
        try {
            readers_name = "";
            selectionReaders = new DataDetail();
            responseServicesDataReaders = new ResponseServicesData();
            String verbo = "GET";
            responseServicesDataReaders = requestJson(getBaseUrl() + "/api/all-readers", verbo, null, Object.class);
            clearBlogsReaders();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String loadReadersTable() {
        readers_name = selectionReaders.getName();
        return null;
    }

    private ResponseServicesData responseServicesDataBlogs;
    private DataDetail selectionBlogs;
    private String title;
    private String description;
    private String descriptionBySelection;

    public String saveBlogs() {
        String verbo = "POST";
        int pk = (selectionBlogs.getId() == 0 ? 0 : (selectionBlogs.getId()));
        RequestBlogs request = RequestBlogs.builder()
                .title(title)
                .id(pk)
                .description(description)
                .build();

        ResponseServicesData map = requestJson(getBaseUrl() + "/api/save-blog", verbo, request, RequestBlogs.class);
        if (map.isSuccess()) {
            addSimpleMessages(map.getMessage());
            clearBlogs();
        } else {
            addSimpleMessagesError(map.getMessage());
        }

        return null;
    }

    public String eliminarBlog() {

        try {
            
            if(selectionBlogs.getId()==0){
                addSimpleMessagesError("Debe de seleccionar un regsitro.");
                return null;
            }
            BandesalBlogs blog = new BandesalBlogs();
            blog = bandesalBlogsFacade.find(selectionBlogs.getId());
            bandesalBlogsFacade.remove(blog);
            addSimpleMessages("Blog eliminado con exito.");
            clearBlogs();
        } catch (EJBException ex) {
            addSimpleMessagesError("Se genero un error al intentar eliminar el registro , verifique que el registro no tengo ninguna relaciona antes de eliminar");
        } catch(Exception ex){
            addSimpleMessagesError("Se genero un error al intentar eliminar el registro");
        }

        return null;
    }

    public String clearBlogs() {
        try {
            title = "";
            description = "";
            selectionBlogs = new DataDetail();
            responseServicesDataBlogs = new ResponseServicesData();
            String verbo = "GET";
            responseServicesDataBlogs = requestJson(getBaseUrl() + "/api/all-blogs", verbo, null, Object.class);
            clearBlogsReaders();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String loadBlogsTable() {
        title = selectionBlogs.getTitle();
        description = selectionBlogs.getDescription();
        return null;
    }

    // Codigo Blogs y Readers
    private List<SelectItem> listaReaders;
    private List<SelectItem> listaBlogs;
    private ResponseServicesData responseServicesDataReaderscmb;
    private ResponseServicesData responseServicesDataBlogscmb;
    private int selectedIdBlog;
    private int selectedIdReaders;
    private ResponseServicesData responseServicesDataBlogsReaders;
    private DataDetail selectionBlogsReaders;

    public String clearBlogsReaders() {
        selectedIdBlog = 0;
        selectedIdReaders = 0;
        descriptionBySelection="";

        responseServicesDataReaderscmb = requestJson(getBaseUrl() + "/api/all-readers", "GET", null, Object.class);
        listaReaders = new ArrayList<>();
        responseServicesDataReaderscmb.getDataDetailAsList().forEach((obj) -> {
            listaReaders.add(new SelectItem(String.valueOf(obj.getId()), obj.getName()));
        });

        responseServicesDataBlogscmb = requestJson(getBaseUrl() + "/api/all-blogs", "GET", null, Object.class);
        listaBlogs = new ArrayList<>();
        responseServicesDataBlogscmb.getDataDetailAsList().forEach((obj) -> {
            listaBlogs.add(new SelectItem(String.valueOf(obj.getId()), obj.getTitle()));
        });

        responseServicesDataBlogsReaders = new ResponseServicesData();
        selectionBlogsReaders = new DataDetail();
        String verbo = "GET";
        responseServicesDataBlogsReaders = requestJson(getBaseUrl() + "/api/all-blogs-readers", verbo, null, Object.class);

        return null;

    }

    public String saveBlogsReaders() {
        String verbo = "POST";
        RequestBlogReader request = RequestBlogReader.builder()
                .idBlog(selectedIdBlog)
                .idReader(selectedIdReaders)
                .build();
        ResponseServicesData map = requestJson(getBaseUrl() + "/api/save-blog-reader", verbo, request, RequestBlogReader.class);
        if (map.isSuccess()) {
            addSimpleMessages(map.getMessage());
            clearBlogsReaders();
        } else {
            addSimpleMessagesError(map.getMessage());
        }

        return null;
    }

    public String loadBlogsReadersTable() {

        selectedIdBlog = selectionBlogsReaders.getId_blog();
        selectedIdReaders = selectionBlogsReaders.getId_reader();
        descriptionBySelection = selectionBlogsReaders.getDescription();

        return null;
    }
    
    
    public String eliminarBlogReaders() {
        try {
            
            if(selectionBlogsReaders.getId_blog()==0){
                addSimpleMessagesError("Debe de seleccionar un regsitro.");
                return null;
            }
            BandesalBlogsReaders reader_blog = new BandesalBlogsReaders();
            BandesalBlogsReadersId pk = new  BandesalBlogsReadersId();
            pk.setIdB(selectionBlogsReaders.getId_blog());
            pk.setIdR(selectionBlogsReaders.getId_reader());
            reader_blog = bandesalBlogsReadersFacade.find(pk);
            bandesalBlogsReadersFacade.remove(reader_blog);
            addSimpleMessages("Relacion eliminada con exito.");
            clearBlogsReaders();
        } catch (Exception ex) {
            addSimpleMessagesError("Se genero un error al intentar eliminar el registro");
        }

        return null;
    }
    
    public String loadDescriptionBlogById(){    
    descriptionBySelection = bandesalBlogsFacade.find(selectedIdBlog).getDescription();    
    return null;
    }
    
    

}

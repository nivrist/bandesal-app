/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bandesal.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.bandesal.dto.ResponseServicesData;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.UUID;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author nivrist
 */
public class Utils implements Serializable {

    private String currentUserInit;

    public static String getMessegesBundles(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        String message = bundle.getString(key);
        return message;
    }

    public void addMessagesWarn(String messages) {

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, Utils.getMessegesBundles(messages), ""));
    }

    public void addMessagesOk(String messages) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Utils.getMessegesBundles(messages), ""));
    }

    public void addMessagesError(String messages) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Utils.getMessegesBundles(messages), ""));
    }

    public void addSimpleMessages(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }

    public void addSimpleMessagesWarn(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, ""));
    }

    public void addSimpleMessagesError(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, ""));
    }

  
    /**
     *
     * @return genera un codigo basado en UUID
     */
    public String codeSec() {
        String code = UUID.randomUUID().toString();
        String[] codeList = code.split("-");
        String codeSec = codeList[0] + "-" + codeList[1];
        return codeSec;
    }

    public String getCurrentUser() {
        String user = "";
        Authentication ctx = SecurityContextHolder.getContext().getAuthentication();

        if (ctx != null) {
            user = (String) ctx.getPrincipal();
        }
        return user;
    }

    

    public HttpServletResponse getResponse() {
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        return response;
    }

   

    public String getCurrentUserInit() {
        return currentUserInit;
    }

    public void setCurrentUserInit(String currentUserInit) {
        this.currentUserInit = currentUserInit;
    }

   public String getBaseUrl(){   
       return "http://localhost:8081";
   }

    public <T> ResponseServicesData requestJson(String url, String verbo, T request, Class<T> requestType ) {
        try {
            String username = "admin";
            String password = "admin";

            Client client = Client.create();
            client.addFilter(new HTTPBasicAuthFilter(username, password));

            ObjectMapper objectMapper = new ObjectMapper();
            String datos = objectMapper.writeValueAsString(request);

            ClientResponse response;

            if (verbo.equalsIgnoreCase("POST")) {
                response = client.resource(url).type("application/json").post(ClientResponse.class, datos);
            } else {
                response = client.resource(url).type("application/json").get(ClientResponse.class);
            }
            
            String responseBody = response.getEntity(String.class);            
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseBody, ResponseServicesData.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}

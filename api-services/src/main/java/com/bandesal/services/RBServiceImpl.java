/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandesal.services;

import com.bandesal.dto.ApiResponse;
import com.bandesal.dto.RBDataProjection;
import com.bandesal.model.BandesalBlogsReaders;
import com.bandesal.model.BandesalBlogsReadersId;
import com.bandesal.repository.BandesalBlogsReadersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author irvin
 */
@Service
public class RBServiceImpl implements RBService{

    @Autowired
    private BandesalBlogsReadersRepository bandesalBlogsReadersRepository;
    
    @Override
    public ResponseEntity<ApiResponse<Object>> saveRB(int idReader, int idBlog) {
        try {
            BandesalBlogsReaders obj =  new BandesalBlogsReaders();
            BandesalBlogsReadersId pk = new BandesalBlogsReadersId();
            pk.setIdB(idBlog);
            pk.setIdR(idReader);
            obj.setId(pk);
           BandesalBlogsReaders response = bandesalBlogsReadersRepository.save(obj);            
            return ResponseEntity.ok(ApiResponse.builder()
                    .data(response)
                    .message("Datos guardados con exito.")
                    .success(true)
                    .build());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .data(ex.getMessage())
                    .message("Se genero un error al intentar guardar los datos.")
                    .success(false)
                    .build());
        }
    }

    @Override
    public ResponseEntity<ApiResponse<Object>> getAllRB() {
         try {
            List<RBDataProjection> obj = bandesalBlogsReadersRepository.getAllBlogreaders();
            return ResponseEntity.ok(ApiResponse.builder()
                    .data(obj)
                    .message("Listado de blogs y readers")
                    .success(true)
                    .build());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .data(ex.getMessage())
                    .message("Se genero un error al intentar obtener los datos.")
                    .success(false)
                    .build());
        }
       
    }

   @Override
public ResponseEntity<ApiResponse<Object>> getAllByFilters(String idBlog, String idReader, String title, String name) {
    try {
        List<RBDataProjection> obj = bandesalBlogsReadersRepository.getAllByFilters(
                idBlog.isEmpty() ? null : idBlog,
                idReader.isEmpty() ? null : idReader,
                title.isEmpty() ? null : title,
                name.isEmpty() ? null : name
        );

        return ResponseEntity.ok(ApiResponse.builder()
                .data(obj)
                .message("Listado de blogs y readers")
                .success(true)
                .build());
    } catch (Exception ex) {
        return ResponseEntity.badRequest().body(ApiResponse.builder()
                .data(ex.getMessage())
                .message("Se generó un error al intentar obtener los datos.")
                .success(false)
                .build());
    }
}

    
}

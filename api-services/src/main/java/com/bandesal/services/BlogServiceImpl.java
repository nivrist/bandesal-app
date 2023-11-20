/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandesal.services;

import com.bandesal.dto.ApiResponse;
import com.bandesal.model.BandesalBlogs;
import com.bandesal.repository.BandesalBlogsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author irvin
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BandesalBlogsRepository bandesalBlogsRepository;

    @Override
    public ResponseEntity<ApiResponse<Object>> saveBlog(String title, String description, int id) {

        try {
            BandesalBlogs obj = new BandesalBlogs();
            obj.setTitle(title);
            obj.setDescription(description);
            if (id != 0) {
                obj.setId(id);
            }
            BandesalBlogs response = bandesalBlogsRepository.save(obj);

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
    public ResponseEntity<ApiResponse<Object>> getAllBlogs() {
        try {
            List<BandesalBlogs> obj = bandesalBlogsRepository.findAll();
            return ResponseEntity.ok(ApiResponse.builder()
                    .data(obj)
                    .message("Listado de blogs")
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

}

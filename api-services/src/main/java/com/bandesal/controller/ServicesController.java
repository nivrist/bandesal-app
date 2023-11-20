/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandesal.controller;

import com.bandesal.dto.ApiResponse;
import com.bandesal.dto.RequestBlog;
import com.bandesal.dto.RequestBlogReaders;
import com.bandesal.dto.RequestRB;
import com.bandesal.dto.RequestReaders;
import com.bandesal.services.BlogService;
import com.bandesal.services.RBService;
import org.springframework.web.bind.annotation.RestController;
import com.bandesal.services.ReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author irvin
 */
@RestController
@RequestMapping(value = "/api")
public class ServicesController {

    @Autowired
    private ReadersService readersService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private RBService rBService;

    @PostMapping(value = "/save-readers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> saveReaders(@RequestBody RequestReaders request) {

        if (request.getName() == null || request.getName().equalsIgnoreCase("")) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .message("El campo name es obligatorio")
                    .success(false)
                    .build());
        }

        return readersService.saveReader(request.getName(),request.getId());
    }

    @GetMapping(value = "/all-readers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> getAllReaders() {
        return readersService.getAllReaders();
    }

    @PostMapping(value = "/save-blog", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> saveBlog(@RequestBody RequestBlog request) {

        if (request.getTitle() == null || request.getTitle().equalsIgnoreCase("")) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .message("El campo title es obligatorio")
                    .success(false)
                    .build());
        }

        if (request.getDescription() == null || request.getDescription().equalsIgnoreCase("")) {

            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .message("El campo description es obligatorio")
                    .success(false)
                    .build());
        }

        return blogService.saveBlog(request.getTitle(), request.getDescription(),request.getId());
    }

    @GetMapping(value = "/all-blogs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> getAllBlog() {
        return blogService.getAllBlogs();
    }

    @PostMapping(value = "/save-blog-reader", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> saveBlogReader(@RequestBody RequestBlogReaders request) {

        if (request.getIdBlog() == 0) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .message("El campos idBlog no puede ser 0")
                    .success(false)
                    .build());
        }

        if (request.getIdReader() == 0) {

            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .message("El campos idReader no puede ser 0")
                    .success(false)
                    .build());
        }

        return rBService.saveRB(request.getIdReader(), request.getIdBlog());
    }

    @GetMapping(value = "/all-blogs-readers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> getAllBlogReader() {
        return rBService.getAllRB();
    }
    
    @PostMapping(value = "/all-blogs-readers-filters", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> getAllBlogReaderFilters(@RequestBody RequestRB request) {
        return rBService.getAllByFilters(request.getIdBlog(),request.getIdReader(), request.getTitle(),request.getName());
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandesal.services;

import com.bandesal.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author irvin
 */
@Service
public interface BlogService {
    public ResponseEntity<ApiResponse<Object>> saveBlog(String title , String description, int id);
    public ResponseEntity<ApiResponse<Object>> getAllBlogs();
}

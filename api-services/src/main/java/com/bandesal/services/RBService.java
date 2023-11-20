/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
public interface RBService {
    public ResponseEntity<ApiResponse<Object>> saveRB(int idReader , int idBlog);
    public ResponseEntity<ApiResponse<Object>> getAllRB();
    public ResponseEntity<ApiResponse<Object>> getAllByFilters(String idBlog , String idReader , String title , String name);
}

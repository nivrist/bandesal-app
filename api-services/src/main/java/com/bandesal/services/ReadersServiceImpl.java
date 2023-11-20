/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandesal.services;

import com.bandesal.dto.ApiResponse;
import com.bandesal.model.BandesalReaders;
import com.bandesal.repository.BandesalReadersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author irvin
 */
@Service
public class ReadersServiceImpl implements ReadersService {

    @Autowired
    private BandesalReadersRepository bandesalReadersRepository;

    @Override
    public ResponseEntity<ApiResponse<Object>> saveReader(String name , int id) {
        BandesalReaders rd = new BandesalReaders();
        if(id!=0){
            rd.setId(id);
        }
        rd.setName(name);
        try {
            BandesalReaders obj = bandesalReadersRepository.save(rd);
            return ResponseEntity.ok(ApiResponse.builder()
                    .data(obj)
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
    public ResponseEntity<ApiResponse<Object>> getAllReaders() {
        try {
            List<BandesalReaders> obj = bandesalReadersRepository.findAll();
            return ResponseEntity.ok(ApiResponse.builder()
                    .data(obj)
                    .message("Listado de readers")
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



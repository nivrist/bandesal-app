/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bandesal.repository;

import com.bandesal.model.BandesalBlogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author irvin
 */

@Repository
public interface BandesalBlogsRepository extends JpaRepository<BandesalBlogs, Integer> {
    
}

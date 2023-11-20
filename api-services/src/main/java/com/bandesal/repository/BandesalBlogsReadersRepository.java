/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bandesal.repository;

import com.bandesal.dto.RBDataProjection;
import com.bandesal.model.BandesalBlogsReaders;
import com.bandesal.model.BandesalBlogsReadersId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author irvin
 */
@Repository
public interface BandesalBlogsReadersRepository extends JpaRepository<BandesalBlogsReaders, BandesalBlogsReadersId> {

    @Query(value = "SELECT\n"
            + "    ROW_NUMBER() OVER (ORDER BY b.id , c.id) AS id,\n"
            + "    c.name,\n"
            + "    b.id AS id_blog,\n"
            + "    c.id AS id_reader,\n"
            + "    b.title,\n"
            + "    b.description\n"
            + "FROM\n"
            + "    bandesal_blogs_readers a\n"
            + "JOIN\n"
            + "    bandesal_blogs b ON a.B_ID = b.id\n"
            + "JOIN\n"
            + "    bandesal_readers c ON a.R_ID = c.id;\n"
            + "", nativeQuery = true)
    public List<RBDataProjection> getAllBlogreaders();

    @Query(value = "SELECT \n"
            + "    ROW_NUMBER() OVER (ORDER BY b.id, c.id) AS id, \n"
            + "    c.name, \n"
            + "    b.id AS id_blog, \n"
            + "    c.id AS id_reader, \n"
            + "    b.title, \n"
            + "    b.description \n"
            + "FROM \n"
            + "    bandesal_blogs_readers a \n"
            + "JOIN \n"
            + "    bandesal_blogs b ON a.B_ID = b.id \n"
            + "JOIN \n"
            + "    bandesal_readers c ON a.R_ID = c.id\n"
            + "WHERE\n"
            + "    (b.id = IFNULL(?1, b.id))\n"
            + "    AND (c.id = IFNULL(?2, c.id))\n"
            + "    AND (b.title = IFNULL(?3, b.title))\n"
            + "    AND (c.name = IFNULL(?4, c.name))", nativeQuery = true)
    public List<RBDataProjection> getAllByFilters(String idBlog , String idReader , String title , String name);

}

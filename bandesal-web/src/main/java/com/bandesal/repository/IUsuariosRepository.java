/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bandesal.repository;


import com.bandesal.entities.MvUsuarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author irvin_monterroza
 */
@Repository
public interface IUsuariosRepository extends JpaRepository<MvUsuarios, Integer> {
    
    @Query(nativeQuery = true, value = "SELECT ifnull(max(id)+1,1) FROM bandesal_usuarios")
    public int nextId();
    @Query(value = "select * from  bandesal_usuarios  where usr = ?1 and estado='A' ", nativeQuery = true)
    public MvUsuarios findByUsr(String usuario);
    
    
    @Query(value = "select * from  bandesal_usuarios  where estado='A' ", nativeQuery = true)
    public List<MvUsuarios> obtenerUsuariosActivos();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bandesal.services;


import com.bandesal.entities.MvUsuarios;
import java.util.List;

/**
 *
 * @author irvin_monterroza
 */
public interface IUsuariosServices{
    
    public MvUsuarios getUsuariosValido(String usuario);    
    public void guardarUsuario(MvUsuarios usr);
    public void eliminarUsuario(MvUsuarios usr);
    public void actualizarUsuario(MvUsuarios usr);
    public List<MvUsuarios> obtenerUsuarios();
    public List<MvUsuarios> obtenerUsuariosActivos();
    public int nextId();
    
    
}

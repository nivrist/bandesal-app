/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bandesal.services;


import com.bandesal.entities.MvUsuarios;
import com.bandesal.repository.IUsuariosRepository;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author irvin_monterroza
 */
@Service
public class UsuariosServicesImpl implements IUsuariosServices,Serializable{

    @Autowired
    IUsuariosRepository iUsuariosRepository;
    
    @Override
    public MvUsuarios getUsuariosValido(String usuario) {
        return iUsuariosRepository.findByUsr(usuario);
    }

    @Override
    public void guardarUsuario(MvUsuarios usr) {
       BCryptPasswordEncoder pass = new BCryptPasswordEncoder(12);
        MvUsuarios userdb = getUsuariosValido(usr.getUsuario());
        if (userdb == null) {
               usr.setFechaCreacion(new Date());
               usr.setPassword(pass.encode(usr.getPassword()));
               iUsuariosRepository.save(usr);
        } else {
            if (!userdb.getPassword().equals(usr.getPassword())) {
                usr.setPassword(pass.encode(usr.getPassword()));
                usr.setFechaModificacion(new Date());
                iUsuariosRepository.save(usr);
            }else{
                 usr.setFechaModificacion(new Date());
                 iUsuariosRepository.save(usr);
            }

        }
    }

    @Override
    public void eliminarUsuario(MvUsuarios usr) {
        iUsuariosRepository.delete(usr);
    }

    @Override
    public void actualizarUsuario(MvUsuarios usr) {
        iUsuariosRepository.save(usr);
    }

    @Override
    public int nextId() {
        return iUsuariosRepository.nextId();
    }

    @Override
    public List<MvUsuarios> obtenerUsuarios() {
        return iUsuariosRepository.findAll();
    }

    @Override
    public List<MvUsuarios> obtenerUsuariosActivos() {
          return iUsuariosRepository.obtenerUsuariosActivos();
    }
    
}

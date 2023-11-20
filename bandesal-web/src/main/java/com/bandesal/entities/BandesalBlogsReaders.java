/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandesal.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author irvin
 */
@Entity
@Table(name = "bandesal_blogs_readers")
public class BandesalBlogsReaders implements Serializable {
    @EmbeddedId
    private BandesalBlogsReadersId id;

    public BandesalBlogsReadersId getId() {
        return id;
    }

    public void setId(BandesalBlogsReadersId id) {
        this.id = id;
    }
    

    
}

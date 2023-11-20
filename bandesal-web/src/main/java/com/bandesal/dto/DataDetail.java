/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandesal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author irvin
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDetail implements Serializable{    
    @JsonProperty("name") 
    private String name;
    @JsonProperty("description") 
    private String description;
    @JsonProperty("title") 
    private String title;
    @JsonProperty("id_blog") 
    private int id_blog;
    @JsonProperty("id_reader") 
    private int id_reader;
    @JsonProperty("id") 
    private int id;
    
}

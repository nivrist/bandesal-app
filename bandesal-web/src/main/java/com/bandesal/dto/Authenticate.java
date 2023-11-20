/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bandesal.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author irvin_monterroza
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Authenticate implements  Serializable{
    @JsonProperty("bearer")
    private String barear;
    @JsonProperty("user")
    private String user;
    @JsonProperty("exp")
    private String exp;
    
}

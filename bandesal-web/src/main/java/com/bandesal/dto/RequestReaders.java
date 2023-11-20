/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandesal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author irvin
 */

@Setter
@Getter
@Builder
public class RequestReaders {
    
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private int id;
}

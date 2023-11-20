/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandesal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author irvin
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseServicesData {    
    @JsonProperty("message") 
    private String message;
    @JsonProperty("success") 
    private boolean success;
    @JsonProperty("data") 
    private Object data; 
  
    public List<DataDetail> getDataDetailAsList() {
        if (data instanceof List<?>) {
           ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.convertValue(data, new TypeReference<List<DataDetail>>() {});
        }
        return null; 
    }
}

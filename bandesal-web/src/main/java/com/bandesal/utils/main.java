/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bandesal.utils;

import com.bandesal.dto.RequestReaders;
import com.bandesal.dto.ResponseServicesData;

/**
 *
 * @author irvin_monterroza
 */
public class main {

    public static void main(String[] arg) {
        try {
            String verbo = "POST";
            Utils htt_serv = new Utils();
            RequestReaders request = RequestReaders.builder().name("TEST").build();
            String url = "http://localhost:8081/api/save-readers";
            ResponseServicesData map = htt_serv.requestJson(url, verbo, request,RequestReaders.class);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

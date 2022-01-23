/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.restconsumer;

/**
 *
 * @author Vaughn
 */

public class MVCRESTConsumer {
    public static void main(String[] args) {
        RESTModel theModel = new RESTModel();
        RESTView theView = new RESTView();
        RESTController theController = new RESTController(theView, theModel);
    }
}

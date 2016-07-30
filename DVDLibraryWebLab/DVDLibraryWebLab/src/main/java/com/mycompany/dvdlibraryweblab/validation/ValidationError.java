/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryweblab.validation;

/**
 *
 * @author apprentice
 */
public class ValidationError {
    public String fieldName;
    public String message;
    
    public ValidationError(String fieldName, String message){
        this.fieldName = fieldName;
        this.message = message;
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
}

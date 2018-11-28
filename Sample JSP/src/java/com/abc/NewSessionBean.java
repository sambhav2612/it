/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc;

import java.util.*;


/**
 *
 * @author root
 */

public class NewSessionBean implements java.io.Serializable {
    private String fileName;
    public NewSessionBean() {
        fileName = "Anurag Kundra";
    }
    public void setFileName(String x) {
        fileName = x;
    }
    public String getFileName() {
        return fileName;
    }
}   

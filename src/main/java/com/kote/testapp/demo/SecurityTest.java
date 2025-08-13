/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kote.testapp.demo;

/**
 *
 * @author jmfl
 */
import javax.management.loading.MLet;

public class SecurityTest {
    private void MLetTest() {
        MLet mlet = new MLet();
        System.out.println("MLet class loaded: " + mlet.getClass().getName());
    }
    
    private void SM() {
        System.setSecurityManager(new SecurityManager()); 
        SecurityManager sm = System.getSecurityManager();
        System.out.println("SecurityManager set: " + sm);
    }
}

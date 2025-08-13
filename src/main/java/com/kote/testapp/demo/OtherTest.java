/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kote.testapp.demo;

/**
 *
 * @author jmfl
 */
import javax.security.auth.Subject;
import java.security.PrivilegedAction;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class OtherTest {
    protected void finalize() throws Throwable {
        System.out.println("Finalizer called");
    }
    
    public static void main(String[] args) {
        new OtherTest();
        System.gc();
        System.runFinalization(); // Deprecated in Java 21
        
        Subject subject = new Subject();
        Subject.doAs(subject, (PrivilegedAction<Void>) () -> {
            System.out.println("Running as subject");
            return null;
        });
    }
    
    private void printDeviation() {
        double[] data = {2.3, 5.1, 3.3, 4.9, 2.9, 5.6};

        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }

        System.out.println("Standard Deviation: " + stats.getStandardDeviation());
    }
}

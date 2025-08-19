/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kote.testapp.demo;



import java.util.Date;
import java.net.SocketException;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketImplFactory;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageInputStream;
import org.apache.commons.math3.util.MathUtils;

/**
 * 
 * 
 *
 * @author jmfl
 */
public class DeprecatedExamples {
    
    private Date fecha;
    
    public void mathJar(){
        // gcd = greatest common divisor
        double[] values = {3.0, 4.0};

        // safeNorm calcula la norma euclídea de forma segura
        double norm = MathUtils.normalizeAngle(values[0], values[1]);

        System.out.println("Norma euclídea de {3.0, 4.0}: " + norm);

        // checkFinite lanza excepción si hay NaN o infinito
        MathUtils.checkFinite(norm);
        System.out.println("El valor es finito.");
    }
    
    public void setDates(){
        fecha = new Date(123, 7, 17); 
    }
    public void useSocket(){
        try {
            Socket.setSocketImplFactory(new SocketImplFactory() {
                @Override
                public java.net.SocketImpl createSocketImpl() {
                    System.out.println("Custom SocketImplFactory invoked (deprecated!)");
                    return null; // solo ejemplo, no válido en producción
                }
            });
        } catch (IOException e) {
            System.out.println("No se pudo establecer SocketImplFactory: " + e);
        }
    }
    
    public void executors() throws InterruptedException{
        ThreadFactory factory = Executors.privilegedThreadFactory();
        Thread t = factory.newThread(() -> System.out.println("Hilo creado con privilegedThreadFactory (deprecated)"));
        t.start();
        t.join();
    }
    
    static class MyObservable extends Observable {
        @Deprecated(since = "9") // Observable está deprecated desde Java 9
        public void triggerChange(Object msg) {
            setChanged(); // aquí sí podemos llamarlo, porque estamos dentro de la subclase
            notifyObservers(msg);
        }
    }
    
    public void observableDemo() {
        MyObservable observable = new MyObservable();

        Observer observer = (o, arg) ->
                System.out.println("Evento recibido en Observer (deprecated Observable): " + arg);

        observable.addObserver(observer);

        // Disparamos un evento
        observable.triggerChange("Mensaje desde Observable");
    }
    
    
}

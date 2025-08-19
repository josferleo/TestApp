/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kote.testapp.demo;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author jmfl
 */
public class MyFileImageInputStream extends FileImageInputStream {
    public MyFileImageInputStream(File file) throws IOException {
        super(file);
    }

    // Exponemos finalize como público solo para fines de demo
    @Override
    @Deprecated(since = "9") // marcamos el override como deprecated también
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() llamado en MyFileImageInputStream (DEPRECATED)");
    }
}

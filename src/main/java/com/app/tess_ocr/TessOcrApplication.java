package com.app.tess_ocr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class TessOcrApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TessOcrApplication.class, args);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while (!line.equalsIgnoreCase("start")) {
            System.out.println("Type START to begin process...");
            line = in.readLine();
            TesseractOCR.recognizeImage();
        }
        in.close();
    }
}

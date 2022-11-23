package com.app.tess_ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Objects;

public class TesseractOCR {


    public static void recognizeImage() {

        try (PrintWriter writer = new PrintWriter("parsed.txt", "UTF-8")) {
            Arrays.stream(Objects.requireNonNull((new File("./input")).listFiles()))
                .forEach(e -> {
                    writer.println("=========<" + e.getName() + ">=========");
                    Tesseract tesseract = new Tesseract();
                    tesseract.setDatapath("./tessdata");
                    tesseract.setLanguage("eng");
                    tesseract.setPageSegMode(1);
                    tesseract.setOcrEngineMode(1);
                try {
                    writer.write(tesseract.doOCR(e));
                    writer.println("");
                } catch (TesseractException tesseractException) {
                    tesseractException.printStackTrace();
                }
            });

        } catch (FileNotFoundException | UnsupportedEncodingException te) {
            te.printStackTrace();
        }
    }
}
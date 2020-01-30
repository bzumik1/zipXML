package com.znamenacek.jakub.zipxml;

import org.xml.sax.HandlerBase;

import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class Main {
    public static void main(String[] args) throws Exception{




        // Creates a new instance of SAXParserFactory that in turn
        // creates a SAXParser.
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // The handler that will listen to the SAX event during
        // the xml traversal.
        SAXHandler handler = new SAXHandler();







        Path path = Paths.get(System.getProperty("user.home"),"uploaded","WebTrace_406_2019.12.04.14.53.08.wtrc");


        System.out.println(Files.exists(path));

        try {
            ZipFile zipFile = new ZipFile(path.toFile());
            ZipEntry zipEntry = zipFile.getEntry("traceinfo.xml");


            InputStream inputStream = zipFile.getInputStream(zipEntry);
            parser.parse(inputStream,handler);
            System.out.println(handler.getLowDEC());
        }catch (IOException e){
            e.getStackTrace();
        }


    }
}

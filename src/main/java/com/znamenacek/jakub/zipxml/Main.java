package com.znamenacek.jakub.zipxml;

import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.parsers.SAXParser;


public class Main {
    public static void main(String[] args) throws Exception{


        Path path = Paths.get(System.getProperty("user.home"),"uploaded","WebTrace_406_2019.12.04.14.53.08.wtrc");

        System.out.println(parseLowDEC(path));


    }

    private static long parseLowDEC(Path path) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // The handler that will listen to the SAX event during
        // the xml traversal.
        HandlerLowDEC handler = new HandlerLowDEC();


        try {
            ZipFile zipFile = new ZipFile(path.toFile());
            ZipEntry zipEntry = zipFile.getEntry("traceinfo.xml");


            InputStream inputStream = zipFile.getInputStream(zipEntry);
            parser.parse(inputStream,handler);
            return handler.getLowDEC();
        }catch (IOException e){
            e.getStackTrace();
        }
        return 0;
    }
}

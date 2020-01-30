package com.znamenacek.jakub.zipxml;

import lombok.Getter;
import lombok.Setter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@Getter
public class HandlerLowDEC extends DefaultHandler {
    // List to hold Employees object
    private Long lowDEC = null;

    private boolean bLowDEC = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("LowDEC")){
            bLowDEC = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("LowDEC")){
            bLowDEC = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(bLowDEC){
            lowDEC = Long.parseLong(new String(ch, start, length)+"000");
        }
    }
}
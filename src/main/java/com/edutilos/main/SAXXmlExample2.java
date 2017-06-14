package com.edutilos.main;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by edutilos on 15.06.17.
 */

/**
 * needs external library :
 * compile group: 'javax.xml', name: 'jaxp-api', version: '1.4.2'
 */
public class SAXXmlExample2 {

    public static void main(String[] args) {
        try {
            DefaultHandler contentHandler = new MyContentHandler();
            ErrorHandler errorHandler = new MyErrorHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(contentHandler);
            reader.setErrorHandler(errorHandler);
            reader.parse(new InputSource("workers.xml"));
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }



    static class MyErrorHandler implements ErrorHandler {

        @Override
        public void warning(SAXParseException exception) throws SAXException {
            System.out.println(String.format("warning: %", exception.getMessage()));
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            System.out.println(String.format("error: %s", exception.getMessage()));
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            System.out.println(String.format("fatalError: %s", exception.getMessage()));
        }
    }


    static class MyContentHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println(">> startDocument");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println(">> endDocument");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println(String.format(">> startElement: [uri,localName,qName] = [%s,%s,%s]", uri, localName, qName));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println(String.format(">> endElement: [uri,localName,qName] = [%s,%s,%s]", uri, localName, qName));
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println(String.format(">> characters: %s", new String(ch, start, length)));
        }
    }
}

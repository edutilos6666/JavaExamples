package com.edutilos.main;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by edutilos on 14.06.17.
 */

/**
 * needs external library :
 * compile group: 'javax.xml', name: 'jaxp-api', version: '1.4.2'
 */
public class SAXXmlExample1 {
    public static void main(String[] args) {
        try {
            MySaxParserHandler handler = new MySaxParserHandler();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            File xmlfile = new File("workers.xml");
            parser.parse(xmlfile, handler);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        }

    static class MySaxParserHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("-- startDocument");

        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("-- endDocument");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println(String.format("startElement: [uri,localName,qName] = [%s,%s,%s]", uri, localName, qName));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println(String.format("endElement: [uri,localName,qName] = [%s,%s,%s]", uri, localName, qName));
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println(String.format("characters: %s", new String(ch, start ,length)));
        }
    }
}

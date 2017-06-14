package com.edutilos.main;

import org.w3c.dom.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * Created by edutilos on 15.06.17.
 */
public class XmlDOMExample2 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        dbf.setIgnoringElementContentWhitespace(true);
        dbf.setNamespaceAware(true);
        dbf.setValidating(false);

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            db.setErrorHandler(new MyErrorHandler());
            Document doc = db.parse(new InputSource("workers.xml"));
            NodeList workerList = doc.getElementsByTagName("Worker");

            //we could read from string
            // InputSource is = new InputSource(new StringReader("<name>foobar</name>"));
            for(int i=0; i< workerList.getLength(); ++i) {
                Element worker = (Element)workerList.item(i);
                Node id = worker.getAttributes().getNamedItem("id");
                Node name = worker.getElementsByTagName("Name").item(0).getFirstChild();
                Node age = worker.getElementsByTagName("Age").item(0).getFirstChild();
                Node wage = worker.getElementsByTagName("Wage").item(0).getFirstChild();
                String _id = id.getNodeValue(),
                        _name = ((CharacterData)name).getData(),
                        _age = ((CharacterData)age).getData(),
                        _wage = ((CharacterData)wage).getData();
                System.out.println(String.format("[%s, %s, %s, %s]", _id, _name, _age, _wage));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


     static class MyErrorHandler implements ErrorHandler {

         @Override
         public void warning(SAXParseException exception) throws SAXException {
             System.out.println(String.format("warning: %s", exception.getMessage()));
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
}

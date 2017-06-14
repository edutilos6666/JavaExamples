package com.edutilos.main;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.sound.midi.Soundbank;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by edutilos on 15.06.17.
 */
public class XmlDOMExample1 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(true);
            dbf.setNamespaceAware(true);
            dbf.setIgnoringComments(true);
            dbf.setIgnoringElementContentWhitespace(true);
            DocumentBuilder db  = dbf.newDocumentBuilder();
            db.setErrorHandler(new MyErrorHandler());
            Document doc = db.parse(new File("workers.xml"));
            TreeDumper dumper = new TreeDumper();
            dumper.dump(doc);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }



    static class MyErrorHandler implements ErrorHandler {

        @Override
        public void warning(SAXParseException exception) throws SAXException {
            System.out.println(String.format("warning : %s", exception.getMessage()));
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

    static class TreeDumper {
/*
ELEMENT_NODE
ATTRIBUTE_NODE
TEXT_NODE
CDATA_SECTION_NODE
ENTITY_REFERENCE_NODE
ENTITY_NODE
PROCESSING_INSTRUCTION_NODE
COMMENT_NODE
DOCUMENT_NODE
DOCUMENT_TYPE_NODE
DOCUMENT_FRAGMENT_NODE
NOTATION_NODE
 */

        public void dump(Document doc) {
             dumpLoop((Node)doc, "");
        }

        private void dumpLoop(Node node ,String indent) {
            String msg = "";
            switch(node.getNodeType()) {
                case Node.ELEMENT_NODE:
                    msg = indent + "ELEMENT_NODE";
                    break;
                case Node.ATTRIBUTE_NODE:
                    msg = indent + "ATTRIBUTE_NODE";
                    break;
                case Node.TEXT_NODE:
                    msg = indent + "TEXT_NODE";
                    break;
                case Node.CDATA_SECTION_NODE:
                    msg = indent + "CDATA_SECTION_NODE";
                    break;
                case Node.ENTITY_REFERENCE_NODE:
                    msg = indent + "ENTITY_REFEREnCE_NODE";
                    break;
                case Node.ENTITY_NODE:
                    msg = indent + "ENTITY_NODE";
                    break;
                case Node.PROCESSING_INSTRUCTION_NODE:
                    msg = indent + "PROCESSING_INSTRUCTION_NODE";
                    break;
                case Node.COMMENT_NODE:
                    msg = indent + "COMMENT_NODE";
                    break;
                case Node.DOCUMENT_NODE:
                    msg = indent + "DOCUMENT_NODE";
                    break;
                case Node.DOCUMENT_TYPE_NODE:
                    msg = indent + "DOCUMENT_TYPE_NODE";
                    break;
                case Node.DOCUMENT_FRAGMENT_NODE:
                    msg = indent + "DOCUMENT_FRAGMENT_NODE";
                    break;
                case Node.NOTATION_NODE:
                    msg = indent + "NOTATION_NODE";
                    break;
            }

            System.out.println(msg);


            NodeList list = node.getChildNodes();
            for(int i=0 ; i< list.getLength(); ++i) {
                dumpLoop(list.item(i), indent+ "   ");
            }
        }
    }
}

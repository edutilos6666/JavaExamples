package com.edutilos.main;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by edutilos on 15.06.17.
 */
public class XSLTExample {
    public static void main(String[] args) {
        try {
            StreamSource xml = new StreamSource(new FileReader("phonebook.xml"));
            StreamSource xsl = new StreamSource(new FileReader("phonebook.xsl"));
            StreamResult res = new StreamResult(new FileWriter("phoneout.html"));
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer(xsl);
            t.transform(xml, res);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

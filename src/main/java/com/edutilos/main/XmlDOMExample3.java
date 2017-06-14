package com.edutilos.main;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;

/**
 * Created by edutilos on 15.06.17.
 */
public class XmlDOMExample3 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation domImplementation = db.getDOMImplementation();
            Document doc = domImplementation.createDocument(null, null, null);
            //add elements
            Element root = doc.createElement("People");
            doc.appendChild(root);
            //Person 1, foo , 10, 100.0
            Element person = doc.createElement("Person");
            person.setAttribute("id", "1");
            Element name = doc.createElement("Name");
            name.appendChild(doc.createTextNode("foo"));
            person.appendChild(name);
            Element age = doc.createElement("Age");
            age.appendChild(doc.createTextNode("10"));
            person.appendChild(age);
            Element wage = doc.createElement("Wage");
            wage.appendChild(doc.createTextNode("100.0"));
            person.appendChild(wage);
            root.appendChild(person);

            //Person 2, bar , 20 , 200.0
            person = doc.createElement("Person");
            person.setAttribute("id", "2");
            name = doc.createElement("Name");
            name.appendChild(doc.createTextNode("bar"));
            age = doc.createElement("Age");
            age.appendChild(doc.createTextNode("20"));
            wage = doc.createElement("Wage");
            wage.appendChild(doc.createTextNode("200.0"));
            person.appendChild(name);
            person.appendChild(age);
            person.appendChild(wage);
            root.appendChild(person);

            //Person 3, bim ,30 , 300.0
            person = doc.createElement("Person");
            person.setAttribute("id", "3");
            name = doc.createElement("Name");
            name.appendChild(doc.createTextNode("bim"));
            age = doc.createElement("Age");
            age.appendChild(doc.createTextNode("30"));
            wage = doc.createElement("Wage");
            wage.appendChild(doc.createTextNode("300.0"));
            person.appendChild(name);
            person.appendChild(age);
            person.appendChild(wage);
            root.appendChild(person);

            //dom source
            DOMSource domSource = new DOMSource(doc);
            // transformer
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            transformer.transform(domSource, sr);
            System.out.println(sw.toString());
            //writing to file
            sr = new StreamResult(new FileWriter(new File("people.xml")));
            transformer.transform(domSource, sr);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

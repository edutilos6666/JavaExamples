package com.edutilos.main;


import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.*;
import java.util.*;

public class XmlStaxExample {
    public static void main(String[] args) {
      String filename = "people-stax.xml";
/*      writeXML(filename);
      filename = "people-stax2.xml";
      writePersonListAsXML(filename);

      readXML(filename);*/
     writeListAsXMLEventBased(filename);
      readXMLEventBased(filename);
    }





    private static void readXMLEventBased(String filename) {
        try {
              XMLInputFactory factory = XMLInputFactory.newInstance();
              XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(filename));
              List<StaxPerson> ret = new LinkedList<>();
              long id = 0 ;
              String name = "";
              int age = 0 ;
              double wage = 0.0;
              boolean active = false ;
               while(reader.hasNext()) {
                  int tag = reader.next();
                  if(reader.isStartElement()) {
                    //  System.out.println(reader.getLocalName());
                     String localName = reader.getLocalName();
                     if(localName.equals("Person")) {
                         id = Long.parseLong(reader.getAttributeValue("", "id"));
                     } else if(localName.equals("Name")) {
                        while(reader.next() != XMLStreamConstants.CHARACTERS);
                        name = reader.getText();
                     } else if(localName.equals("Age")) {
                         while(reader.next() != XMLStreamConstants.CHARACTERS);
                         age = Integer.parseInt(reader.getText());
                     } else if(localName.equals("Wage")) {
                         while(reader.next() != XMLStreamConstants.CHARACTERS);
                         wage = Double.parseDouble(reader.getText());

                     } else if(localName.equals("Active")) {
                         while(reader.next() != XMLStreamConstants.CHARACTERS);
                         active = reader.getText().equals("true");
                         ret.add(new StaxPerson(id , name, age, wage, active));
                     }
                  }
              }


            System.out.println("<<all people>>");
               for(StaxPerson sp: ret) {
                   System.out.println(String.format("[%d,%s,%d,%f,%b]",
                           sp.getId(), sp.getName(), sp.getAge(), sp.getWage(), sp.isActive()));
               }

              reader.close();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    private static void writeListAsXMLEventBased(String filename) {
        try {
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLEventWriter writer = factory.createXMLEventWriter(new FileOutputStream(filename));
            XMLEventFactory ef = XMLEventFactory.newInstance();
            StartDocument startDocument = ef.createStartDocument();
            writer.add(startDocument);
            EndElement ee = null;
            Characters chars = null;
            //Root
            StartElement se = ef.createStartElement("", "", "People");
            writer.add(se);

            //list
            List<StaxPerson> list = Arrays.asList(
               new StaxPerson(1, "foo", 10, 100.0 , true),
                    new StaxPerson(2, "bar", 20 , 200.0, false),
                    new StaxPerson(3, "bim", 30 , 300.0, true)
            );
            for(StaxPerson sp : list) {
                Attribute attrId = ef.createAttribute("id", String.valueOf(sp.getId()));
                List<Attribute> attrList = Arrays.asList(attrId);
                se = ef.createStartElement("", "" , "Person", attrList.iterator(), new ArrayList().iterator());
                writer.add(se);
                //name
                se = ef.createStartElement("", "", "Name");
                writer.add(se);
                chars = ef.createCharacters(String.valueOf(sp.getName()));
                writer.add(chars);
                ee = ef.createEndElement("", "", "Name");
                writer.add(ee);

                //age
                se = ef.createStartElement("", "", "Age");
                writer.add(se);
                chars = ef.createCharacters(String.valueOf(sp.getAge()));
                writer.add(chars);
                ee = ef.createEndElement("", "" , "Age");
                writer.add(ee);

                //wage
                se = ef.createStartElement("", "", "Wage");
                writer.add(se);
                chars = ef.createCharacters(String.valueOf(sp.getWage()));
                writer.add(chars);
                ee = ef.createEndElement("", "", "Wage");
                writer.add(ee);

                //active
                se = ef.createStartElement("", "", "Active");
                writer.add(se);
                chars = ef.createCharacters(sp.isActive()?"true": "false");
                writer.add(chars);
                ee = ef.createEndElement("", "", "Active");
                writer.add(ee);
                //end
                ee = ef.createEndElement("", "", "Person");
                writer.add(ee);
            }
            ee =  ef.createEndElement("", "", "People");
            writer.add(ee);
            EndDocument endDocument = ef.createEndDocument();
            writer.add(endDocument);

            //flush and close
            writer.flush();
            writer.close();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void readXML(String filename) {
      try {
          XMLInputFactory factory = XMLInputFactory.newInstance();
          XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(filename));
          long id = 0 ;
          String name = "";
          int age = 0 ;
          double wage = 0.0 ;
          boolean active = false ;
          List<StaxPerson> list = new ArrayList<>();
          while(reader.hasNext()) {
              int tag =  reader.next();
              if(tag == XMLStreamConstants.START_ELEMENT) {
                  String localName= reader.getLocalName();
                 if(localName.equals("Person")) {
                     //while(reader.next() != XMLStreamConstants.CHARACTERS);
                     id = Long.parseLong(reader.getAttributeValue(null, "id"));
                 } else if(localName.equals("Wage")) {
                     while(reader.next() != XMLStreamConstants.CHARACTERS);
                     wage = Double.parseDouble(reader.getText());
                 } else if(localName.equals("Active")) {
                     while(reader.next() != XMLStreamConstants.CHARACTERS);
                     String activeStr = reader.getText();
                    if(activeStr.equalsIgnoreCase("true")) active = true ;
                 } else if(localName.equals("Age")) {
                     while(reader.next() != XMLStreamConstants.CHARACTERS);
                     age = Integer.parseInt(reader.getText());
                 } else if(localName.equals("Name")) {
                     while(reader.next() != XMLStreamConstants.CHARACTERS);
                     name = reader.getText();
                      list.add(new StaxPerson(id, name, age, wage, active));
                 }
              }
          }
          reader.close();
          System.out.println("<<all People>>");
          for(StaxPerson p: list) {
              System.out.println(String.format("[%d, %s, %d, %f, %b]",
                      p.getId(), p.getName(), p.getAge(), p.getWage(), p.isActive()));
          }
      } catch(Exception ex) {
          System.err.println(ex.getMessage());
      }
    }

    private static void writePersonListAsXML(String filename) {
        List<StaxPerson> list = Arrays.asList(
           new StaxPerson(1, "foo", 10 , 100.0 , true),
                new StaxPerson(2, "bar", 20 , 200.0, false),
                new StaxPerson(3, "bim", 30 , 300.0 , true)
        );

        try {
            XMLOutputFactory  factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(filename));
            writer.writeStartDocument();
            writer.writeStartElement("People");

            for(StaxPerson p: list) {
                Map<String , String> props = new HashMap<>();
               // props.put("id", String.valueOf(p.getId()));
                props.put("Name", p.getName());
                props.put("Age", String.valueOf(p.getAge()));
                props.put("Wage", String.valueOf(p.getWage()));
                props.put("Active", String.valueOf(p.isActive()));
                writer.writeStartElement("Person");
                writer.writeAttribute("id", String.valueOf(p.getId()));
                props.forEach((k, v)-> {
                    try {
                        writer.writeStartElement(k);
                        writer.writeCharacters(v);
                        writer.writeEndElement();
                    } catch(Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                });

                writer.writeEndElement();
            }

            //end
            writer.writeEndElement();
            writer.writeEndDocument();
            //flush and close
            writer.flush();
            writer.close();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    private static void writeXML(String filename) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new BufferedWriter(new FileWriter(filename)));
            //People
            writer.writeStartDocument();
            writer.writeStartElement("People");
            //Person 1
            writer.writeStartElement("Person");
            writer.writeAttribute("id", "1");
            //name
            writer.writeStartElement("Name");
            writer.writeCharacters("foo");
            writer.writeEndElement();
            //age
            writer.writeStartElement("Age");
            writer.writeCharacters("10");
            writer.writeEndElement();
            //wage
            writer.writeStartElement("Wage");
            writer.writeCharacters("100.0");
            writer.writeEndElement();
            writer.writeEndElement();

            //Person 2
            writer.writeStartElement("Person");
            writer.writeAttribute("id", "2");
            //name
            writer.writeStartElement("Name");
            writer.writeCharacters("bar");
            writer.writeEndElement();
            //age
            writer.writeStartElement("Age");
            writer.writeCharacters("20");
            writer.writeEndElement();
            //wage
            writer.writeStartElement("Wage");
            writer.writeCharacters("200.0");
            writer.writeEndElement();
            writer.writeEndElement();

            //Person 3
            writer.writeStartElement("Person");
            writer.writeAttribute("id", "3");
            //name
            writer.writeStartElement("Name");
            writer.writeCharacters("bim");
            writer.writeEndElement();
            //age
            writer.writeStartElement("Age");
            writer.writeCharacters("30");
            writer.writeEndElement();
            //wage
            writer.writeStartElement("Wage");
            writer.writeCharacters("300.0");
            writer.writeEndElement();
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndDocument();
            //flush and close
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    private static class StaxPerson {
        private long id ;
        private String name;
        private int age;
        private double wage;
        private boolean active ;

        public StaxPerson(long id, String name, int age, double wage, boolean active) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.wage = wage;
            this.active = active;
        }

        public StaxPerson() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getWage() {
            return wage;
        }

        public void setWage(double wage) {
            this.wage = wage;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        @Override
        public String toString() {
            return "StaxPerson{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", wage=" + wage +
                    ", active=" + active +
                    '}';
        }
    }

}

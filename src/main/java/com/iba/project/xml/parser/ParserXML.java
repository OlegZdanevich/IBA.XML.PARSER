package com.iba.project.xml.parser;

import com.iba.project.entity.book.Book;
import com.iba.project.entity.person.Person;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParserXML {

    public static List<Book> parse(InputStream stream) throws XMLStreamException {


        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = inputFactory.createXMLEventReader(stream);
        reader.close();

        return parseToTable(reader);


    }

    private static List<Book> parseToTable(XMLEventReader reader) throws XMLStreamException {
        List<Book> books = new ArrayList<>();


        Book book = null;
        Person auther = null;

        while (reader.hasNext()) {


            XMLEvent xmlEvent = reader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();


                if (startElement.getName().getLocalPart().equals("nameAuthor")) {
                    xmlEvent = reader.nextEvent();

                    book = new Book();
                    auther = new Person();
                    auther.setName(xmlEvent.asCharacters().getData());


                }

                if (startElement.getName().getLocalPart().equals("lastnameAuthor")) {
                    xmlEvent = reader.nextEvent();

                    auther.setLastName(xmlEvent.asCharacters().getData());


                }


                if (startElement.getName().getLocalPart().equals("name")) {
                    xmlEvent = reader.nextEvent();

                    book.setName(xmlEvent.asCharacters().getData());


                }

                if (startElement.getName().getLocalPart().equals("price")) {
                    xmlEvent = reader.nextEvent();

                    book.setPrice(new BigDecimal(xmlEvent.asCharacters().getData()));


                }

            }
            if (xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("book")) {
                    book.setAuthor(auther);
                    books.add(book);
                }

            }
        }



        return books;
    }
}

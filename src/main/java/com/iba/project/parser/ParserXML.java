package com.iba.project.parser;

import com.iba.project.entity.book.Book;
import com.iba.project.entity.person.Person;
import com.iba.project.entity.table.Table;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ParserXML
{
    public static List<Book> parse(InputStream stream)
    {
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLEventReader reader = inputFactory.createXMLEventReader(stream);

            parseToTable(reader);


        }
        catch (XMLStreamException exception)
        {
            //TO DO LOG
        }
        return new ArrayList<>();

    }

    private static List<Book> parseToTable(XMLEventReader reader) throws XMLStreamException {
        List<Book> books=new ArrayList<>();


        while (reader.hasNext())
        {
            XMLEvent xmlEvent=reader.nextEvent();

            if (xmlEvent.isStartElement())
            {
                StartElement startElement=xmlEvent.asStartElement();

                if (startElement.getName().getLocalPart().equals("Book"))
                {



                }
            }
        }
        return  new ArrayList<>();
    }
}

package com.iba.project.xml.creater;

import com.iba.project.entity.book.Book;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class CreateXML {
    private static final Logger log = Logger.getLogger(CreateXML.class);

    public static <T extends Book> String createStreamWriter(List<T> books) {
        try (StringWriter writer = new StringWriter()) {


            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(writer);

            addHeadOfDocument(xmlStreamWriter, "books");

            for (Book book : books) {
                addBook(xmlStreamWriter, book);
            }

            addEndOfDocument(xmlStreamWriter);

            xmlStreamWriter.flush();
            xmlStreamWriter.close();


            return writer.getBuffer().toString();
        } catch (XMLStreamException exception) {
            log.trace("Some problems with xml file",exception);
        } catch (IOException exception) {
            log.trace("Some problems with input output streams",exception);
        }

        return null;
    }

    private static void addBook(XMLStreamWriter xmlStreamWriter, Book book) throws XMLStreamException {
        addHeadOfElement(xmlStreamWriter, "book");

        addHeadOfElement(xmlStreamWriter, "author");
        addTag(xmlStreamWriter, "nameAuthor", book.getAuthor().getName());
        addTag(xmlStreamWriter, "lastnameAuthor", book.getAuthor().getLastName());
        addEndOfElement(xmlStreamWriter);

        addTag(xmlStreamWriter, "name", book.getName());
        addTag(xmlStreamWriter, "price", book.getPrice().toString());

        addEndOfElement(xmlStreamWriter);
    }

    private static void addTag(XMLStreamWriter xmlStreamWriter, String name, String value) throws XMLStreamException {
        xmlStreamWriter.writeStartElement(name);
        xmlStreamWriter.writeCharacters(value);
        xmlStreamWriter.writeEndElement();
    }

    private static void addHeadOfDocument(XMLStreamWriter xmlStreamWriter, String value) throws XMLStreamException {
        xmlStreamWriter.writeStartDocument();
        xmlStreamWriter.writeStartElement(value);
    }

    private static void addHeadOfElement(XMLStreamWriter xmlStreamWriter, String value) throws XMLStreamException {
        xmlStreamWriter.writeStartElement(value);

    }

    private static void addEndOfElement(XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
        xmlStreamWriter.writeEndElement();
    }

    private static void addEndOfDocument(XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndDocument();
    }
}

package org.testxml;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXContentHandler;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

@Slf4j
public class MySAXContentHandler extends SAXContentHandler {

    private Locator locator;

    public MySAXContentHandler(DocumentFactory documentFactory, ElementHandler elementHandler) {
        super(documentFactory, elementHandler);
    }

    public void setDocumentLocator(Locator documentLocator) {
        this.locator = documentLocator;
        super.setDocumentLocator(documentLocator);
    }



    @Override
    public void startElement(String namespaceURI, String localName,
                             String qualifiedName, Attributes attributes) throws SAXException {
        super.startElement(namespaceURI,localName,qualifiedName,attributes);
        ElementPath elementPath =  super.getElementStack();
        Element element = elementPath.getCurrent();
        MyElement myElement = (MyElement) element;
        myElement.setStartLineNumber(locator.getLineNumber());
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        ElementPath elementPath =  super.getElementStack();
        Element element = elementPath.getCurrent();
        MyElement myElement = (MyElement) element;
        myElement.setEndLineNumber(locator.getLineNumber());
        super.endElement(namespaceURI, localName, qName);
    }

}

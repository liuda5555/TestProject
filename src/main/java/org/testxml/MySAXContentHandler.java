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

    private MyDocumentFactory myDocumentFactory = null;

    public MySAXContentHandler(DocumentFactory documentFactory, ElementHandler elementHandler) {
        super(documentFactory, elementHandler);
    }

    public void setMyDocumentFactory(MyDocumentFactory myDocumentFactory) {
        this.myDocumentFactory = myDocumentFactory;
    }

    public void setDocumentLocator(Locator documentLocator) {
        super.setDocumentLocator(documentLocator);
        if (myDocumentFactory != null) {
            this.myDocumentFactory.setLocator(documentLocator);
        }
    }

    public void startElement(String namespaceURI, String localName,
                             String qualifiedName, Attributes attributes) throws SAXException {
        ElementPath elementPath =  super.getElementStack();
        Element element = elementPath.getCurrent();
//        log.debug("")


    }

}

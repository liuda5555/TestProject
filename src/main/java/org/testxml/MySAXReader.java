package org.testxml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXContentHandler;
import org.dom4j.io.SAXReader;
import org.xml.sax.*;

public class MySAXReader extends SAXReader {

    private MyDocumentFactory factory;


    public MySAXReader() {
    }

    public MySAXReader(boolean validating) {
        super(validating);
    }

    public MySAXReader(DocumentFactory factory) {
        super(factory);
    }

    public MySAXReader(DocumentFactory factory, boolean validating) {
        super(factory, validating);
    }

    public MySAXReader(XMLReader xmlReader) {
        super(xmlReader);
    }

    public MySAXReader(XMLReader xmlReader, boolean validating) {
        super(xmlReader, validating);
    }

    public MySAXReader(String xmlReaderClassName) throws SAXException {
        super(xmlReaderClassName);
    }

    public MySAXReader(String xmlReaderClassName, boolean validating) throws SAXException {
        super(xmlReaderClassName, validating);
    }


    public Document read(InputSource in) throws DocumentException {
        try {
            XMLReader reader = getXMLReader();

            reader = installXMLFilter(reader);

            EntityResolver thatEntityResolver = super.getEntityResolver();

            reader.setEntityResolver(thatEntityResolver);

            SAXContentHandler contentHandler = createContentHandler(reader);
            contentHandler.setEntityResolver(thatEntityResolver);
            contentHandler.setInputSource(in);

            boolean internal = isIncludeInternalDTDDeclarations();
            boolean external = isIncludeExternalDTDDeclarations();

            contentHandler.setIncludeInternalDTDDeclarations(internal);
            contentHandler.setIncludeExternalDTDDeclarations(external);
            contentHandler.setMergeAdjacentText(isMergeAdjacentText());
            contentHandler.setStripWhitespaceText(isStripWhitespaceText());
            contentHandler.setIgnoreComments(isIgnoreComments());
            reader.setContentHandler(contentHandler);

            configureReader(reader, contentHandler);

            reader.parse(in);

            return contentHandler.getDocument();
        } catch (Exception e) {
            if (e instanceof SAXParseException) {
                // e.printStackTrace();
                SAXParseException parseException = (SAXParseException) e;
                String systemId = parseException.getSystemId();

                if (systemId == null) {
                    systemId = "";
                }

                String message = "Error on line "
                        + parseException.getLineNumber() + " of document "
                        + systemId + " : " + parseException.getMessage();

                throw new DocumentException(message, e);
            } else {
                throw new DocumentException(e.getMessage(), e);
            }
        }
    }


    protected SAXContentHandler createContentHandler(XMLReader reader) {
        return new MySAXContentHandler(getDocumentFactory(), super.getDispatchHandler());
    }

    public DocumentFactory getDocumentFactory() {
        if (factory == null) {
            factory = new MyDocumentFactory();
        }

        return factory;
    }
}

package org.testxml;

import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.QName;
import org.xml.sax.Locator;

public class MyDocumentFactory extends DocumentFactory {
    private Locator locator;

    public MyDocumentFactory(Locator locator){
        super();
        this.locator = locator;
    }

    @Override
    public Element createElement(QName qname) {
        MyElement element = new MyElement(qname);
        element.setLineNumber(this.locator.getLineNumber());
        return element;
    }

    @Override
    public Element createElement(String name) {
        MyElement element = new MyElement(name);
        element.setLineNumber(this.locator.getLineNumber());
        return element;
    }

    public void setLocator(Locator locator){
        this.locator = locator;
    }

}

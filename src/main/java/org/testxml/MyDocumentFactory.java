package org.testxml;

import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.util.SingletonStrategy;

public class MyDocumentFactory extends DocumentFactory {
    private static SingletonStrategy<DocumentFactory> singleton = null;

    public MyDocumentFactory(){
        super();
    }

    @Override
    public Element createElement(QName qname) {
        return new MyElement(qname);
    }

    @Override
    public Element createElement(String name) {
        return new MyElement(name);
    }

    @Override
    public Element createElement(String qualifiedName, String namespaceURI) {
        return createElement(createQName(qualifiedName, namespaceURI));
    }

}

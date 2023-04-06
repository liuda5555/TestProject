package org.testxml;

import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.tree.DefaultElement;

public class MyElement extends DefaultElement {
    private int lineNumber = 0;
    public MyElement(String name) {
        super(name);
    }

    public MyElement(QName qname) {
        super(qname);
    }

    public MyElement(QName qname, int attributeCount) {
        super(qname, attributeCount);
    }

    public MyElement(String name, Namespace namespace) {
        super(name, namespace);
    }

    public void setLineNumber(int lineNumber){
        this.lineNumber = lineNumber;
    }

}

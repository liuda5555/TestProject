package org.testxml;

import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.tree.DefaultElement;

public class MyElement extends DefaultElement {
    private int startLineNumber = 0;
    private int endLineNumber = 0;
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


    public int getStartLineNumber() {
        return startLineNumber;
    }

    public void setStartLineNumber(int startLineNumber) {
        this.startLineNumber = startLineNumber;
    }

    public int getEndLineNumber() {
        return endLineNumber;
    }

    public void setEndLineNumber(int endLineNumber) {
        this.endLineNumber = endLineNumber;
    }
}

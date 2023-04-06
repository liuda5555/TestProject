package org.testxml;

import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.tree.DefaultElement;

public class MyDefaultElement extends DefaultElement {
    private int startLineNumber = 0;
    private int endLineNumber = 0;

    public MyDefaultElement(String name) {
        super(name);
    }

    public MyDefaultElement(QName qname) {
        super(qname);
    }

    public MyDefaultElement(QName qname, int attributeCount) {
        super(qname, attributeCount);
    }

    public MyDefaultElement(String name, Namespace namespace) {
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

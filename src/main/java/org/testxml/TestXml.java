package org.testxml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class TestXml {


    public static void main(String[] args) throws Exception {
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("./src/main/resources/test.xml");

        Element element = document.getRootElement();
        System.out.println(element.getName());

        List<Element> elements = document.getRootElement().elements();

        elements.forEach(r -> System.out.println(r.getName()));




    }
}

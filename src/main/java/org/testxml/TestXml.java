package org.testxml;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.List;

@Slf4j
public class TestXml {


    public static void main(String[] args) throws Exception {
        MySAXReader saxReader = new MySAXReader();

        Document document = saxReader.read("./src/main/resources/test.xml");

        Element element = document.getRootElement();

        System.out.println("类名：" + element.attributeValue("namespace"));

        List<Element> elements = document.getRootElement().elements();
        for (Element e: elements) {
            MyElement myElement = (MyElement)e;
            System.out.println("标签名称：" + myElement.getName() + "，行号："+ myElement.getStartLineNumber() +" :" + myElement.getEndLineNumber());
            System.out.println(myElement.attribute("id").getValue());
        }







    }
}

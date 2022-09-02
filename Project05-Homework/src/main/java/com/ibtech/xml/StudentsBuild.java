package com.ibtech.xml;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class StudentsBuild {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String path = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\Students.xml";
		Document document = XmlUtilities.parse(path);
		Element root = document.getDocumentElement();
		
		NodeList students = root.getElementsByTagName("student");
		for(int i = 0; i < students.getLength();i++) {
			Element student = (Element) students.item(i);
			String id = XmlUtilities.getAttribute(student, "id", "");
			String name = XmlUtilities.getSingleElementText(student, "name", "");
			double mark = XmlUtilities.getSingleElementText(student, "mark", 0);
			System.out.println(id + " " + name + " " + mark);
		}
	}
}

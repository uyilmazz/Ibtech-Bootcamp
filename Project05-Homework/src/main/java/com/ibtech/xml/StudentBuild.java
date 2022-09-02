package com.ibtech.xml;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class StudentBuild {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String path = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\Student.xml";
		Document document = XmlUtilities.parse(path);
		Element student = document.getDocumentElement();
		String id = XmlUtilities.getAttribute(student,"id","");
		
		String name = XmlUtilities.getSingleElementText(student, "name", "");
		double mark = XmlUtilities.getSingleElementText(student, "mark", 0);
		System.out.println(id + " " + name + " " + mark);
	}
	
}

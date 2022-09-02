package com.ibtech.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.*;

public class XmlCreate {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
		String path = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\Generated.xml";
		Document document = XmlUtilities.create();
//		Element student = document.createElement("student");
//		student.setAttribute("id", "601");
//		document.appendChild(student);
	
		XmlUtilities.addSingleElement(document,null, "student", null, "id", "601");
		Element student = document.getDocumentElement();
		XmlUtilities.addSingleElement(document, student, "name", "Yıldırım Gürses", null, null);
		XmlUtilities.addSingleElement(document, student, "mark", 2.7, null, null);
		
		XmlUtilities.dump(document, path);
	}
}

package com.godoro.xml;

import static com.godoro.xml.XmlUtilities.*;
import org.w3c.dom.*;

public class XmlBuild {
	
	public static void main(String[] args) throws Exception {
		
		// JAXP
		String path = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\Product.xml";
		Document document = XmlUtilities.parse(path);
		
		// DOM
		Element product = document.getDocumentElement();
		String id = getAttribute(product, "id", "");
		System.out.println("Özdeşlik: " + id);
		
		String name = getSingleElementText(product, "name", "");
		System.out.println("Ad: " +name);
		double price = getSingleElementText(product,"price",0);
		System.out.println("Eder: " + price);
	}
}

package com.ibtech.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XmlUtilities {

	private static DocumentBuilderFactory documentBuilderFactory;
	private static DocumentBuilderFactory getFactory() {
		if(documentBuilderFactory == null) {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
		}
		return documentBuilderFactory;
	}
	
	private static TransformerFactory transformerFactory;
	private static TransformerFactory getTransformerFactory() {
		if(transformerFactory == null) {
			transformerFactory = TransformerFactory.newInstance();
		}
		return transformerFactory;
	}
	
	public static Document create() throws ParserConfigurationException {
		DocumentBuilder builder = getFactory().newDocumentBuilder();
		Document document = builder.newDocument();
		return document;
	}
	
	public static void dump(Document document,String path) throws TransformerException, IOException {
		Transformer transformer = getTransformerFactory().newTransformer();
		DOMSource data = new DOMSource(document);
		FileWriter writer = new FileWriter(new File(path));
		StreamResult result = new StreamResult(writer);
		transformer.transform(data, result);
	}
	
	public static Document parse(String path) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder builder = getFactory().newDocumentBuilder();
		Document document = builder.parse(path);
		return document;
	}
	
	public static String getSingleElementText(Element parent,String tag,String defaultValue) {
		NodeList nodelist = parent.getElementsByTagName(tag);
		if(nodelist.getLength() == 0) {
			return defaultValue;
		}
		return nodelist.item(0).getTextContent();
	}
	
	public static double getSingleElementText(Element parent,String tag,double defaultValue) {
		String string = getSingleElementText(parent, tag, Double.toString(defaultValue));
		return Double.parseDouble(string);
	}
	
	public static String getAttribute(Element element,String tag,String defaulValue) {
		if(!(element.hasAttribute(tag))) {
			return defaulValue;
		}
		return element.getAttribute(tag);
	}
	
	public static Long getAttribute(Element element,String tag,long defaulValue) {
		String string = getAttribute(element, tag, Long.toString(defaulValue));
		return Long.parseLong(string);
	}
	
	public static void addSingleElement(Document document,Element parent,String tag,String content,String attribute,String attributeValue) {
		Element element = document.createElement(tag);
		
		if(content != null) {
			element.setTextContent(content);
		}
		
		if(attribute != null) {
			element.setAttribute(attribute, attributeValue);
		}
		
		if(parent == null) {
			document.appendChild(element);
		}else {
			parent.appendChild(element);
		}
	}
	
	public static void addSingleElement(Document document,Element parent,String tag,double content,String attribute,String attributeValue) {
		addSingleElement(document, parent, tag, Double.toString(content),attribute,attributeValue);
	}
}

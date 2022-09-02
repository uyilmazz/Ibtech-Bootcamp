package com.godoro.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlUtilities {

	private static DocumentBuilderFactory factory;
	private static DocumentBuilderFactory getFactory() {
		if(factory == null) {
			factory = DocumentBuilderFactory.newInstance();
		}
		return factory;
	}
	
	public static Document parse(String path) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder builder = getFactory().newDocumentBuilder();
		Document document = builder.parse(path);
		return document;
	}
	
	public static Document parse(InputStream in) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder builder = getFactory().newDocumentBuilder();
		Document document = builder.parse(in);
		return document;
	}
	
	public static Document create(String root) throws Exception {
		DocumentBuilder builder = getFactory().newDocumentBuilder();
		Document document = builder.newDocument();
		Element employee = document.createElement(root);
		document.appendChild(employee);
		return document;
	}
	
	public static void dump(Document document,String path) throws IOException, TransformerException {
		FileWriter writer = new FileWriter(new File(path));
		dump(document,writer);
	}
	
	public static String dump(Document document) throws IOException, TransformerException {
		StringWriter writer = new StringWriter();
		dump(document,writer);
		return writer.toString();
	}
	
	public static void dump(Document document,Writer writer) throws IOException, TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer =  factory.newTransformer();
		DOMSource data = new DOMSource(document);
		StreamResult result = new StreamResult(writer);
		transformer.transform(data, result);
		writer.close();
	}
	
	public static String getSingleElementText(Element parent,String tag,String defaultValue) {
		NodeList elementList = parent.getElementsByTagName(tag);
		if(elementList.getLength() == 0) {
			return defaultValue;
		}
		return elementList.item(0).getTextContent();
	}
	
	public static double getSingleElementText(Element parent,String tag,double defaultValue) {
		String string = getSingleElementText(parent,tag,Double.toString(defaultValue));
		return Double.parseDouble(string);
	}
	
	public static String getAttribute(Element element,String name,String defaultValue) {
		if(!element.hasAttribute(name)) {
			return defaultValue;
		}
		return element.getAttribute(name);
	}
	
	public static Long getAttribute(Element element,String name,long defaultValue) {
		String string = getAttribute(element,name,Long.toString(defaultValue));
		return Long.parseLong(string);
	}
	
	public static void addSingleElementText(Document document,Element parent,String tag,String content) {
		Element name = document.createElement(tag);
		name.setTextContent(content);
		parent.appendChild(name);
	}
	
	public static void addSingleElementText(Document document,Element parent,String tag,double content) {
		String string = Double.toString(content);
		addSingleElementText(document,parent,tag,string);
	}
}

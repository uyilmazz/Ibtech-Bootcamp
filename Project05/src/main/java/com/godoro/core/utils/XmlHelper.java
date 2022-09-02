package com.godoro.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlHelper {
	
	private static DocumentBuilderFactory documentBuilderFactory;
	private static DocumentBuilderFactory getDocumentBuilderFactory() {
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
		
	public static void dump(Document document,OutputStream out) throws TransformerException, IOException  {
		Transformer transformer =  getTransformerFactory().newTransformer();
		DOMSource data = new DOMSource(document);
		StreamResult result = new StreamResult(out);
		transformer.transform(data, result);
		out.close();
	}
	
	public static Document parse(InputStream in) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder builder = getDocumentBuilderFactory().newDocumentBuilder();
		Document document = builder.parse(in);
		return document;
	}
}

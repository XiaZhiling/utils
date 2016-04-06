package com.zoran.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.zoran.handles.SAXParserHandler;

public class SaxXml {
	
	public void parseXml() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse("src/resources/books.xml", new SAXParserHandler());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void createXml() {
		SAXTransformerFactory stf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		try {
			TransformerHandler hander = stf.newTransformerHandler();
			Transformer tr = hander.getTransformer();
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			
			File file = new File("D:/xzm.xml");
			if(file.exists()){
				file.createNewFile();
			}
			Result result = new StreamResult(new FileOutputStream(file));
			hander.setResult(result);
			
			hander.startDocument();
			AttributesImpl atts =new AttributesImpl();
			hander.startElement("", "", "bookStore", atts);
			atts.clear();
			atts.addAttribute("", "", "id", "", "1");
			hander.startElement("", "", "book", atts);
			atts.clear();
			hander.startElement("", "", "name", atts);
			hander.characters("罗密欧".toCharArray(), 0, "罗密欧".length());
			hander.endElement("", "", "name");
			hander.endElement("", "", "book");
			hander.endElement("", "", "bookStore");
			hander.endDocument();
			
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SAXException e) {
			e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		SaxXml saxXml = new SaxXml();
		saxXml.createXml();
	}
}

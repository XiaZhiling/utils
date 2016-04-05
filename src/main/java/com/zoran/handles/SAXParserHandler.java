package com.zoran.handles;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX解析开始");
	}
	
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX解析结束");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if(qName.equals("book")){
			System.out.println("开始遍历某本书的内容");
//			//已知book元素下的属性名称
//			String value = attributes.getValue("id");
//			System.out.println("book的属性值是：" + value);
			
			//不知道book元素下的属性名称
			for(int i = 0 ;i<attributes.getLength();i++){
				System.out.print("book元素的第"+(i+1)+"个属性名是："+attributes.getQName(i));
				System.out.println("--属性值："+attributes.getValue(i));
			}
		}else if(!qName.equals("book")&&!qName.equals("bookstore")){
			System.out.print("节点名是"+qName);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if("book".equals(qName)){
			System.out.println("结束遍历某本书的内容");
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		String st = new String(ch, start, length);
		if(!st.trim().equals("")){
			System.out.println("---节点值："+st);
		}
	}
}

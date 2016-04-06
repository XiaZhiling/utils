package com.zoran.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jXml {
	
	@SuppressWarnings("unchecked")
	public void parseXml(){
		//1.创建SaxReader 的对象saxReader
		SAXReader saxReader = new SAXReader();
		try {
			//2.通过saxReader.read方法加载books.xml并创建Document对象
			Document document = saxReader.read(new File("src/resources/books.xml"));
			//3.获取根节点
			Element rootElement =  document.getRootElement();
			//4.通过elementIterator方法获取迭代器
			Iterator<Element> it = rootElement.elementIterator();
			//遍历迭代器，获取根节点中的信息（书籍）
			while(it.hasNext()){
				Element book =  it.next();
				//获取book的属性名以及属性值
				List<Attribute> attrs =  book.attributes();
				for (Attribute attribute : attrs) {
					System.out.println("属性名："+attribute.getName()+"--属性值"+attribute.getValue());
				}
				
				//遍历节点名
				Iterator<Element>  itt= book.elementIterator();
				while(itt.hasNext()){
					Element bookChild = itt.next();
					System.out.println("节点名："+bookChild.getName()+"--节点值"+bookChild.getStringValue());
				}
				
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Dom4jXml dom4jXml = new Dom4jXml();
		dom4jXml.parseXml();
	}

}

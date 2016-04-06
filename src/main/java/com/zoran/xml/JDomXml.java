package com.zoran.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDomXml {
	
	public void parseXml() {
		//1.创建一个SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream in;
		try {
			//2.创建一个输入流，将xml文件加载到输入流
			in = new FileInputStream("src/resources/books.xml");
			//3.通过saxBuilder的build方法，将输入流加载到saxBuilder中
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");//解决有可能乱码的问题
			Document document = saxBuilder.build(isr);
			//4.通过document对象获取xml文件的根节点
			Element rootElement =  document.getRootElement();
			List<Element> bookList =  rootElement.getChildren();
			
			//开始解析
			for (Element book : bookList) {
				System.out.println("开始解析第"+(bookList.indexOf(book)+1)+"本书");
				//解析属性名属性值
				List<Attribute> attrs  = book.getAttributes();
				for (Attribute attribute : attrs) {
					System.out.println("属性名：" + attribute.getName()+"--属性值："+attribute.getValue());
				}
				
				//对book子节点的解析
				List<Element> bookChild = book.getChildren();
				for (Element child : bookChild) {
					System.out.println("节点名：" + child.getName()+"--节点值："+child.getValue());
				}
				System.out.println("结束解析第"+(bookList.indexOf(book)+1)+"本书");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		JDomXml jDomXml = new JDomXml();
		jDomXml.parseXml();
	}

}

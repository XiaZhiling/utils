package com.zoran.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

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
	
	public void creatXml() {
		//1.创建document对象  代表整个xml
		Document document = DocumentHelper.createDocument();
		//2.创建根节点rss
		Element rss = document.addElement("rss");
		//3.向rss节点中添加version属性
		rss.addAttribute("version", "2.0");
		//4.生成子节点及子节点的内容
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("国内最新新闻");
		Element name = channel.addElement("name");
		name.setText("<国内最新新闻>");
		
		//设置生成xml格式
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("GBK");
		
		//4.生成xml文件
		File file = new File("D:/rss.xml");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file),outputFormat);
			//设置是否转义  默认true代表转义
			writer.setEscapeText(false);
			writer.write(document);
			writer.close();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		Dom4jXml dom4jXml = new Dom4jXml();
//		dom4jXml.parseXml();
		dom4jXml.creatXml();
	}

}

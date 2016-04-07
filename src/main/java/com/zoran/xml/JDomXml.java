package com.zoran.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

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
	
	public void createXml() {
		//1.生成一个根节点
		Element rootElement = new Element("rss");
		//2.为节点添加属性
		rootElement.setAttribute("version", "2.0");
		Element channel = new Element("channel");
		rootElement.addContent(channel);
		Element title = new Element("title");
		title.setText("这是一个Title");
		channel.addContent(title);
		
		Element name = new Element("name");
		CDATA cdata = new CDATA("<这是行>");  //转义字符的处理
		name.addContent(cdata);
		channel.addContent(name);
		
		//3.生成一个document对象
		Document document= new Document(rootElement);
		
		//
		Format format = Format.getCompactFormat();
		format.setIndent("");//设置换行
		format.setEncoding("UTF-8");//设置编码
		//4.创建一个XMLOutputter对象
		XMLOutputter outputter = new XMLOutputter(format);
		//5.通过outputter输出document对象
		try {
			outputter.output(document, new FileOutputStream(new File("D:/rsss.xml")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JDomXml jDomXml = new JDomXml();
//		jDomXml.parseXml();
		jDomXml.createXml();
	}

}

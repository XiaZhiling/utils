package com.zoran.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParse {
	
	

	public static void main(String[] args) {
		//1.创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			//2.创建一个DocumentBuilder的对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			//3.通过DocumentBuilder.parse方法加载books.xml到当前项目下
			Document document = db.parse("src/resources/books.xml");
			
			//通过getElementsByTagName获取所有book节点的集合
			NodeList bookList = document.getElementsByTagName("book");
			System.out.println("一共有"+bookList.getLength()+"本books");
			for(int i=0;i<bookList.getLength();i++){
				//通过item(i)方法获取一个book节点
				Node book = bookList.item(i);
				
				
				//获取book节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第"+(i+1)+"本book共有"+attrs.getLength()+"个属性");
				for(int j=0;j<attrs.getLength();j++){
					Node node = attrs.item(j);
					System.out.print("属性名："+node.getNodeName());
					System.out.println("--属性值："+node.getNodeValue());
				}
				
				
				//获取book节点的所有子节点
				NodeList childNodes =  book.getChildNodes();
				System.out.println("第"+(i+1)+"本书共有"+childNodes.getLength()+"个子节点");
				for(int k =0;k<childNodes.getLength();k++){
					//区分Element类型的Node和text类型的Node
					if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
						System.out.print("第"+(k+1)+"个子节点的节点名："+childNodes.item(k).getNodeName());
//						System.out.println("--节点值："+childNodes.item(k).getFirstChild().getNodeValue());
						System.out.println("--节点值："+childNodes.item(k).getTextContent());
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

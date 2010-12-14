package com.sheng.util;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConnfigReader {
	public static ConnfigReader instance=new ConnfigReader();
	private Document doc;
	//private static String user;
	private Jdbcpro jdbcpro;
	private ConnfigReader(){
		try{
			jdbcpro=new Jdbcpro();
			doc=new SAXReader().read(Thread.currentThread().getContextClassLoader().getResourceAsStream("Jdbinfo.xml"));
			//System.out.println(doc);//-------------ok
			Element driver=(Element) doc.selectSingleNode("//config/driver-name");
			//System.out.println(driver);//--------------ok
			Element url=(Element) doc.selectSingleNode("//config/url");
			//System.out.println(url);//--------ok
			Element username=(Element) doc.selectSingleNode("//config/username");
			//System.out.println(username);---------ok
			//user=username.getStringValue();
			Element passwd=(Element) doc.selectSingleNode("//config/passwd");
			jdbcpro.setDrivername(driver.getStringValue());
			jdbcpro.setUrl(url.getStringValue());
			jdbcpro.setUsername(username.getStringValue());
			jdbcpro.setPasswd(passwd.getStringValue());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("解析文件出现问题");
		}
		
	}	
	public static ConnfigReader getInstance(){
		return instance;
	}
	public Jdbcpro getJdbcpro(){
		return jdbcpro;
	}
	public static void main(String args[]){
		System.out.println("user:"+(ConnfigReader.getInstance().getJdbcpro().getPasswd()).equals(""));
	}
}

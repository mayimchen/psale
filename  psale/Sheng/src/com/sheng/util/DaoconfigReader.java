package com.sheng.util;

import org.dom4j.Document;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 单例模式
 * **/
public class DaoconfigReader {
	private Daopro dp;
	private Document doc;
	private static DaoconfigReader instance=new DaoconfigReader();
	private  DaoconfigReader(){
		dp=new Daopro();
		try {
			doc=new SAXReader().read(Thread.currentThread().getContextClassLoader().getResourceAsStream("daoinfo.xml"));
			Element insertuserdao=(Element) doc.selectSingleNode("//config/insertuserdao");
			Element checkuserexistdao=(Element) doc.selectSingleNode("//config/checkuserexistdao");
			Element insertwuliaodao=(Element) doc.selectSingleNode("//config/insertwuliaodao");
			Element delwuliaodao=(Element) doc.selectSingleNode("//config/delwuliaodao");
			Element findwuliaodao=(Element) doc.selectSingleNode("//config/findwuliaodao");
			Element getuinfodao=(Element) doc.selectSingleNode("//config/getuinfodao");
			Element lookpersondao=(Element) doc.selectSingleNode("//config/lookpersondao");
			Element manageuserdao=(Element) doc.selectSingleNode("//config/manageuserdao");
			Element saveandbackdao=(Element) doc.selectSingleNode("//config/saveandbackdao");
			dp.setCheckuserexistdao(checkuserexistdao.getStringValue());
			dp.setDelwuliaodao(delwuliaodao.getStringValue());
			dp.setFindwuliaodao(findwuliaodao.getStringValue());
			dp.setGetuinfodao(getuinfodao.getStringValue());
			dp.setInsertuserdao(insertuserdao.getStringValue());
			dp.setInsertwuliaodao(insertwuliaodao.getStringValue());
			dp.setLookpersondao(lookpersondao.getStringValue());
			dp.setManageuserdao(manageuserdao.getStringValue());
			dp.setSaveandbackdao(saveandbackdao.getStringValue());
		} catch (Exception  e) {
			System.out.println("dao解析文件加载失败");
			e.printStackTrace();
		}
		
	}
	public static DaoconfigReader getInstance(){
		
		return instance;
	
	}
	public Daopro getDp(){
		return dp;
	}
}

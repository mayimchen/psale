package com.sheng.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConnfigReader {
	public static ConnfigReader instance = new ConnfigReader();
	private Document doc;
	// private static String user;
	private Jdbcpro jdbcpro;

	private ConnfigReader() {
		try {
			jdbcpro = new Jdbcpro();
			doc = new SAXReader()
					.read(Thread.currentThread().getContextClassLoader()
							.getResourceAsStream("Jdbinfo.xml"));

			Element driver = (Element) doc
					.selectSingleNode("//config/driver-name");

			Element url = (Element) doc.selectSingleNode("//config/url");

			Element username = (Element) doc
					.selectSingleNode("//config/username");

			Element passwd = (Element) doc.selectSingleNode("//config/passwd");
			Element maxactive = (Element) doc
					.selectSingleNode("//config/maxactive");
			Element maxwaite = (Element) doc
					.selectSingleNode("//config/maxwait");
			Element maxinit = (Element) doc
					.selectSingleNode("//config/maxinit");
			Element maxidle = (Element) doc
					.selectSingleNode("//config/maxidle");
			jdbcpro.setDrivername(driver.getStringValue());
			jdbcpro.setUrl(url.getStringValue());
			jdbcpro.setUsername(username.getStringValue());
			jdbcpro.setPasswd(passwd.getStringValue());
			jdbcpro.setMaxactive(Integer.parseInt(maxactive.getStringValue()));
			jdbcpro.setMaxidle(Integer.parseInt(maxidle.getStringValue()));
			jdbcpro.setMaxinit(Integer.parseInt(maxinit.getStringValue()));
			jdbcpro.setMaxwaite(Integer.parseInt(maxwaite.getStringValue()));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("解析文件出现问题");
		}

	}

	public static ConnfigReader getInstance() {
		return instance;
	}

	public Jdbcpro getJdbcpro() {
		return jdbcpro;
	}

	public static void main(String args[]) {
		/*System.out.println("user:"
				+ (ConnfigReader.getInstance().getJdbcpro().getPasswd())
						.equals(""));*/
		
		/*System.out.println("Maxactive:"+ConnfigReader.getInstance().getJdbcpro().getMaxactive());
		System.out.println("Maxidle:"+ConnfigReader.getInstance().getJdbcpro().getMaxidle());
		System.out.println("maxinit:"+ConnfigReader.getInstance().getJdbcpro().getMaxinit());
		System.out.println("maxwaite:"+ConnfigReader.getInstance().getJdbcpro().getMaxwaite());*/
	}
}

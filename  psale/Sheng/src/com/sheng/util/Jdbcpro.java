package com.sheng.util;

/*
 * @param drivername ����
 * @param url  ���ݿ��ַ
 * @param username   �û���
 * @param  passwd   ����
 * @param   maxactive  ���������
 * @param   maxwaite  ���ӵȴ�ʧЧʱ��
 * @param   maxinit  ��ʼ��������
 * @param   maxidle  �������������
 * **/
public class Jdbcpro {
	private String drivername;
	private String url;
	private String username;
	private String passwd;
	private int maxactive;
	private int maxwaite;
	private int maxinit;
	private int maxidle;
	public int getMaxinit() {
		return maxinit;
	}
	public void setMaxinit(int maxinit) {
		this.maxinit = maxinit;
	}
	public int getMaxidle() {
		return maxidle;
	}
	public void setMaxidle(int maxidle) {
		this.maxidle = maxidle;
	}
	public int getMaxactive() {
		return maxactive;
	}
	public void setMaxactive(int maxactive) {
		this.maxactive = maxactive;
	}
	public int getMaxwaite() {
		return maxwaite;
	}
	public void setMaxwaite(int maxwaite) {
		this.maxwaite = maxwaite;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}

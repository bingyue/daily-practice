package me.bingyue.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @Title: TestPost 
 * @Description: Java模拟http登录
 */
public class TestPost {
	
	static String SURL="http://xuan.news.cn/xhcms/login";

	public static void main(String args[]){
		
	}
	
	/**
	 * 使用HttpURLConnection
	 * @throws MalformedURLException 
	 */
	public static void urlPost() throws IOException{
		StringBuilder sbl=new StringBuilder();
		URL url=new URL(SURL);
		//HttpURLConnection继承自URLConnection
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		//
		connection.setRequestMethod("POST");
		
		StringBuffer sbf = new StringBuffer();  
		sbf.append("username=bingyue_2014");
		sbf.append("password:xinhua201508");
		
	}
	
	/**
	 * 使用httpclient
	 */
	public static void httpclientPost(){
		
//		String xsrfValue = responseHtml.split("<input type=\"hidden\" name= \"_xsrf\" value=\"")[1].split("\"/>")[0];
	}
}

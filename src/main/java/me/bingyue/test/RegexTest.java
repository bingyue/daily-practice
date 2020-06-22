package me.bingyue.test;

import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.regex.Pattern;

public class RegexTest {


	public static String getUUID(){

		UUID uuid=UUID.randomUUID();
		System.out.println(uuid.toString());
		return uuid.toString();
	}





	public static void main(String[] args) {

		getUUID();

//		String s = "<td class=\"qsgg\"><a href=\"/finalpage/2013-03-08/543210.PDF\" target=new>百度知道：2012年我们一起加油</a>  <img align=absMiddle border=0 height=16 src='/imagesnew/Pdf.gif' width=16> (503K) </td>";
//
//		String regex = "<a\\s+href=\"([^\"]*?)\".*?>([^<>]*?)</a>";
//
//		Pattern p = Pattern.compile(regex);
//
//		Matcher m = p.matcher(s);
//
//		while (m.find()) {
//
//			System.out.println(m.group(1));
//
//			System.out.println(m.group(2));
//
//			if (m.group(2).contains("摘要")) {
//
//				System.out.println("字符串中有“摘要”这两个字");
//
//			} else {
//
//				System.out.println("字符串中没有“摘要”这两个字");
//
//			}
//
//		}
		
//		 String keyWord="%E4%BA%92%E5%8A%A8%20%E4%B8%AD%E5%9B%BD%20%E5%AA%92%E4%BD%93";
//		 String regEx="[`~!@#$%^&*()+=|{}':;'\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
//		 Pattern  p = Pattern.compile(regEx);
//		 try {
//			keyWord = java.net.URLDecoder.decode(keyWord,"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//	     keyWord = p.matcher(keyWord).replaceAll(" ").replaceAll("\\s{1,}", " ").trim().replaceAll(" ", ",");//替换查询语句中的特殊字符（不替换逗号）
//	     int i=(0+1)/2;
//	     System.out.println(i);

//			String s = "c_124934671.htm";
//			String ss= "http://news.xinhuanet.com/photo/2013-07/01/c_124934671.htm";
//
//			String regex = "[\\s\\S]*\\_([\\d]+)\\.[\\w]+";
//
//			Pattern p = Pattern.compile(regex);
//
//			Matcher m = p.matcher(ss);
//
//			while (m.find()) {
//
//				System.out.println(m.group(1));
//			}
//			
//			
	}

}
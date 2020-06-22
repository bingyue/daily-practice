package me.bingyue.protocol;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 自定义文本协议
 * 指定使用 ASCII字符集对文本进行编码
 * @author bingyue56@163.com 
 */
public class MsgTxtCoder implements MsgCoder{
	
	/**魔法数字 与其他消息区分开*/
	public static final String MAGIC="MYMSG";
	/**请求或者响应消息*/
	public static final String RESPONSESTR = "P"; 
	public static final String REQUEST = "Q"; 
	
	/**空格区分*/
	public static final String DELIMSTR=" ";
	/**编码方式*/
	public static final String CHARSET = "US-ASCII";  

	@Override
	public byte[] encode(CustomMessage msg) throws IOException{
		String strMessage=MAGIC+DELIMSTR+(msg.isResponse()?RESPONSESTR:REQUEST)
				+DELIMSTR+msg.getId()+DELIMSTR+msg.getContent();		
		byte[] data=strMessage.getBytes(CHARSET);
		return data;
	}

	@Override
	public CustomMessage parse(byte[] data) throws IOException{
		ByteArrayInputStream msgStream=new ByteArrayInputStream(data);
		Scanner s = new Scanner(new InputStreamReader(msgStream, CHARSET));
		String temp;
		boolean isResponse;
		int id;
		String content;
		try{
			temp=s.next();
			if(!temp.equals(MAGIC))
				throw new IOException("wrong message");
			
			temp=s.next();
			if(temp.equals(RESPONSESTR))
				isResponse=true;
			else if(temp.equals(REQUEST))
				isResponse=false;
			else
				throw new IOException("wrong response or request");
			
			id=Integer.valueOf(s.next());
			content=s.next();
			
		}catch(Exception e){
			throw new IOException("parse error");
		}
		
		return new CustomMessage(isResponse, id, content);
	}

}

package me.bingyue.protocol;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 自定义二进制协议
 * @author bingyue56@163.com 
 */
public class MsgBinaryCoder implements MsgCoder {

	/**魔法数字 与其他消息区分开*/
	public static final int MAGIC=0X0000;
	public static final int MIN_WIRE_LENGTH = 4;  
	public static final int MAX_WIRE_LENGTH = 16;  
	public static final int RESPONSE_FLAG = 0x0200;  
	
	@Override
	public byte[] encode(CustomMessage msg) throws IOException{
		
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();  
		DataOutputStream out = new DataOutputStream(byteStream); 
		/**拼接二进制信息*/
		short magicAndFlags = MAGIC;  
		if (msg.isResponse()) {  
		     magicAndFlags |= RESPONSE_FLAG;  
		   }  
		 
		out.writeShort(magicAndFlags); 
		out.write((msg.getId()));  
		byte[] data = byteStream.toByteArray();  
		return data;
	}

	@Override
	public CustomMessage parse(byte[] data) throws IOException{
		/**待续*/
		return null;
	}

}

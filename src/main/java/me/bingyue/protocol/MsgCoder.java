package me.bingyue.protocol;

import java.io.IOException;

public interface MsgCoder {

	/**将对象编码成文件流
	 * @throws Exception */
	byte[] encode(CustomMessage msg) throws IOException;
	
	/**从文件流中解析得到对象
	 * * @throws Exception */
	CustomMessage parse(byte[] data) throws IOException;
}

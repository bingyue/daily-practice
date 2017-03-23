package me.bingyue.practice.protocol;

/**
 * 消息格式
 * @author bingyue56@163.com 
 */
public class CustomMessage {

	private boolean isResponse;/**请求或者响应消息*/
	private int id;/**消息id*/
	private String content;/**消息体*/
	
	public CustomMessage(boolean isResponse,int id,String content){
		this.isResponse=isResponse;
		this.id=id;
		this.content=content;
	}


	public boolean isResponse() {
		return isResponse;
	}


	public void setResponse(boolean isResponse) {
		this.isResponse = isResponse;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
}

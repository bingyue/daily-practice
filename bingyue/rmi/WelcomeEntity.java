package bingyue.rmi;

import java.io.Serializable;

public class WelcomeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String hello;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHello() {
		return hello;
	}
	public void setHello(String hello) {
		this.hello = hello;
	}
	

}

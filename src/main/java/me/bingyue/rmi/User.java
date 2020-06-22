package me.bingyue.rmi;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String age;
	
	public User(String id,String name,String age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("~用户id-"+id);
		sb.append("~用户姓名-"+id);
		sb.append("~用户年龄-"+id);
		return sb.toString();
	}

}

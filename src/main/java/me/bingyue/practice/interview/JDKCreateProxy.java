package me.bingyue.practice.interview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKCreateProxy {

	//生成代理类
	public Object create(Object obj) {
		
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), (InvocationHandler) this);
		}
}

package me.bingyue.practice.simplerpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RpcImporter <S>{

	/** 
	 *  向服务端发送数据流
	 *  监听Socket返回
	 */
	@SuppressWarnings("unchecked")
	public S importer(final Class<?> serviceClass,final InetSocketAddress addr){
		
		return (S)Proxy.newProxyInstance(serviceClass.getClassLoader(), 
				serviceClass.getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						Socket socket=null;
						ObjectOutputStream output=null;
						ObjectInputStream input=null;
						try{
							socket=new Socket();
							socket.connect(addr);
							output=new ObjectOutputStream(socket.getOutputStream());
							/**写入接口相关信息*/
							System.out.println("获取类的限定名"+serviceClass.getName());
							output.writeUTF(serviceClass.getName());
							
							System.out.println("方法名称"+method.getName());
							output.writeUTF(method.getName());
							
							System.out.println("参数类型"+method.getParameterTypes());
							output.writeObject(method.getParameterTypes());
							
							System.out.println("方法调用的参数值的对象数组"+args);
							output.writeObject(args);
							
							if(socket.getInputStream()!=null)
								input=new ObjectInputStream(socket.getInputStream());
							/**返回监听socket端口的结果*/
							return input.readObject();
							
						}finally{
							if(socket!=null)
								socket.close();
							if(output!=null)
								output.close();
						}
						
						
					}
				});
	}
}

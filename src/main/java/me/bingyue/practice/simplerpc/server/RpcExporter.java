package me.bingyue.practice.simplerpc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RpcExporter {

	static Executor executor=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	/**
	 * 服务发布者的主要职责
	 * 1)作为服务端,监听客户端的TCP连接,接收到新的客户端连接后,将其封装成Task,由线程池执行
	 * 2)将客户端发送的数据流反序列化成对象，通过反射调用服务实现者，获取执行结果
	 * 3)将执行结果对象反序列化，通过socket发送给客户端
	 * 4)调用完成以后，释放Socket等连接资源,防止句柄泄露
	 */
	public static void experter(String host,int port) throws Exception{ 
	
		ServerSocket server=new ServerSocket();
		server.bind(new InetSocketAddress(host, port));
		
		try{
			while(true){
				executor.execute(new ExperterTask(server.accept()));
			}
			
		}finally{
			server.close();
		}
	}
	
	/**
	 * 不对外开放的内部类请声明为私有
	 */
	static class ExperterTask implements Runnable{

		Socket client=null;
		
		public ExperterTask(Socket socket){
			this.client=socket;
		}
		
		@Override
		public void run() {
			ObjectInputStream input=null;
			ObjectOutputStream output=null;
			
			try{
				input=new ObjectInputStream(client.getInputStream());
				String interfaceName=input.readUTF();
				Class<?> service=Class.forName(interfaceName);
				String methodName=input.readUTF();
				Class<?> parameterTypes=(Class<?>)input.readObject();
				Object[] arguments=(Object[])input.readObject();
				
				Method method=service.getMethod(methodName, parameterTypes);
				
				Object result=method.invoke(service.newInstance(), arguments);
				
				output.writeObject(result);
				output.write(null);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				if(client!=null)
					try {
						client.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if(input!=null)
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if(output!=null)
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
			}
		}
		
	}
	
}

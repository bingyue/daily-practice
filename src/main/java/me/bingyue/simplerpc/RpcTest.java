package me.bingyue.simplerpc;

import java.net.InetSocketAddress;

import me.bingyue.simplerpc.client.RpcImporter;
import me.bingyue.simplerpc.server.EchoService;
import me.bingyue.simplerpc.server.EchoServiceImpl;
import me.bingyue.simplerpc.server.RpcExporter;

/**
 * 客户端测试
 */
public class RpcTest {

	public static void main(String[] agrs){
		new Thread(new Runnable() {
			@Override
			public void run() {
				try{
					RpcExporter.experter("localhost",8888);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}).start();
		
		RpcImporter<EchoService> importer=new RpcImporter<EchoService>();
		/**此处class的泛型不能是接口*/
		EchoService serv=importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8888));
		System.out.println(serv.echo("Try connect "));
		
	}
}

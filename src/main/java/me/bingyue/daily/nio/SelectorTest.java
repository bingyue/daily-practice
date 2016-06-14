package me.bingyue.daily.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * 测试使用Selector
 * @author Daniel
 *
 */
public class SelectorTest {

	public static void main(String[] args){
		try {
			//创建选择器
			Selector sle =Selector.open();
			//创建socket服务器通道
			ServerSocketChannel socketChn=ServerSocketChannel.open();
			/**
			 * 绑定端口
			 * InetSocketAddress是SocketAddress的子类
			 */
			socketChn.socket().bind(new InetSocketAddress(65535));
			//设置是否非阻塞
			socketChn.configureBlocking(false);
			/**
			 * 将通道注册到选择器，指定通道兴趣是等待接收连接  
			 * NIO中定义了4中可选择操作：OP_READ(读)、OP_WRITE(写)、OP_CONNECT(连接)、OP_ACCEPT(接受)，
			 * 这些常量在SelectionKey中定义
			 */
			SelectionKey key = socketChn.register(sle, SelectionKey.OP_ACCEPT);
			//使用while循环轮询获取注册到选择器中通道感兴趣的操作
			while(true){
				//选择注册到选择器中通道感兴趣的键，此方法是阻塞的，直到有感兴趣的事件发生
//				int n=sle.select();
				//立即查询，非阻塞
				int n=sle.selectNow();
				 Iterator<SelectionKey> iter = sle.selectedKeys().iterator();  
			        while (iter.hasNext()) {  
			            SelectionKey keyy = iter.next();  
			            iter.remove();  
			            // ......  
			        } 
			    	//close()方法可以关闭选择器
					sle.close();
			    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

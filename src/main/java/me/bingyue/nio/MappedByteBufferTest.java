package me.bingyue.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * Use MappedByteBuffer to realize Memory-Mapped Files
 * @author Daniel
 *
 */
public class MappedByteBufferTest {

	/**
	 * 
	 */
	public static void main(String[] args){
		
		try {
			
			RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
			FileChannel fc = raf.getChannel();  
			//将test.txt文件所有数据映射到虚拟内存，并只读  
			MappedByteBuffer mbuff = fc.map(MapMode.READ_ONLY, 0, fc.size()); 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
}

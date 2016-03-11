package bingyue.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class TestObj {

	public static void main(String[] args){

//		int totalCount=40;
//		int pageSize=20;
		
		try {
			File file = new File("G:\\test.txt");
			InputStream input=new FileInputStream(file);
			 StringBuffer buffer = new StringBuffer();
		        byte[] bytes = new byte[1024];
		        for(int n ; (n = input.read(bytes))!=-1 ; ){
		            buffer.append(new String(bytes,0,n));
		        }
		        System.out.println(isMessCode(buffer.toString()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       


	}
	
	public static boolean isMessCode(String str){
		 for (int i = 0; i < str.length(); i++) {
			   char c = str.charAt(i);
			   // 当从Unicode编码向某个字符集转换时，如果在该字符集中没有对应的编码，则得到0x3f（即问号字符?）
			   //从其他字符集向Unicode编码转换时，如果这个二进制数在该字符集中没有标识任何的字符，则得到的结果是0xfffd
			   //System.out.println("--- " + (int) c);
			   if ((int) c == 0xfffd) {
			    // 存在乱码
			    //System.out.println("存在乱码 " + (int) c);
			    return true;
			   }
			  }
			  return false;
	}
	
	public static void  bigSet(){
//		//初始化一个长度为2^32的BiteSet
//		BitSet bitSet = new BitSet(2^32);  
//		System.out.println(bitSet.size());  
//        //将指定位的值设为true  
//        bitSet.set(2^20, true);  
//        //输出指定位的值  
//        System.out.println(bitSet.get(1024));  
//        System.out.println(bitSet.get(2^20));  
	}
	
	public static String ttt(){
		String ttt="0/1/2/3/";
		
		StringBuffer orgIds=new StringBuffer(ttt.endsWith("/")?ttt:ttt.concat("/"));
		orgIds.append("4");
		int size=orgIds.length();
		for(int i=0;i<size;i++ ){
			if(orgIds.charAt(i)=='/'){
				orgIds.setCharAt(i, '_');
			}
		}
		
		return orgIds.toString();
	}
	
	 public static void add(Byte b)
	    {
	        b = b++;
	    }
	    public static void test()
	    {
	        Byte a = 127;
	        Byte b = 127;
	        add(++a);
	        System.out.print(a + " ");
	        add(b);
	        System.out.print(b + "");
	    }
}

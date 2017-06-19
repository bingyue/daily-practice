package me.bingyue.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.imageio.stream.FileImageInputStream;

public class LoadImage {
	
	public static void main(String[] args){
		
		//String imgurl="https://img.daily.taobaocdn.net/imgextra/i3/3638350697/TB2HdtjXiHdkKJjyzdKXXb1DFXa_!!3638350697.jpg";
		//String imgurl="http://img.daily.taobaocdn.net/bao/uploaded/TB1jpJnXiHdkKJjyzdKL6T1DFXa";
		String imgurl="https://img.daily.taobaocdn.net/imgextra/i1/3638350697/TB2pN0kXiHdkKJjyzdKXXb1DFXa_!!3638350697.jpeg";

        try {
        	
            imgurl=imgurl.replace("https:","http:");
        	
			URL url = new URL(imgurl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			
//	        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	        // 取得该连接的输入流，以读取响应内容
	        // InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream());

			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();//通过输入流获取图片数据

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while( (len=inStream.read(buffer)) != -1 ){
				byteArrayOutputStream.write(buffer, 0, len);
			}
			inStream.close();
			
			byte[] imagebuffer = byteArrayOutputStream.toByteArray();  
	        //new一个文件对象用来保存图片，默认保存当前工程根目录  
	        File imageFile = new File("temp.jpg");  
	        //创建输出流  
	        FileOutputStream fileOutputStream = new FileOutputStream(imageFile);  
	        //写入数据  
	        fileOutputStream.write(imagebuffer);  
	        //关闭输出流  
	        fileOutputStream.close();  
	        
	        
			System.out.println(imagebuffer);
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
              
//        String[] uriStrs2=imgurl.split("imgextra/");
//		//https://img.daily.taobaocdn.net/imgextra/i3/3638350697/TB2HdtjXiHdkKJjyzdKXXb1DFXa_!!3638350697.jpg
//	    if (imgurl != null && imgurl.indexOf("imgextra") != -1) {
//	        String[] uriStrs=imgurl.split("imgextra/");
//	        String imgPath=uriStrs[1];
//	        String[] pathStrs=imgPath.split("/");
//	        String imageName=pathStrs[pathStrs.length-1];
//	        String[] nameStrs=imageName.split("\\.");
//
//	        String suffix=null;
//	        String fileName=nameStrs[0];
//	        if(nameStrs.length>1){
//	            suffix=nameStrs[1];
//	        }
//	        
//	        System.out.println("fileName="+fileName);
//	        System.out.println("suffix"+suffix);
//
//	    }else{
//	        System.out.println("fileName=asdd"); 	
//	    }
//	
	}
	
	public byte[] image2byte(String path){
	    byte[] data = null;
	    FileImageInputStream input = null;
	    try {
	      input = new FileImageInputStream(new File(path));
	      ByteArrayOutputStream output = new ByteArrayOutputStream();
	      byte[] buf = new byte[1024];
	      int numBytesRead = 0;
	      while ((numBytesRead = input.read(buf)) != -1) {
	      output.write(buf, 0, numBytesRead);
	      }
	      data = output.toByteArray();
	      output.close();
	      input.close();
	    }
	    catch (FileNotFoundException ex1) {
	      ex1.printStackTrace();
	    }
	    catch (IOException ex1) {
	      ex1.printStackTrace();
	    }
	    return data;
	  }
	
	
}

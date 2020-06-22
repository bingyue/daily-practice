package me.bingyue.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BooleanTest {

	public static void main(String[] args){
		SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		try {
		int timeStamp=1488452129;
		Long time=new Long(timeStamp);
		String d = format.format(time);
		Date date = format.parse(d);
		System.out.println(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

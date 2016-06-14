package me.bingyue.daily.bat;

/**
 * final修饰参数
 * @author Bingyue
 *
 */
public class FinalParam {
	public static void main(String[] args){
		FinalParam test=new FinalParam();
		test.change(10);
	}
	public void change(final int i){
//		i++; 编译报错
		System.out.print(i);
	}
}

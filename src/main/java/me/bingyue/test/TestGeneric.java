package me.bingyue.test;

import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 * <T extends Comparable<T>>
 * 对泛型约束，T必须是Comparable的子类
 * <T extends Comparable<? super T>>
 * 对泛型约束，T必须直接实现Comparable，注意理解Comparable<? super T>不能分割
 * 而且，对泛型不能只约束下限，如果只对子类做约束，父类可以千奇百怪
 * @Title: TestGeneric 
 * @Description: TODO
 * @param <T>
 */
public class TestGeneric <T extends Comparable<? super T>>
{
	public static void main(String[] args) {
		TestGeneric<GregorianCalendar> p = null; // 编译正确
		}
}

//public class TestGeneric <T extends Comparable<T>>
//{
//	/**
//	 * <T extends Comparable<T>>相当于<GregorianCalendar extends Comparable<GregorianCalendar>>
//	 * 但是GregorianCalendar并没有实现Comparable<GregorianCalendar>而是实现的Comparable<Calendar>，这里不在限制范围之内
//	 */
//	public static void main(String[] args) {
//		TestGeneric<GregorianCalendar> p = null; // 编译错误
//		}
//}

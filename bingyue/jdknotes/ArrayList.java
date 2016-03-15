package bingyue.jdknotes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.RandomAccess;

/**
 * Based on JDK 1.6
 * @Title: ArrayList 
 * @Description: TODO
 */
public class ArrayList extends AbstractList implements List, RandomAccess,
Cloneable, Serializable  {

	private static final long serialVersionUID = 8683452581122892189L;
	private transient Object elementData[]; //实际存储元素的数据结构
	private int size;//始终维护动态数组的实际容量
	
	//使用传入的i初始化列表大小
	public ArrayList(int i) {
		if (i < 0) {
			throw new IllegalArgumentException((new StringBuilder())
					.append("Illegal Capacity: ").append(i).toString());
		} else {
			elementData = new Object[i];
			return;
		}
	}

	//默认数组大小为10
	public ArrayList() {
		this(10);
	}

	/**
	 * 使用一个Collection进行构造
	 * Arraylist中大量使用了Arrays的相关方法
	 */
	public ArrayList(Collection collection)
    {
        elementData = collection.toArray();
        size = elementData.length;
        if((Object) (elementData).getClass() != Object.class){
        	elementData = Arrays.copyOf(elementData, size, (elementData).getClass());
        }
    }

	/**
	 * 如果当前数组的容量大于数组实际存储的数据元素数量，重新调整数组大小
	 * 用于把ArrayList的容量缩减到当前实际大小，减少存储容量。
	 * 其中的变量modCount由AbstracList继承而来，记录List发生结构化修改（structurally modified）的次数。
	 * @Title: trimToSize
	 */
	public void trimToSize() {
		modCount++;
		int i = elementData.length;
		if (size < i)
			elementData = Arrays.copyOf(elementData, size);
	}

	/**
	 * 确保ArrayList的大小
	 * @Title: ensureCapacity 
	 * @param i
	 */
	public void ensureCapacity(int i) {
		modCount++;
		int j = elementData.length;
		if (i > j) {
			Object aobj[] = elementData;
			int k = (j * 3) / 2 + 1;
			if (k < i)
				k = i;
			elementData = Arrays.copyOf(elementData, k);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	//判断元素是否存在
	public boolean contains(Object obj) {
		//判断该元素下标
		return indexOf(obj) >= 0;
	}

	/**
	 * 返回指定元素的下标，要区分参数是否为null
	 * 注意ArrayList可以是可以存储null的
	 */
	public int indexOf(Object obj) {
		if (obj == null) {
			for (int i = 0; i < size; i++)
				if (elementData[i] == null)
					return i;

		} else {
			for (int j = 0; j < size; j++)
				if (obj.equals(elementData[j]))
					return j;

		}
		return -1;
	}

	/**
	 * 返回指定元素的下标
	 * lastIndexOf和indexOf类似，不过是从后往前搜索
	 */
	public int lastIndexOf(Object obj) {
		if (obj == null) {
			for (int i = size - 1; i >= 0; i--)
				if (elementData[i] == null)
					return i;

		} else {
			for (int j = size - 1; j >= 0; j--)
				if (obj.equals(elementData[j]))
					return j;

		}
		return -1;
	}

	public Object clone() {
		try {
			ArrayList arraylist = (ArrayList) super.clone();
			arraylist.elementData = Arrays.copyOf(elementData, size);
			arraylist.modCount = 0;
			return arraylist;
		} catch (CloneNotSupportedException clonenotsupportedexception) {
			throw new InternalError();
		}
	}
	
	//直接调用Arrays的方法
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}
	
	/**
	 * 使用了系统的System.arraycopy方法
	 * 这是一个native的方法
	 */
	public Object[] toArray(Object aobj[]) {
		if (aobj.length < size)
			return (Object[]) Arrays.copyOf(elementData, size,(aobj).getClass());
		System.arraycopy(((Object) (elementData)), 0, ((Object) (aobj)), 0,
				size);
		if (aobj.length > size)
			aobj[size] = null;
		return aobj;
	}

	public Object get(int i) {
		RangeCheck(i);
		return elementData[i];
	}

	public Object set(int i, Object obj) {
		RangeCheck(i);
		Object obj1 = elementData[i];
		elementData[i] = obj;
		return obj1;
	}

	public boolean add(Object obj) {
		ensureCapacity(size + 1);
		elementData[size++] = obj;
		return true;
	}

	public void add(int i, Object obj) {
		if (i > size || i < 0) {
			throw new IndexOutOfBoundsException((new StringBuilder())
					.append("Index: ").append(i).append(", Size: ")
					.append(size).toString());
		} else {
			ensureCapacity(size + 1);
			System.arraycopy(((Object) (elementData)), i,
					((Object) (elementData)), i + 1, size - i);
			elementData[i] = obj;
			size++;
			return;
		}
	}

	public Object remove(int i) {
		RangeCheck(i);
		modCount++;
		Object obj = elementData[i];
		int j = size - i - 1;
		if (j > 0)
			System.arraycopy(((Object) (elementData)), i + 1,
					((Object) (elementData)), i, j);
		elementData[--size] = null;
		return obj;
	}

	public boolean remove(Object obj) {
		if (obj == null) {
			for (int i = 0; i < size; i++)
				if (elementData[i] == null) {
					fastRemove(i);
					return true;
				}

		} else {
			for (int j = 0; j < size; j++)
				if (obj.equals(elementData[j])) {
					fastRemove(j);
					return true;
				}

		}
		return false;
	}

	private void fastRemove(int i) {
		modCount++;
		int j = size - i - 1;
		if (j > 0)
			System.arraycopy(((Object) (elementData)), i + 1,
					((Object) (elementData)), i, j);
		elementData[--size] = null;
	}

	public void clear() {
		modCount++;
		for (int i = 0; i < size; i++)
			elementData[i] = null;

		size = 0;
	}

	/**
	 * 调用修通native方法，注意保持size的准确
	 */
	public boolean addAll(Collection collection) {
		Object aobj[] = collection.toArray();
		int i = aobj.length;
		ensureCapacity(size + i);
		System.arraycopy(((Object) (aobj)), 0, ((Object) (elementData)), size,
				i);
		size += i;
		return i != 0;
	}

	public boolean addAll(int i, Collection collection) {
		if (i > size || i < 0)
			throw new IndexOutOfBoundsException((new StringBuilder())
					.append("Index: ").append(i).append(", Size: ")
					.append(size).toString());
		Object aobj[] = collection.toArray();
		int j = aobj.length;
		ensureCapacity(size + j);
		int k = size - i;
		if (k > 0)
			System.arraycopy(((Object) (elementData)), i,
					((Object) (elementData)), i + j, k);
		System.arraycopy(((Object) (aobj)), 0, ((Object) (elementData)), i, j);
		size += j;
		return j != 0;
	}

	protected void removeRange(int i, int j) {
		modCount++;
		int k = size - j;
		System.arraycopy(((Object) (elementData)), j, ((Object) (elementData)),
				i, k);
		for (int l = size - (j - i); size != l;)
			elementData[--size] = null;

	}

	/**
	 * 判断下标是否越界
	 */
	private void RangeCheck(int i) {
		if (i >= size)
			throw new IndexOutOfBoundsException((new StringBuilder())
					.append("Index: ").append(i).append(", Size: ")
					.append(size).toString());
		else
			return;
	}

	/**
	 * 和序列化以及transient的处理有关系
	 */
	private void writeObject(ObjectOutputStream objectoutputstream)
			throws IOException {
		int i = modCount;
		objectoutputstream.defaultWriteObject();
		objectoutputstream.writeInt(elementData.length);
		for (int j = 0; j < size; j++)
			objectoutputstream.writeObject(elementData[j]);

		if (modCount != i)
			throw new ConcurrentModificationException();
		else
			return;
	}

	private void readObject(ObjectInputStream objectinputstream)
			throws IOException, ClassNotFoundException {
		objectinputstream.defaultReadObject();
		int i = objectinputstream.readInt();
		Object aobj[] = elementData = new Object[i];
		for (int j = 0; j < size; j++)
			aobj[j] = objectinputstream.readObject();

	}

	
}

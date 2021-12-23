package com.zc;

import java.util.Iterator;

public class ArrayList<E> {

	// 元素的数量
	private int size;
	
	// 所有的元素
	private E[] elements;

	// 默认容量 大小为10
	private static final int DEFAULT_CAPACITY = 2;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	// 有参构造函数
	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity; 
		elements = (E[]) new Object[capacity];
	}
	
	// 无参构造函数
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	// 清除所有元素
	public void clear() {
//		size = 0;
		for (int i = 0; i < size; i++) {
			elements[i] = null; // 清空
		}
		size = 0;
	}
	
	// 数组的长度
	public int size() {
		return size;
	}
	
	// 是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	// 是否包含某个元素
	public boolean contains(E emelent) {
		return indexOf(emelent) != ELEMENT_NOT_FOUND;
	}
	
	// 添加元素到尾部
	public void add(E element) {
//		elements[size] = element; // 添加数据
//		size++;
		// 等同于
//		elements[size++] = element;
		add(size, element); // 直接将元素添加到最后面 size 位置
	}
	
	// 获取index位置的元素
	public E get(int index) { 
		if (index < 0 || index >= size)	{
			// 抛出异常
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		};
		return elements[index];
	}
	
	// 设置index位置的元素
	public E set(int index, E element) {
		if (index < 0 || index >= size)	{
			// 抛出异常
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		};
		
		E old = elements[index];
		elements[index] = element;		
		return old;
	}
	
	// 在index位置插入一个元素，从index后往后移动
	public void add(int index, E element) {
		if (index < 0 || index > size)	{ // 这里的判断要注意
			// 抛出异常
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		};
		
		// 判断要不要扩容
		ensureCapacity(size + 1);
		
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	
	// 删除index位置的元素
	public E remove(int index) {
		if (index < 0 || index >= size)	{
			// 抛出异常
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		};

		// 先记录之前的元素
		E old = elements[index];
		for (int i = index+1; i <= size-1; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
		return old;
	}
	
	// 查看元素的索引
	public int indexOf(E element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) return i;
		}
		return ELEMENT_NOT_FOUND; // -1
	}
	
	// 扩容(保证要有capacity)的容量
	public void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return; // 此处不需要扩容
		
		// 右移动 1, oldCapacity >> 1 相当于 oldCapacity / 2
		// 新容量 是 旧容量的 1.5倍
		int newCapaciy = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[])new Object[newCapaciy];
		// 将之前elements的内容移动到 newElements 中
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		
		System.out.println(oldCapacity + "扩容为" + newCapaciy);
	}
	
	// 打印
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// Java中字符串拼接用 StringBuilder
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append("，[");
		
		for (int i = 0; i < size; i++) {
//			if (i != 0) {
//				string.append("，");
//			}
			string.append(elements[i]);
			if (i != size - 1) {
				string.append("，");
			}
		}
		string.append("]");
		return string.toString();
	}
	
}

package com.zc;

import java.util.Iterator;

public class ArrayList {

	// 元素的数量
	private int size;
	
	// 所有的元素
	private int[] elements;

	// 默认容量 大小为10
	private static final int DEFAULT_CAPATICY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	// 有参构造函数
	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPATICY) ? DEFAULT_CAPATICY : capaticy;
		elements = new int[capaticy];
	}
	
	// 无参构造函数
	public ArrayList() {
		this(DEFAULT_CAPATICY);
	}
	
	// 清除所有元素
	public void clear() {
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
	public boolean contains(int emelent) {
		return indexOf(emelent) != ELEMENT_NOT_FOUND;
	}
	
	// 添加元素到尾部
	public void add(int element) {
		
	}
	
	// 获取index位置的元素
	public int get(int index) {
		if (index < 0 || index >= size)	{
			// 抛出异常
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		};
		return elements[index];
	}
	
	// 设置index位置的元素
	public int set(int index, int element) {
		if (index < 0 || index >= size)	{
			// 抛出异常
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		};
		
		int old = elements[index];
		elements[index] = element;		
		return old;
	}
	
	// 在index位置插入一个元素
	public void add(int index, int element) {
		
	}
	
	// 删除index位置的元素
	public int remove(int index) {
		return 0;
	}
	
	// 查看元素的索引
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) return i;
		}
		return ELEMENT_NOT_FOUND; // -1
	}
	
}

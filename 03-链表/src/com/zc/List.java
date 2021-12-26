package com.zc;

public interface List <E> {

	static final int ELEMENT_NOT_FOUND = -1;

	// 清除所有元素
	void clear();
	
	// 元素的数量
	int size();
	
	// 是否为空
	boolean imEmpty();
	
	// 是否包含某个元素
	boolean contains(E element);
	
	// 添加元素到尾部
	void add(E element);
	
	// 获取index位置的元素
	E get(int index);
	
	
	
}

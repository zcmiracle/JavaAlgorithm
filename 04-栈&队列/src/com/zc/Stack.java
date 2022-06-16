package com.zc;

import com.zc.list.ArrayList;
import com.zc.list.LinkedList;
import com.zc.list.List;

public class Stack<E> {	
	private List<E> list = new ArrayList<>(); // 数组
//	private List<E> list = new LinkedList<>(); // 链表方式
	
	// 清除元素
	@SuppressWarnings("unused")
	private void clear() {
		list.clear();
	}
	
	// 长度
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void push(E element) {
		list.add(element);
	}
	
	public E pop() {
		return list.remove(list.size() - 1);
	}

	public E top() {
		return list.get(list.size() - 1);
	}
	
}

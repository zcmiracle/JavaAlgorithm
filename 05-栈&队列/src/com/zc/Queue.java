package com.zc;

import com.zc.list.LinkedList;
import com.zc.list.List;

public class Queue<E> {
	private List<E> list = new LinkedList<>();
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void clear() {
		list.clear();
	}
	
	public void enQueue(E element) {
		list.add(element);
	}
	
	public E deQueue() {
		return list.remove(0);
	}	
	
	public E fornt() {
		return list.get(0);
	}
}

package com.zc.circle;

import java.util.Iterator;

@SuppressWarnings("unchecked")
// 循环队列
public class CircleQueue<E> {

	private int front;
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[index(i)] = null;
		}
		front = 0;
		size = 0;
	}
	
	public void enQueue(E element) {
		// 保证要有capacity的容量
		ensureCapacity(size + 1);
		elements[index(size)] = element;
		size++;
	}
	
	public E deQueue() {
		E frontElement = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return frontElement;
	}
	
	public E front() {
		return elements[front];
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("capacity = ").append(elements.length)
		.append(" size = ").append(size)
		.append(" front = ").append(front)
		.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				sBuilder.append(", ");
			}
			sBuilder.append(elements[i]);
		}		
		sBuilder.append("]");
		return sBuilder.toString();
	}
	
	// 保证要有capacity的容量
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 新容量 为 旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;
		
		// 重置front
		front = 0;
	}
	
	// private 
	private int index(int index) {
		index += front;
		return index - (index >= elements.length ? elements.length : 0);
	}
	
}

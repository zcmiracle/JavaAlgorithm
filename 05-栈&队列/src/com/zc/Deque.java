package com.zc;

import com.zc.list.LinkedList;
import com.zc.list.List;

public class Deque<E> {
	private List<E> list = new LinkedList<>();

	public int size() {
		return list.size();
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
			
	/**
	 * 清空
	 * 
	 */
	public void clear() {
		list.clear();
	}
		
	/**
	 * 从队尾入队
	 * @param element
	 */
	public void enQueueRear(E element) {
		list.add(element);
	}
	
	/**
	 * 从队尾出队
	 * @return
	 */
	public E deQueueRear() {
		return list.remove(list.size() - 1);
	}	

	/**
	 * 从队头出队
	 * @return
	 */
	public E deQueueFront() {
		return list.remove(0);
	}
	
	/**
	 * 从对头入队
	 * @param element
	 */
	public void enQueueFront(E element) {
		list.add(0, element);
	}
	
	/**
	 * 获取队列的头元素
	 * @return
	 */
	public E front() {
		return list.get(0);
	}
	
	/**
	 * 获取队列的尾元素
	 * @return
	 */
	public E rear() {
		return list.get(list.size() - 1);
	}
}

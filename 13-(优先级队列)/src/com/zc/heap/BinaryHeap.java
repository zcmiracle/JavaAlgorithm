package com.zc.heap;

import java.util.Comparator;

/**
 * 二叉堆（大顶堆）
 * @author fearless
 *
 * @param <E>
 */
public class BinaryHeap<E> extends AbstractHeap<E> {
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	public BinaryHeap(E[] elements, Comparator<E> comparator) {
		super(comparator);
		
		if (elements == null || elements.length == 0) {
			this.elements = (E[]) new Object[DEFAULT_CAPACITY];
		} else {
			size = elements.length;
			int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
			this.elements = (E[]) new Object[capacity];
			for (int i = 0; i < elements.length; i++) {
				this.elements[i] = elements[i];
			}
			
			// 批量建堆
			heapify();
		}
	}
	
	public BinaryHeap(E[] elements) {
		this(elements, null);
	}
	
	public BinaryHeap(Comparator<E> comparator) {
		this(null, comparator);
	}
	
	public BinaryHeap() {
		this(null, null);
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		// 添加元素，先检查元素是否为空
		elementNotNullCheck(element);
		ensureCapacity(size + 1);
		elements[size++] = element;
		siftUp(size - 1); // 自上而下的 上滤
	}

	/**
	 * 获得堆顶元素
	 */
	@Override
	public E get() {
		// TODO Auto-generated method stub
		emptyCheck();
		return elements[0];
	}

	/**
	 * 删除堆顶元素
	 */
	@Override
	public E remove() {
		// TODO Auto-generated method stub
		emptyCheck();
		
		int lastIndex = --size;
		E root = elements[0];
		elements[0] = elements[lastIndex];
		elements[lastIndex] = null;
		
		siftDown(0); // 自下而上的下滤
		return root;
	}
	
	/**
	 * 删除堆顶元素 的同时 插入一个新元素
	 */
	@Override
	public E replace(E element) {
		// TODO Auto-generated method stub
		elementNotNullCheck(element);
		
		E root = null;
		if (size == 0) { // 如果没有数据
			elements[0] = element;
			size ++;
		} else {
			root = elements[0]; 
			elements[0] = element;
			siftDown(0);
		}
		return root;
	}
	
	/**
	 * 批量建堆
	 */
	private void heapify() {
		// 自上而下 上滤
		for (int i = 0; i < elements.length; i++) {
			siftUp(i);
		}
		
//		// 上下而上 下滤
//		for (int i = (size >> 1) - 1; i >= 0; i--) {
//			siftDown(i);
//		}
	}
	
	/**
	 * 让index位置的元素上滤
	 * @param index
	 */
	private void siftUp(int index) {
		E element = elements[index];
		while(index > 0) {
			int parentIndex = (index - 1) >> 1;
			E parent = elements[parentIndex];
			if (compare(element, parent) <= 0) break;
			
			// 将父元素 存储在 index 位置
			elements[index] = parent;
			
			// 重新赋值 index
			index = parentIndex;
		}
		elements[index] = element;
	}
	
	/**
	 * 让index位置的元素下滤
	 * @param index
	 */
	private void siftDown(int index) {
		E element = elements[index];
		int half = size >> 1; // 重点
		// 第一个叶子节点的索引 == 非叶子节点的数量
	    // index < 第一个叶子节点的索引
		// 必须保证 index 位置是非叶子节点
		
		while (index < half) {
			// index 的节点有两种情况
			// 1、只有左子节点
			// 2、同时有左右子节点
			
			// 默认为左子节点 跟它进行比较，因为左子节点是存在的，右子节点不一定存在
			int childIndex = (index << 1) + 1;
			E child = elements[childIndex];
			
			// 右子节点
			int rightIndex = childIndex + 1;
			
			// 选出左右子节点最大的那个
			if (rightIndex < size && compare(elements[rightIndex], child) > 0) {
				child = elements[childIndex = rightIndex];
			}
			
			// 将左右子节点最大的元素 和 element 比较
			if (compare(element, child) >= 0) break;
			
			// 将子节点存放到 index 位置
			elements[index] = child;
			// 重新设置index
			index = childIndex;
		}
		elements[index] = element;
	}
		
	// 检测是否为空
	private void emptyCheck() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("Heap is empty");
		}
	}

	// 元素不能为空
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	// 确保容量
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 新容量为 旧容量的1.5倍  (oldCapacity >> 1) 除以2
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}

	
	
}

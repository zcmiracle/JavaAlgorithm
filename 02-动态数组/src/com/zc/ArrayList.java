package com.zc;

@SuppressWarnings("unchecked")
public class ArrayList<E> {

	// 元素的数量
	private int size;
	
	// 所有的元素
	private E[] elements;

	// 默认容量 大小为10
	private static final int DEFAULT_CAPACITY = 10;
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
		add(size, element); // 直接将元素添加到最后面 size 位置
	}
	
	// 获取index位置的元素
	public E get(int index) { 
		rangeCheck(index);
		return elements[index];
	}
	
	// 设置index位置的元素
	public E set(int index, E element) {
		rangeCheck(index);
		
		E oldElement = elements[index];
		elements[index] = element;		
		return oldElement;
	}
	
	// 在index位置插入一个元素，从index后往后移动
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
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
		rangeCheck(index);

		// 先记录之前的元素
		E oldElement = elements[index];
		for (int i = index + 1; i <= size-1; i++) {
			elements[i - 1] = elements[i];
		}
		elements[--size] = null; // 将删除的置为null
		return oldElement;
	}
	
	// 查看元素的索引
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(element)) return i;
			}
		}		
		return ELEMENT_NOT_FOUND; // -1
	}

	// 保证capacity的容量
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 新容量是旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}
	
	
	
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size);
	}

	// 检查
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	
	@Override
	public String toString() {

		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				sBuilder.append(", ");
			}	
			sBuilder.append(elements[i]);
		}
		sBuilder.append("]");
		return sBuilder.toString();
	}
	
}

package com.zc;

// 去除警告
@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E> {

	private E[] elements;
	private static final int DEFAULT_CAPATICT = 10;

	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPATICT) ? DEFAULT_CAPATICT : capaticy;
		elements = (E[]) new Object[capaticy];
	}

	public ArrayList() {
		this(DEFAULT_CAPATICT);
	}

	// 清除所有元素
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	// 获取index位置的元素
	@Override
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	// 设置index位置上的元素, 返回原来的元素
	@Override
	public E set(int index, E element) {
		rangeCheck(index);

		// 旧元素
		E oldElement = elements[index];
		elements[index] = element;
		return oldElement;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		// 确保要有capacity容量
		ensureCapacity(size + 1);

		// 倒序遍历，12345 6 789
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		size++;
	}

	// 删除index位置的元素
	@Override
	public E remove(int index) {
		rangeCheck(index);

		E oldElement = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		// 将最后一个元素的置为null
		elements[--size] = null;
		return oldElement;
	}

	// 查看元素的索引
	@Override
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	// 保证要有capacity容量
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity)
			return;

		// 新容量 是 旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];

		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}

		elements = newElements;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}

	// 重写 toString 方法
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("size = ").append(size).append(", [");
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

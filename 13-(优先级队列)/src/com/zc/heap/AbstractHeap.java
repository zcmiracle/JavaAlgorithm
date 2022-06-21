package com.zc.heap;
import java.util.Comparator;

public abstract class AbstractHeap<E> implements Heap<E> {
	protected int size;
	// 比较器
	protected Comparator<E> comparator;
	
	public AbstractHeap(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	public AbstractHeap() {
		this(null);
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	
	@SuppressWarnings("unchecked")
	protected int compare(E element1, E element2) {
		// 写注释
		return comparator != null ? comparator.compare(element1, element2) 
				: ((Comparable<E>)element1).compareTo(element2);
	}
	
}

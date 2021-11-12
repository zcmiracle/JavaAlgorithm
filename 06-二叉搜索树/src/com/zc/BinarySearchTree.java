package com.zc;

public class BinarySearchTree<E> {

	private int size;
	// 根节点
	private Node<E> root;
	
	public int size() {
		return 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		
	}
	
	// 添加
	public void add(E element) {
		// 首先检测是否为空
		elementNotNullCheck(element);
		
	}
	
	// 删除
	public void remove(E element) {
		
	}
	
	// 是否包含
	public boolean contains(E element) {
		return false;
	}
	
	// 检测是否为空
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		
		// 构造函数
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.left = left;
			this.right = right;			
		}
		
	}
	
}

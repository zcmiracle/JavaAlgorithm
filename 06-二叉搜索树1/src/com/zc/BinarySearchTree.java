package com.zc;
import java.util.Comparator;

import com.zc.printer.BinaryTreeInfo;

public class BinarySearchTree<E> implements BinaryTreeInfo {
	
	private int size;
	private Node<E> root; // 根节点
	private Comparator<E> comparator; // 比较器
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
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
		// 添加第一个节点
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		// 添加的不是第一个节点
		// 找到父节点
//		Node<E> parent = nil;
		Node<E> parent = root;
		Node<E> node = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			// 保留父节点
			parent = node;
			
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else { // 相等
				return;
			} 
		}
		
		// 看插入到父节点的哪个位置
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;
	}
	
	// 删除
	public void remove(E element) {
		
	}
	
	// 是否包含
	public boolean contains(E element) {
		return false;
	}
	
	/**
	 * @return 返回值等于0，代表e1 == e2 
	 * 返回值 大于 0，代表e1 大于 e2
	 * 返回值 小于 0，代表e1 小于 e2
	 * 
	 */
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		// 强制转换 
		return ((Comparable<E>)e1).compareTo(e2);
	} 
	
	// 检测是否为空
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	// Node 节点
	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		@SuppressWarnings("unused")
		Node<E> parent;
		
		// 构造函数
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;			
		}
	}
	
	
	@Override
	public Object root() {
		return root;
	}
	
	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}
	
	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}
	
	@Override
	public Object string(Object node) {
		return ((Node<E>)node).element;
	}
	
	
}

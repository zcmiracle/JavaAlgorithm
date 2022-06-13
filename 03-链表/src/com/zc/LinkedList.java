package com.zc;

public class LinkedList<E> extends AbstractList<E> {

	private Node<E> first;
	private Node<E> last;

	private static class Node<E> {
		E element; // 元素
		Node<E> prev; // 前驱节点
		Node<E> next; // 后继节点
			
		// 构造方法？
		public Node(Node<E> prev, E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder sBuilder = new StringBuilder();
		
			if (prev != null) {
				sBuilder.append(prev.element);
			} else {
				sBuilder.append("null");
			}
			
			sBuilder.append("_").append(element).append("_");
			
			if (next != null) {
				sBuilder.append(next.element);
			} else {
				sBuilder.append("null");
			}
			
			return sBuilder.toString();
		}		
	}

	
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
		last = null;
	}

	@Override
	public boolean imEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return node(index).element;
	}

	// 设置index位置的元素，返回原来的元素
	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		rangeCheckForAdd(index);
		
		// size == 0;
		// index == 0
		if (index == size) { // 最后添加元素
			Node<E> oldLastNode = last;
			last = new Node<>(oldLastNode, element, null);
			if (oldLastNode == null) {
				first = last;
			} else {
				oldLastNode.next = last;
			}
		} else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(prev, element, next);
			next.prev = node; // 
			
			if (prev == null) { // index == 0
				first = node;
			} else {
				prev.next = node;
			}
		}
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next =  node.next;
		
		if (prev == null) { // index == 0
			first = next;
		} else {
			prev.next = next;
		}
		
		if (next == null) { // index = size - 1
			last = prev;
		} else {
			next.prev = prev;
		}
		
		size--;
		
		return node.element;
	}

	// 查看元素的索引
	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				node = node.next;
			}
 		}		
		return ELEMENT_NOT_FOUND;
	}
	
	// 获取index位置对应的节点对象
	private Node<E> node(int index) {
		rangeCheck(index); // 检查
		
		if (index < (size >> 1)) {
			// ✨✨✨
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
 		} else {
			// ✨✨✨
 			Node<E> node = last;
 			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
 			return node;
 		}
	}
}



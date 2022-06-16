package com.zc;
//import com.zc.AbstractList;

public class LinkedList<E> extends AbstractList<E> {
	private Node<E> first;
	private Node<E> last;

	private static class Node<E> {
		E element; // 元素
		Node<E> prev; // 前驱节点
		Node<E> next; // 后继节点

		// 构造方法
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
		size = 0;
		first = null;
		last = null;
	}

	@Override
    public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
        Node<E> node = node(index);
		E oldElement = node.element;
		node.element = element;
		return oldElement;
	}
	
	@Override
    public void add(int index, E element) {
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
		
		size++; // 此处没有添加报错了
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;

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
				if (node.element == null)
					return i;
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element))
					return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	// 获取index位置对应的节点对象
	private Node<E> node(int index) {
		rangeCheck(index); // 检查

		if (index < (size >> 1)) {
			// 头节点
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			// 尾结点
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("size = ").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				sBuilder.append(", ");
			}
			sBuilder.append(node);
			node = node.next;
		}

		sBuilder.append("]");
		return sBuilder.toString();
	}

	@Override
	public boolean imEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}

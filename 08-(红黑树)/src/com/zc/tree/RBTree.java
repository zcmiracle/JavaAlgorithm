package com.zc.tree;

import java.awt.Color;
import java.util.Comparator;
import com.zc.tree.BinaryTree.Node;
import com.zc.tree.BBST;

@SuppressWarnings("unused")

public class RBTree<E> extends BBST<E> {

	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	public RBTree() {
		this(null);
	}
	
	public RBTree(Comparator<E> comparator) {
		super(comparator);
	}
	
	@Override
	protected void afterAdd(Node<E> node) {
		// TODO Auto-generated method stub
		Node<E> parent = node.parent;
		
		// 添加节点是根节点 或 上溢到达了根节点
		if (parent == null) {
			black(node);
			return;
		}	
		
		// 如果父节点是黑色，直接返回
		if (isBlack(node)) return;
		
		// 叔叔节点
		Node<E> uncleNode = parent.sibling();
		// 祖父节点
		Node<E> grandNode = red(parent.parent); // ???
	
		// 叔叔节点是红色
		if (isRed(uncleNode)) { 
			black(parent);
			black(uncleNode);
			// 把祖父节点当做新添加的节点
			afterAdd(grandNode);
			return;
		}
		
		// 叔叔节点不是红色
		if (parent.isLeftChild()) {
			
		} else {
			
		}
		
	}
	
	@Override
	protected void afterRemove(Node<E> node) {
		// TODO Auto-generated method stub
		super.afterRemove(node);
	}
	
		

	private Node<E> color(Node<E> node, boolean color) {
		if (node == null) return node;
		((RBNode<E>)node).color = color;
		return node;
	}
	
	// 染红
	private Node<E> red(Node<E> node) {
		return color(node, RED);
	}
	
	// 染黑
	private Node<E> black(Node<E> node) {
		return color(node, BLACK);
	}
	
	// 是否是黑色
	private boolean isBlack(Node<E> node) {
		return colorOf(node) == BLACK;
	}
	
	// 是否是红色
	private boolean isRed(Node<E> node) {
		return colorOf(node) == RED;
	}
	
	private boolean colorOf(Node<E> node) {
		return node == null? BLACK : ((RBNode<E>)node).color;
	}
	
	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		// TODO Auto-generated method stub
		return new RBNode<>(element, parent);
	}
	
	private static class RBNode<E> extends Node<E> {
		boolean color = RED;
		public RBNode(E element, Node<E> parent) {
			super(element, parent);
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String string = "";
			if (color == RED) {
				string = "R_";
			}
			return string + element.toString();
		}
	}
	
	

	
}
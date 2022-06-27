package com.zc.tree;
import java.util.Comparator;
	
@SuppressWarnings("unused")
// 平衡二叉搜索树
public class BBST<E> extends BST<E> {

	public BBST() {
		this(null);
	}
	
	public BBST(Comparator<E> comparator) {
		super(comparator);
	}	
	
	/**
	 * 左旋
	 * @param grand
	 */
	protected void rotateLeft(Node<E> grand) {
		Node<E> parent = grand.right;
		Node<E> child = parent.left;
		grand.right = child;
		parent.left = grand;
		afterRotate(grand, parent, child);
	}
	
	/**
	 * 右旋
	 * @param grand
	 */
	protected void rotateRight(Node<E> grand) {
		Node<E> parent = grand.left;
		Node<E> child = parent.right;
		grand.left = child;
		parent.right = grand;
		afterRotate(grand, parent, child);
	}
	
	/**
	 * @param grand 祖父节点
	 * @param parent 父节点
	 * @param child 子节点
	 */
	protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
		// 让parent称为子树的根节点
		parent.parent = grand.parent;
		if (grand.isLeftChild()) {
			grand.parent.left = parent;
		} else if (grand.isRightChild()) {
			grand.parent.right = parent;
		} else { // grand是root节点
			root = parent;
		}
		
		// 更新child的parent
		if (child != null) {
			child.parent = grand;
		}
		
		// 更新grand的parent
		grand.parent = parent;
	}
}

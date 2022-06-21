package com.zc;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.mj.BinarySearchTree.Node;
import com.mj.BinarySearchTree.Visitor;
import com.zc.printer.BinaryTreeInfo;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size;
	private Node<E> root; // 根节点
	private Comparator<E> comparator; // 比较器

	// 二叉搜索树
	public BinarySearchTree() {
		this(null);
	}

	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}

	/**
	 * 长度
	 * @return
	 */
	public int size() {
		return 0;
	}

	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 清空
	 */
	public void clear() {
		root = null; // 根节点为null
		size = 0; // 长度 == 0
	}

	/**
	 * 是否包含
	 * @param element
	 * @return
	 */
	public boolean contains(E element) {
		return node(element) != null;
	}

	/**
	 * 添加节点
	 * @param element
	 */
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

	/**
	 * 删除
	 * @param element
	 */
	public void remove(E element) {
		remove(node(element));
	}

	/**
	 * 删除节点
	 * 
	 * @param element
	 */
	private void remove(Node<E> node) {
		if (node == null)
			return;
		size--;

		// 度为2的节点
		if (node.hasTwoChildren()) {
			// 找到后继节点
			Node<E> successorNode = successor(node);
			// 用后继节点的值覆盖度为2的值
			node.element = successorNode.element;
			// 删除后继节点
			node = successorNode;
		}

		// 删除node节点（node的度必然是1或者0）
		Node<E> replacementNode = node.left != null ? node.left : node.right;

		// node是度为1的节点
		if (replacementNode != null) {
			// 更改parent
			replacementNode.parent = node.parent;
			// 更改parent的left、right的指向
			if (node.parent == null) { // node是度为1的节点并且是根节点
				root = replacementNode;
			} else if (node == node.parent.left) {
				node.parent.left = replacementNode;
			} else { // node == node.parent.right
				node.parent.right = replacementNode;
			}
		} else if (node.parent == null) {
			root = null;
		} else { // node是叶子节点，但不是根节点
			if (node == node.parent.left) {
				node.parent.left = null;
			} else { // node == node.parent.left
				node.parent.right = null;
			}
		}
	}

	private Node<E> node(E element) {
		// TODO Auto-generated method stub
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp == 0)
				return node;
			if (cmp > 0) {
				node = node.right;
			} else { // cmp < 0
				node = node.left;
			}
		}
		return null;
	}

	
	/**
	 * 前序遍历 
	 * 访问顺序：根节点、前序遍历左子树、前序遍历有子树
	 * 栈实现
	 */
	public void preorderTraversal() {
		preorderTraversal(root);
	}
	
	private void preorderTraversal(Node<E> node) {
		if (node == null) return;
		System.out.println(node.element);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
		
	/**
	 * 中序遍历 
	 * 访问顺序：中序遍历左子树、根节点、中序遍历右子树
	 */
	public void inorderTraversal() {
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(Node<E> node) {
		if (node == null) return;
		inOrderTraversal(node.left);
		System.out.println(node.element);
		inOrderTraversal(node.right);
	}
		
	/**
	 * 后续遍历 
	 * 访问顺序：后续遍历左子树、后续遍历右子树、根节点
	 */
	public void postorderTraversal() {
		postorderTraversal(root);
	}
	
	private void postorderTraversal(Node<E> node) {
		if (node == null) return;
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node.element);
	}
		
	/**
	 * 层序遍历
	 * 访问顺序：从上到下、从左到右依次访问每一个节点
	 */
	public void levelOrdertTraversal() {
		if (root == null) return;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll(); // 出队
			System.out.println(node.element);
			
			if (node.left != null) {
				queue.offer(node.left); // 入队
			}
			if (node.right != null) {
				queue.offer(node.right); // 入队
			}
		}
	}
	
	
	

	public void preorder(Visitor<E> visitor) {
		if (visitor == null) return;
		preorder(root, visitor);
	}
	
	private void preorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;

		visitor.stop = visitor.visit(node.element);
		preorder(node.left, visitor);
		preorder(node.right, visitor);
	}
	
	
	
	
	public void inorder(Visitor<E> visitor) {
		if (visitor == null) return;
		inorder(root, visitor);
	}
	
	private void inorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		
		inorder(node.left, visitor);
		if (visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
		inorder(node.right, visitor);
	}
	
	
	

	public void postorder(Visitor<E> visitor) {
		if (visitor == null) return;
		postorder(root, visitor);
	}
	
	private void postorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		
		postorder(node.left, visitor);
		postorder(node.right, visitor);
		if (visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
	}
	
	
	
	
	// 层序遍历
	public void levelOrder(Visitor<E> visitor) {
		if (root == null || visitor == null) return;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (visitor.visit(node.element)) return;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	

	/**
	 * 是否是完全二叉树
	 * @return
	 */
	public boolean isComplete() {
		if (root == null) return false;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && !node.isLeaf()) return false;
			
			if (node.left != null) {
				queue.offer(node.left);
			} else if (node.right != null) { // node.left == null && node.right != null
				return false;
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			} else { // node.right == null
				leaf = true;
			}
		}
		
		return true;
	}
	
	
	
	public int height() {
		if (root == null) return 0;
		
		// 树的高度
		int height = 0;
		// 存储着每一层的元素数量
		int levelSize = 1;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll(); // 出队
			levelSize--;
			
			if (node.left != null) {
				queue.offer(node.left); // 入队
			}
			
			if (node.right != null) {
				queue.offer(node.right); // 入队
			}
			
			if (levelSize == 0) { // 意味着即将要访问下一层
				levelSize = queue.size();
				height++;
			}
		}
		
		return height;
	}
	
	
	public int height2() {
		return height(root);
	}
	
	private int height(Node<E> node) {
		if (node == null) return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sBuilder = new StringBuilder();
		toString(root, sBuilder, "");
		return sBuilder.toString();
	}

	private void toString(Node<E> node, StringBuilder sBuilder, String prefix) {
		if (node == null)
			return;
		toString(node, sBuilder, prefix + "L---");
		sBuilder.append(prefix).append(node.element).append("\n");
		toString(node.right, sBuilder, prefix + "R---");
	}

	/**
	 * @return 返回值等于0，代表e1 == e2 返回值 大于 0，代表e1 大于 e2 返回值 小于 0，代表e1 小于 e2
	 */
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>) e1).compareTo(e2);
	}

	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	public static abstract class Visitor<E> {
		boolean stop;
		/**
		 * 如果返回true，就代表停止遍历
		 * 
		 * @param element
		 * @return
		 */
		public abstract boolean visit(E element);
	}


	/**
	 * 前驱节点：predecessor
	 * 
	 * 前驱节点：中序遍历时的 前一个节点 如果是二叉搜索树，前驱节点就是前一个比它小的节点
	 * 
	 * @param node
	 * @return
	 */
	@SuppressWarnings("unused")
	private Node<E> predecessor(Node<E> node) {
		if (node == null)
			return null;

		// 前驱节点在左子树中 （left.right.right.right...）
		Node<E> preNode = node.left;
		if (preNode != null) {
			// 终止条件 right = null
			while (preNode.right != null) {
				preNode = preNode.right;
			}
			return preNode;
		}

		// 从父节点、祖父节点寻找前驱节点
		while (node.parent != null && node == node.parent.right) {
			// node 在 parent 的右子树中
			node = node.parent;
		}

		// node.parent = null
		// node == node.parent.right
		return node.parent;
	}

	/**
	 * 后继节点：successor
	 * 
	 * 后继节点：中序遍历时的 后一个节点 如果是二叉搜索树，后继节点就是后一个比它大的节点
	 * 
	 * @param node
	 * @return
	 */
	private Node<E> successor(Node<E> node) {
		if (node == null)
			return null;

		// 前驱节点 在左子树中 right.left.left.left...
		Node<E> prevNode = node.right;
		if (prevNode != null) {
			// 终止条件 left 为 null
			while (prevNode.left != null) {
				prevNode = prevNode.left;
			}
			return prevNode;
		}

		// 从父节点、祖父节点中寻找前驱节点
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		return node.parent;
	}

	// Node 节点
	private static class Node<E> {
		E element;
		Node<E> left; // 左子节点
		Node<E> right; // 有子节点
		Node<E> parent; // 父节点
		// 构造函数

		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}

		// 是否是叶子节点
		public boolean isLeaf() {
			return left == null && right == null;
		}

		// 度为2的节点，有左右子节点
		public boolean hasTwoChildren() {
			return left != null && right != null;
		}
	}

	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>) node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>) node).right;
	}

	@Override
	public Object string(Object node) {
		Node<E> myNode = (Node<E>) node;
		String parentString = "null";
		if (myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentString + ")";
	}
}

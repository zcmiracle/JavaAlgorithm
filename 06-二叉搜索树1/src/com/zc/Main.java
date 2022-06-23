package com.zc;

import java.util.Comparator;
import java.util.Iterator;

import com.zc.file.Files;
import com.zc.printer.BinaryTreeInfo;
import com.zc.printer.BinaryTrees;
import com.zc.printer.BinaryTrees.PrintStyle;

public class Main {
	
	/**
	 * 二叉搜索树：二叉查找树、二叉排序树 BST
	 * 特点：
	 * 1、任意一个节点的值 大于 其左子树所有节点的值
	 * 2、任意一个节点的值 小于 其右子树所有节点的值 
	 * 3、它的左右子树也是一颗 二叉搜索树 📌📌📌 
	 * 4、二叉搜索树 可以调高 搜索数据的效率 📌📌📌
	 * 5、二叉搜索树 存储的元素 必须具备可比较性 int、double 📌📌📌
	 * 6、自定义类型、需要指定比较方式   📌📌📌
	 * 7、不允许为null 📌📌📌
	 */
	
	public static class PersonComparator1 implements Comparator<Person> {
		public int compare(Person e1, Person e2) {
			return e1.getAge() - e2.getAge();
		}
	}
	
	public static class PersonComparator2 implements Comparator<Person> {
		public int compare(Person e1, Person e2) {
			return e2.getAge() - e1.getAge();
		}
	}
	
	static void test() {
		Integer data[] = new Integer[] {
			7, 4, 9, 2, 5, 8, 11, 3, 10, 1
		};
			
		BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p2.getAge() - p1.getAge();
			}
		});
		for (int i = 0; i < data.length; i ++) {
			bst1.add(new Person(data[i]));
		}
		BinaryTrees.println(bst1);
	}
	
	static void test1() {
		Integer data[] = new Integer[] {
			7, 4, 9, 2, 5, 8, 11, 3, 10, 1
		};
		
		BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i ++) {
			bst1.add(new Person(data[i]));
		}
		BinaryTrees.println(bst1);
	}
	
	static void test2() {
		// 匿名函数 block-oc，闭包swift
//		BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new Comparator<Person>() {
//			@Override
//			public int compare(Person p1, Person p2) {
//				return 0;
//			}
//		});
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new PersonComparator1());
		bst2.add(new Person(12));
		bst2.add(new Person(15));
		
		BinarySearchTree<Person> bst3 = new BinarySearchTree<>(new PersonComparator2());
		bst3.add(new Person(10));
		bst3.add(new Person(21));
		
		Integer data[] = new Integer[] {
			7, 4, 9, 2, 5, 8, 11, 3, 10, 1
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i ++) {
			bst.add(data[i]);
		}
		// 打印
		BinaryTrees.println(bst);
		BinaryTrees.println(bst, PrintStyle.INORDER);		
	}	
	
	static void test3() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < 30; i ++) {
			bst.add((int)(Math.random() * 100));
		}
		// 写入文件
		String string = BinaryTrees.printString(bst);
		string += "\n";
		Files.writeToFile("~/Desktop/Project/JavaAlgorithm", string, true);
		
//		BinaryTrees.println(bst);		
	} 
	
	static void test4() {
		BinaryTrees.println(new BinaryTreeInfo() {
			
			@Override
			public Object string(Object node) {
				// TODO Auto-generated method stub
				return node.toString() + "_";
			}
			
			@Override
			public Object root() {
				// TODO Auto-generated method stub
				return "A";
			}
			
			@Override
			public Object right(Object node) {
				// TODO Auto-generated method stub
				if (node.equals("A")) return "C";
				if (node.equals("C")) return "E";
				return null;
			}
			
			@Override
			public Object left(Object node) {
				// TODO Auto-generated method stub
				if (node.equals("A")) return "B";
				if (node.equals("C")) return "D";
				return null;
			}
		});
	}

	
	static void test5() {
		BinarySearchTree<Person> bst = new BinarySearchTree<>();
        bst.add(new Person(10, "jack"));
        bst.add(new Person(12, "rose"));
        bst.add(new Person(8, "James"));
        bst.add(new Person(9, "michael"));

        BinaryTrees.print(bst);
	}
		
	static void test6() {
		Integer data[] = new Integer[] {
                7, 4, 9, 2, 5
		};
		
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			binarySearchTree.add(data[i]);
		}
		
//		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
//		for (int i = 0; i < 10; i++) {
//			binarySearchTree.add((int)(Math.random() * 100));
//		}
		
		BinaryTrees.print(binarySearchTree);
		System.out.println(binarySearchTree.isComplete()); // 是否是完全二叉树
		
		// 层序遍历
//		binarySearchTree.levelOrdertTraversal();				
	}
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub		
//		test();
//		test1();
//		test2();		
//		test3();
//		test4();
//		test5();
		test6();
	}
}

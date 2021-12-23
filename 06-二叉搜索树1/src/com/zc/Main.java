package com.zc;

import java.util.Comparator;
import java.util.Iterator;

import com.zc.printer.BinaryTreeInfo;
import com.zc.printer.BinaryTrees;
import com.zc.printer.BinaryTrees.PrintStyle;

public class Main {

//	BinaryTreeI
	
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
		BinaryTrees.println(bst);		
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		// 匿名函数 block-oc，闭包swift
//		BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new Comparator<Person>() {
//			@Override
//			public int compare(Person p1, Person p2) {
//				return 0;
//			}
//		});
		
		test();
		test1();
//		test2();		
		test3();
		
	}
}

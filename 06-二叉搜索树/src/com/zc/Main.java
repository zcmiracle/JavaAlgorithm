package com.zc;

import java.util.Comparator;

public class Main {

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 匿名函数 block-oc 闭包swift
		BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return 0;
			}
		});

		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new PersonComparator1());
		bst2.add(new Person(12));
		bst2.add(new Person(15));
		
		BinarySearchTree<Person> bst3 = new BinarySearchTree<>(new PersonComparator2());
		bst3.add(new Person(10));
		bst3.add(new Person(21));
		
		Integer data[] = new Integer[] {
			7, 4, 9, 2, 5, 8, 11, 3
		};
		
		
		
	}

}

package com.zc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[] {1, 2, 3, 4, 5};

		// new是向堆空间申请内存
		ArrayList<Object> list = new ArrayList<>();
		list.add(123);
		list.add(456);
		list.add(789);
		list.add(111);
		list.add(222);
		list.add(333);	
		list.add(444);		
		list.add(555);		
		list.add(666);		
		list.add(777);		
		list.add(888);		
		System.out.println(list.toString());
		
//		list.remove(2);
//		list.add(4, 999);
//		System.out.println(list.toString());
		
		// test()
		test();
	}
	
	static void test() {
		
		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(new Person(10, "James"));
		persons.add(null);
		persons.add(new Person(12, "Java"));
		persons.add(null);
		persons.add(new Person(15, "Rose"));
		persons.clear();
		persons.add(new Person(22, "ABC"));
	
		System.out.println(persons);
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(10);
		integers.add(20);
		integers.add(30);
		integers.add(40);
		System.out.println(integers);
		
	}

} 

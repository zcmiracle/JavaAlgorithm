package com.zc;

public class Main {

	static void testList(List<Integer> list) {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list.add(0, 100);
		list.add(1, 200);
		list.add(list.size(), 500);

		System.out.println(list);
	};

	public static void main(String[] args) {

//		testList(new ArrayList<>()); // size = 8, [100, 200, 1, 2, 3, 4, 5, 500]
		testList(new LinkedList<>());
		
	}

}

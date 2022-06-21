package com.zc;

import java.util.Comparator;
import java.util.Iterator;
import com.zc.heap.BinaryHeap;
import com.zc.printer.BinaryTrees;

public class Main {

	static void test1() {
		BinaryHeap<Integer> heap = new BinaryHeap<>();
		heap.add(68);
		heap.add(73);
		heap.add(45);
		heap.add(56);
		heap.add(32);
		heap.add(88);
		heap.add(65);
		BinaryTrees.println(heap);
		heap.remove(); // 移除堆顶元素
		System.out.println("\n");
		BinaryTrees.println(heap);
	}
	
	// 
	static void  test2() {
		Integer[] dataIntegers = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};
		BinaryHeap<Integer> heap = new BinaryHeap<>(dataIntegers);
		BinaryTrees.print(heap);
//		dataIntegers[0] = 10;
//		dataIntegers[1] = 20;
//		System.out.println("\n");
//		BinaryTrees.print(heap);
	}
	
	// 小顶堆
    static void test3() {
        Integer[] data = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};
        // 系统比较器
        BinaryHeap<Integer> heap = new BinaryHeap<>(data, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        BinaryTrees.println(heap);
    }
    
    static void test4() {
    	// 新建一个小顶堆
    	 BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
             public int compare(Integer o1, Integer o2) {
                 return o2 - o1;
             }
         });
    	 
    	 // 找出最大的前K个数
    	 int k = 5;
         Integer[] data = {888, 999, 926, 388, 745, 843, 862, 297, 492, 940,
        		 397, 814, 230, 453, 866, 840, 216, 650, 533, 464, 729, 662, 
        		 452, 698, 203, 894, 938, 15, 120, 646, 239, 707, 457, 416,
        		 981, 591, 65, 427, 104, 872, 614, 212, 664, 738, 789, 784,
        		 308, 253, 766, 962, 6, 724, 206, 154, 3, 630, 881, 284,
        		 524, 180, 812, 269, 755, 748, 42, 356, 170, 667, 817,
        		 606, 757, 395, 963, 90, 775, 106, 167, 53, 299, 653, 897};
    	 for (int i = 0; i < data.length; i++) {
			if (heap.size() < k) { // 前k个数添加到小顶堆
				heap.add(data[i]); // logk
			} else if (data[i] > heap.get()) { // 如果是第k + 1个数，并且大于堆顶元素
				heap.replace(data[i]);
			}
    	 }
    	 // nlogk
    	 BinaryTrees.println(heap);
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test1();
//		test2();
//		test3();
		test4(); 
	}

}

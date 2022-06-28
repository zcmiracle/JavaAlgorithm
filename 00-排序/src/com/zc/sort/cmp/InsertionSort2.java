package com.zc.sort.cmp;

import com.zc.sort.Sort;

public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		// TODO Auto-generated method stub
		
//		9 8 7 6 5 4 3
//		8 9 7 6 5 4 3  array[current] = array[current-1];
//		8 7 9 6 5 4 3  
//		7 8 9 6 5 4 3 
		
		for (int begin = 1; begin < array.length; begin++) {
			int current = begin;
			T value = array[current];
			while (current > 0 && cmp(value, array[current-1]) < 0) {
				array[current] = array[current-1];
				current--;
			}
			array[current] = value;
		}
		
	}
	
}

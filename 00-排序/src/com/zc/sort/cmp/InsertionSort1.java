package com.zc.sort.cmp;

import java.util.Iterator;

import com.zc.sort.Sort;

public class InsertionSort1<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		// TODO Auto-generated method stub
//		9 8 7 6 5 4 3 
//		8 9 7 6 5 4 3 
//		8 7 9 6 5 4 3  current--
//		7 8 9 6 5 4 3 
		
		for (int begin = 1; begin < array.length; begin++) {
			int current = begin;
			while (current > 0 && cmp(current, current-1) < 0) {
				swap(current, current-1);
				current--;
			}
		}
	}
}

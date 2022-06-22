package com.zc.sort.cmp;

import com.zc.sort.Sort;

public class BubbleSort2<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		// TODO Auto-generated method stub
		for (int end = array.length - 1; end > 0; end--) {
			boolean sorted = true;
			for (int begin = 1; begin <= end; begin++) {
				if (cmp(begin, begin-1) < 0) {
					swap(begin, begin-1);
					sorted = false;
				}
			}
			if (sorted == true) break;
		} 
	}
}

package com.zc.sort.cmp;
import com.zc.sort.Sort;

public class BubbleSort1<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		// TODO Auto-generated method stub
		for (int end = array.length - 1; end > 0; end--) {
			for (int begin = 1; begin <= end; begin++) {
				if (cmp(begin, begin-1) < 0) {
					swap(begin, begin-1);
				}
			}
		} 
	}
}

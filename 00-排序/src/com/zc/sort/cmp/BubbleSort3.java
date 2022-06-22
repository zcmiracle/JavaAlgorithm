package com.zc.sort.cmp;

import com.zc.sort.Sort;

public class BubbleSort3<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		// TODO Auto-generated method stub
		for (int end = array.length - 1; end > 0; end--) {
			Integer sortedIndex = 1;
			for (int beigin = 1; beigin <= end; beigin++) {
				if (cmp(beigin, beigin-1) < 0) {
					swap(beigin, beigin-1);
					sortedIndex = beigin;
				}
			}
			end = sortedIndex;
		}
	}
}

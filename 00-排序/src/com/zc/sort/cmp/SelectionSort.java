package com.zc.sort.cmp;

import com.zc.sort.Sort;

/**
 * 选择排序
 * 1、从序列中找出最大的那个元素，然后与末尾的元素交换位置
 * 	执行完一轮后，最末尾的元素就是最大的元素
 * 2、忽略1中曾今找到的最大元素，重复执行步骤
 * @author fearless
 *
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		// TODO Auto-generated method stub		
		for (int end = array.length - 1; end > 0; end--) {
			int maxIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (cmp(maxIndex, begin) <= 0) {
					maxIndex = begin;
				}
			}
			swap(maxIndex, end);
		}
	}
}



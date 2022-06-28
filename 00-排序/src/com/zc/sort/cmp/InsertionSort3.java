package com.zc.sort.cmp;

import javax.naming.directory.SearchControls;

import com.zc.sort.Sort;

public class InsertionSort3<T extends Comparable<T>> extends Sort<T> {

	/**
	 * 要求二分搜索返回的插入位置：第1个大于 value 的元素位置
	 * value < middle, [begin, middle) 范围内二分搜索
	 * value >= middle, [middle+1, end) 范围内二分搜索
	 */
	@Override
	protected void sort() {
		// TODO Auto-generated method stub
		
		for (int begin = 1; begin < array.length; begin++) {
			insert(begin, search(begin));
		}
	}
	
	/**
	 * 将source位置的元素插入到dest
	 * @param source
	 * @param dest
	 */
	private void insert(int source, int dest) {
		T value = array[source];
		for (int i = source; i > dest; i--) {
			array[i] = array[i - 1];
		}
		array[dest] = value;
	}
	
	/**
	 * 利用二分搜索找到 index 位置元素的待插入位置
	 * 已经排好序数组的区分范围是 [0 index)
	 * @param index
	 * @return
	 */
	private int search(int index) {
		int begin = 0;
		int end = index;
		while (begin < end) {
			int middle = (begin + end) >> 1;
			if (cmp(array[index], array[middle]) < 0) {
				end = middle;
			} else {
				begin = middle;
			}
		}
		return begin;
	}
	
}

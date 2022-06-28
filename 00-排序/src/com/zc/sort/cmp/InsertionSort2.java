package com.zc.sort.cmp;

import com.zc.sort.Sort;

public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {

	/**
	 * 1、将待插入的元素备份
	 * 2、头部有序数据中比待插入元素大的，都朝尾部方向挪动1个位置
	 * 2、将待插入元素放到最终的合适位置
	 */
	@Override
	protected void sort() {
		// TODO Auto-generated method stub
//		9 8 7 6 5 
//		8 9 7 6 5   array[current] = array[current-1];
//		8 7 9 6 5   
//		7 8 9 6 5 
		// 【交换】 - 【挪动】
		for (int begin = 1; begin < array.length; begin++) {
			int current = begin;
			T value = array[current]; // 将待插入的元素备份
			while (current > 0 && cmp(value, array[current-1]) < 0) {
				array[current] = array[current-1]; // 挪动位置
				current--;
			}
			array[current] = value;
		}
		
	}
	
}

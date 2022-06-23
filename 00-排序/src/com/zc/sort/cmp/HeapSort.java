package com.zc.sort.cmp;

import com.zc.sort.Sort;

/**
 * 堆排序
 * @author fearless
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
	
	private int heapSize; // 堆的大小
	
	@Override
	protected void sort() {
		// TODO Auto-generated method stub
		// 原地建堆
		heapSize = array.length;
		
		// 子下而上 下滤
		for (int i = (heapSize>>1) - 1; i >= 0; i--) {
			siftDown(i);
		}
		
		while (heapSize > 1) {
			swap(0, --heapSize); // 交换堆顶元素和尾部元素，并将堆的长度减去-，先交换后减
			siftDown(0); // 对0号位置进行 siftDown（恢复堆的性质）
		}		
	}
	
	private void siftDown(int index) {
		T element = array[index];

		int half = heapSize >> 1; // 重点
		// 第一个叶子节点的索引 == 非叶子节点的数量
	    // index < 第一个叶子节点的索引
		// 必须保证 index 位置是非叶子节点
		while (index < half) {
			// index 的节点有两种情况
			// 1、只有左子节点
			// 2、同时有左右子节点
			
			// 默认为左子节点 跟它进行比较，因为左子节点是存在的，右子节点不一定存在
			int childIndex = (index << 1) + 1;
			T child = array[childIndex];
			
			// 右子节点
			int rightIndex = childIndex + 1;
			
			// 选出左右子节点最大的那个
			// 右子节点 > 左子节点
			if (rightIndex < heapSize && cmp(array[rightIndex], child) > 0) {
				child = array[childIndex = rightIndex];
			}
			
			// 将左右子节点最大的元素 和 element 比较
			// >= 子节点
			if (cmp(element, child) >= 0) break;
			
			// 将子节点存放到 index 位置
			array[index] = child;
			// 重新设置index
			index = childIndex;
		}
		array[index] = element;
	}

}

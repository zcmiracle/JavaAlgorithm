package com.zc.sort.cmp;

import com.zc.sort.Sort;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
	
	@Override
	protected void sort() {
		sort(0, array.length);
	}

	/**
	 * 对 [begin, end) 范围的元素进行快速排序
	 * @param begin
	 * @param end
	 */
	private void sort(int begin, int end) { 
		if (end - begin < 2) return;
		
		// 确定轴点位置 
		int middle = pivotIndex(begin, end);
		// 对子序列进行快速排序
		sort(begin, middle);
		sort(middle+1, end);
	} 
	
	/**
	 * 构造出 [begin, end) 范围的轴点元素
	 * @return 轴点元素的最终位置
	 */
	private int pivotIndex(int begin, int end) {
		
		// 随机选择一个元素 和 begin 位置进行交换
		swap(begin, begin + (int)(Math.random() * (end - begin)));
		
		// 备份begin位置的元素
		T pivot = array[begin];
		// end 指向最后一个元素
		end--;
		
		while (begin < end) {
			
			while (begin < end) {
				
				if (cmp(pivot, array[end]) < 0) { // 轴点元素 < 右边元素
					end--;
				} else { // 轴点元素 >= 右边元素
					array[begin] = array[end];
					begin ++;
					break;
				}
				
				if (cmp(pivot, array[begin]) > 0) { // 轴点元素 > 左边元素
					begin ++;
				} else { // 轴点元素 <= 左边元素
					array[end] = array[begin];
					end--;
					break;
				}
				
			}
			
		}
		
		// 将轴点元素放入最终的位置
		array[begin] = pivot;
		// 返回轴点元素的位置
		return begin;
	}
}

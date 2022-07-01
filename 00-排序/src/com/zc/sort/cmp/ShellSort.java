package com.zc.sort.cmp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.zc.sort.Sort;

@SuppressWarnings("unused")
public class ShellSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		// TODO Auto-generated method stub
		List<Integer> stepSequence = shellStepSequence();
		for (Integer step : stepSequence) {
			sort(step);
		}
	}
	
	/**
	 * 分成step列进行排序
	 * @return
	 */
	private void sort(int step) {
		// column 第几列
		for (int column = 0; column < step; column++) { // 对第column列进行排序
			// column、column+step、column+2*step、column+3*step
			for (int begin = column + step; begin < array.length; begin += step) {
				int current = begin;
				while (current > column && cmp(current, current-step) < 0) {
					swap(current, current-step);
					current -= step;
				}
			}
		}
	}
	
	private List<Integer> shellStepSequence() {
		List<Integer> stepSequence = new ArrayList<>();
		int step = array.length;
		while ((step >>= 1) > 0) { // 关键 >= 不是 > 
			stepSequence.add(step);
		}
		return stepSequence;
	}
}

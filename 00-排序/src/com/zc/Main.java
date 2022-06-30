package com.zc;

import java.util.Arrays;
import com.zc.sort.Sort;
import com.zc.tools.Asserts;
import com.zc.tools.Integers;

import com.zc.sort.cmp.BubbleSort1;
import com.zc.sort.cmp.BubbleSort2;
import com.zc.sort.cmp.BubbleSort3;
import com.zc.sort.cmp.SelectionSort;
import com.zc.sort.cmp.HeapSort;
import com.zc.sort.cmp.InsertionSort1;
import com.zc.sort.cmp.QuickSort;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Main {

	public static void main(String[] args) {
		
//		Integer[] array = {240, 571, 303, 863, 414, 273, 629, 430, 668, 
//				526, 274, 562, 14, 806, 690, 993, 587, 27, 284, 352,
//				72, 844, 823, 564, 369, 556, 348, 2, 53, 250, 339, 
//				11, 458, 213, 625, 550, 963, 290, 51, 426, 752, 592
//				, 399, 309, 136, 978, 424, 452, 183, 529, 215, 913, 
//				178, 749, 772, 99, 807, 302, 928, 703, 329, 349, 377
//				, 194, 965, 76, 511, 358, 862, 431, 520, 156, 402, 
//				42, 783, 110, 295, 36, 139, 437, 747, 3, 82, 406, 
//				146, 773, 613, 873, 713, 439, 721, 536, 58, 621, 177};
		
		Integer[] array = Integers.random(10000, 1, 9999999);
		testSorts(array, 
				new BubbleSort1(), 
				new BubbleSort2(),
				new BubbleSort3(),
				new SelectionSort(),
				new InsertionSort1(),
				new HeapSort(),
				new QuickSort()
				);
	}
	
	static void testSorts(Integer[] array, Sort... sorts) {
		for (Sort sort : sorts) {
			Integer[] newArray = Integers.copy(array);
			sort.sort(newArray);
			Asserts.test(Integers.isAscOrder(newArray));
		}
		
		Arrays.sort(sorts);
		
		for (Sort sort : sorts) {
			System.out.println(sort);
		}
	}
	
}

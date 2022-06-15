package com.zc;

public class DynamicArrayList<E> extends AbstractList<E> {
	
	// 所有的元素
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public DynamicArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = (E[]) new Object[capaticy];
	}
	
    public DynamicArrayList() {
    	this(DEFAULT_CAPACITY);
	}
    
    // 清除元素
    public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	
		// 补充
		if (elements != null && elements.length > DEFAULT_CAPACITY) {
			elements = (E[]) new Object[DEFAULT_CAPACITY];
		}		
    }
    
    // 获取index位置的元素
    public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}
    
    // 设置index位置的元素
    public E set(int index, E element) {
    	rangeCheck(index);
	   
    	E oldElement = elements[index];
    	elements[index] = element;
    	return oldElement;
    }
   
 
   // 在index位置上插入一个元素
   public void add(int index, E element) {
	   rangeCheckForAdd(index);
	   
	   // 确保容量足够
	   ensureCapaticy(size + 1);
	   
	   // 将index 之后的位置 进行挪动
	   for (int i = size; i > index; i++) {
		   elements[i] = elements[i - 1];
	   }
	   elements[index] = element;
	   // size++
	   size++; 
   }
   
   
  // 删除index元素
   public E remove(int index) {
	   rangeCheck(index);
	   E oldElement = elements[index];
	   for (int i = index+1; i < size; i++) {
		   elements[i - 1] = elements[i];
	   }
	   elements[--size] = null;
	   
	   // 缩容
	   trim();
	   
	   return oldElement;
   }
   
   
   // 缩容
   private void trim() {
	   // 30
	   int oldCapacity = elements.length;
	   // 15
	   int newCapacity = oldCapacity >> 1;
	   
	   // 重点
	   if (size > (newCapacity) || oldCapacity <= DEFAULT_CAPACITY) return;
	   
	   // 剩余空间还有很多
	   E[] newElements = (E[]) new Object[newCapacity];
	   for (int i = 0; i < size; i++) {
		   newElements[i] = elements[i];
	   }
	   elements = newElements;
	   
	   System.out.println(oldCapacity + "缩容为" + newCapacity);
   }
   
   // 保证要有 capacity 的容量
   private void ensureCapaticy(int capacity) {
	   int oldCapacity = elements.length;
	   if (oldCapacity >= capacity) return;
	   
	   // 新容量 是 旧容量的1.5倍
	   int newCapacity = oldCapacity + (oldCapacity >> 1);
	   
	   // 新容量 是 旧容量的2倍
//	   int newCapacity = oldCapacity << 1;
	   
	   E[] newElements = (E[]) new Object[capacity];
	   for (int i = 0; i < size; i++) {
		   newElements[i] = elements[i];
	   }
	   elements = newElements;

	   // 旧容量 扩容为 新容量
	   System.out.println(oldCapacity + "扩容为" + newCapacity);
   }
   
   
   // 查看元素的索引
   public int indexOf(E element) {
	   if (element == null)  {
		   for (int i = 0; i < size; i++) {
			  if (elements[i] == null) return i;
		   }
	   } else {
		   for (int i = 0; i < size; i++) {
			  if (elements[i].equals(element)) return i;
		   }
	   }
	   return ELEMENT_NOT_FOUND;
   }

@Override
public boolean imEmpty() {
	// TODO Auto-generated method stub
	return false;
}
	
}

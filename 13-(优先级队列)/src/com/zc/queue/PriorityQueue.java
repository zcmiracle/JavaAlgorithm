package com.zc.queue;
 import java.util.Comparator;
 import com.zc.heap.BinaryHeap;

 /**
  * 优先级队列
  * @author fearless
  *
  */
 public class PriorityQueue<E> {
     private BinaryHeap<E> heap;
     
     public PriorityQueue(Comparator<E> comparator) {
         heap = new BinaryHeap<>(comparator);
     }
     
     public PriorityQueue() {
         this(null);
     }
     
     public int size() {
         return heap.size();
     }
     
     /**
      * 是否为空
      * @return
      */
     public boolean isEmpty() {
         return heap.isEmpty();
     }
     
     /**
      * 清空
      */
     public void clear() {
         heap.clear();
     }
     
     /**
      * 入队
      * @param element
      */
     public void enQueue(E element) {
         // TODO Auto-generated method stub
         heap.add(element);
     }

     /**
      * 出队
      */
     public E deQueue() {
         // TODO Auto-generated method stub
         return heap.remove();
     }
     
     /**
      * 获取对头
      * @return
      */
     public E front() {
         return heap.get();
     }
 }
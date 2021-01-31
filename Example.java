import dsa.algorithms.problems.*;
import dsa.algorithms.search.*;
import dsa.algorithms.sort.*;
import dsa.datastructures.heap.*;
import dsa.datastructures.linkedlist.*;
import dsa.datastructures.list.*;
import dsa.datastructures.queue.*;
import dsa.datastructures.stack.*;
import java.util.*;

class Example
{
	public static void main(String[] args) 
	{
		Random rand = new Random();	//random number generator 
		long start,end;
		int size = 10000;
		int a[] = new int[size];
		int b[] = new int[size];	//duplicate array of a
		Object[] o = null;
		
		//create random array
		for(int i=0;i<size;i++)
		{
			b[i] = a[i] = rand.nextInt(size) - 10;	
		}
		
		
		System.out.println("\n++++++++++++++ ALGORITHMS ++++++++++++++");
		
		System.out.println("============== Maximum Subarray Sum ==============");
		System.out.println("Maximum Subarray Sum of array a = " + MaximumSubArraySum.sum(a) + "\n");
		
		
		System.out.println("============== Search Algorithm ==============");
		System.out.println("Linear Search (a contains 10 at index) = " + LinearSearch.search(a, 10) + "\n");
		
		
		System.out.println("============== Sort Algorithms ==============");
		start = System.currentTimeMillis();
		BubbleSort.sort(a,'a');
		end = System.currentTimeMillis();
		System.out.println("BubbleSort = " + (end-start) + "ms");
		
		for(int i=0;i<size;i++)	//restore previous values from b
		{
			a[i] = b[i];
		}
		start = System.currentTimeMillis();
		CountingSort.sort(a, 'a');
		end = System.currentTimeMillis();
		System.out.println("CountingSort = " + (end-start) + "ms");
		
		for(int i=0;i<size;i++)
		{
			a[i] = b[i];
		}
		start = System.currentTimeMillis();
		HeapSort.sort(a,'a');
		end = System.currentTimeMillis();
		System.out.println("HeapSort = " + (end-start) + "ms");
		
		for(int i=0;i<size;i++)
		{
			a[i] = b[i];
		}
		start = System.currentTimeMillis();
		InsertionSort.sort(a,'a');
		end = System.currentTimeMillis();
		System.out.println("InsertionSort = " + (end-start) + "ms");
		
		for(int i=0;i<size;i++)
		{
			a[i] = b[i];
		}
		start = System.currentTimeMillis();
		MergeSort.sort(a,'a');
		end = System.currentTimeMillis();
		System.out.println("MergeSort = " + (end-start) + "ms");
		
		
		for(int i=0;i<size;i++)
		{
			a[i] = b[i];
		}
		start = System.currentTimeMillis();
		QuickSort.sort(a,'a');
		end = System.currentTimeMillis();
		System.out.println("QuickSort = " + (end-start) + "ms");
		
		for(int i=0;i<size;i++)
		{
			a[i] = b[i];
		}
		start = System.currentTimeMillis();
		RadixSort.sort(a, 'a');
		end = System.currentTimeMillis();
		System.out.println("RadixSort = " + (end-start) + "ms");
		
		for(int i=0;i<size;i++)
		{
			a[i] = b[i];
		}
		start = System.currentTimeMillis();
		RandomizedQuickSort.sort(a,'a');
		end = System.currentTimeMillis();
		System.out.println("RandomizedQuickSort = " + (end-start) + "ms");
		
		for(int i=0;i<size;i++)
		{
			a[i] = b[i];
		}
		start = System.currentTimeMillis();
		SelectionSort.sort(a,'a');
		end = System.currentTimeMillis();
		System.out.println("SelectionSort = " + (end-start) + "ms");
		
		double[] d = new double[size];
		for(int i=0;i<size-1000;i++)
		{
			d[i] = rand.nextDouble() - 0.5;
		}
		start = System.currentTimeMillis();
		BucketSort.sort(d,'a');
		end = System.currentTimeMillis();
		System.out.println("BucketSort = " + (end-start) + "ms");
		
		
		System.out.println("\n++++++++++++++ DATA STRUCTURES ++++++++++++++");
		
		System.out.println("============== Heap ==============");
		Heap<Integer> h = new Heap<Integer>("max");
		h.add(3);
		h.add(1);
		h.add(22);
		h.add(-5);
		System.out.println(h.toString());
		System.out.println("size = " + h.size());
		System.out.println("h contains 1 = " + h.contains(1));
		System.out.println("poll = " + h.poll());
		System.out.println("peek = " + h.peek());
		System.out.println("to array = ");
		o = h.toArray();
		for(Object x : o)
		{
			System.out.print(x + " ");
		}
		h.clear();
		
		
		System.out.println("\n\n============== Linked List ==============");
		Linked_List l = new Linked_List("int");
		l.add(4);
		l.add(2);
		l.add(1);
		l.add(1,3);
		l.add(2);
		l.add(5);
		System.out.println(l.toString());
		System.out.println("size = " + l.size());
		System.out.println("first element = " + l.firstElement());
		System.out.println("last element = " + l.lastElement());
		System.out.println("at index 1 = " + l.get(1));
		System.out.println("index of 2 = " + l.indexOf(2));
		System.out.println("index of 2 starting from index 3 to end = " + l.indexOf(2,3));
		System.out.println("last index of 2 = " + l.lastIndexOf(2));
		System.out.println("last index of 2 starting from index 3 to start = " + l.lastIndexOf(2,3));
		System.out.println("is empty = " + l.isEmpty());
		System.out.println("remove 2 = " + l.remove(2));
		System.out.println("h contains 2 = " + l.contains(2));
		System.out.println("remove at index 3 = " + l.removeAtIndex(3));
		System.out.println("replace 1 with 99 = " + l.replace(1,99));
		System.out.println("replace value at index 0 with 100");    l.replaceAt(100,0);
		System.out.println("sort in ascending order");     l.sort('a');
		System.out.println("to array = ");
		o = l.toArray();
		for(Object x : o)
		{
			System.out.print(x + " ");
		}
		h.clear();
		
		
		System.out.println("\n\n============== Dynamic Array ==============");
		DynamicArray da = new DynamicArray("byte");
		da.add((byte)4);
		da.add((byte)2);
		da.add((byte)1);
		da.add(1,(byte)3);
		da.add((byte)2);
		da.add((byte)5);
		System.out.println(da.toString());
		System.out.println("size = " + da.size());
		System.out.println("ensure capacity is atleast 5");	da.ensureCapacity(5);
		System.out.println("capacity = " + da.capacity());
		System.out.println("first element = " + da.firstElement());
		System.out.println("last element = " + da.lastElement());
		System.out.println("at index 1 = " + da.get(1));
		System.out.println("index of 2 = " + da.indexOf((byte)2));
		System.out.println("index of 2 starting from index 3 to end = " + da.indexOf((byte)2,3));
		System.out.println("last index of 2 = " + da.lastIndexOf((byte)2));
		System.out.println("last index of 2 starting from index 3 to start = " + da.lastIndexOf((byte)2,3));
		System.out.println("is empty = " + da.isEmpty());
		System.out.println("remove 2 = " + da.remove((byte)2));
		System.out.println("h contains 2 = " + da.contains((byte)2));
		System.out.println("remove at index 3 = " + da.removeAtIndex(3));
		System.out.println("replace 1 with 99 = " + da.replace((byte)1,(byte)99));
		System.out.println("replace value at index 0 with 100");    da.replaceAt((byte)100,0);
		System.out.println("sort in ascending order");     da.sort('a');
		System.out.println("to array = ");
		o = da.toArray();
		for(Object x : o)
		{
			System.out.print(x + " ");
		}
		System.out.println("\ntrim capacity to size");	 da.trimToSize();
		System.out.println("fill zero");	da.zeroFill();
		System.out.println(da.toString());
		h.clear();
		
		
		System.out.println("\n============== Queue Array ==============");
		QueueArray qa = new QueueArray("float");
		qa.enqueue(1.11f);
		qa.enqueue(2.1f);
		qa.enqueue(-0.11f);
		qa.enqueue(198f);
		System.out.println("front = " + qa.front());
		System.out.println("rear = " + qa.rear());
		System.out.println("dequeue = " + qa.dequeue());
		qa.clear();
		
		System.out.println("\n============== Queue Linked List ==============");
		QueueLinkedList qll = new QueueLinkedList("float");
		qll.enqueue(1.11f);
		qll.enqueue(2.1f);
		qll.enqueue(-0.11f);
		qll.enqueue(198f);
		System.out.println("front = " + qll.front());
		System.out.println("rear = " + qll.rear());
		System.out.println("dequeue = " + qll.dequeue());
		qll.clear();
		
		
		System.out.println("\n============== Stack Array ==============");
		StackArray sa = new StackArray("char");
		sa.push('a');
		sa.push('S');
		sa.push('e');
		sa.push('d');
		System.out.println("peek = " + sa.peek());
		System.out.println("pop = " + sa.pop());
		sa.clear();
		
		System.out.println("\n============== Stack Linked List ==============");
		StackLinkedList sll = new StackLinkedList("char");
		sll.push('a');
		sll.push('S');
		sll.push('e');
		sll.push('d');
		System.out.println("peek = " + sll.peek());
		System.out.println("pop = " + sll.pop());
		sll.clear();
	}
}

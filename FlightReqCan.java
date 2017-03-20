import java.io.*;
import java.util.*;
public class FlightReqCan {
 	public static void main(String[] args) 
	{
		
		       //for testing 
//		
//		 		Flyer flyer1 = new Flyer("John", 2);
//		 		Flyer flyer2 = new Flyer("Jim", 1);
//		 		Flyer flyer3 = new Flyer("Tim", 4);
//		 		Flyer flyer4 = new Flyer("Cindy", 3);
//		 		ArrayList waitinglist = new ArrayList();
//		 		MyPriorityQueue<Flyer> priorityQueue = new MyPriorityQueue<>();
//		 		priorityQueue.enqueue(flyer1);
//		 		priorityQueue.enqueue(flyer2);
//		 		priorityQueue.enqueue(flyer3);
//		 		priorityQueue.enqueue(flyer4);
//		 		waitinglist = priorityQueue.print();
//				System.out.print(waitinglist);
		
		
		
		ArrayList waitinglist = new ArrayList();
		MyPriorityQueue<Flyer> priorityQueue = new MyPriorityQueue<>();
		
		while (true) {
		System.out.print("1. Request upgrade\n");
		System.out.print("2. Cancel upgrade\n");
		System.out.print("3. Print upgrade list\n");
		Scanner in = new Scanner(System.in);    
		System.out.println("Please input a int number:\n");
		int command = in.nextInt();    
			
		if (command == 1) 
		{
			System.out.print("Please input your name and status: \n");
			Scanner info = new Scanner(System.in);    
			String flyer_name = info.next();    
//			System.out.print(flyer_name + "\n");
//			String flyer_status = info.next();
			String flyer_status = info.nextLine();
//			System.out.print(flyer_status);
			int flyer_status_int = 0;
//			System.out.print(flyer_status+ "\n" );
			if (flyer_status.equals(" silver")) {
				flyer_status_int = 1;
			}
			else if (flyer_status.equals(" gold")) {
				flyer_status_int = 2;
			}
			else if (flyer_status.equals(" platinum")) {
				flyer_status_int = 3;
			}
			else if (flyer_status.equals(" super")) {
				flyer_status_int = 4;
			}
			else {
				System.out.print("Incorrect status! \n");
//				System.out.print(flyer_status_int);
			}
			while (flyer_status_int != 0) {
				priorityQueue.enqueue(new Flyer(flyer_name, flyer_status_int));
//				waitinglist = priorityQueue.print();
//				System.out.print(waitinglist);	
				break;	
			}
		}
		
		
		else if (command == 2) 
		{
			System.out.print("Please input your name and status: \n");
			Scanner info = new Scanner(System.in);    
			String flyer_name = info.next();    
//			System.out.print(flyer_name + "\n");
//			String flyer_status = info.next();
			String flyer_status = info.nextLine();
//			System.out.print(flyer_status);
			int flyer_status_int = 0;
//			System.out.print(flyer_status+ "\n" );
			if (flyer_status.equals(" silver")) {
				flyer_status_int = 1;
			}
			else if (flyer_status.equals(" gold")) {
				flyer_status_int = 2;
			}
			else if (flyer_status.equals(" platinum")) {
				flyer_status_int = 3;
			}
			else if (flyer_status.equals(" super")) {
				flyer_status_int = 4;
			}
			else {
				System.out.print("Incorrect status! \n");
//				System.out.print(flyer_status_int);
			}
			while (flyer_status_int != 0) {
				priorityQueue.dequeue();
//				waitinglist = priorityQueue.print();
//				System.out.print(waitinglist);	
				break;	
			}
		}
	
		else if (command == 3) {
			
			System.out.print("please enter k");
			Scanner sc = new Scanner(System.in);    
			int k = sc.nextInt();   
			Flyer[] wlist = new Flyer[100];

			for (int i = 0; i<k; i++) {
				wlist[i] = priorityQueue.dequeue();
				System.out.print(wlist[i] + "\n");										
			}
			for (int i = 0; i<k; i++) {
				priorityQueue.enqueue(wlist[i]);
			}
			
		}
		else {
			System.out.print("Incorrect command!\n");
		}
		}
		
		
		
		

		

	//	while (priorityQueue.getSize() > 0)
	//		System.out.print(priorityQueue.dequeue() + " ");
			

	
	}



	 static class Flyer implements Comparable<Flyer> {
		private String name;
		private int priority;

	 public Flyer(String name, int priority) {
		this.name = name;
		this.priority = priority;
	 }

	 @Override
	 public String toString() {
		return name + "(priority:" + priority + ")";
	 }

	 @Override
	 public int compareTo(Flyer Flyer) {
		return this.priority - Flyer.priority;
		 }
  	}

}

class MyPriorityQueue<E extends Comparable<E>> {
 private Heap<E> heap = new Heap<>();

	public void enqueue(E newObject) {
		heap.add(newObject);
	}

	public E dequeue() {
		return heap.remove();
	}

	public int getSize() {
		return heap.getSize();
	}
	public java.util.ArrayList<E> print(){
		return heap.print();
	}
 }

class Heap<E extends Comparable<E>> {
 public ArrayList<E> list = new ArrayList<>();

 /** Create a default heap */
	public Heap() {
	}

 /** Create a heap from an array of objects */
	public Heap(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
		}

 /** Add a new object into the heap */
	public void add(E newObject) {
		list.add(newObject); // Append to the heap
		int currentIndex = list.size() - 1; // The index of the last node

		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
 // Swap if the current object is greater than its parent
			if (list.get(currentIndex).compareTo(
				list.get(parentIndex)) > 0) {
					E temp = list.get(currentIndex);
					list.set(currentIndex, list.get(parentIndex));
					list.set(parentIndex, temp);
				}
			else
			break; // The tree is a heap now

			currentIndex = parentIndex;
		}
 }
	public ArrayList<E> print()
	{
		return list;
	}

	public E remove() {
		if (list.size() == 0) return null;

		E removedObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);

		int currentIndex = 0;
		while (currentIndex < list.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;

 // Find the maximum between two children
	if (leftChildIndex >= list.size()) break; // The tree is a heap
		int maxIndex = leftChildIndex;
	if (rightChildIndex < list.size()) {
		if (list.get(maxIndex).compareTo(
			list.get(rightChildIndex)) < 0) {
				maxIndex = rightChildIndex;
			}
 }

 // Swap if the current node is less than the maximum
	if (list.get(currentIndex).compareTo(
		list.get(maxIndex)) < 0) {
			E temp = list.get(maxIndex);
			list.set(maxIndex, list.get(currentIndex));
			list.set(currentIndex, temp);
			currentIndex = maxIndex;
		}
		else
		break; // The tree is a heap
	}

	return removedObject;
 }


	public int getSize() {
		return list.size();
	}
 }
import java.util.*;
import java.io.File;
class NBComparator {
		public Integer cmp(Integer a, Integer b)
		{
			return a.compareTo(b);
		}
  }

public class NutsNBolts {

	public static void main(String[] args) throws Exception{

//			Integer[] a={7, 2, 4, 8, 6, 5};
//			Integer[] b={5, 6, 8, 4, 2, 7};
//			sortNutsAndBolts(a,b,new NBComparator());
			// file 1
			File arg = new File(args[0]);
			Scanner s1 = new Scanner(arg);
			int counter = 0;
			while(s1.hasNextInt()) 
			{
				counter++;
				s1.nextInt();
				
			}
			Scanner s2 = new Scanner(arg);
			Integer[] a = new Integer[counter];
			for (int i = 0; i < counter; i++)
				{
					a[i] = s2.nextInt();
				}

		    
		// file 2 	
			File arg2 = new File(args[1]);
			Scanner s3 = new Scanner(arg2);
			int counter2 = 0;
			while(s3.hasNextInt()) 
			{
				counter2++;
				s3.nextInt();
				
			}
			Scanner s4 = new Scanner(arg2);
			Integer[] b = new Integer[counter2];
			for (int i = 0; i < counter2; i++)
				{
					b[i] = s4.nextInt();
				}
				
			sortNutsAndBolts(a,b,new NBComparator());
			System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(b));
			
		}

	public static void sortNutsAndBolts(Integer[] nuts, Integer[] bolts, NBComparator compare) {
		if (nuts == null || bolts == null) {
			return;
		}
		if (nuts.length != bolts.length) {
			return;
		}

		Integer totalLength = nuts.length;
		qsort(nuts, bolts, 0, totalLength - 1, compare);
	}

	public static void qsort(Integer[] nuts, Integer[] bolts, Integer l, Integer r, NBComparator compare) { 
		if (l >= r) {
			return;
		}
		// Find partition index for nuts, with bolts[l]
		Integer partIndex = partition(nuts, bolts[l], l, r, compare);
		// Partition bolts, with nuts[partIndex]
		partition(bolts, nuts[partIndex], l, r, compare);

		qsort(nuts, bolts, l, partIndex - 1, compare);
		qsort(nuts, bolts, partIndex + 1, r, compare);
	}

	public static Integer partition(Integer[] arr, Integer pivot, Integer l, Integer r, NBComparator compare) {

		Integer m = l;
		for (Integer i = l + 1; i <= r; i++) {
			if (compare.cmp(arr[i], pivot) == -1 || compare.cmp(pivot, arr[i]) == 1) {
				m++;
				swap(arr, i, m);
			} else if (compare.cmp(arr[i], pivot) == 0 || compare.cmp(pivot, arr[i]) == 0) {
				swap(arr, i, l);
				i--;
			}
		}
		swap(arr, m, l);

		return m;
	}

	public static void swap(Integer[] arr, Integer l, Integer r) {
		Integer temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}
	
}

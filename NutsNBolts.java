import java.util.*;
import java.io.File;
class NBComparator {
		public int cmp(String a, String b)
		{
			return a.toLowerCase().compareTo(b.toLowerCase());
		}
  }

public class NutsNBolts {

	public static void main(String[] args){
			String[] a={"ab","bd","dd","gg"};
			String[] b={"AB","GG","DD","BC"};
			sortNutsAndBolts(a,b,new NBComparator());
			System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(b));
//			File a = new File(args[0]);
////			File b = new File(args[1]);
//			System.out.println(a);
		}

	public static void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
		if (nuts == null || bolts == null) {
			return;
		}
		if (nuts.length != bolts.length) {
			return;
		}

		int totalLength = nuts.length;
		qsort(nuts, bolts, 0, totalLength - 1, compare);
	}

	public static void qsort(String[] nuts, String[] bolts, int l, int r, NBComparator compare) {
		if (l >= r) {
			return;
		}
		// Find partition index for nuts, with bolts[l]
		int partIndex = partition(nuts, bolts[l], l, r, compare);
		// Partition bolts, with nuts[partIndex]
		partition(bolts, nuts[partIndex], l, r, compare);

		qsort(nuts, bolts, l, partIndex - 1, compare);
		qsort(nuts, bolts, partIndex + 1, r, compare);
	}

	public static int partition(String[] arr, String pivot, int l, int r, NBComparator compare) {

		int m = l;
		for (int i = l + 1; i <= r; i++) {
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

	public static void swap(String[] arr, int l, int r) {
		String temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}
	
}

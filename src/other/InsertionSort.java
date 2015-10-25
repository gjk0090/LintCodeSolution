package other;

public class InsertionSort {

	public static void main(String[] args){
		int[] a = new int[]{5,2,4,6,1,3};
		insertionSort(a);
		for(int curr: a){
			System.out.print(curr + " ");
		}

	}

	public static void insertionSort(int[] a){
		for(int i=1;i<a.length;i++){
			int j=i;
			while(j>0 && a[j]<a[j-1]){
				int temp = a[j];a[j]=a[j-1];a[j-1]=temp;
				j--;
			}
		}
	}

}

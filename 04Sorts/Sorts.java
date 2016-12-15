import java.util.Arrays;

public class Sorts{

    public static String name(){
	return "06.Wu.Joyce"; 
    }

    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	int temp, orgNum;
	for(int i = 0; i<data.length-1; i++){
	    temp = smallest(data, i);
	    orgNum = data[i];
	    data[i] = data[temp];
	    data[temp] = orgNum;
	}
    }
	    

    public static int smallest(int[] data, int start){
	int small = data[start];
	int ans = start;
	for(int i = start; i < data.length; i++){
	    if(data[i] < small){
		small = data[i];
		ans = i;
	    }
	}
	return ans;
    }

    public static void insertionSort(int[] data){
	int tempNum;
	for(int i = 1; i<data.length; i++){
	    tempNum = data[i];
	    while(i > 0 && tempNum < data[i -1]){
		data[i] = data[i-1];
		i--;
	    }
	    data[i] = tempNum;
	}
    }

    public static void main(String[] args){
	int[] a = {2, -1, 5, 7, 10, 13, -900, 20000};
	System.out.println("Orginal: " + Arrays.toString(a));
	insertionSort(a);
	System.out.println("Sorted: " + Arrays.toString(a));
	int[] b = {2013, 216, 216, 0, 0, -4, 88};
	System.out.println("Orginal: " + Arrays.toString(b));
	insertionSort(b);
	System.out.println("Sorted: " + Arrays.toString(b));
       	int[] c = {46, 772013, 32, 45, 1, 0, -1, 4};
	System.out.println("Orginal: " + Arrays.toString(c));
	insertionSort(c);
	System.out.println("Sorted: " + Arrays.toString(c));

    }
    
      

}

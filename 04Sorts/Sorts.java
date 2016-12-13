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
	int swap = 0;
	int[] ans = new int[data.length];
	int i = 0;
        while(data.length > 0){
	    if(data.length == 1){
		ans[data.length] = data[0];
	    }
	    swap = smallest(Arrays.copyOfRange(data, i, data.length));
	    ans[i] = ans[swap];
	    ans[swap] = ans[i];
	    i++;
	    data = Arrays.copyOfRange(data, i, data.length);
	}
    }

    public static int smallest(int[] data){
	int small = data[0];
	int ans = 0;
	for(int i = 0; i < data.length; i++){
	    if(data[i] < small){
		ans = i;
	    }
	}
	return ans;
    }

    public static void main(String[] args){
	int[] a = {2, -1, 5, 7, 10, 13, -900, 20000};
	selectionSort(a);
	System.out.println(a);
    }
    
      

}

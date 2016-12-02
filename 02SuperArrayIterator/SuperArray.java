public class SuperArray implements Iterable<String>{
    private int[] data;
    private int size;

    
    public SuperArray(){
	size = 0;
	data = new int[10];
    }

    public SuperArray(int len){
	if(len < 0){
	    throw new IllegalArgumentException();
	}
	size = 0;
	data = new int[len];
    }
	

    public int get(int i){
	if(i<0 || i>=size()){
	    throw new IndexOutOfBoundsException();
	}
        return data[i];
    }

    public void setSize(int n){
	size = n;
    }
    
    public int size(){
	return size;
    }

   
    public int set(int n, int value){
	if(n<0 || n>=size()){
	    throw new IndexOutOfBoundsException();
	}
	int org = data[n];
	data[n] = value;
	return org;
    }
    
    public boolean add(int n){
	if(size() == data.length){
	    grow();
	}
	data[size] = n;
	size++;
	return true;
    }

    // public void add(int index, int element){
    // 	if(index<0 || index >= size()){
    // 	    throw new IndexOutOfBoundsException();
    // 	}
    //   	if(size() >= data.length){
    // 	    grow();
    // 	}
    // 	int[] ary = new int[data.length];
    // 	for(int i = 0; i<data.length; i++){
    // 	    if(i<index){
    // 		ary[i] = data[i];
    // 	    }
    // 	    else if(i==index){
    // 		ary[i] = element;
    // 	    }
    // 	    else{
    // 		ary[i] = data[i-1];
    // 	    }
    // 	}
    // 	size++;
    // 	data = ary;
    // 	System.out.println(toString());
    // }

    public void add(int index, int element){
	if (index < 0 || index > size())
	    throw new IndexOutOfBoundsException("Invalid index");
	if (data.length > size){
	    size += 1;
	    for (int x = size - 1; x > index; x--){
		set(x, data[x-1]);
	    }
	    set(index, element);
	}
	else{
	    grow();
	    add(index, element);
	}
    }

    
    public void grow(){
        int[] ary = new int[data.length*2];
	for(int i = 0; i<data.length;i++){
	    ary[i] = data[i];
	}
	data = ary;
    }

    public int remove(int index){
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	int ret = data[index];
	int[] ary = new int[data.length];
	for(int i = 0; i<data.length-1; i++){
	    if(i<index){
		ary[i] = data[i];
	    }
	    else{
		ary[i] = data[i+1];
	    }
	}
	size--;
	data = ary;
	return ret;
    }
    
    public String toString(){
	if(size() == 0){
	    return "[]";
	}
	String newstr = "[";
	for(int i = 0; i<data.length-1; i++){
	    newstr += data[i] + ", ";
	}
	newstr +=  data[data.length-1] + "]";
	return newstr;
    }
    
    public String toStringDebug(){
    	String newstr = "[";
    	for(int i = 0; i<data.length-1; i++){
    	    if(i<size){
    		newstr += data[i] + ", ";
    	    }
    	    else{
    		newstr += "_, ";
    	    }
    	}
    	if(data.length>size()){
    	    newstr += "_]";
    	}
    	else{
    	    newstr += data[size-1] + "]";
    	}
    	return newstr;
    }

    public int[] toArray(){
	int[] ary = new int[data.length];
	for(int i = 0; i<data.length; i++){
	    ary[i] = data[i];
	}
	return ary;
    }

    public void clear(){
	size = 0;
    }

    public boolean isEmpty(){
	return size == 0;
    }

    public int indexOf(int i){
	for(int n = 0; n < data.length; n++){
	    if(data[n] == i){
		return n;
	    }
	}
	return -1;
    }

    public int lastIndexOf(int i){
	for(int n=data.length-1; n>=0; n--){
	    if(data[n] == i){
		return n;
	    }
	}
	return -1;
    }

    public void trimToSize(){
	int[] ary = new int[size];
	for(int i = 0; i < size; i++){
	    ary[i] = data[i];
	}
	data = ary;
    }

    public Iterator<String> iterator(){
	return SuperArrayIterator(data);
    }

    //   public static void main(String[]args){
    // 	SuperArray s = new SuperArray();
    // 	s.add(1);
    // 	s.add(2);
    // 	s.add(6);
    // 	s.add(4);
    // 	s.add(5);
    // 	System.out.println(s);
    // 	System.out.println(s.size());
    // 	OrderedSuperArray ns = new OrderedSuperArray(s.toArray());
    // 	System.out.println(ns.toStringDebug());

    // 	OrderedSuperArray z = new OrderedSuperArray();
    // 	z.add(4);
    // 	z.add(3);
    // 	z.add(1);
    // 	z.add(5);
    // 	System.out.println(z);
	
    // 	OrderedSuperArray x = new OrderedSuperArray();
    // 	System.out.println(x);
    // 	System.out.println(x.add(3));
    // 	//x.grow();
    // 	System.out.println(x);
    // 	System.out.println(x.toStringDebug());
    // 	x.clear();
    // 	System.out.println(x.isEmpty());
    // 	System.out.println(x.add(7));
    // 	//	System.out.println(x.set(0,2));
    // 	//	x.add(0,3);
    // 	System.out.println(x.toStringDebug());
    // 	System.out.println(x.remove(0));
    // 	System.out.println(x.toStringDebug());
    // 	System.out.println(x.toArray());
    // 	System.out.println(x.add(2));
    // 	System.out.println(x.add(1));
    // 	System.out.println(x.toStringDebug());
    // 	System.out.println(x.size());
    // 	System.out.println(x.indexOf(2));
    // 	System.out.println(x.indexOf(3));
    // 	System.out.println(x.lastIndexOf(2));
    // 	System.out.println(x.lastIndexOf(5));
    // }	

}

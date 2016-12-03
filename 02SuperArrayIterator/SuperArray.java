import java.util.*;

public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    
    public SuperArray(){
	size = 0;
	data = new String[10];
    }

    public SuperArray(int len){
	if(len < 0){
	    throw new IllegalArgumentException();
	}
	size = 0;
	data = new String[len];
    }
	

    public String get(int i){
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

   
    public String set(int n, String value){
	if(n<0 || n>=size()){
	    throw new IndexOutOfBoundsException();
	}
	String org = data[n];
	data[n] = value;
	return org;
    }
    
    public boolean add(String  n){
	if(size() == data.length){
	    grow();
	}
	data[size] = n;
	size++;
	return true;
    }


    public void add(int index, String element){
	if (index < 0 || index > size())
	    throw new IndexOutOfBoundsException("Invalid index");
	if (data.length > size){
	    size += 1;
	    for (int i = size - 1; i > index; i--){
		set(i, data[i-1]);
	    }
	    set(index, element);
	}
	else{
	    grow();
	    add(index, element);
	}
    }

    
    public void grow(){
        String[] ary = new String[data.length*2];
	for(int i = 0; i<data.length;i++){
	    ary[i] = data[i];
	}
	data = ary;
    }

    public String remove(int index){
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	String ret = data[index];
	String[] ary = new String[data.length];
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
	for(int i = 0; i<size()-1; i++){
	    newstr += data[i] + ", ";
	}
	newstr +=  data[size-1] + "]";
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

    public String[] toArray(){
	String[] ary = new String[data.length];
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

    public int indexOf(String i){
	for(int n = 0; n < data.length; n++){
	    if(data[n].equals(i)){
		return n;
	    }
	}
	return -1;
    }

    public int lastIndexOf(String i){
	for(int n=size()-1; n>=0; n--){
	    if(data[n].equals(i)){
		return n;
	    }
	}
	return -1;
    }

    public void trimToSize(){
	String[] ary = new String[size];
	for(int i = 0; i < size; i++){
	    ary[i] = data[i];
	}
	data = ary;
    }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }

}

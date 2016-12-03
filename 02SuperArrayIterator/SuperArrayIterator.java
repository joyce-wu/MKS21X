import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    private SuperArray ary;
    private int index;

    public SuperArrayIterator(SuperArray ary){
	this.ary = ary;
	index = 0;
    }

    public SuperArray ary(){
	return ary;
    }
    public void setAry(SuperArray newAry){
	ary = newAry;
    }
    public int index(){
	return index;
    }
    public void setIndex(int i){
	index = i;
    }
    
    public boolean hasNext(){
	return index < ary.size();
    }

    public String next(){
	if(hasNext()){
	    index++;
	    return ary.get(index-1);
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }

}

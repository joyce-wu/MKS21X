public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String author, String title, String ISBN, String call){
	setAuthor(author);
	setTitle(title);
	setISBN(ISBN);
	callNumber = call;
    }

    public String callNumber(){
	return callNumber;
    }
    public void setCallNumber(String call){
	callNumber = call;
    }

    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();

    public String toString(){
	String str = "";
	str += super.toString();
	str += "Circulation status: "+circulationStatus()+"\nCall Number: "+callNumber+"\n";
	return str;
    }

    public int compareTo(LibraryBook book){
	if(book.author().equals(author()) &&
	   book.title().equals(title()) &&
	   book.ISBN().equals(ISBN()) &&
	   book.callNumber().equals(callNumber)){
	    return 0;
	}
	else{ return -1; }
    }
    
	
}

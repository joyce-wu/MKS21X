public class ReferenceBook extends LibraryBook{
    private String collection;
    public ReferenceBook(String author, String title, String ISBN, String callNumber, String collect){
	super(author, title, ISBN, callNumber);
	collection = collect;
    }

    public String collection(){
	return collection;
    }
    public void getCollection(String newc){
	collection = newc;
    }

    public void checkout(String patron, String due){
	System.out.println("Cannot check out a reference book.");
    }

    public void returned(){
        System.out.println("Reference book could not have been checked out -- return impossible.");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
	String s = "";
	s += super.toString();
	s += "Collection: " + collection + "\n";
	return s;
    }
						
						
}

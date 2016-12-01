public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN, callNumber);
	dueDate = "";
	currentHolder = "";
	dueDate = "";
    }

    public String currentHolder(){
	return currentHolder;
    }
    public void setCurrentHolder(String holder){
	currentHolder = holder;
    }
    public String dueDate(){
	return dueDate;
    }
    public void setDueDate(String date){
	dueDate = date;
    }

    public void checkout(String patron, String date){
	currentHolder = patron;
	dueDate = date;
    }
    public void returned(){
	currentHolder = "";
	dueDate = "";
    }

    public String circulationStatus(){
	if(currentHolder.equals("")){
	    return "Name: " + currentHolder + "Due date: " + dueDate;
	}
	else{
	    return "Book available on shelves.";
	}
    }

    public String toString(){
	String s = "";
	s = super.toString() + "Current Holder: " + currentHolder + "\nDue Date: " + dueDate + "\n";
	return s;
    }
	    
	
}

public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
	author = "";
	title = "";
	ISBN = "";
    }

    public Book(String auth, String titl, String num){
	author = auth;
	title = titl;
	ISBN = num;
    }

    public String author(){
	return author;
    }
    public void setAuthor(String newa){
	author = newa;
    }
    public String title(){
	return title;
    }
    public void setTitle(String newt){
	title = newt;
    }
    public String ISBN(){
	return ISBN;
    }
    public void setISBN(String newi){
	ISBN = newi;
    }

    public String toString(){
	String str = "Author: "+author+"\nTitle: "+title+"\nISBN: "+ISBN+"\n";
	return str;
    }
	
	
}

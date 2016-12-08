public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;

    public String _zip(){
	return _zip;
    }
    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	try{
	    Integer.parseInt(zip);
	    if(zip.length() != 5){
		throw new IllegalArgumentException("please input a zipcode with 5 digits");
	    }
	    _zip = zip;
	    _checkDigit = checkSum() % 10;
      
	}catch(NumberFormatException e){
	    throw new IllegalArgumentException("please input a zipcode as a 5 digit string");
	}   
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	Barcode c = new Barcode(_zip);
	return c;
    }

    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int sum = 0;
	for(int i = 0; i < _zip.length(); i++){
	    sum += Integer.parseInt(_zip.charAt[i]);
	}
	return sum;
    }

    public String createBarcode(){
	String ans = "";
	String[] c = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:",
		":||::", "|:::|", "|::|:", "|:|::"};
	for(int i = 0; i < _zip.length(); i++){
	    ans += c[(int)_zip.charAt[i]];
	}
	ans += c[checkSum()%10];
	return ans;
    }

    //postcondition: format zip + check digit + barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return _zip + _checkDigit +  " " + createBarcode();
    }


    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	_zip.compareTo(other._zip());
    }
}

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
	    _checkDigit = checkSum(_zip) % 10;
      
	}catch(NumberFormatException e){
	    throw new IllegalArgumentException("please input a zipcode as a 5 digit string");
	}   
    }

    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String zip){
	int sum = 0;
	for(int i = 0; i < zip.length(); i++){
	    sum += Integer.parseInt(zip.substring(i, i+1));
	}
	return sum;
    }

    public static String toCode(String zip){
	String ans = "|";
	String[] c = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:",
		      ":||::", "|:::|", "|::|:", "|:|::"};
	if(zip.length() != 5){
	    throw new IllegalArgumentException("zipcodes must be 5 digits");
	}
	else{
	    for(int i = 0; i < zip.length(); i++){
		try{
		    ans += c[Integer.parseInt(zip.substring(i, i+1))];
		}catch(NumberFormatException e){
		    throw new IllegalArgumentException("zipcodes must be digits");
		}
	    }
	    ans += c[checkSum(zip)%10] + "|";
	    return ans;
	}
    }

    public static String toZip(String code){
	if(code.length() != 32){
	    throw new IllegalArgumentException("Barcodes must have a length of 32.");
	}
	if(!(code.substring(0,1).equals("|") && code.substring(31).equals("|"))){
	    throw new IllegalArgumentException("Barcode does not end or start with |");
	}
	else{
	    String ans = "";
	    for(int i = 1; i<31; i++){
		if(!(code.substring(i, i+1).equals("|") || code.substring(i,i+1).equals(":"))){
		    throw new IllegalArgumentException("non-barcode characters are used.");
		}
	    }
	    for(int i = 1; i<code.length()-5; i+=5){
		String num = code.substring(i, i+5);
		switch(num){
		case "||:::":
		    ans += "0";
		    break;
		case ":::||":
		    ans += "1";
		    break;
		case  "::|:|":
		    ans += "2";
		    break;
		case "::||:":
		    ans += "3";
		    break;
		case ":|::|":
		    ans += "4";
		    break;
		case ":|:|:":
		    ans += "5";
		    break;
		case ":||::":
		    ans += "6";
		    break;
		case "|:::|":
		    ans += "7";
		    break;
		case "|::|:":
		    ans += "8";
		    break;
		case "|:|::":
		    ans += "9";
		    break;
		default:
		    throw new IllegalArgumentException("Barcode has invalid characters.");
		}
	    }
	    if(checkSum(ans.substring(0, 5))%10 != Integer.parseInt(ans.substring(5))){
		throw new IllegalArgumentException("Checksum failed.");
	    }
	    return ans;
	}
    }
		       
    //postcondition: format zip + check digit + barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return _zip + _checkDigit +  " " + toCode(_zip);
    }


    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return _zip.compareTo(other._zip);
    }

    public static void main(String args[]){
	Barcode b = new Barcode("08451");
	Barcode c = new Barcode("99999");
	Barcode d = new Barcode("01111");
	System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
	System.out.println(b.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(b.compareTo(b)); //0
	System.out.println(c.compareTo(b));
	System.out.println(d.compareTo(b));
	/*
	  Barcode e = new Barcode("123456");
	  System.out.println(e);
	*/
	/*
	  Barcode e = new Barcode("1234");
	  System.out.println(e);
	*/
	/*
	  Barcode e= new Barcode("12.45");
	  System.out.println(e);
	*/
	//System.out.println("To fail (too short): ");
	//b.toCode("00");
	//System.out.println("To fail (nondigits): ");
	//b.toZip("ab01e");
	//System.out.println("To fail (non-barcode characters): ");
	//b.toZip("|a|::c|::|::|::|:|:|::::|||::|::");
	//System.out.println("To fail (does not start or end with |): ");
	//b.toZip("|||:::|::|::|::|:|:|::::|||::|::");
	//System.out.println("To fail (wrong length): ");
	//b.toZip("|||:::|::|::|::|:|:|::::|||::|:::");
	//System.out.println("To fail: (invalid char): ");
	//b.toZip("|:::::|::|::|::|:|:|:::::||::|:|");
	//System.out.println(b.toZip("|||:::|::|::|::|:|:|::::|||::|:|"));
	//System.out.println("To fail: (checkSum failed): ");
	//b.toZip("|||:::|::|::|::|:|:|::::||:|:|:|");
    }
}

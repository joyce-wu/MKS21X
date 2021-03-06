public class Temperatures{
    public static double CtoF(double t){
	return t*1.8+32;
    }

    public static double FtoC(double t){
	return (t-32)*5/9.;
    }

    public static void main(String[] args){
	System.out.println(Temperatures.CtoF(-40.0)); //-40.0
	System.out.println(Temperatures.CtoF(100.0)); //212.0
	System.out.println(Temperatures.CtoF(0)); //32.0
	System.out.println(Temperatures.FtoC(-40.0)); //-40.0
	System.out.println(Temperatures.FtoC(212.0)); //100.0
	System.out.println(Temperatures.FtoC(32.0)); //0.0
    }


}

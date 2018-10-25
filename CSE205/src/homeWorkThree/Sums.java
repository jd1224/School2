package homeWorkThree;

public class Sums {

	public static void main(String[] args) {
		Sums test = new Sums();
		test.run();
	}
	
	public void run() {
		System.out.println(sigma(5));
		System.out.println(power(5,2));
		String reversed = reverse("Recrusive Reverse");
		System.out.println(reversed);
	}
	
	
	private int sigma(int x) {
		
		if(x==1) {
			return 1;
		}else {
			return x + sigma(x-1);
		}
	}
	
	
	private double power(double x, int n) {
		if(n==1) {
			return x;
		}else {
			return x*(power(x,n-1));
		}
	}
	
	private String reverse(String x) {
		if((x==null)||x.length()<=1) {
			return x;
		}
		return reverse(x.substring(1))+x.charAt(0);
	}
}

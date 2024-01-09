public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	double payment = loan/n;
    	iterationCounter = 0;
    	while(endBalance(loan, rate, n, payment) > epsilon){
    		payment += epsilon;
    		iterationCounter++;
    	}
    	return payment;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	double l = loan / n;
    	double h = loan;
    	double payment = ((l+h) / 2);
    	iterationCounter = 0;
    	while(h - l > epsilon){
    		if (endBalance(loan, rate, n, payment) * endBalance(loan, rate, n, l) > epsilon){
				l = payment;
    		}
			else{
				h = payment;
			}
			payment = (l + h) / 2;
			iterationCounter++;
    	}
    	return payment;
    }

	private static double endBalance(double loan, double rate, int n, double payment) {
		for (int i = 1; i <= n ; i++ ) {
			loan -= payment;
			loan = loan * (1 + (rate / 100));
		}
		return loan;
	}
}
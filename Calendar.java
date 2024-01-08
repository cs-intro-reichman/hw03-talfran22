/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar{	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	

	public static void main(String args[]) {
		int givenyear = Integer.parseInt(args[0]);
	 	while (year < 2025) {
	 		//// Write the body of the while 
	 		if(year == givenyear){
	 			while(year == givenyear)
	 			{	
	 				if(dayOfWeek == 1){
	 					System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
	 				}
	 				else{
	 					System.out.println(dayOfMonth + "/" + month + "/" + year);
	 				}
	 				advance();
	 			}
	 		}
			advance();
	 		
        }

	 }
	
	 private static void advance() {
		if(dayOfWeek < 7){
			dayOfWeek++;
		}
		else{
			dayOfWeek = 1;
		}
		if(dayOfMonth< nDaysInMonth(month, year))
		{
			dayOfMonth++;
		}
		else{
			dayOfMonth = 1;
			if(month < 12) 
			{
				month++;
			}
			else {
				year++;
				month = 1;
			}
		}
	 } 
		 
   
	private static boolean isLeapYear(int year) {
	    boolean Isleapyear = false;
		if (year % 400 == 0) {
			Isleapyear = true;
		}
		if((year % 4 == 0) && (year % 100 != 0)){
			Isleapyear = true;
		}
		return Isleapyear;	
	}
	 
	
	private static int nDaysInMonth(int month, int year) {
		if(month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		else{
			if (month == 2) {
				if (isLeapYear(year)) 
					return 29;	
				return 28;
			}	
			return 31;
		}
	}
}

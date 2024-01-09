public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	public static void main(String args[]) {
		int sunday = 0;
	 	while (year < 2000) {		
	 		if(dayOfWeek == 1 && dayOfMonth == 1){
	 			System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
	 			sunday++;
	 		}
	 		else{
	 			System.out.println(dayOfMonth + "/" + month + "/" + year);
	 		}
			advance();
	 		
        }
        System.out.println("During the 20th century, " + sunday + " Sundays fell on the first day of the month");
	 	
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

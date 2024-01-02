/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {
        String change = "";
        for (int i = 0 ; i < s.length() ; i++ ) {
            char check = s.charAt(i);
            if( (int)check >= 65 && (int)check <= 90){
                check += 32;
                change += check;
            }
            else{
                change += s.charAt(i);
            }
        }
        return change;
    }
}

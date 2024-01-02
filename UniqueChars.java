/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
                System.out.println(uniqueChars("yael played the yokelele"));

    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String check = "";
        int count = 0;
        for (int i = 0; i < s.length() ; i++) {
            for (int j = 0; j < check.length() ; j++) {
                if(s.charAt(i) != ' ' && s.charAt(i) != check.charAt(j)){
                    count++;
                }
            }
            if(count == check.length()){
                check += s.charAt(i);
            }
            if(s.charAt(i) == ' '){
                check += ' ';
            }
            count = 0;
        }
            return check;
    }
}

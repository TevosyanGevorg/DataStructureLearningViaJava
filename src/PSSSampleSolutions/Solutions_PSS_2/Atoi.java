
public class Atoi {

    public static void main(String[] args) {
        System.out.println(atoi("1023"));
    }

    /**
     * @brief           converts the given string Argument TO an Integer(that's why it's called 'atoi')
     * @pre-condition   str argument must be valid and nonempty string.
     */
    public static int atoi(String str) throws IllegalArgumentException{
       if(str.isEmpty())
           throw new IllegalArgumentException("given argument is an empty string!");

        int num = 0;
        for(int i = 0; i < str.length(); ++i){
            num = num * 10 + str.charAt(i) - '0';
        }
        return num;
    }
}

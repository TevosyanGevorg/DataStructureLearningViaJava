
public class StringDecoder {

    public static void main(String[] args) {
        System.out.println(decode("2[abc]3[cd]ef"));
    }

    public static String decode(String str){
        StringBuilder builder = new StringBuilder();
        while (j < str.length() && str.charAt(j) != ']'){
            int n = 0;
            if(Character.isDigit(str.charAt(j))){
                n = str.charAt(j++) - '0';
                j++;
                String str1 = decode(str);
                while(n > 0){
                    builder.append(str1);
                    --n;
                }
            }
            else
                builder.append(str.charAt(j));
            ++j;
        }

        return builder.toString();
    }
    private static int j;
}

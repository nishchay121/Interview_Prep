

public class ReverseVowelInString {
    //mail caller function
    public String reverseVowels(String s) {

        /*
         * brute force would be start from left and go right until we find a vowel.
         * once vowel found start searching from right for the vowel.
         * once found swap and keep going on.
         */

         /*
          * Optimized 2 pointer approach
          */
       char[] c = s.toCharArray();
       return reverseVoweHelper(c);

    }
    public String reverseVoweHelper(char[] c){
        int i =0; 
        int j = c.length;
        while (i < j){ //until both left n right pointer meet keep continuing
            if(!isVowel(c[i])){//if current left is not vowel, move
                i++;
            }
            if(!isVowel(c[j])){
                j--;//if current right is not vowel, move
            }
            if(isVowel(c[i]) && isVowel(c[j])){//if current i and j both are vowels then we need to swap;
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        return new String(c);//return new string from new array
    }
    public boolean isVowel(Character c){
        if(c == 'a' || c == 'A' || c =='e' || c == 'E' ||  c == 'i'
            || c == 'I' || c == 'o' || c== 'O' || c=='u' || c == 'U')
            return true;
        return false;
    }
}

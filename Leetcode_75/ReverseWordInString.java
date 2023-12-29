package Leetcode_75;
public class ReverseWordInString {

   /*
  *Reverse any char array/ word/string passed by swapping
  */
  public void reverse(int start, int end, char[] c){
      while(start <= end){
          char temp = c[start];
          c[start] = c[end];
          c[end] = temp;
          start++;
          end--;
      }
  }

  /*
   * Function to reverse each word by word of string 
   */

  public void reverseWords(char[] c){
      int start = 0;
      int end = 0;
      int len = c.length;
      while(end < len ){
          while(start < len && c[start] == ' ')
            start++;
          end = start; // move end to start ptr
          while(end < len && c[end] != ' ')
           end++;
           //now we have start of word and end of word where end is at blank space
           reverse(start,end-1,c);
           //now word is sawpped;
           //again reset start to end + 1;
           start = end + 1;
      }
  }
  /*
   * Method to clear the extra spaces from between and ends
   */
  public String clearSpace(char[] c){
      if(c.length == 0 )
            return "";
      int start =0;
      int end = 0;
      int len = c.length;

      while(end < len){
          while(end < len && c[end]== ' ')
            end++;
          while(end < len && c[end] != ' ') //keep going until again we dont get space
          {
              c[start] = c[end];//keep copying
              start++;
              end++;
          }
          //now end is at space
          //again keep skipping space char
          while(end < len && c[end] == ' '){
              end++;
          }
         if(end< len){ //if not the end of string
            c[start] = ' ';
            start++;
         }
          
        
      }
      return new String(c).substring(0,start);//since start will be desired last + 1 
  }

  //main caller function
  public String reverseWords(String s) {
    char [] c = s.toCharArray();
    reverse(0,c.length-1, c); //reverse the whole string first

    reverseWords(c); //reverse each word
    //now we have each word reversed with spaces
    return clearSpace(c);

  }
  /*
   * We have more implementation which include inbuilt methods such as trim and split(//s+) and join.
   * but the basic idea remains same that we revrse string and reverse each word to get this done in O(N) time complexity
   */
}
import java.util.Scanner;

public class StringMatching
{

        public static void main(String[] args)
        {
                Scanner sc = new Scanner(System.in);

                while (sc.hasNext() != false)
                {
                        String pattern = sc.nextLine(); //get the pattern and text
                        String text = sc.nextLine();
                        findPattern( pattern, text);                                    // this will print

                }


                sc.close();
        }

        /*
         * input :2 strings => a pattern, a text
         * output: void, effect = print position at which all the patterns apears in the text separated by a single space
         */
        public static void findPattern(String pattern,String text)
        {
                int atPattern = 0;
                int atText = 0;
                
                if (pattern.length() > text.length() || pattern.length() <= 0) return; // if the pattern is bigguer then the text then there is no way to find it in it

                while(atText < text.length())
                {
                	if(pattern.length() > text.length() || atPattern >= pattern.length()) return ;
                	
                        while( pattern.charAt(atPattern) == text.charAt(atText)) // check if pattern pointer points at the same char as text char
                        {
                        	                        	
                                if(atPattern == pattern.length()-1) // if the whole pattern has been found print its location and reset
                                {
                                        System.out.print((atText - pattern.length() + 1) + " " );
                                        break;
                                }
                                else // if we are not done comparing the pattern check next char
                                {
                                        atText++;
                                        atPattern++;
                                }
                                
                                if(pattern.length() > text.length() || atPattern >= pattern.length()||atText >= text.length()) return ;
                        }
                        atText = atText + 1 - atPattern;  // the pattern doesnt fit anymore try again on the next text char
                        atPattern = 0 ;

                }

                System.out.println(""); // prints new line for next test case
                return;
        }
}

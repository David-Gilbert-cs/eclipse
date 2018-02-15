import java.util.Scanner;
import java.util.regex.Matcher;


/*
 * String matching with KMP
 */

public class StringMatching2
{
	//**********************************************************************************
	  
	  
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
            int[] prefixes = computePrefix(pattern);
        	
        	match(pattern,text,prefixes);
        
        }
        
        //we compute all the possible prefixes for future use *when we have a mismatch
        public static int[] computePrefix(String pattern) 
        {
        	int[] prefixes = new int[pattern.length()];
        	
        	  int k = -1;
        	  prefixes[0] = 0;
        	  for(int i =1 ; i <= pattern.length() ;i++)
        	  {
        		  while(k>=0 && pattern.charAt(k+1) != pattern.charAt(i))
        		  {
        			  k = prefixes[k];
        		  }
        		  prefixes[i] = ++k;
        	  }
        	 
        	  
        	  return prefixes;
        }
        
        
        
        
        public static void match(String pattern,String text,int[] prefixes)
        {
        	//j = text pointer/ i = pattern pointer
        	int k=0;
        	for(int i=0;i<=text.length();i++)       
        	{
        		while(k>=0 && pattern.charAt(i+1)!= text.charAt(i))
        		{
        			k = prefixes[k]; //increment with the prefixes
        		}
        		k++;
        		
        		if (k == pattern.length()) //match found
        		{
        			System.out.print((i - pattern.length() + 1) + " " );
        			k = prefixes[k];
        		}
        	}
           	
        }
        
       
        
        
}
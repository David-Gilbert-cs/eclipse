// STUDENT_NAME:
// STUDENT_ID:

import java.util.*;
import java.io.*;



public class Scrabble{

    static HashSet<String> myDictionary; // this is where the words of the dictionary are stored

    // DO NOT CHANGE THIS METHOD
    // Reads dictionary from file
    public static void readDictionaryFromFile(String fileName) throws Exception {
        myDictionary=new HashSet<String>();

        BufferedReader myFileReader = new BufferedReader(new FileReader(fileName) );

        String word;
        while ((word=myFileReader.readLine())!=null) myDictionary.add(word);

 myFileReader.close();
    }



    /* Arguments: 
        char availableLetters[] : array of characters containing the letters that remain available
        String prefix : Word assembled to date
        Returns: String corresponding to the longest English word starting with prefix, completed with zero or more letters from availableLetters. 
          If no such word exists, it returns the String ""
     */
  
        
  public static String longestWord(char availableLetters[], String prefix) {

     
  String longest = "";
 
  if (myDictionary.contains(prefix)){
   longest= prefix;
  }
 
 
  for(int i=0; i<availableLetters.length;i++){
  
   String temp = prefix + availableLetters[i];

     char[] availableLetters2 = new char[availableLetters.length-1];     //create new available letters
     for(int j=0;j<i;j++){
     availableLetters2[j]=availableLetters[j];
     }
     for(int k=i+1;k<availableLetters2.length;k++){
      availableLetters2[k]=availableLetters[k];
      }
     
  
  if (myDictionary.contains(temp))  { 
   if (temp.length()>longest.length()){
    longest = temp;
   }
  }
  String newLong=longestWord( availableLetters,temp);
    if(newLong.length()>longest.length()){
  longest = newLong;
  }
 
 
 /* for(int i=0; i<availableLetters.length;i++){
   String temp = prefix + availableLetters[i];
  
   if (myDictionary.contains(temp))  {
    availableLetters[i]=(Character) null;
    String longer = longestWord( availableLetters,prefix);
    if (longer.length()>longest.length()){
     longest = longer;
    
    }
   }
  
  }
  */
 
  }
 
 
 
 

  // example of how to check with a string is in the dictionary. Remove this line when you understand how this works.
  if (myDictionary.contains(prefix)) System.out.println("The word " + prefix + " is in the dictionary");

  return longest;


    }


    

    
    
    /* main method
        You should not need to change anything here.
     */
    public static void main(String args[]) throws Exception {
       
 // First, read the dictionary
 try {
     readDictionaryFromFile("englishDictionary.txt");
        }
        catch(Exception e) {
            System.out.println("Error reading the dictionary: "+e);
        }
        
        
        // Ask user to type in letters
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in) );
        char letters[]; 
        do {
            System.out.println("Enter your letters (no spaces or commas):");
            
            letters = keyboard.readLine().toCharArray();

     // now, enumerate the words that can be formed
            String longest = longestWord(letters, "");
     System.out.println("The longest word is "+longest);
        } while (letters.length!=0);

        keyboard.close();
        
    }
}
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * author: David Gilbert 
 * ID: 260746680
 * email : david.gilbert@mail.mcgill.ca 
 * input from System.in first value:number of input(int n) / next n value (int -10<x<10) 
 * output: the correct data structure between [stack,queue,priority queue, impossible to tell, not sure]
 * see "I Can Guess the Data Structure!"  problem on katiss for more details
 */

public class GuessStruc 
{

    public static void main(String[] args) 
    {
        
        
        
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext() != false)
        {
        int n = sc.nextInt();
        //make 2 new arrayList 1 for ADDED one for REMOVED values
        LinkedList<Integer> IN= new  LinkedList<>();
        LinkedList<Integer> OUT= new LinkedList<>();
        boolean isStack =true;
        boolean isQueue =true;
        boolean isPriority =true;
        boolean IsImpossible = false;
            
            while (n>0)
            {
                int action = sc.nextInt();
                int value = sc.nextInt();
            
                if(action == 1)//add
                {
                    IN.addLast(value);          
                }
                else if (action ==2)//remove
                {                   
                    OUT.addLast(value);
                    int firstIn;
                    int firstOut;
                    int lastIn;
                    int max;
                    try {
                        firstIn = IN.peekFirst();
                        firstOut = OUT.peekFirst();
                        lastIn = IN.peekLast();
                        max = Collections.max(IN);
                    } catch (Exception e) {
                        
                        IsImpossible=true;
                        n--;
                        continue;
                    }
                    
                    //check if queue
                    if(firstIn != firstOut) isQueue = false;
                    //check if stack
                    if(lastIn != firstOut) isStack = false;
                    //check if priority queue
                    if(max != firstOut) isPriority = false;
                    
                    if (! IN.contains(value)) // trying to remove something that hasnt been added => impossible
                    {
                        
                        IsImpossible=true;
                        n--;
                        continue;
                    }           
                    
                    try {
                        IN.remove((Integer) value); // remove the value wherever it is
                        OUT.remove();
                    } catch (Exception e) {
                        
                        IsImpossible=true;
                        n--;
                        continue;
                    }
                }
                
                
                n--; 
            
            }
            if(! IsImpossible)
            {
                // if more then one is true or none are then not sure else the 1 that is true
                if(isPriority)
                {
                    if(isQueue || isStack) System.out.println("not sure");
                    else System.out.println("priority queue");
                }
                else if (isQueue)
                {
                    if(isPriority || isStack) System.out.println("not sure");
                    else System.out.println("queue");
                }
                else if (isStack)
                {
                    if(isQueue || isPriority) System.out.println("not sure");
                    else System.out.println("stack");
                }
                else System.out.println("impossible");
            }
            else System.out.println("impossible");
            

    

    }
    }

}
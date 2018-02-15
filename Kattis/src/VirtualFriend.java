import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections; 

import java.util.TreeSet;

public class VirtualFriend
{
    
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int testNum = sc.nextInt();
        
        
        
        for(;testNum > 0;testNum--)
        {
        	ArrayList<TreeSet<String>> forest = new  ArrayList<TreeSet<String>>(); // a forest of all trees (connected social networks)
        	int friendNum = sc.nextInt();
        	
            for(;friendNum > 0;friendNum--)
            {
                String friend1 = sc.next(); // first and second friends which form a new friendship
                String friend2 = sc.next();
                TreeSet<String> network1 = new TreeSet<String>();
                TreeSet<String> network2 = new TreeSet<String>();
              
                
                for(TreeSet<String> t : forest ) // go trough all social networks to find one containing the names (if non it'll be empty)
                {
                	if(t.contains(friend1))
                	{
                		network1 = t;
                		forest.remove(t);
                		break;
                		
                	}
                }
                for(TreeSet<String> t : forest ) // go trough all social networks to find one containing the names (if non it'll be empty)
                {
                	if (t.contains(friend2))
                	{
                		network2 = t;
                		forest.remove(t);
                		break;
                	}
                }
                
                //if there are no network containing them make one
                network1.add(friend1);
                network2.add(friend2);
                 
                // take the union of both friend list
                network1.addAll(network2);
                forest.remove(network2);
                forest.add(network1);
   
                 System.out.println(network1.size()); // prints number of friend
                 
                
            }
            forest.clear(); // clear hashmap for next test
        }
        
      
    }
    
 
}


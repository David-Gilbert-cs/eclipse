import java.util.Scanner;
import java.util.Set;

import java.util.Collections; 
import java.util.HashMap;
import java.util.HashSet;


/*with hashmap ?*/
public class VirtualFriends
{
    
    static HashMap<String, HashSet<String>> hm = new  HashMap<String,HashSet<String>>();
    
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int testNum = sc.nextInt();
        int friendNum = sc.nextInt();
        
        
        for(;testNum > 0;testNum--)
        {
            for(;friendNum > 0;friendNum--)
            {
                String f1 = sc.next(); // first and second friends which form a new friendship
                String f2 = sc.next();
                
                if (! hm.containsKey(f1) ) { hm.put(f1,new HashSet<String>()); } // if new people add them to the hash map *with no friend
                if (! hm.containsKey(f2) ) { hm.put(f2,new HashSet<String>()); }
                
                HashSet<String> f1List = hm.get(f1); // get the current friend list
                HashSet<String> f2List = hm.get(f2);
                
                f1List.add(f2); //add new friend
                f2List.add(f1);
                f1List.add(f1); //add new friend
                f2List.add(f2);
                f1List.addAll(hm.get(f1)); //and friend of friends
                f2List.addAll(hm.get(f2));
                f1List.addAll(hm.get(f2)); //and friend of friends
                f2List.addAll(hm.get(f1));
                
                hm.put(f1, f1List); // save in hash map
                hm.put(f2, f2List);
                
                             
                
                // take the union of both friend list
                 Set<String> union = new HashSet<String>();
                 union.addAll(hm.get(f1));
                 union.addAll(hm.get(f2));
            
                 System.out.println(union.size()); // prints number of friend
                 //union.clear(); //clear for next iteration *might not be needed
                
            }
            hm.clear(); // clear hashmap for next test
        }
        
      
    }
    
 
}


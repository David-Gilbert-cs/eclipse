import java.util.ArrayList;
import java.util.Scanner;

public class WrongVirtualFriends
{

	public static void main(String[] args)
	{
		 int numTest = 0 ;
		 int numFriends = 0 ; 
		 int totalFriend = 0;
		 String name1 ;
		 String name2 ;
		 ArrayList<String> friendships = new ArrayList<String>();
		 Scanner sc = new Scanner(System.in);
		 
         numTest = sc.nextInt();
         
		 for(; numTest > 0;numTest--)
         {
       

         numFriends = sc.nextInt();
        
        	
        		for(; numFriends > 0;numFriends--)
        		{
        			name1 = sc.next();
        			name2 = sc.next();
        			
        			
        			if (friendships.contains(name1) && friendships.contains(name2) ) 
        			{
        				 //no new people were added
						// this does nothing
					}
        			else if (!friendships.contains(name1) && !friendships.contains(name2)) 
        			{
						friendships.add(name1);
						
						if(!friendships.contains(name2))
						{
						friendships.add(name2);
        				totalFriend += 2  ;		
						}
						else
						{
							totalFriend ++ ;
						}
        			}
        			else if (!friendships.contains(name1)) 
        			{
        				friendships.add(name1);
						totalFriend ++ ;
					}
        			else if (!friendships.contains(name2)) 
        			{
        				friendships.add(name2);
						totalFriend ++ ;
					}
        			else
        			{
						//System.out.println("this should never occur");
					}
        			
        	        System.out.println(totalFriend); // prints output # of friends currently in 			
        		}
        		
        		totalFriend = 0; // reset for next test
        		numFriends = 0;
        		friendships.clear();
        		
         }
        
        	
        sc.close();
	}

}

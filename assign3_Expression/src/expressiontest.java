
import java.io.*;
import java.util.*;


public class expressiontest {
	
	static String delimiters="+-*%()";
	
	
	static Integer evaluate(String expr) throws Exception {

	Integer errorReturn = new Integer(-1);
	
    StringTokenizer st = new StringTokenizer( expr , delimiters , true );    // delimiter separates tokens, true means that delimiter are tokens as well
    Stack<String> operators = new Stack<>();
    Stack<String> numbers = new Stack<>();
    boolean isNum1=false;
    boolean isNum2;  
   
while ( st.hasMoreTokens() ) {
	String element = st.nextToken();
     
     if (delimiters.contains(element)) isNum2= false;   // set boolean to know if this element is numerical , at this point isNum1 is either null or represent the previous entry
     else isNum2= true;
     
     if(isNum1 && isNum2){                                 // takes care of numbers with more than one digits
     element=numbers.peek()+element;
     }
     

if (delimiters.contains(element)){              //put in operators
isNum1= false;
operators.push(element);

if (element.equals(")")) {    //takes care of operations within parenthesis  *****might be useless
operators.pop();                                  
while ( !operators.peek().equals("(")){
String num1=numbers.peek();
numbers.pop();
String num2=numbers.peek();
numbers.pop();
String oper=operators.peek();
if(! operators.empty())operators.pop();
if(oper.equals("*")) numbers.push(Integer.toString(Integer.parseInt(num2)*Integer.parseInt(num1)));                                 // if for operators +-*%  
if(oper.equals("%")) numbers.push(Integer.toString(Integer.parseInt(num2)/Integer.parseInt(num1)));
if(oper.equals("+")) numbers.push(Integer.toString(Integer.parseInt(num2)+Integer.parseInt(num1)));
if(oper.equals("-")) numbers.push(Integer.toString(Integer.parseInt(num2)-Integer.parseInt(num1)));

}
}

}
else{
numbers.push(element);                             // put in numbers
isNum1= true;
}

if(isNum2 && !isNum1){   //if current number and previous operator      takes cares of operations 
     
     String num1=numbers.peek();
     numbers.pop();
     String num2=numbers.peek();
     numbers.pop();
    String oper=operators.peek();
     operators.pop();

     if(oper.equals("*")) numbers.push(Integer.toString(Integer.parseInt(num2)*Integer.parseInt(num1)));                                 // if for operators +-*%  
     if(oper.equals("%")) numbers.push(Integer.toString(Integer.parseInt(num2)/Integer.parseInt(num1)));
     if(oper.equals("+")) numbers.push(Integer.toString(Integer.parseInt(num2)+Integer.parseInt(num1)));
     if(oper.equals("-")) numbers.push(Integer.toString(Integer.parseInt(num2)-Integer.parseInt(num1)));
    isNum1 = true;
     }


}
while ( ! numbers.empty()) {
	System.out.println(numbers.peek());
	numbers.pop();
}

return 2;


}



	public static void main(String args[]) throws Exception {
		String line;
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
                                      	                        
		do {
			line=stdin.readLine();
			if (line.length()>0) {
				try {
					Integer x=evaluate(line);
					System.out.println(" = " + x);
				}
				catch (Exception e) {
					System.out.println("Malformed Expression: "+e);
				}
			}
		} while (line.length()>0);
	}
}







if(oper.equals("*"))                               // if for operators +-*%  
if(oper.equals("%")) 
if(oper.equals("+")) 
if(oper.equals("-")) 

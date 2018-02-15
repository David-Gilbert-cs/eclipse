
public class backup {
	
	double evaluate(double x) {
		// WRITE YOUR CODE HERE
	    	ExpressionTree tree = this.deepCopy();
	     String operators = ("add  minus  mult cos sin exp ");
	     

	     //base case, where calculations are made
	     
	  if(! (this.getLeftChild() == null && this.getRightChild() == null)){
	    if ( this.getLeftChild() == null || !operators.contains((CharSequence) this.leftChild.value) && ! operators.contains((CharSequence) this.leftChild.value) ){ // left null ?***
	    	if( getRightChild() != null){
	    	   if(!(this.rightChild.value.equals("x") || this.leftChild.value.equals("x"))){
	    	if (this.value.equals("add")){
	    		this.setValue(String.valueOf(Double.parseDouble(this.getLeftChild().getValue()) + Double.parseDouble(this.getRightChild().getValue()))); 
	    		this.leftChild=null;
				this.rightChild=null;
	    	}
	    	else if (this.value.equals("minus")){
	    		this.setValue(String.valueOf(Double.parseDouble(this.getLeftChild().getValue()) - Double.parseDouble(this.getRightChild().getValue())));
	    		this.leftChild=null;
				this.rightChild=null;
	    	}
	    	
	    	else if (this.value.equals("mult")){
	    		this.setValue(String.valueOf(Double.parseDouble(this.getLeftChild().getValue()) * Double.parseDouble(this.getRightChild().getValue()))); 
	    		this.leftChild=null;
				this.rightChild=null;
	    	}
	    	   }   	    	
	    	}
	    	else if(! this.leftChild.value.equals("x")){
	    	if (this.value.equals("cos")){
	    		if(this.leftChild.equals(null)){   // *** does this null is fine or should it be string ?
	    			this.setValue(String.valueOf(Math.cos(Double.parseDouble(this.getRightChild().getValue()))));
	    			this.leftChild=null;
	    		}
	    		else{
	    			this.setValue(String.valueOf(Math.cos(Double.parseDouble(this.getLeftChild().getValue()))));
	    			this.leftChild=null;
	    		}
	    		}
	    	
	    	else if (this.value.equals("sin")){
	    		if(this.leftChild.equals(null)){
	    			this.setValue(String.valueOf(Math.sin(Double.parseDouble(this.getRightChild().getValue()))));
	    			this.leftChild=null;
	    		}
	    		else{
	    			this.setValue(String.valueOf(Math.sin(Double.parseDouble(this.getLeftChild().getValue()))));
	    			this.leftChild=null;
	    		}
	    		}
	    	
	    	else if (this.value.equals("exp")){
	    		if(this.leftChild.equals(null)){
	    			this.setValue(String.valueOf(Math.exp(Double.parseDouble(this.getRightChild().getValue()))));
	    			this.leftChild=null;
	    		}
	    		else{
	    			this.setValue(String.valueOf(Math.exp(Double.parseDouble(this.getLeftChild().getValue()))));
	    			this.leftChild=null;
	    		}
	    		}
	    	
	    	 }
	    }
	    
	    if(! (this.getLeftChild() == null && this.getRightChild() == null)){
	           if ((! operators.contains((CharSequence) this.leftChild.value)) && ((! operators.contains((CharSequence) this.leftChild.value)))|| this.getRightChild() == null   ){
	    	   //if needs replacement by x
	             if (this.value.equals("add")){
	    	 		
	            		this.setValue(String.valueOf(Double.parseDouble(this.getLeftChild().getValue())+x)); 
	            		this.leftChild=null;
	        			this.rightChild=null;
	            		
	        	}
	        	else if (this.value.equals("minus")){
	        		if(this.getLeftChild().value.equals("x")){
	        			this.setValue(String.valueOf(x-Double.parseDouble(this.getRightChild().getValue()))); 
	        			this.leftChild=null;
	        			this.rightChild=null;
	            		}
	            		else{
	            		this.setValue(String.valueOf(Double.parseDouble(this.getLeftChild().getValue())-x)); 
	            		this.leftChild=null;
	        			this.rightChild=null;
	            		}
	        	}
	        	
	        	else if (this.value.equals("mult")){
	        		if(this.getLeftChild().value.equals("x")){
	        		this.setValue(String.valueOf(x*Double.parseDouble(this.getRightChild().getValue()))); 
	        		this.leftChild=null;
	    			this.rightChild=null;
	        		}
	        		else{
	        		this.setValue(String.valueOf(Double.parseDouble(this.getLeftChild().getValue())*x));
	        		this.leftChild=null;
	    			this.rightChild=null;
	        		}
	        		}
	             		    	
	        	else if (this.value.equals("cos")){
	        		this.setValue(String.valueOf(Math.cos(x)));
	        		this.leftChild=null;
	        		}
	        	else if (this.value.equals("sin")){
	        		this.setValue(String.valueOf(Math.sin(x)));
	        		this.leftChild=null;
	        		}
	        	
	        	else if (this.value.equals("exp")){
	        		this.setValue(String.valueOf(Math.exp(x)));
	        		this.leftChild=null;
	        		}
	           }
	        	//if has x end block
	    }
	  
	    	   
	    	       
	    
	    //recursive step
	   
	    
	    if( this.getLeftChild() != null  ){
	    if( operators.contains((CharSequence) this.getLeftChild().value)){
	    	this.getLeftChild().setValue( String.valueOf(this.getLeftChild().evaluate(x)));
	    }
	    }
	    
	    if( this.getRightChild() != null ){
	        if( operators.contains((CharSequence) this.getRightChild().value)){
	        	this.getRightChild().setValue( String.valueOf(this.getRightChild().evaluate(x)));
	        }
	        }
	  }
	  if(this.value.equals("x"))return x;
	   System.out.println(this.value);
	    if(! operators.contains(this.value)){
		return Double.parseDouble(this.value);                                                 
	    }
	    else{
	    	this.evaluate(x);   	
	    }
		
	    if(! operators.contains(this.value)){
	    	return Double.parseDouble(this.value);                                                 
	        }
	        else{
	        	this.evaluate(x);   	
	        }
	    
	    if(! operators.contains(this.value)){
	    	return Double.parseDouble(this.value);                                                 
	        }
	        else{
	        	this.evaluate(x);   	
	        }
	    
	    if(! operators.contains(this.value)){
	    	return Double.parseDouble(this.value);                                                 
	        }
	        else{
	        	this.evaluate(x);   	
	        }
	    
	    if(! operators.contains(this.value)){
	    	return Double.parseDouble(this.value);                                                 
	        }
	        else{
	        	this.evaluate(x);   	
	        }
	    
	    if(! operators.contains(this.value)){
	    	return Double.parseDouble(this.value);                                                 
	        }
	        else{
	        	this.evaluate(x);   	
	        }
	    
	    if(! operators.contains(this.value)){
	    	return Double.parseDouble(this.value);                                                 
	        }
	        else{
	        	this.evaluate(x);   	
	        }
	    System.out.println("too many equations");
		return -1;
	    
	    
	    }
}

interface MyCalculatorInterface{
    int calculate(String expression)throws EmptyStackException;
}


public class MyCalculator implements MyCalculatorInterface {
    // implement the calculate function here
    public int calculate(String expression)throws EmptyStackException{
		/*String e = expression.replaceAll("\\s+","");
		// remove next
		//System.out.println(e);
		//System.out.println(e.length());
	    MyStack<Integer> numbers = new MyStack<Integer>(); 
	    MyStack<Character> symbols = new MyStack<Character>(); 

	    for( int i = 0 ; i < e.length() ; i++){ 
			System.out.println(i + " " +e.charAt(i));
	        if (e.charAt(i) == '('){
	        	symbols.push(e.charAt(i)); 
	        }
	        else if (e.charAt(i) == ')') {
	            while (!symbols.isEmpty() && symbols.top() != '(') {
	            	char s = symbols.pop();
	            	int r = numbers.pop();
	            	int l = numbers.pop();
	            	if ( s == '+') {
	            		numbers.push(l+r);
	            	}
	            	else if ( s == '-') {
	            		numbers.push(l-r);
	            	}
	            	else if ( s == '*') {
	            		numbers.push(l*r);
	            	}
	            }
	            if (!symbols.isEmpty()) symbols.pop();
	                   
	        }
	        else if (Character.isDigit(e.charAt(i))){
				StringBuffer temp = new StringBuffer();
				//System.out.println( "digit ") ; 
				//System.out.println(i + " "+ e.charAt(i)); 
	            while ( i < e.length() && Character.isDigit(e.charAt(i)) ) {
					temp.append(e.charAt(i));
					System.out.println(i + " " +e.charAt(i));
					i++;
	            } 
				i--;
				
				
	            numbers.push(Integer.parseInt(temp.toString())); 
	             
			}  
	        else if (e.charAt(i) == '*' || e.charAt(i) == '+' || e.charAt(i) == '-'  ){
				//System.out.println( "symbol") ;
			    //System.out.println(i + " "+ e.charAt(i));     
	            while (!symbols.isEmpty() && symbols.top() == '*' && (e.charAt(i) == '+' || e.charAt(i) == '-')) {
	                symbols.pop();
	            	int r = numbers.pop();
	            	int l = numbers.pop();
	            	numbers.push(l*r);
	            }
	            symbols.push(e.charAt(i)); 
	        } 
	    } 
	    while (!symbols.isEmpty()) {
	    	if (symbols.top() == '(') {
	    		symbols.pop();
	    	}
	    	char s = symbols.pop();
        	int r = numbers.pop();
        	int l = numbers.pop();
        	if ( s == '+') {
        		numbers.push(l+r);
        	}
        	else if ( s == '-') {
        		numbers.push(l-r);
        	}
        	else if ( s == '*') {
        		numbers.push(l*r);
        	}
	    } 
		return numbers.top(); 
		*/
		String e = expression.replaceAll("\\s+","");
			// remove next
			//System.out.println(e);
			//System.out.println(e.length());
		    MyStack<Integer> numbers = new MyStack<Integer>(); 
		    MyStack<Character> symbols = new MyStack<Character>(); 

		    for( int i = 0 ; i < e.length() ; i++){ 
				//System.out.println(i + " " +e.charAt(i));
		        if (e.charAt(i) == '('){
		        	symbols.push(e.charAt(i)); 
		        }
		        else if (e.charAt(i) == ')') {
		            while (!symbols.isEmpty() && symbols.top() != '(') {
		            	char s = symbols.pop();
		            	int r = numbers.pop();
		            	int l = numbers.pop();
		            	if ( s == '+') {
		            		numbers.push(l+r);
		            	}
		            	else if ( s == '-') {
		            		numbers.push(l-r);
		            	}
		            	else if ( s == '*') {
		            		numbers.push(l*r);
		            	}
		            }
		            if (!symbols.isEmpty()) symbols.pop();
		                   
		        }
		        else if (Character.isDigit(e.charAt(i))){
					StringBuffer temp = new StringBuffer();
					//System.out.println( "digit ") ; 
					//System.out.println(i + " "+ e.charAt(i)); 
		            while (i < e.length()  && Character.isDigit(e.charAt(i)) ) {
						temp.append(e.charAt(i));
						//System.out.println(i + " " +e.charAt(i));
						i++;
		            } 
					i--;
					
					
		            numbers.push(Integer.parseInt(temp.toString())); 
		             
				}  
		        else if (e.charAt(i) == '*' || e.charAt(i) == '+' || e.charAt(i) == '-'  ){
					//System.out.println( "symbol") ;
				    //System.out.println(i + " "+ e.charAt(i));     
		            while (!symbols.isEmpty() && symbols.top() == '*' && (e.charAt(i) == '+' || e.charAt(i) == '-')) {
		                symbols.pop();
		            	int r = numbers.pop();
		            	int l = numbers.pop();
		            	numbers.push(l*r);
		            }
		            symbols.push(e.charAt(i)); 
		        } 
		    } 
		    while (!symbols.isEmpty()) {
		    	if (symbols.top() == '(') {
		    		symbols.pop();
		    	}
		    	char s = symbols.pop();
	        	int r = numbers.pop();
	        	int l = numbers.pop();
	        	if ( s == '+') {
	        		numbers.push(l+r);
	        	}
	        	else if ( s == '-') {
	        		numbers.push(l-r);
	        	}
	        	else if ( s == '*') {
	        		numbers.push(l*r);
	        	}
		    } 
		    return numbers.top(); 

        
	}
/*
	public static void main (String[] Args)throws EmptyStackException{
		String str = "   3+(4-  2)*2+98  ";
		System.out.println(str.length());
		MyCalculator calc = new MyCalculator();
		System.out.println(calc.calculate(str));

	}
	*/
}

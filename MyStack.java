
// Interface for MyStack Class
interface MyStackInterface<T>{ 
    void push(T value);
    T pop()throws EmptyStackException;
    T top()throws EmptyStackException;
    boolean isEmpty();

} 
  
// Implement all the functions
class MyStack<T> implements MyStackInterface<T> 
{ 
    public T[] arr ;
    private int last = -1 ; 
    MyStack(){
        arr = (T[])new Object[0];
    }
    public void push(T value){
        if (arr.length == 0 ){
            T[] arrn = (T[])new Object[2];
            arr = arrn ;
            last = 0 ;
            arr[0] = value ;
        }
        else {
        	if ( last < arr.length - 1) {
        		arr[last+1] = value ;
        		last++;
        	}
        	else {
        		T[] arrn = (T[])new Object[2*arr.length];
        		for ( int x = 0 ; x <= last ; x++) {
        			arrn[x] = arr[x] ;
        		}
        		arrn[last+1] = value ;
        		last++;
        		arr = arrn ;	
        	}
        }

    }
    public T pop() throws EmptyStackException{
        if( last == -1 ) {
    		throw new EmptyStackException("Stack is empty");
    	}
    	else {
    		T popelem = (T)arr[last];
    		// element in arr is of type object 
    		// last element still exists
    		last--;
    		
    		if ( last < arr.length/2 ) {
    			T[] arrn = (T[])new Object[last+1];
    			for ( int x = 0 ; x <= last ; x++ ) {
    				arrn[x] = arr[x] ;
    			}
    			arr = arrn ;
    		}
    		return popelem ;
    	}	
        
    }
    public T top()throws EmptyStackException{
        if( last == -1 ) {
    		throw new EmptyStackException("Stack is empty");
    	}
    	else {
    		T popelem = (T)arr[last];
    		return popelem ;
    		
    	}
    }
    public boolean isEmpty(){
        if ( last == -1) {
    		return true;
    	}
    	else {
    		return false;
    	}
        
    }
    
}

class EmptyStackException extends Exception
{
	public EmptyStackException(String s)
	{
	// Call constructor of parent Exception
		super(s);
		}
}


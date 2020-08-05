interface StackSortInterface{
    String[] sort(int[] nums)throws EmptyStackException;
    // for part D
    String[][] kSort(int[] nums)throws EmptyStackException;
}

// Implement the functions here
public class StackSort {
	public Boolean sorted = false ; 
	public int[] n ;
    public String[] sort(int[] nums)throws EmptyStackException {
        MyStack<Integer> stack = new MyStack<Integer>() ;
		String[] answer = new String[2*nums.length] ;
		int ai = 0 ;
		int[] popped = new int[nums.length];
		// last is the last index of garbage 
		// garbage is filled in ascending order 
		int last = 0 ; 
		for( int i = 0 ; i < nums.length ; i++) {
			if( stack.isEmpty()) {
				stack.push(nums[i]);
				if( ai >= answer.length) break; 
				answer[ai++] = "PUSH";
			}
			else {
				if ( nums[i] > stack.top()) {
					while ( (!stack.isEmpty()) && nums[i] > stack.top()  ) {
						int top = stack.pop();
						if( ai >= answer.length) break; 
						answer[ai++] = "POP";
						if( last > popped.length) break;
						popped[last++] = top;
					}
					
				}
				if( last >= 0 && last < nums.length) {
					for ( int j = last ; j >= 0 ; j--) {
						if ( nums[i] < popped[j] ) {
							String[] s = new String[1];
							s[0] = "NOTPOSSIBLE";
							return s ;
						}
					}
				}
					
				
				stack.push(nums[i]);
				if( ai >= answer.length) break; 
				answer[ai++] = "PUSH";
			}
		}
		while( !stack.isEmpty()) {
			int top = stack.pop();
			if( ai >= answer.length) break; 
			answer[ai++] = "POP";
			if( last > popped.length) break;
			popped[last++] = top;
		}
		return answer;
	}


    
	public String[] dummysort()throws EmptyStackException{
		Boolean b = false ;
		int[] dummynums = new int[n.length]; 
		int di = 0 ; 
		MyStack<Integer> stack = new MyStack<Integer>() ;
		String[] answer = new String[2*n.length] ;
		int ai = 0 ;
		int[] popped = new int[n.length];
		// last is the last index of garbage 
		// garbage is filled in ascending order 
		int last = -1 ; 
		for( int i = 0 ; i < n.length ; i++) {
			if( stack.isEmpty()) {
				stack.push(n[i]);
				answer[ai++] = "PUSH";
			}
			else {
				if ( n[i] > stack.top()) {
					while ( (!stack.isEmpty()) && n[i] > stack.top()  ) {
						int top = stack.pop();
						dummynums[di++] = top;
						answer[ai++] = "POP";
						popped[++last] = top;
					}
					
				}
				if( last >= 0 && last < n.length) {
					for ( int j = last ; j >= 0 ; j--) {
						if ( n[i] < popped[j] ) {
							//String[] s = new String[1];
							//s[0] = "NOTPOSSIBLE";
							//return s ;
							
							
							b = true ; 
						}
					}
				}
				stack.push(n[i]);
				answer[ai++] = "PUSH";
			}
		}
		
		while( !stack.isEmpty()) {
			int top = stack.pop();
			dummynums[di++] = top;
			answer[ai++] = "POP";
			popped[++last] = top;
		}
		if ( b ) {
			sorted = false;
		}
		else {
			sorted = true;
		}
		n = dummynums.clone();
		return answer;
	}
	
	
	

	














    public String[][] kSort(int[] nums)throws EmptyStackException{
		n = nums.clone();
		// System.out.println(  "printing array  "  );
		/*
		 for ( int x = 0 ; x < n.length ; x++) {
			 System.out.print(n[x] + " ");
		 }
		 */
		 //System.out.print("\n");
		 //System.out.print("\n");
		
		sorted = false ; 
		int k = 0 ; 
		while ( !sorted) {
			String[] str = dummysort();
			k++;
			/*System.out.println(  "printing array  "  );
			for ( int x = 0 ; x < n.length ; x++) {
				 System.out.print(n[x] + " ");
			 }
			 */
			// System.out.print("\n");
			// System.out.print("\n");
			//System.out.println(  "k is " + k );
			//System.out.println(  "sort status  is " + sorted);
			
		}
		String[][] answer = new String[k][2*nums.length];
		for( int i = 0 ; i < k ; i++) {
			String[] str = dummysort();
			answer[i] = str;			
		}
		return answer ; 

	}




/*
	public static void main(String[] Args)throws EmptyStackException{
		int[] arr = {1023,5029,158};
		StackSort ob = new StackSort();
		String[][] td = ob.kSort(arr);
		for( int i = 0 ; i < td.length ; i++) {
			for ( int x = 0 ; x < td[i].length ; x++) {
				System.out.print( td[i][x] + " ");
			}
			System.out.println("\n");
			System.out.println("\n");
		}
	}

	*/
	






}

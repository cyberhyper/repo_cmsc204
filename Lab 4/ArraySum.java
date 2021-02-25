package lab4;

public class ArraySum {

	public int sumOfArray (Integer[] a, int index) {
		
	    if (index == 0) 
	    {
	        return a[index];
	    }
	    
	      return sumOfArray(a, index - 1) +  a [index];
	}

}
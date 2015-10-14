
import java.util.ArrayList;
import java.util.List;

/*Union of two lists. Excludes duplicates in both lists.*/
public class Union {
	public static void main(String[] args) {
	    List<Integer> list1 = new ArrayList<Integer>();
	    List<Integer> list2 = new ArrayList<Integer>();
	    list1.add(1);list1.add(2);list1.add(5);list1.add(6);list1.add(7);list1.add(9);
	    list2.add(2);list2.add(3);list2.add(3);list2.add(3);list2.add(4);list2.add(5);list2.add(6);
	    System.out.println(union(list1, list2));
	}

	public static List<Integer> union(List<Integer> l1, List<Integer> l2) {
	    if((l1 == null && l2 == null)) {
	        return null;
	    }
	    if(l1.size() == 0 && l2.size() == 0) {
	        return null;
	    }
	    if(l1.size() == 0) {
	        return l2;
	    }
	    if(l2.size() == 0){
	        return l1;
	    }
	    int j = 0;
	    int i = 0;
	    int len1 = l1.size();
	    int len2 = l2.size();
	    List<Integer> l3 = new ArrayList<Integer>();
	    int remember = 0;
	    int count = 0;	    
	    while(i < len1 && j < len2) {
	        int var1 = l1.get(i);
	        int var2 = l2.get(j);
	        if(count > 0) {
	        	if(remember == var1) {
	        		i++;
	        		continue;
	        	}
	        	if(remember == var2) {
	        		j++;
	        		continue;
	        	}
	    	}
	        if(var1 == var2) {	        	
	            remember = var1;
	            l3.add(var1);
	            l1.get(i++);	            
	        }
	        if(var1 < var2) {
	            remember = var1;
	            l3.add(var1);
	            l1.get(i++);
	        }
	        if(var1 > var2) {
	            remember = var2;
	            l3.add(var2);
	            l2.get(j++);
	        }
	        count++;
	    }
	    while(i < len1) {	    	
    		l3.add(l1.get(i));
    		i++;
	    } 
	    while(j < len2) {	    	
    		l3.add(l2.get(j));
    		j++;
	    }
	    return l3;
	}
}

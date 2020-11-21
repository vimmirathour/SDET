import java.util.HashSet;

public class Activity3_2 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("G");
        hs.add("C");
        hs.add("N");
        hs.add("H");
        hs.add("A");
        hs.add("T");
       
        System.out.println("Original HashSet: " + hs);        
       
        System.out.println("Size of HashSet: " + hs.size());
        
        System.out.println("Removing H from HashSet: " + hs.remove("H"));
       
        if(hs.remove("E")) {
        	System.out.println("E removed from the Set");
        } else {
        	System.out.println("E is not present in the Set");
        }
        System.out.println("Check if G is present: " + hs.contains("G")); 
        System.out.println("New HashSet: " + hs);
    }
}

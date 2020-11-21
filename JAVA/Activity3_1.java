import java.util.ArrayList;

public class Activity3_1 {
    public static void main(String[] args) {
       
        ArrayList<String> list = new ArrayList<String>();
        
        list.add("Banana");
        list.add("Watermelon");
        list.add("Apple");
        list.add(3, "PineApple");
        list.add(1, "Guva");
        
        System.out.println("Print all Fruits:");
        for(String s:list){
            System.out.println(s);
        }
        
        System.out.println("Third element in the Fruits list is: " + list.get(2));
        System.out.println("Is Papaya is in list: " + list.contains("Papaya"));
        System.out.println("Size of ArrayList: " + list.size());
        
        list.remove("Guva");
        
        System.out.println("New Size of Fruits list: " + list.size());
    }
}
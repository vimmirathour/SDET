import java.util.*;

public class Activity3_3B {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();

        deque.add("Dog");
        deque.addFirst("Cat");
        deque.addLast("Wolf");
        
        deque.offer("Tiger");
        deque.offerFirst("Cow");
        deque.offerLast("Camel");

       
        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

       
        System.out.println("Peek: " + deque.peekFirst());
        System.out.println("Peek: " + deque.peekLast());
        System.out.println("After peek: " + deque);
     
        System.out.println("Contains Wolf?: " + deque.contains("Wolf"));
        deque.removeFirst();
        deque.removeLast();
        System.out.println("dq after removing first and last elements: " + deque);
        System.out.println("Size of deque after removing: " + deque.size());
    }
}
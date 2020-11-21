import java.util.LinkedList;
import java.util.Queue;

public class Activity3_3A {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

    
        for (int i=0;i<5;i++) {
        	queue.add(i);
        }

        System.out.println("Elements in queue: " + queue);

        int removeEle = queue.remove();
        System.out.println("removed element: " + removeEle);

        int headEle = queue.peek();
        System.out.println("head of queue: " + headEle);

        int size = queue.size();
        System.out.println("Size of queue: " + size);
    }
}
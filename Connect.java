import java.util.*;

public class Connect {

    public static void main(String args[]) {
        int rope[] = { 2, 3, 3, 4, 6 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < rope.length; i++) {
            pq.add(rope[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min + min2);
        }
        System.out.println("cost of connection ropes:" + cost);
    }

}

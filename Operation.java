import java.util.*;

public class Operation {
    public static void main(String args[]) {
        // create hashfunction
        HashMap<String, Integer> hm = new HashMap<>();
        // nsert function
        hm.put("India", 150);
        hm.put("China", 200);
        hm.put("Us", 50);
        System.out.println(hm);
        // get op[eration]
        int population = hm.get("India");
        System.out.println(population);
    }

}

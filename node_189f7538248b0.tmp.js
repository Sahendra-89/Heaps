import java.util.*;

public class Hash {

    public static void main(String args[]) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bangluru");
        Iterator it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

}

import java.util.*;

public class insertHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();
        private int minIdx;

        public void add(int data) {
            // add at lastidx;
            arr.add(data);
            int x = arr.size() - 1;// x is child index
            int par = (x - 1) / 2; // par index
            while (arr.get(x) < (par)) {// time complexity in o(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapfy(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int midIdx = i;
            if (left < arr.size() && arr.get(midIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.get(minIdx);
                heapfy(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // step 1 -swap first & last elements
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            // step 2 -delete last
            arr.remove(arr.size() - 1);
            // step 3 -heapfy
            heapfy(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

    }

    public static void main(String args[]) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }

}

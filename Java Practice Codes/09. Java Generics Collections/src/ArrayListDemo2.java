import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDemo2 {

    public static void main(String args[]) {
        // create an array list
        List<Integer> al = new ArrayList<>();
        System.out.println("Initial size of al: " + al.size());

        // add elements to the array list
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);

        // foreach iterate
        for (Integer i : al) {
            System.out.print(i + " ");
        }
        System.out.println();

        al.forEach(e -> System.out.println(e));

        al.remove(2); // remove using index
        al.remove(new Integer(10)); // remove using value

        // iterate through Iterator
        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // convert to array
        Integer ia[] = new Integer[al.size()];
        al.toArray(ia);

        // iterate array
        for (int i = 0; i < ia.length; i++) {
            System.out.print(ia[i] + " ");
        }
        System.out.println();

        // convert array to list
        List<Integer> alist = Arrays.asList(ia);

        // foreach iterate
        for (Integer i : alist) {
            System.out.print(i + " ");
        }
        System.out.println();

        // streams
        List<Integer> streamList = Arrays.stream(ia).collect(Collectors.toList());
        streamList.forEach(e -> System.out.print(e + " "));

        System.out.println();

        // primitive type array to list
        int[] a = {10, 20, 30, 40, 50};
        List<Integer> integerList = Arrays.stream(a).boxed().collect(Collectors.toList());
        integerList.forEach(e -> System.out.print(e + " "));

    }
}
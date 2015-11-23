import java.util.List;

/**
 * Created by ryan on 11/20/15.
 */
public class GenericsExample {

    /**
     * Reverses a list of type E
     *
     * @param l   The list of any type
     * @param <E> Any element
     * @return The list with same contents, but reversed indexes
     */
    static <E> List<E> reverseList(List<E> l) {
        for (int i = 0; i < l.size() / 2; i++) {
            E temp;
            temp = l.get(i);
            l.set(i, l.get(l.size() - i));
            l.set(l.size() - i, temp);
        }

        return l;
    }


}

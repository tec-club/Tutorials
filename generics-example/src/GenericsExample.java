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
    static <E> void reverseList(List<E> l) {
        for (int i = 0; i < l.size() / 2; i++) {
            E temp;
            temp = l.get(i);
            l.set(i, l.get(l.size() - i));
            l.set(l.size() - i, temp);
        }


    }
    //OR....

    /**
     * @param elem A type that extends List
     * @param <E>  The instance of the subclass of List
     * @return The reversed list
     */
    static <E extends List<E>> void reverseExtendedGenericList(E elem) {
        for (int i = 0; i < elem.size(); i++) {
            E temp = elem.get(i);
            elem.set(i, elem.get(elem.size() - i));
            elem.set(elem.size() - i, temp);
        }
    }


}

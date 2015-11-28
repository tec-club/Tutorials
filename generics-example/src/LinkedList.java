/**
 * Created by ryan on 11/25/15.
 * <p/>
 * Simple LinkedList implementation
 */
public class LinkedList<T> {
    private final static int MIN_CAPACITY = 5;
    private Reference first;
    private int numElements;

    public LinkedList(int capacity) {
        first = null;
        numElements = 0;
    }

    public LinkedList() {
        this(0);
    }


    public int size() {
        return numElements;
    }

    public boolean add(T element, int index) {
        if (index < 0 || index > numElements) throw new ArrayIndexOutOfBoundsException();
        if (index == 0) {
            first = new Reference(element, first);
            return true;
        }
        Reference temp = first;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null) return false;
            temp = temp.next;
        }
        Reference inserted = new Reference(element);
        inserted.next = temp.next;
        temp.next = inserted;
        numElements++;
        return true;

    }

    public boolean add(T element) {
        if (this.first == null) {
            first = new Reference(element);
            numElements++;
            return true;
        } else {
            Reference temp = this.first;
            if (temp.next == null) {
                temp.next = new Reference(element);
                numElements++;
                return true;
            }
            while ((temp = temp.next).next != null) ;

            temp.next = new Reference(element);
            numElements++;

            return true;
        }


    }

    public T get(int index) {
        Reference temp = first;
        for (int i = 0; i < index; i++) {
            if (temp == null) return null;
            temp = temp.next;
        }
        return temp.value;

    }

    public T set(T elem, int index) {
        Reference temp = first;
        for (int i = 0; i < index; i++) {
            if (temp == null) return null;
            temp = temp.next;
        }
        T old = temp.value;
        temp.value = elem;
        return old;
    }

    public boolean contains(T elem) {
        Reference temp = first;
        for (int i = 0; i < numElements; i++) {
            if (temp == null) return false;
            if (temp.value.equals(elem)) return true;

            temp = temp.next;


        }
        return false;

    }

    public T remove(int index) {
        Reference temp = first;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null) return null;
            temp = temp.next;
        }
        T old = temp.next.value;
        // temp -> temp.next (item to remove)  -> temp.next.next
        temp.next = temp.next.next;
        numElements--;
        return old;
    }


    class Reference {
        public Reference next;
        public T value;

        Reference(T element, Reference next) {
            this.next = next;
            this.value = element;

        }

        Reference(T element) {
            this(element, null);
        }


    }
}


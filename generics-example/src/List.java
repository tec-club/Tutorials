/**
 * Created by ryan on 11/20/15.
 * <p/>
 * For those interested, this is a very simple implementation of
 * a minimalist Java Generic List.
 * <p/>
 * Big-Oh Analysis:
 * <p/>
 * size() -> O(1)
 * get() ->  O(1)
 * add()  -> O(1)
 * contains()-> O(N)
 */
public class List<T> {
    final static int MIN_CAPACITY = 10;
    private T[] contents;
    private int numElements;

    public List() {
        this(MIN_CAPACITY);
    }

    public List(int size) {
        //To avoid ClassCast Compiler Error
        this.contents = (T[]) (new Object[Math.max(size * 2, MIN_CAPACITY)]);
    }

    /**
     * @return The number of Elements in the List
     */
    public int size() {
        return numElements;
    }

    /**
     * @param index The index of the element in the list from 0...size()-1
     * @return The item from index
     * @throws ArrayIndexOutOfBoundsException If index is greater than or equal to size() or negative
     */
    public T get(int index) throws ArrayIndexOutOfBoundsException {

        if (index > contents.length - 1 || index < 0 || index > numElements - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return contents[index];
    }

    /**
     * *****NOTICE*******
     * I've decided to comment out the following add methods that used an insertion
     * implementation in favor of a more memory consuming, yet faster add method
     * that comes from keeping the length of contents larger than the capacity of
     * elements.
     * <p/>
     * <p/>
     * Conceptually, this method partitions the contents array into two separate parts,
     * before and after the specified insertion index. It copies the first part to a new array
     * (from 0 to index-1) and then inserts the specified element at (index). It then copies the
     * rest of contents to the new array starting from index to the end of the array on contents,
     * but copies those items to the new array at indices index+1 to end of the new array.
     * <p/>
     * (P.S) Sorry my explanation sucks-(@Ryan Tolsma)
     *
     * @param index   Where to insert the element
     * @param element Element to be inserted
     * @return True if successful, false if an exception occurred
     */
    public boolean add(int index, T element) throws ArrayIndexOutOfBoundsException {
        ensureContentSize();
        if (index > numElements || index < 0)
            throw new ArrayIndexOutOfBoundsException();

        T[] newContents = (T[]) (new Object[contents.length + 1]);
        arrayCopy(0, index - 1, 0, contents, newContents);
        newContents[index] = element;
        arrayCopy(index, numElements, index + 1, contents, newContents);
        contents = newContents;
        return true;
    }

    /**
     * Basically offloads work to other add method,
     * assumes you are appending to the end of the list
     */
    public boolean add(T element) {
        contents[numElements++] = element;
        //The ++ returns the value of numElements, and then increments
        //it to keep track
        return true;
    }

    /**
     * @param element Element to check
     * @return True if element with equal contents exists in the List, false otherwise
     */
    public boolean contains(T element) {
        for (int i = 0; i < numElements; i++) {
            if (element.equals(contents[i])) return true;
        }
        return false;
    }

    /**
     * @param index Index to remove item from
     * @return The element that was removed
     * @throws ArrayIndexOutOfBoundsException If index is greater than size
     */
    public T remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > numElements) throw new ArrayIndexOutOfBoundsException();
        T[] newArray = (T[]) (new Object[contents.length - 1]);
        T elem = contents[index];
        arrayCopy(0, index - 1, 0, contents, newArray);
        arrayCopy(index + 1, numElements, index, contents, newArray);

        return elem;
    }

    /**
     * @param index   Index to replace
     * @param element Element to replace old element with
     * @return The old element
     */
    public T set(int index, T element) {
        T temp = contents[index];
        contents[index] = element;
        return temp;

    }

    /**
     * Makes sure that there is always space in the array compared
     * to the number of elements in the List, so that the add method
     * is faster, but comes with downside of consuming roughly twice
     * as much memory
     */
    public void ensureContentSize() {
        if (contents.length < numElements * 2) {
            T[] newArray = (T[]) (new Object[numElements * 2]);
            arrayCopy(0, numElements, 0, contents, newArray);
            return;

        }


    }

    /**
     *
     * @param start Index to start copying from
     * @param end Index to end copying from
     * @param toStart Index to start copying to
     * @param from Array to copy from
     * @param to Array to copy to
     * @throws ArrayIndexOutOfBoundsException If any indices are out of either array bounds, or if
     */
    public void arrayCopy(int start, int end, int toStart, T[] from, T[] to) throws ArrayIndexOutOfBoundsException {
        if (start > end || end > from.length - 1 || start < 0 || (end-start)+toStart>to.length
                || toStart < 0 || toStart > to.length - 1)
            throw new ArrayIndexOutOfBoundsException();

        for (int i = start; i < end; i++) {
            to[i] = from[i];
        }
    }

    public void arrayCopy(int start, int toStart, T[] from, T[] to) {
        arrayCopy(start, from.length - 1, toStart, from, to);
    }

}

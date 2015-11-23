/**
 * Created by ryan on 11/20/15.
 *
 * For those interested, this is a very simple implementation of
 * a minimalist Java Generic List.
 *
 * Big-Oh Analysis:
 *
 * size() -> O(1)
 * get() ->  O(1)
 * add()  -> O(1)
 * contains()-> O(N)
 * 
 *
 */
public class List<T> {
    final static int MIN_CAPACITY=10;
    private T[] contents;
    private int numElements;

    public List() {
        this(MIN_CAPACITY);
    }
    public List(int size) {
        //To avoid ClassCast Compiler Error
        this.contents = (T[]) (new Object[Math.max(size*2, MIN_CAPACITY)]);
    }

    /**
     *
     * @return The number of Elements in the List
     */
    public int size() {
        return numElements;
    }

    /**
     *
     * @param index The index of the element in the list from 0...size()-1
     * @return The item from index
     * @throws ArrayIndexOutOfBoundsException If index is greater than or equal to size() or negative
     */
    public T get(int index) throws ArrayIndexOutOfBoundsException {

        if (index >contents.length-1 || index<0 || index>numElements-1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return contents[index];
    }

    /**         ******NOTICE*******
     *  I've decided to comment out the following add methods that used an insertion
     *  implementation in favor of a more memory consuming, yet faster add method
     *  that comes from keeping the length of contents larger than the capacity of
     *  elements.
     *
     *
     *Conceptually, this method partitions the contents array into two separate parts,
     * before and after the specified insertion index. It copies the first part to a new array
     * (from 0 to index-1) and then inserts the specified element at (index). It then copies the
     * rest of contents to the new array starting from index to the end of the array on contents,
     * but copies those items to the new array at indices index+1 to end of the new array.
     *
     * (P.S) Sorry my explanation sucks-(@Ryan Tolsma)
     *
     *
     *
     * @param index Where to insert the element
     * @param element Element to be inserted
     * @return True if successful, false if an exception occurred

     */
    public boolean add(int index, T element) throws ArrayIndexOutOfBoundsException {
        if(index>contents.length || index<0)
            throw new ArrayIndexOutOfBoundsException();

        T[] newContents=(T[]) (new Object[contents.length+1]);
        arrayCopy(0,index-1, 0,  contents, newContents);
        newContents[index]=element;
        arrayCopy(index, numElements, index+1, contents, newContents);
        contents=newContents;
        return true;
    }


   public boolean add(T element) {
       ensureContentSize();
       contents[numElements++]=element;
       return true;
   }


    public boolean contains(T element) {
       for(int i=0; i<numElements; i++) {
           if(element.equals(contents[i])) return true;
           }
        return false;
       }


    public void ensureContentSize() {
        if(contents.length<numElements*2) {
            T[] newArray=(T[]) (new Object[numElements*2]);
            arrayCopy(0, numElements, 0, contents, newArray);
            return;

        }



    }






    public void arrayCopy(int start, int end, int toStart, T[] from, T[] to) throws ArrayIndexOutOfBoundsException {
        if (start > end || end > from.length - 1 || start < 0 || to.length <= from.length
             || toStart<0 || toStart>to.length-1
                )
            throw new ArrayIndexOutOfBoundsException();

        for (int i = start; i < end; i++) {
            to[i] = from[i];
        }
    }

    public void arrayCopy(int start, int toStart, T[] from, T[] to) {
        arrayCopy(start, from.length - 1, toStart, from, to);
    }

}

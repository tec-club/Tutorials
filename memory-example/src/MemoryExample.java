/**
 * Created by ryan on 11/19/15.
 */
public class MemoryExample {

    public boolean isStringEqual(){
        String a="Hello World!";
        String b="Hello World!";

        return a==b; //->always returns false b/c they reference different objects in the heap
        //however, a.equals(b) returns true b/c that checks for object value equivalency


    }

    public boolean isReferenceEqual() {
        String s="Hello World!";
        String t=s;
        s="Goodbye World!";
        return s.equals(t);  //->always returns false
        //because t still points at "Hello World!" in the heap, while s
        //changed its reference to "Goodbye World!" which is a new object in
        // the heap. This happens because strings are 'immutable'
    }

    public void changeInt(int num) {

        num=4;
      //Since Java primitives are passed by value the actual value of num
      //is not changed after calling this method
    }
        public void changeString(String word) {

            word="New String!!!";
            //Since Java objects are passed by reference, the value of word
            //will change to "New String!!!" after calling this method

        }

}

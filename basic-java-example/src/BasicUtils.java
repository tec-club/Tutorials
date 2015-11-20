/**
 * Created by ryan on 11/19/15.
 *
 * Meant to illustrate simple methods when dealing
 * with commonly used objects and types in java
 */
public class BasicUtils {

    public void helloWorld() {
        System.out.println("Hello World");
    }
    //reverses an array of type int, can be used for any type
    public void sortIntArray(int[] arr) {
        int temp=-1;
        for(int i=0; i<arr.length/2; i++) {
            temp=arr[i];
            arr[i]=arr[arr.length-i];
            arr[arr.length-i]=temp;

        }
        return;
    }

    public String reverseString(String s) {
        String temp="";

        for(int i=0; i<s.length()-1; i++) {

            temp+=s.charAt(s.length()-i-1);
        }
        return temp;
    }

}

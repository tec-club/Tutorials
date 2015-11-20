import java.util.*;

/**
 * Created by ryan on 11/19/15.
 */
public class CollectionUtils {

    public List<String> createListFromArray(String[] arr) {
        List<String> l=new ArrayList<String>();
       if(arr.length==0) return null;
        for(String temp: arr) {
            l.add(temp);
        }

        return l;
    }

    public Map<String, String> createMapFromTwoArray(String[] keys, String[] values) {
        Map<String,String> map=new HashMap<String, String>();
        //Need to have the same number of keys and values in this example
        if(keys.length==0 || values.length==0 || values.length!=keys.length) return null;
        for(int i=0; i<keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }


       public List<String> getValues(Map<String, String> map) {
           List<String> l = new ArrayList<String>();
           /**
            * Two Possible ways to do this, one uses a newer Java version (1.5?) and
            * a for-each loop, while the other uses an older fashioned iterator
            */
            /*
                for(Map.Entry<String, String> temp: map.entrySet()) {
            l.add(temp.getValue());
                     }
            */
           //OR...

           Iterator i = map.entrySet().iterator();
           while (i.hasNext()) {

               l.add((String) i.next());
           }
           return l;

              }
       }

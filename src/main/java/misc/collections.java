package misc;

import java.util.*;

/**
 * The problem was: order a Map by its value taking in consideration we have duplicated values and we want to keep them.
 *  1. we try using TreeMap and sortedSet but by definition SETS don't allow duplicates.
 *  2. we used LinkedList and LinkedHashMap instead.
 */
public class collections {
    private static Map<String, Integer> sortByValue(Map<String, Integer> map2) {
        List list = new LinkedList(map2.entrySet());
        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        Map result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


//    //java hasmap of objects order by field
//    contactList.sort(new Comparator<Map<String, Object>>() {
//        @Override
//        public int compare(Map<String, Object> o1, Map<String, Object> o2) {
//            if(null != o1.get("status") && null != o1.get("status")){
//                return o2.get("status").toString().compareTo(o1.get("status").toString());
//            }else if(null != o1.get("status")){
//                return 1;
//            }else{
//                return -1;
//            }
//        }
//    });
}

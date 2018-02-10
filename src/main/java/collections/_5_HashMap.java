package collections;

import java.util.HashMap;

/**
 * You can use mutable objects as a Key but is dangerous because for the sorts/new order entries could be
 * unpredictable due to it will be a different object.
 */
public class _5_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMapAsAKey = new HashMap<>();
        hashMapAsAKey.put("1key",1);
        hashMapAsAKey.put("2key",2);

        HashMap<String, Integer> hashMapAsAKey2 = new HashMap<>();
        hashMapAsAKey.put("1key",1);
        hashMapAsAKey.put("2key",2);

        HashMap<HashMap<String, Integer>, Integer> hashMap = new HashMap<>();
        hashMap.put(hashMapAsAKey, 1);

        System.out.println(hashMap.containsKey(hashMapAsAKey));
        System.out.println(hashMap.containsKey(hashMapAsAKey2));

        hashMapAsAKey.put("3key", 3);
        System.out.println(hashMap.containsKey(hashMapAsAKey));
    }
}

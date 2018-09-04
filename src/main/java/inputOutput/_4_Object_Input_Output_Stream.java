package inputOutput;

import java.io.*;
import java.util.*;

/**
 * Use private final serialVersionUID. If you change something from the class, UID have to change to control InvalidClassException.
 * Ideally, an object serialized, all its fields have to be serializable.
 *
 * class Foo { Bar var;} Foo foo1 = new Foo(); Foo foo2 = new Foo(); foo1, foo2 --> name.dat. File does not contain 2 bar
 * is unique across the file when you read back you have 2 Bar instances.
 *
 * */
public class _4_Object_Input_Output_Stream implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    // 1. This first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long.  It will start at byte 8 and end at byte 1699
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700


    static {
        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(System.getProperty("user.dir").concat("/src/main/java/inputOutput/").concat("locationsObject.dat"))))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");

                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch(InvalidClassException e) {
            System.out.println("InvalidClassException " + e.getMessage());
        } catch(IOException io) {
            System.out.println("IO Exception " + io.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locationsObject.dat")))) {
            for(Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

}
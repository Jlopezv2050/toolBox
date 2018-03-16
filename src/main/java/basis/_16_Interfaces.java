package basis;

import java.util.ArrayList;

/**
 * When we talk about abstract classes we are defining characteristics of an object type; specifying what an object is.
 * When we talk about an interface and define capabilities that we promise to provide, we are talking about establishing a contract about what the object can do.
 *
 * You define what kind of operation an object can perform, a contract with the class. Unrelated classes.
 */
public class _16_Interfaces {

    static void saveInterface (ISaveable iSaveable, ArrayList<Integer> objectsList){
        iSaveable.populateObjectsFieldsFromArrayList(objectsList);
    }

    interface ISaveable {
        void populateObjectsFieldsFromArrayList(ArrayList<Integer> objectsList);
    }

    class Players implements ISaveable{

        private ArrayList<Integer> theList;

        public Players(){
            this.theList = new ArrayList<>();
        }

        @Override
        public void populateObjectsFieldsFromArrayList(ArrayList<Integer> objectsList){
            theList.addAll(objectsList);
        }

        @Override
        public String toString(){
            return null;
        }
    }

    class Monsters implements ISaveable{

        private ArrayList<Integer> theList;

        public Monsters(){
            this.theList = new ArrayList<>();
        }

        @Override
        public void populateObjectsFieldsFromArrayList(ArrayList<Integer> objectsList){
            theList.addAll(objectsList);
        }

        @Override
        public String toString(){
            return null;
        }
    }

    public static void main(String[] args) {

        _16_Interfaces interfaces = new _16_Interfaces();
        Players player = interfaces.new Players();
        Monsters monster = interfaces.new Monsters();

        ArrayList<Integer> thelis = new ArrayList<>();
        thelis.add(1);
        thelis.add(2);
        thelis.add(3);

        saveInterface(player, thelis);
        saveInterface(monster, thelis);

        System.out.println(player.theList.size());
        System.out.println(monster.theList.size());
    }
}
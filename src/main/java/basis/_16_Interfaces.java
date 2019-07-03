package basis;

import java.util.ArrayList;

/**
 * When we talk about abstract classes we are defining characteristics of an object type; specifying what an object is.
 * When we talk about an interface and define capabilities that we promise to provide, we are talking about establishing a contract about what the object can do.
 *
 * You define what kind of operation an object can perform, a contract with the class. Unrelated classes.
 *
 * <b>Note: you can't implement an interface in another interface. You can extend</b>
 */
class _16_Interfaces {

    int CONSTANT = 100; //public static final (by default)

    //is public by default
    void B(){
        System.out.println("default");
    }



    static void saveInterface (ISaveable iSaveable, ArrayList<Integer> objectsList){
        iSaveable.populateObjectsFieldsFromArrayList(objectsList);
    }

    interface ISaveable {

        /**
         * 1. Help extending interfaces without changing all implementations.
         * 2. Has bridge down the differences between interfaces and abstract classes.
         * 3. Avoid utility classes providing the methods in the interfaces itself.
         * 4. One of the major reason for introducing it is to enhance the lambda expressions in J8 Collections API.
         * 5. If any class in the hierarchy has a method with same signature, default method become irrelevant.
         * 6. A default method cannot override a method from java.lang.Object.
         * 7. Also called Defender/Virtual extension methods.
         */
        //DEFAULT
        default void overrideDefault(){
            System.out.println("Default method");
        }

        /**
         * 1. Is part of iterface, we can't use it for implementation class objects
         * 2. Good for utility methods (null check, collection sorting,...)
         * 3. Is secure because implementation class can't override them
         * 4. Can't define instance method with same signature for Object class methods.
         */
        //STATIC
        static void overrideStatic(){
            System.out.println("I'm static method from Isaveable");
        }

        void populateObjectsFieldsFromArrayList(ArrayList<Integer> objectsList);
    }

    class Players implements ISaveable{

        private ArrayList<Integer> theList;

        public Players(){
            this.theList = new ArrayList<>();
        }

        @Override
        public void overrideDefault(){
            System.out.println("Default overrided");
        }

        //we can't override
        public void overrideStatic(){

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

        player.overrideDefault();

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
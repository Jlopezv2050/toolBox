package basis;

import java.util.ArrayList;

/**
 * When we talk about abstract classes we are defining characteristics of an object type; specifying what an object is.
 * <p>
 * When we talk about an interface and define capabilities that we promise to provide, we are talking about establishing a contract about what the object can do.
 */


// Create a simple interface that allows an object to be saved to some sort of storage medium.
// The exact type of medium is not known to the interface (nor to the classes that implement it).
// The interface will just specify 2 methods, one to return an ArrayList of values to be saved
// and the other to populate the object's fields from an ArrayList.
//
// Create some sample classes that implement your saveable interface (we've used the idea of a game,
// with Players and Monsters, but you can create any type of classes that you want).
//
// Override the toString() method for each of your classes so that they can be easily printed to enable
// the program to be tested easier.
//
// In Main, write a method that takes an object that implements the interface as a parameter and
// "saves" the values.

// We haven't covered I/O yet, so your method should just print the values to the screen.
// Also in Main, write a method that restores the values to a saveable object.
//
// Again, we are not going to use Java file I/O; instead use the readValues() method below to
// simulate getting values from a file – this allows you to type as many values as your class
// requires, and returns an ArrayList.

public class _16_Interfaces {

    static void saveInterface (ISaveable iSaveable){
        iSaveable.saveTheValues();
    }

    interface ISaveable {
        ArrayList saveTheValues();
        void populateObjectsFieldsFromArrayList(ArrayList objectsList);
    }

    class Players implements ISaveable{

        @Override
        public ArrayList saveTheValues(){
            return null;
        }

        @Override
        public void populateObjectsFieldsFromArrayList(ArrayList objectsList){

        }

        @Override
        public String toString(){
            return null;
        }
    }

    class Monsters implements ISaveable{

        @Override
        public ArrayList saveTheValues(){
            return null;
        }

        @Override
        public void populateObjectsFieldsFromArrayList(ArrayList objectsList){

        }

        @Override
        public String toString(){
            return null;
        }
    }

    public static void main(String[] args) {


        saveInterface();

    }

}

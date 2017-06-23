package javaCore;

/**
 * Once a class is instanced we call Object (have state and behaviour).
 * There can be only one public class per source file and multiple non-public classes.
 * The public class name should be the name of the source file.
 */

public class _1_Classes {

    String name;
    long id;
    String type;
    
    //nestedClasses --> if nested class is used in one place, group logically classes, increasing encapsulation, readable and maintainability
    //_1_Classes is an outerClass
    //Inner_1_Classes is an innerClass
    protected class Inner_1_Classes {
        int i = 0;

        protected boolean isGreatherThanZero (int a){

            boolean result = false;

            if (a>0) result = true;

            return result;
        }
    }

    //how to instantaite an inner class
    //"this" is not necessary
    //creation from another class ->> _1_classes.new Inner_1_Classes();
    Inner_1_Classes aux = this.new Inner_1_Classes();

    //CONSTRUCTOR
    _1_Classes (String name, long id, String type){
        this.name = name;
        this.id = id;
        this.type = type;
    }

    //this block will be executed when the class will be instanced.
    {
        System.out.println("_1_Classes non-statical loading.");
    }

    //this block will be executed when the class will be loaded in memory.
    static {
        System.out.println("_1_Classes statical loading.");
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public void actionToinhiretance(){
        System.out.println("action to inhiretance");
    }
}
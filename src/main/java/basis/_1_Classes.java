package basis;

/**
 * Once a class is instanced, is called Object (have state and behaviour).
 * There can be only one public class per source file and multiple non-public classes.
 * The public class name should be the name of the source file.
 */

public class _1_Classes {

    String name;
    long id;
    String type;

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

    public void actionToinhiretance(){
        System.out.println("action to inhiretance");
    }
}
package basis;

/**
 * <h1>Classes, Constructors and Objects</h1>
 * Short description
 * <p>
 * <ul>
 *     <li><b>Class:</b> template with properties, behaviours (methods), external interactions and how an specimen of this is created.</li>
 *     <li><b>Object:</b> specific instance of the class (have state and behaviour).</li>
 * </ul>
 * <p>
 * <b>Note:</b> There can be only one public class per source file and multiple non-public classes.
 * The public class name should be the name of the source file.
 *
 * @author  jlopezv
 * @version 1.0
 * @since   2016
 */

public class _1_Classes {

    String name;
    long id;
    String type;

    //CONSTRUCTOR
    _1_Classes(String name, long id, String type) {
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

    public void actionToInheritance() {
        System.out.println("action to inheritance");
    }
}
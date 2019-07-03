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

// class could be public -> all packages could see
// class could be default-package -> only its package could see
// protected is not allowed because is like default-package plus subpackages (not exist)
// private make no sense because package can't use classes so can't instantiate it

// final can no be subclassed
class _1_Classes {

    private String name;

    //CONSTRUCTOR
    _1_Classes(String name) {
        this.name = name;
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

    //WRONG!! you're overloading (change the passed parameters) instead overriding
    public boolean equals(_1_Classes object){
        return this == object;
    }

    //PROBLEM EQUALS WHEN SUBCLASSING
    //Dog d1   Labrador d2
    //d1.equals(d2)-> d1 instanceOf d2 -> false! (ok!)
    //d2.equals(d1)-> d2 instanceOf d1 -> true! (ko!)
}
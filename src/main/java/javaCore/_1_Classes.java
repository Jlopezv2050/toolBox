package javaCore;

/**
 * Created by juan on 21/11/16.
 * Once a class is instanced we call Object (have state and behaviour).
 * There can be only one public class per source file and multiple non-public classes.
 * The public class name should be the name of the source file.
 */
public class _1_Classes {
    
    //innerClasses or nestedClasses
    protected class Inner_1_Classes {
        int i = 0;

        protected boolean isGreatherThanZero (int a){

            boolean result = false;

            if (a>0) result = true;

            return result;
        }
    }

    //this block will be executed when the class will be instanced.
    {
        System.out.println("_1_Classes non-statical loading.");
    }

    //this block will be executed when the class will be loaded in memory.
    static {
        System.out.println("_1_Classes statical loading.");
    }

}

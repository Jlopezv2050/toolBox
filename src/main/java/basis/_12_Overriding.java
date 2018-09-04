package basis;

/**
 * Static method override

 Child class can redefine methods of the parent class. This is called function overriding.
 The signature (return type, parameter type and number of parameters) is kept same as defined in the parent class.
 Method overriding is done to achieve Run Time Polymorphism (An overridden method is called according to the object invoking it,
 not according to the reference type).

 Can we Override static methods in java?
 We can declare static methods with same signature in subclass,
 but it is not considered overriding as there won’t be any run-time polymorphism. Hence the answer is ‘No’.
 If a derived class defines a static method with same signature as a static method in base class,
 the method in the derived class hides the method in the base class. This is also called method hiding.

 OVERLOADING    VS      OVERRIDING

 Same name              Same signature
 Diff params            Same params
 "Compile time"         "Runtime polymorphism"
 May different return   Return can be subclass
                        No lower access modifier ej. parent protected child can't be private
                        keyword super to call parent version

 */
public class _12_Overriding {
}

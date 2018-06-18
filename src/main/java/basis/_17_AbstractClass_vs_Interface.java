package basis;

/**
 * ___________________________________ABSTRACT_class__|__Interface____
 * Can instantiate                  |       X         |      X       |
 * Methods with implementation      |       V         |      J8      |
 * Non-static final variables       |       V         |   private J9 |
 * Public/private/protected methods |       V         |      X       |
 * Can extend parent class          |       V         |      X       |
 * Can implements n interfaces      |       V         |      V       |
 * -------------------------------------------------------------------
 *
 * DIAMOND PROBLEM (In abstract class and using default methods Interface)
 *  Compiler can't decide which superclass method to use.
 *
 *  class implements Interface1, Interface2 with log() method in both interfaces.
 *      in class you MUST provide implementation for log(), otherwise will throw compile time error
 */

public class _17_AbstractClass_vs_Interface {
}

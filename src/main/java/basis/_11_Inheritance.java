package basis;

/**
 * "is-a" relationship
 * -----line------|>
 */

public class _11_Inheritance extends _1_Classes {

    //specific field that is not contain in the inherited class
    String inheritanceReason;

    _11_Inheritance(String a, long b, String c, String inheritanceReason) {
        super(null, 1, null);
        //set the specific fields from the class
        this.inheritanceReason = inheritanceReason;
    }

    private void preFunctionAction() {
        System.out.println("preAction");
    }

    @Override
    public void actionToInheritance() {
        preFunctionAction();
        //use super only if is not clear if the method is from the clas or from its parent
        super.actionToInheritance();
    }

}

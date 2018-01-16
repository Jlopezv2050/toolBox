package basis;

/**
 * Created by juan on 24/11/16.
 */
public class _8_b_User_Defined_Exceptions extends Exception {

    public _8_b_User_Defined_Exceptions (String message){
        super(message.concat(Long.valueOf(1).toString()));
    }

}

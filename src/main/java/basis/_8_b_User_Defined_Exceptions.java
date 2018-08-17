package basis;

import java.io.IOException;

/**
 * Created by juan on 24/11/16.
 */
public class _8_b_User_Defined_Exceptions extends IOException {

    public _8_b_User_Defined_Exceptions (String message, Throwable throwable){
        super(message.concat(Long.valueOf(1).toString()), throwable);
    }

}

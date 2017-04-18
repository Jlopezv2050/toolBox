package javaCore;

/**
 * Created by juan on 21/11/16.
 * JAVA always passes per value
 */
public class _5_Wrappers {

    private class ByValue {

        int value = 0;

        public ByValue(int value){

            this.value = value;
        }

    }

    public ByValue getByValueInstance (int value){

        ByValue result = new ByValue(value);

        return result;
    }

    //even the reference to m1 is passed by value, otherwise we could point from m1 to m2 inside of the method
    public void metodo_referencia2(ByValue m1) {
        m1.value = 23;
        ByValue m2 = new ByValue(1);
        //we loss the reference
        m1 = m2;
        m1.value = 6;
    }


    public static void main (String [] args){

        _5_Wrappers wrappers = new _5_Wrappers();

        ByValue m3 = wrappers.getByValueInstance(2);

        System.out.println(m3.value);
        wrappers.metodo_referencia2(m3);
        System.out.println(m3.value);

    }


}

package basis;

public class _3_Arrays {

    boolean[] booleanArray = new boolean[5];

    //Anonymous array
    int[] intsArray = {1,2,45,45,6};

    public static int[] sortArray (int[] intsArray){

        boolean toOrder = true;
        while (toOrder){
            toOrder = false;
            for(int i=0; i< intsArray.length-1; i ++){
                if (intsArray[i]< intsArray[i+1]){
                    int temp = intsArray[i];
                    intsArray[i] = intsArray[i+1];
                    intsArray[i+1] = temp;
                    toOrder = true;
                }
            }

        }

        return intsArray;
    }


    static void printArray(int[] intsArray){
        for (int anIntsArray : intsArray) {
            System.out.println(anIntsArray);
        }
    }


    public static void main(String[] args) {
        _3_Arrays arrays = new _3_Arrays();
        int[] sortedArray = sortArray(arrays.intsArray);
        printArray(sortedArray);
    }
}

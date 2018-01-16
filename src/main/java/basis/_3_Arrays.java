package basis;


public class _3_Arrays {
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


//    public void sortArray(int[] intsArray){
//        int[] sortedArray = new int[intsArray.length];
//
//        int valorMasGrande = 0;
//        for(int j = 0; j< sortedArray.length; j++){
//            for (int i = 0; i< intsArray.length; i++){
//                if (valorMasGrande < intsArray[i]){
//                    valorMasGrande = intsArray[i];
//                }
//            }
//            sortedArray[j] = valorMasGrande;
//            for (int w = 0; w < intsArray.length; w++){
//                if (valorMasGrande == intsArray[w]){
//                    intsArray[w] = 0;
//                    break;
//                }
//            }
//            valorMasGrande = 0;
//        }
//        System.out.println("hello");
//    }


    static void printArray(int[] intsArray){
        for(int i=0 ; i<intsArray.length; i++){
            System.out.println(intsArray[i]);
        }
    }


    public static void main(String[] args) {
        _3_Arrays arrays = new _3_Arrays();
        int[] sortedArray = sortArray(arrays.intsArray);
        printArray(arrays.intsArray);
        printArray(sortedArray);
    }
}

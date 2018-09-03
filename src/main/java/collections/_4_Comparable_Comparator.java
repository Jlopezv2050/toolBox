package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparable
 *    Natural order
 *
 * Comparator
 *    Other orders
 */
public class _4_Comparable_Comparator {

    public static Comparator<ForexTransaction> BY_SCORING = new Comparator<ForexTransaction>(){
        @Override
        public int compare(ForexTransaction forexTransaction1, ForexTransaction forexTransaction2) {
            return forexTransaction1.totalScoringTransaction.compareTo(forexTransaction2.totalScoringTransaction);
        }
    };

    //LAMBDA STYLE
    public static Comparator<ForexTransaction> BY_ROI = (ForexTransaction o1,ForexTransaction o2) -> o1.roiTransaction.compareTo(o2.roiTransaction);

    class ForexTransaction implements Comparable<ForexTransaction>{
        private String name;
        private Double priceTransaction;
        private Double roiTransaction;
        private Double totalScoringTransaction;

        public ForexTransaction(String name, Double priceTransaction, double roiTransaction, double totalScoringTransaction){
            this.name = name;
            this.priceTransaction = priceTransaction;
            this.roiTransaction = roiTransaction;
            this.totalScoringTransaction = totalScoringTransaction;
        }

        @Override
        public int compareTo(ForexTransaction forexTransaction) {
            return this.priceTransaction.compareTo(forexTransaction.priceTransaction);
        }
    }

    public static void main(String[] args) {

        //COMPARABLE
        _4_Comparable_Comparator comparable_comparator = new _4_Comparable_Comparator();
        List<ForexTransaction> forexTransactionList = new ArrayList<>();
        forexTransactionList.add(comparable_comparator.new ForexTransaction("Tr1", 1.00, 0.01, 2.00));
        forexTransactionList.add(comparable_comparator.new ForexTransaction("Tr2", 3.00, 0.10, 1.00));
        forexTransactionList.add(comparable_comparator.new ForexTransaction("Tr3", 2.00, 0.11, 1.05));

        Collections.sort(forexTransactionList);

        System.out.println("Natural Order: ");
        for (ForexTransaction forexTransaction : forexTransactionList){
            System.out.println(forexTransaction.name);
        }

        Collections.sort(forexTransactionList, _4_Comparable_Comparator.BY_SCORING);

        System.out.println("SCORING Order: ");
        for (ForexTransaction forexTransaction : forexTransactionList){
            System.out.println(forexTransaction.name);
        }

        Collections.sort(forexTransactionList, _4_Comparable_Comparator.BY_ROI);
        System.out.println("ROI Order: ");
        for (ForexTransaction forexTransaction : forexTransactionList){
            System.out.println(forexTransaction.name);
        }
    }
}
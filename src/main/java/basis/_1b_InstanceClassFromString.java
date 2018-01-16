package basis;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

class InstanceClassFromString {
    class Hamburguer {
        private double basePrice;
        private double totalPrice;
        private int numberExtraItems = 0;
        List<ExtraItem> extraItems = new ArrayList<>();

        public Hamburguer(double basePrice){
            this.basePrice = basePrice;
            this.totalPrice = basePrice;
        }

        public void addExtraItem(InstanceClassFromString instanceClassFromString, String item) throws Exception {
            if (numberExtraItems >= 4) throw new Exception("You can't add more than 4 extra items.");

            Class<?> clazz = Class.forName("basis.InstanceClassFromString$"+item);
            Constructor<?> ctor = clazz.getConstructor(InstanceClassFromString.class, String.class);
            ExtraItem object = (ExtraItem) ctor.newInstance(instanceClassFromString, item);

            totalPrice = totalPrice + object.price ;
            extraItems.add(object);
            System.out.println(item+" added!");
            numberExtraItems++;
        }

        public void showBurger(){
            System.out.println("base price:" +basePrice+"\n");
            for (ExtraItem item : extraItems){
                System.out.println("Name"+item.name);
                System.out.println("Price"+item.price);
            }
            System.out.println("Total burger:" +totalPrice);
        }
    }

    class Healthy_burger extends Hamburguer {
        public Healthy_burger(double price){
            super(price);
        }
    }

    class ExtraItem {
        private String name;
        private double price;

        public ExtraItem (String name, double price){
            this.name = name;
            this.price = price;
        }
    }
    @SuppressWarnings("unused")
    class Lettuce extends ExtraItem{
        //The parameter is only to show how to use the constructor instance
        public Lettuce(String name) {
            super("Lettuce", 0.15D);
        }
    }
    @SuppressWarnings("unused")
    class Tomato extends ExtraItem{
        //The parameter is only to show how to use the constructor instance
        public Tomato(String name) {
            super("Tomato",0.40D);
        }
    }

    public static void main(String[] args) throws Exception {
        InstanceClassFromString instanceClassFromString = new InstanceClassFromString();
        Healthy_burger helth1 = instanceClassFromString.new Healthy_burger(3.60D);
        helth1.addExtraItem(instanceClassFromString,"Lettuce");
        helth1.addExtraItem(instanceClassFromString,"Tomato");

       helth1.showBurger();
    }
}
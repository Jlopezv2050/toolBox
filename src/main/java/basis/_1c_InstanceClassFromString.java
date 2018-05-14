package basis;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Instance Class From String nameNon-static Nested Classes</h1>
 * <p>
 * <ol>
 *   <li>Get class for name</li>
 *   <li>With previous class.getConstructor</li>
 *   <li>With cast and previous constructor.newInstance</li>
 * </ul>
 *
 * @author jlopezv
 * @version 1.0
 * @since 2016
 */

class InstanceClassFromString {

    private final static double LETTUCE_PRICE = 0.15D;
    private final static double TOMATO_PRICE = 3.60D;

    class Hamburger {
        private double basePrice;
        private double totalPrice;
        private int numberExtraItems = 0;
        private final static int MAX_EXTRA_ITEMS = 4;

        List<ExtraItem> extraItems = new ArrayList<>();

        public Hamburger(double basePrice) {
            this.basePrice = basePrice;
            this.totalPrice = basePrice;
        }

        public void addExtraItem(InstanceClassFromString instanceClassFromString, String item) throws Exception {
            if (numberExtraItems >= MAX_EXTRA_ITEMS) throw new Exception("You can't add more than 4 extra items.");

            Class<?> clazz = Class.forName("basis.InstanceClassFromString$" + item);
            Constructor<?> ctor = clazz.getConstructor(InstanceClassFromString.class, String.class);
            ExtraItem object = (ExtraItem) ctor.newInstance(instanceClassFromString, item);

            totalPrice = totalPrice + object.price;
            extraItems.add(object);
            System.out.println(item + " added!");
            numberExtraItems++;
        }

        public void showBurger() {
            System.out.println("base price:" + basePrice + "\n");
            for (ExtraItem item : extraItems) {
                System.out.println("Name" + item.name);
                System.out.println("Price" + item.price);
            }
            System.out.println("Total burger:" + totalPrice);
        }
    }

    class Healthy_burger extends Hamburger {
        public Healthy_burger(double price) {
            super(price);
        }
    }

    class ExtraItem {
        private String name;
        private double price;

        public ExtraItem(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    @SuppressWarnings("unused")
    class Lettuce extends ExtraItem {
        //The parameter is only to show how to use the constructor instance
        public Lettuce(String name) {
            super("Lettuce", LETTUCE_PRICE);
        }
    }

    @SuppressWarnings("unused")
    class Tomato extends ExtraItem {
        //The parameter is only to show how to use the constructor instance
        public Tomato(String name) {
            super("Tomato", TOMATO_PRICE);
        }
    }

    public static void main(String[] args) throws Exception {
        InstanceClassFromString instanceClassFromString = new InstanceClassFromString();
        Healthy_burger health1 = instanceClassFromString.new Healthy_burger(3.60D);
        health1.addExtraItem(instanceClassFromString, "Lettuce");
        health1.addExtraItem(instanceClassFromString, "Tomato");

        health1.showBurger();
    }
}
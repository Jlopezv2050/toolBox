package basis;

public class _13_Polymorphism {

    private class Bycicle {
        String type;

        public Bycicle(String type) {
            this.type = type;
        }

        public void slowDown() {
        }
    }

    private class MTB extends Bycicle {
        String model;

        public MTB(String model) {
            super("MTB");
            this.model = model;
        }

        /**Best practice not must to*/
        @Override
        public void slowDown() {
            System.out.println("Slow down with an MTB");
        }
    }

    private class Street extends Bycicle {
        String model;

        public Street(String model) {
            super("Street");
            this.model = model;
        }

        public void slowDown() {
            System.out.println("Slow down with an Street");
        }
    }

    public static void main(String[] args) {
        _13_Polymorphism polymorphism = new _13_Polymorphism();

        MTB mtb = polymorphism.new MTB("Orbea");
        Street street = polymorphism.new Street("Street");

        mtb.slowDown();
        street.slowDown();
    }
}

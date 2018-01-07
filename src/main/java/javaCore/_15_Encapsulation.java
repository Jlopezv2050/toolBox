package javaCore;

@SuppressWarnings("unused")
public class _15_Encapsulation {
    class Drone{
        public String model;
        /**We can change on by running if we use a method call turnOn*/
        private boolean on;
        /**If we set directly battery_level we could set battery up to 100*/
        private int battery_level;

        /**Use a constructor instead of instantiate directly avoid miss some parameter and allow validations*/
        public Drone (String model, boolean on, int battery_level){
            this.model = model;
            this.on = on;
            this.battery_level = battery_level;
        }
    }
}
package basis;

/**
 * We consider a dog, a bat and a penguin. As a relation all are animals. We create abstract class animal.
 * We can do Mamals and birds. But bat is a mamal that fly and mamals not implements canFly. We use interface canFly
 *
 */
public class _14_Abstraction {

    abstract class Animals{
        void breath(){
            System.out.println("breathing");
        }
    }

    abstract class Mamal extends Animals{
        void nursing(){
            System.out.println("nursing");
        }
    }

    interface CanFly{
        void fly();
    }

    class Bat extends Mamal implements CanFly{
        public void fly(){
            System.out.println("flying");
        }
    }

    public static void main(String[] args) {
        _14_Abstraction abstraction = new _14_Abstraction();
        Bat bat = abstraction.new Bat();

        bat.breath();
        bat.nursing();
        bat.fly();
    }
}

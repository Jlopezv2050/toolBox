package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

/**
 * CONSUMER -> doesn't return a value (accept) (1/2 A, NR, CH)
 * SUPPLIER -> doesn't accept any parameter (get) (0 A, R, NCH)
 * PREDICATE -> only return TRUE or FALSE (test) (1/2 A, R, CH)
 * FUNCTION -> takes a parameter and return a value (apply) (1/2 A, R, CH)
 * UNARY_OPERATOR -> receive and return the same   (Long -> Long) (applyAsType) (1 A, R, CH)
 *
 * (1/2 A, NR, CH) --> 1 or 2 arguments, no return, can be chained
 *
 * */
public class Functional_Interfaces {
    public static void main(String[] args) {
        Functional_Interfaces predicates_suppliers = new Functional_Interfaces();
        Employee john = predicates_suppliers.new Employee("John Doe", 30);
        Employee tim = predicates_suppliers.new Employee("Tim Buchalka", 21);
        Employee jack = predicates_suppliers.new Employee("Jack Hill", 40);
        Employee snow = predicates_suppliers.new Employee("Snow White", 22);
        Employee red = predicates_suppliers.new Employee("Red RidingHood", 35);
        Employee charming = predicates_suppliers.new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        //CONSUMER
        String aux = "hello";

        //Combination functional interfaces
        Consumer<String> cJ = consumer -> {
            Function<String, String> upperCase = String::toUpperCase;
            System.out.println(upperCase.apply(consumer));
        };

        Consumer<String> c2 = System.out::println;

        //normal use of the consumer
        cJ.accept(aux);

        //check the variable is not modified
        System.out.println(aux);

        //if you CHAIN consumers, both receive aux (first finish one and then the other)
        cJ.andThen(c2).accept(aux);

        //FUNCTIONS
        Function<Employee, String> getLastName = (employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastName = getLastName.apply(employees.get(2));
        System.out.println(lastName);

        //using multiple function, we pass getLastName as an argument
        System.out.println(getAName(getLastName,employees.get(1)));

        //CHAIN CONSUMERS, PREDICATES AND FUNCTIONS
        //BiConsumer, BiPredicate and BFunction only can be chained if is the first in the chain
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));

        //This line is in error because compose acts in the opposite way of andThen
        //the result of firstName is String but upperCase receive an Employee
        //Function chainedF = upperCase.compose(firstName);

        //BiX has no compose because he will be the receiver of the previous function and even BiX as Functions
        // return a single type
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());

        };

        BiFunction<String, Employee, String> chainedFunction = concatAge.andThen(firstName);

        System.out.println(chainedFunction.apply(employees.get(1).getName(),employees.get(1)));

        //UNARY OPERATORS
        IntUnaryOperator incByFive = i -> i + 5;
        System.out.println(incByFive.applyAsInt(10));

        //PREDICATES
        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployees 30 and under", employee ->employee.getAge() <= 30);

        //EQUATE TO an ANONYMOUS CLASS
        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        //equivalent to nested block
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;

        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a + 5));

        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

        //Doesn't accept any argument and it does return a value
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i=0; i<10; i++) {
            System.out.println(randomSupplier.get());
        }


    }
    //You can create DIFFERENT FUNCTIONS  and use one or another (ex. get first name or last name) passing as an argument
    private static String getAName(Function<Employee,String> nameFunction, Employee employee){
        return  nameFunction.apply(employee);
    }


    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {

        System.out.println(ageText);
        System.out.println("==================");
        for(Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
    class Employee {
        private String name;
        private int age;

        Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }
    }

}
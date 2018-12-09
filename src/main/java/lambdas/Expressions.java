package lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * From JDK.8 there is an easier way to work with interfaces that have only one method (functional interfaces). Often
 * used in places we use anonymous classes
 * */
public class Expressions {
    public static void main (String[]args){

        //YOU ONLY NEED CURLY BRACES IF HAVE MORE THAN ONE STATEMENT
        //        new Thread(()-> {
        //            System.out.println("Printing from the Runnable");
        //            System.out.println("Line 2");
        //            System.out.format("This is line %d\n", 3);
        //        }).start();


        Employee john = new Employee("John Doe");
        Employee tim = new Employee("Tim Buchalka");
        Employee jack = new Employee("Jack Hill");
        Employee snow = new Employee("Snow White");

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        //lambda thread is using employee (new variable each loop) NO employees, so final
        for(Employee employee: employees){
            new Thread(()-> System.out.println(employee.getName()));
        }

//        OLD STYLE
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        //
        // JAVADOC tab Abstract methods says equals, compare are abstract methods. Why are functional?
        // 1. The Doc sas on description
        // 2. Has an annotation
        // 3. Inherits from Object so has default equals
//        Collections.sort(employees, (employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName()));


//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },
//        employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);
//
//        UpperConcat uc = (s1, s2) -> {
//            String result = s1.toUpperCase() +  s2.toUpperCase();
//            return result;
//        };
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

   static String doStringStuff(UpperConcat uc){
        return uc.upperAndConcat("String1", "String2");
    }
}

class Employee {
    private String name;

    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    String doSomething() {
        int i = 8;

        //CHECK ANONYMOUS CLASS, I HAVE TO BE EFFECTIVELY FINAL
        //i++;

        //lambda expression getClass return the name that wraps the anonymous class because isn't a class (AnotherClass).
        // No instance of UpperConcat is created is TREATED LIKE A NESTED BLOCKS and has the same scope
        // i is USED IN THE SCOPE
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName() + i);
            return s1.toUpperCase() + s2.toUpperCase();
        };

        System.out.println(uc.getClass().getSimpleName());
        //AnotherClass$$Lambda$1/1688019098

        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return Expressions.doStringStuff(uc);
    }

//    //ANONYMOUS class style
//    String doSomething(){
//        //to use this local variable inside the anonymous class has to be effective final.
//        //why? because this variable doesn't belong to the anonymous class. If the wrap class change the value,
//        //  the anonymous class won't be updated because it has a copy of the value
//        final int i = 0;
//
//        {
//            UpperConcat uc = new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//                    System.out.println("i inside anonymous class is: " + i);
//                    System.out.println("The anonymous class is" + getClass().getSimpleName());
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            };
//
//            //local variable can be used inside the nested block
////            i++;
////            System.out.println("The i = " + i);
//            return Expressions.doStringStuff(uc, "String1", "String2");
//        }
//
//    }
}
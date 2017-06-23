package javaCore.challenges._11_Inheritance;

/**
 */
public class Person {

    private String name;
    private int age;
    private int identification;

    public void Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public boolean makeIdentification(String nationallity, int identificationNumber){
        if (nationallity.equals("ES") && identificationNumber > 0){
            this.identification = identificationNumber;
            System.out.println("Person has been identificated");
            return true;
        } else {
            return false;
        }
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

}

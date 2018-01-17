package collections;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;





// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.

// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.
public class _1_ArrayList {

    class MobilePhone{

        private ArrayList<Contacts> listContacts;

        public MobilePhone(){
            listContacts = new ArrayList<Contacts>();
        }

        private void printContacts(){
            if (listContacts.isEmpty()) {
                System.out.println("Empty listContacts");
            } else{
                for (Contacts contact : listContacts){
                    System.out.println("Name: "+contact.name+" Phone Number: "+contact.phoneNumber);
                }
            }
        }

        private void addNewContact(String name, Long phoneNumber){
            listContacts.add(new Contacts(name, phoneNumber));
        }


    }


    class Contacts{

        private String name;
        private Long phoneNumber;

        public Contacts(String name, Long phoneNumber){
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }

    private static void printOptions(){
        System.out.println("Introduce an option: \n");
        System.out.println("A. Print contacts.\n");
        System.out.println("B. Add new contact.\n");
        System.out.println("C. Update existing contact.\n");
        System.out.println("D. Remove contact.\n");
        System.out.println("E. Search contact.\n");
        System.out.println("F. Quit.\n");
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean runningProgram = true;

        _1_ArrayList arrayList = new _1_ArrayList();
        MobilePhone mobilePhone = arrayList.new MobilePhone();

        while (runningProgram){
            printOptions();
            switch(scanner.nextLine()){
                case("A"):
                    mobilePhone.printContacts();
                break;
                case("B"):
                    System.out.println("Tell me the name:");
                    String name = scanner.nextLine();
                    System.out.println("Tell me the phone:");
                    Long number = scanner.nextLong();

                    mobilePhone.addNewContact(name, number);

                    System.out.println("Added!");

                    break;
                case("C"):
                    System.out.println("Who are you looking for:");
                    name = scanner.nextLine();

                    mobilePhone.listContacts.indexOf(new Contacts(name scanner.nextLine());
                    break;
                case("D"):
                    System.out.println();
                    break;
                case("E"):
                    System.out.println();
                    break;
                case("F"):
                    runningProgram = false;
                    break;
                default:
                    System.out.println("this option doesn't exist");

            }
        }
    }
}

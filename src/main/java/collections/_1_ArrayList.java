package collections;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class _1_ArrayList {

    class MobilePhone {

        private ArrayList<Contacts> listContacts;

        public MobilePhone() {
            listContacts = new ArrayList<>();
        }

        private void printContacts() {
            if (listContacts.isEmpty()) {
                System.out.println("Empty listContacts");
            } else {
                for (Contacts contact : listContacts) {
                    System.out.println("Name: " + contact.name + " Phone Number: " + contact.phoneNumber);
                }
            }
        }

        private void addNewContact(Scanner scanner) {
            System.out.println("Tell me the name:");
            String name = scanner.nextLine();
            System.out.println("Tell me the phone:");
            Long phoneNumber = scanner.nextLong();

            listContacts.add(new Contacts(name, phoneNumber));
            System.out.println("Added!");
        }

        private void updateContact(Scanner scanner) {

            System.out.println("Who are you looking for:");
            String name = scanner.nextLine();

            int indexContact = listContacts.indexOf(new Contacts(name, null));
            if (indexContact >= 0) {

                System.out.println("Tell the new name: ");
                String newName = scanner.nextLine();
                System.out.println("Tell the new numberPhone: ");
                Long newNumberPhone = scanner.nextLong();
                listContacts.set(indexContact, new Contacts(newName, newNumberPhone));
                System.out.println("Updated!");

            } else {
                System.out.println("Contact not found!");
            }
        }

        private void removeContact(Scanner scanner) {

            System.out.println("Who are you looking for:");
            String name = scanner.nextLine();

            int indexContact = listContacts.indexOf(new Contacts(name, null));
            if (indexContact >= 0) {

                System.out.println("Are you sure? Enter --> Y");
                String sure = scanner.nextLine();
                if (sure.equals("Y")) {
                    listContacts.remove(indexContact);
                }

            }
        }
    }

    class Contacts{

        private String name;
        private Long phoneNumber;

        public Contacts(String name, Long phoneNumber){
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public boolean equals(Object o){
            if(o == null) return false;
            if(!(o instanceof Contacts)) return false;

            Contacts other = (Contacts) o;
            return Objects.equals(this.name, other.name);
        }
    }

    private static void printOptions(){
        System.out.println("Introduce an option: \n");
        System.out.println("A. Print contacts.\n");
        System.out.println("B. Add new contact.\n");
        System.out.println("C. Update existing contact.\n");
        System.out.println("D. Remove contact.\n");
        System.out.println("F. Quit.\n");
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean runningProgram = true;

        _1_ArrayList arrayList = new _1_ArrayList();
        _1_ArrayList.MobilePhone mobilePhone = arrayList.new MobilePhone();

        while (runningProgram){
            printOptions();
            switch(scanner.nextLine()){
                case("A"):
                    mobilePhone.printContacts();
                break;
                case("B"):
                    mobilePhone.addNewContact(scanner);
                    break;
                case("C"):
                    mobilePhone.updateContact(scanner);
                    break;
                case("D"):
                    mobilePhone.removeContact(scanner);
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
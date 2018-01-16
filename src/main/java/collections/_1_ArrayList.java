package collections;

import java.util.ArrayList;
import java.util.Scanner;


// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.
public class _1_ArrayList {

    class MobilePhone{

        private ArrayList<Contacts> listContacts;

        public MobilePhone(){
            
        }

        private void store(){

            //Contacts newContact = new ArrayList();

        }
        private void setRemove(){

        }
        private void setGet(){

        }
        private void setcontains(){

        }
    }


    class Contacts{

        private int name;
        private int number;

        public Contacts(int name, int number){
            this.name = name;
            this.number = number;
        }
    }
}

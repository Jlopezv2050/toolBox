package javaCore.challenges._11_Inheritance;

import javaCore.challenges._11_Inheritance.Patient;

/**
 */
public class UrgencyPatient extends Patient {

    private String treatment;

    public void UrgencyPatient(String name, int age, String ilness){
        super.Patient(name,age,ilness);
    }

    @Override
    public void makeTreatement(String treatment){
        this.treatment = treatment;
        System.out.println("UrgencyPatient treatement made.");
    }
}

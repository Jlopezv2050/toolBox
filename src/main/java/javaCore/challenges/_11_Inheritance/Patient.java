package javaCore.challenges._11_Inheritance;

/**
 */
public class Patient extends Person {

    private String ilness;
    private int medicalIdentification;
    private boolean medicalRelease;

    public void Patient(String name, int age, String ilness){
        super.Person(name,age);
        this.ilness = ilness;
        medicalRelease = false;
    }

    public boolean makeMedicalIdentification (boolean medicalValidation, String nationallity, int identificationNumber){
        if(medicalValidation && nationallity!=null && identificationNumber >0 ){
            boolean identification;
            identification = super.makeIdentification(nationallity, identificationNumber);
            if (identification){
                this.medicalIdentification = identificationNumber + 13;
                return true;
            }
        }else{
            return false;
        }
        return false;
    }

    public void makeTreatement(String treatment){
        System.out.println("Treatement made.");
    }
}

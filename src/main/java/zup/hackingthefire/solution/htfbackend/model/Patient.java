package zup.hackingthefire.solution.htfbackend.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Patient {

    @NotEmpty
    private String fullName;

    @NotEmpty
    private String gender;

    @NotNull
    private int age;

    @NotEmpty
    private String symptomDescription;

    public Patient(){}

    public Patient(String fullName, String gender, int age, String symptomDescription){
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.symptomDescription = symptomDescription;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSymptomDescription() {
        return symptomDescription;
    }

    public void setSymptomDescription(String symptomDescription) {
        this.symptomDescription = symptomDescription;
    }
}

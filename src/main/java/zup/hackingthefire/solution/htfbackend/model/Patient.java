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

    private String pressure;

    private String cardiacFrequency;

    private String o2Saturation;

    private String temperature;

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

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getCardiacFrequency() {
        return cardiacFrequency;
    }

    public void setCardiacFrequency(String cardiacFrequency) {
        this.cardiacFrequency = cardiacFrequency;
    }

    public String getO2Saturation() {
        return o2Saturation;
    }

    public void setO2Saturation(String o2Saturation) {
        this.o2Saturation = o2Saturation;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

}

package zup.hackingthefire.solution.htfbackend.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "occurrences")
public class Occurrence {

    @Id
    private final String id = RandomStringUtils.randomNumeric(8);

    @NotEmpty
    private String phone;

    @NotEmpty
    private String requester;

    @NotEmpty
    private String city;

    @NotEmpty
    private String address;

    @NotEmpty
    private String addressNumber;

    @NotEmpty
    private String neighborhood;

    @NotEmpty
    private String reference;

    @NotEmpty
    private List<Patient> patients;

    @NotEmpty
    private String gender;

    @NotNull
    private int age;

    @NotEmpty
    private String patientComplaint;

    @NotEmpty
    private String comments;

    @NotNull
    private Boolean isEmergency;

    @NotNull
    private OccurrenceStatus occurrenceStatus;

    public Occurrence(){}

    public Occurrence(String phone, String city, String address, String addressNumber, String neighborhood, String reference,
                      List<Patient> patients, String gender, int age, String patientComplaint, String comments, Boolean isEmergency, String occurrenceStatus) {
        this.phone = phone;
        this.city = city;
        this.address = address;
        this.addressNumber = addressNumber;
        this.neighborhood = neighborhood;
        this.reference = reference;
        this.patients = patients;
        this.gender = gender;
        this.age = age;
        this.patientComplaint = patientComplaint;
        this.comments = comments;
        this.isEmergency = isEmergency;
        this.occurrenceStatus = OccurrenceStatus.valueOf(occurrenceStatus);
    }

    public enum OccurrenceStatus{
        OPENED, ANSWERED, CHECKINMODE, CHECKOUTMODE, FINISHED
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
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

    public String getPatientComplaint() {
        return patientComplaint;
    }

    public void setPatientComplaint(String patientComplaint) {
        this.patientComplaint = patientComplaint;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getEmergency() {
        return isEmergency;
    }

    public void setEmergency(Boolean emergency) {
        isEmergency = emergency;
    }

    public OccurrenceStatus getOccurrenceStatus() {
        return occurrenceStatus;
    }

    public void setOccurrenceStatus(OccurrenceStatus occurrenceStatus) {
        this.occurrenceStatus = occurrenceStatus;
    }

}

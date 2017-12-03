package zup.hackingthefire.solution.htfbackend.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "occurrences")
public class Occurrence {

    private static final String GEOCODE_MAPS_API_URL = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String GEOCODE_MAPS_API_KEY = "AIzaSyBLiHfvDCzU5_D3p4JHqNHQiWVdUjFRz3I";
    private static final Logger logger = LoggerFactory.getLogger(Occurrence.class);

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
    private String comments;

    @NotNull
    private Boolean isEmergency;

    @NotNull
    private OccurrenceStatus occurrenceStatus;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    private String emergencyDescription;

    public Occurrence(){}

    public Occurrence(String phone, String city, String address, String addressNumber, String neighborhood, String reference,
                      List<Patient> patients, String comments, Boolean isEmergency, String occurrenceStatus, String emergencyDescription) {
        this.phone = phone;
        this.city = city;
        this.address = address;
        this.addressNumber = addressNumber;
        this.neighborhood = neighborhood;
        this.reference = reference;
        this.patients = patients;
        this.comments = comments;
        this.isEmergency = isEmergency;
        this.occurrenceStatus = OccurrenceStatus.valueOf(occurrenceStatus);
        this.emergencyDescription = emergencyDescription;
        setCoordinatesFromOccurrance();
    }

    public void setCoordinatesFromOccurrance(){

        logger.info("Seting Coordinates for Occurrance " + this.getId());
        Connection.Response firstResponse = null;

        try {
            firstResponse = Jsoup.connect(GEOCODE_MAPS_API_URL + "?address=" + address + ", " + addressNumber + " - " + city + "&key=" + GEOCODE_MAPS_API_KEY)
                        .method(Connection.Method.GET)
                        .ignoreContentType(true)
                        .execute();

            JSONObject firstResponseJson = new JSONObject(firstResponse.body());

            logger.info("Response API maps: " + firstResponseJson.toString());

            if(firstResponseJson.getString("status").equals("OK")){
                this.latitude = firstResponseJson.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getDouble("lat");
                logger.info("Lat: " + this.latitude);
                this.longitude = firstResponseJson.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getDouble("lng");
                logger.info("Long: " + this.longitude);
            }

        } catch (Exception e){
            logger.info(e.getMessage());
        }

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

    public String getEmergencyDescription() {
        return emergencyDescription;
    }

    public void setEmergencyDescription(String emergencyDescription) {
        this.emergencyDescription = emergencyDescription;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}

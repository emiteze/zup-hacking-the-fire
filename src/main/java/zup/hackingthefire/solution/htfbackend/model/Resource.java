package zup.hackingthefire.solution.htfbackend.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "resources")
public class Resource {

    @Id
    private final String id = RandomStringUtils.randomNumeric(3);

    @NotEmpty
    private String resourceToken;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotEmpty
    private String resourceType;

    private String occurrenceId;

    @NotNull
    private ResourceStatus resourceStatus;

    public enum ResourceStatus{
        FREE, ATTENDING, CHECKINMODE, CHECKOUTMODE
    }

    public Resource(){}

    public Resource(String resourceToken, Double latitude, Double longitude, String resourceType){
        this.resourceToken = resourceToken;
        this.latitude = latitude;
        this.longitude = longitude;
        this.resourceType = resourceType;
    }

    public String getId() {
        return id;
    }

    public String getResourceToken() {
        return resourceToken;
    }

    public void setResourceToken(String resourceToken) {
        this.resourceToken = resourceToken;
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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getOccurrenceId() {
        return occurrenceId;
    }

    public void setOccurrenceId(String occurrenceId) {
        this.occurrenceId = occurrenceId;
    }

    public ResourceStatus getResourceStatus() {
        return resourceStatus;
    }

    public void setResourceStatus(ResourceStatus resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

}

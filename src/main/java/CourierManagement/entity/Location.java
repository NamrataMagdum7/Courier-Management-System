package CourierManagement.entity;

public class Location {
    private long locationID;
    private String locationName;
    private String address;

    public Location() {}

    public Location(long locationID, String locationName, String address) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.address = address;
    }

    // Getters, Setters, and toString()
}
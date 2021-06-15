package model;

import java.util.Date;

public class TourismOffer {
    private int offerId;
    private Type type;
    private String destinationCity;
    private Date departureDate;
    private Date arrivalDate;
    private double pricePerPerson;
    private boolean isAvailable;
    private String accomodationAddress;
    private String accomodationName;
    private AccomodationType accomodationType;

    public TourismOffer(int offerId, Type type, String destinationCity, Date departureDate, Date arrivalDate,
                        double pricePerPerson, boolean isAvailable, String accomodationAddress,
                        String accomodationName, AccomodationType accomodationType){
        this.offerId = offerId;
        this.type = type;
        this.destinationCity = destinationCity;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.pricePerPerson = pricePerPerson;
        this.isAvailable = isAvailable;
        this.accomodationAddress = accomodationAddress;
        this.accomodationName = accomodationName;
        this.accomodationType = accomodationType;
    }
    public int getOfferId(){
        return offerId;
    }
    public void setOfferId(int offerId){
        this.offerId = offerId;
    }
    public Type getType(){
        return type;
    }
    public void setType(Type type){
        this.type = type;
    }
    public String getDestinationCity(){
        return destinationCity;
    }
    public void setDestinationCity(String destinationCity){
        this.destinationCity = destinationCity;
    }
    public Date getDepartureDate(){
        return departureDate;
    }
    public void setDepartureDate(Date departureDate){
        this.departureDate = departureDate;
    }
    public Date getArrivalDate(){
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate){
        this.arrivalDate = arrivalDate;
    }
    public double getPricePerPerson(){
        return pricePerPerson;
    }
    public void setPricePerPerson(double pricePerPerson){
        this.pricePerPerson = pricePerPerson;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    }
    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
    public String getAccomodationAddress(){
        return accomodationAddress;
    }
    public void setAccomodationAddress(String accomodationAddress){
        this.accomodationAddress = accomodationAddress;
    }
    public String getAccomodationName(){
        return accomodationName;
    }
    public void setAccomodationName(String accomodationName){
        this.accomodationName = accomodationName;
    }
    public AccomodationType getAccomodationType(){
        return accomodationType;
    }
    public void setAccomodationType(AccomodationType accomodationType){
        this.accomodationType = accomodationType;
    }
    @Override
    public int hashCode(){
        int prime = 31;
        int result = offerId * prime;
        return result;
    }
    @Override
    public boolean equals(Object o){
        TourismOffer tourismOffer = (TourismOffer) o;
        if(tourismOffer.getOfferId() == this.offerId) {
            return true;
        }
        else return false;
    }
    @Override
    public String toString(){
        return "Offer ID: " + offerId + ", Type: " + type + ", Destination City: " + destinationCity +
                ", Departure Date: " + departureDate + ", Arrival Date: " + arrivalDate + ", Price Per Person: " +
                pricePerPerson + ", Availability: " + isAvailable + ", Accomodation Address: " + accomodationAddress +
                ", Accomodation Name: " + accomodationName + ", Accomodation: " + accomodationType + "\n";
    }
}

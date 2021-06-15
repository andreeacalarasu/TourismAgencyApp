package model;

import java.util.Date;

public class InternationalTourismOffer extends TourismOffer implements Discountable{
        private TransportType transportType;
        private String departureCity;
        private double transportCost;

        public InternationalTourismOffer(int offerId, Type type, String destinationCity, Date departureDate, Date arrivalDate,
                                         double pricePerPerson, boolean isAvailable, String accomodationAddress,
                                         String accomodationName, AccomodationType accomodationType, TransportType transportType,
                                         String departureCity, double transportCost){
            super(offerId, type, destinationCity, departureDate, arrivalDate, pricePerPerson, isAvailable, accomodationAddress,
                    accomodationName, accomodationType);
            this.transportType = transportType;
            this.departureCity = departureCity;
            this.transportCost = transportCost;
        }
        public TransportType getTransportType(){
            return transportType;
        }
        public void setTransportType(TransportType transportType){
            this.transportType = transportType;
        }
        public String getDepartureCity(){
            return departureCity;
        }
        public void setDepartureCity(String departureCity){
            this.departureCity = departureCity;
        }
        public double getTransportCost(){
            return transportCost;
        }
        public void setTransportCost(double transportCost){
            this.transportCost = transportCost;
        }
        @Override
        public String toString(){
            return "Offer ID: " + getOfferId() + ", Type: " + getType() + ", Destination City: " + getDestinationCity() +
                    ", Departure Date: " + getDepartureDate() + ", Arrival Date: " + getArrivalDate() + ", Price Per Person: " +
                    getPricePerPerson() + ", Availability: " + getIsAvailable() + ", Accomodation Address: " + getAccomodationAddress() +
                    ", Accomodation Name: " + getAccomodationName() + ", Accomodation: " + getAccomodationType() + ", Transport Type: " +
                    transportType + ", Departure City: " + departureCity + ", Transport Cost: " + transportCost;
        }
        @Override
        public void applyDiscount(int percentage){
            double actualPrice = this.getPricePerPerson();
            double newPrice = actualPrice - (actualPrice * percentage/100);
            setPricePerPerson(newPrice);
        }
}

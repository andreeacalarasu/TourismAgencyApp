package model;

import java.util.Date;
import java.util.List;

public class Reservation {
    private int reservationId;
    private int offerId;
    private Date reservationDate;
    private boolean isPaid;
    private double finalPrice;
    private List<Tourist> touristList;

    public Reservation(int reservationId, int offerId, Date reservationDate, boolean isPaid, double finalPrice,
                       List<Tourist> touristList) {
        this.reservationId = reservationId;
        this.offerId = offerId;
        this.reservationDate = reservationDate;
        this.isPaid = isPaid;
        this.finalPrice = finalPrice;
        this.touristList = touristList;
    }

    public int getReservationId(){
        return reservationId;
    }
    public void setReservationId(int reservationId){
        this.reservationId = reservationId;
    }
    public int getOfferId(){
        return offerId;
    }
    public void setOfferId(int offerId){
        this.offerId = offerId;
    }
    public Date getReservationDate(){
        return reservationDate;
    }
    public void setReservationDate(Date reservationDate){
        this.reservationDate = reservationDate;
    }
    public boolean getIsPaid(){
        return isPaid;
    }
    public void setIsPaid(boolean isPaid){
        this.isPaid = isPaid;
    }
    public double getFinalPrice(){
        return finalPrice;
    }
    public void setFinalPrice(double finalPrice){
        this.finalPrice = finalPrice;
    }
    public List<Tourist> getTouristList(){
        return touristList;
    }
    public void setTouristList(List<Tourist> touristList){
        this.touristList = touristList;
    }
    @Override
    public int hashCode(){
        int prime = 31;
        int result = reservationId * prime;
        return result;
    }
    @Override
    public boolean equals(Object o){
        Reservation reservation = (Reservation) o;
        if(reservation.getReservationId() == this.reservationId) {
            return true;
        }
        else return false;
    }
    @Override
    public String toString(){
        return "Reservation ID: " + reservationId + ", Offer ID: " + offerId + ", Reservation Date: " +
                reservationDate + ", Is Paid: " + isPaid + ", Final Price: " + finalPrice + ", Tourist List: " +
                touristList + "\n";
    }
}

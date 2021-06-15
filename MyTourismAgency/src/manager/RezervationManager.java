package manager;

import model.Reservation;
import model.TourismOffer;
import model.Tourist;

import java.util.*;

public class RezervationManager {
    public void updateIsPaidRezervation(List<Reservation> reservationList, int reservationId, boolean isPaid) {
        for (Reservation r : reservationList) {
            if (r.getReservationId() == reservationId) {
                r.setIsPaid(isPaid);
            }
        }
    }

    public Reservation findReservationById(List<Reservation> reservationList, int reservationId) {
        Reservation reservation = null;
        for (Reservation r : reservationList) {
            if (r.getReservationId() == reservationId) {
                reservation = r;
            }
        }
        return reservation;
    }

    public boolean findReservationByOfferId(List<Reservation> reservationList, int offerId) {
        boolean reservation = false;
        for (Reservation r : reservationList) {
            if (r.getOfferId() == offerId) {
                reservation = true;
            }
        }
        return reservation;
    }

    public boolean findReservationByDestinationCity(List<Reservation> reservationList, String
            destinationCity) {
        boolean reservation = false;
        for (Reservation r : reservationList) {
            if (r.getTouristList().equals(destinationCity)) {
                reservation = true;
            }
        }
        return reservation;
    }

    public List<Reservation> filterReservationByDestinationCity(List<Reservation> reservationList, String
            destinationCity) {
        List<Reservation> resultReservationList = new ArrayList<>();
        for (Reservation r : reservationList) {
            if (r.getTouristList().equals(destinationCity)) {
                resultReservationList.add(r);
            }
        }
        return resultReservationList;
    }

    public List<Reservation> filterReservationByXOfferId(List<Reservation> reservationList, int offerId) {
        List<Reservation> resultReservationList = new ArrayList<>();
        for (Reservation r : reservationList) {
            if (r.getOfferId() == offerId) {
                resultReservationList.add(r);
            }
        }
        return resultReservationList;
    }

    public List<Reservation> filterReservationCheaperThanXPrice(List<Reservation> reservationList, double
            finalPrice) {
        List<Reservation> resultReservationList = new ArrayList<>();
        for (Reservation r : reservationList) {
            if (r.getFinalPrice() >= finalPrice) {
                resultReservationList.add(r);
            }
        }
        return resultReservationList;
    }

    public List<Reservation> filterReservationByDate(List<Reservation> reservationList, Date reservationDate) {
        List<Reservation> resultReservationList = new ArrayList<>();
        for (Reservation r : reservationList) {
            if (r.getReservationDate() == reservationDate) {
                resultReservationList.add(r);
            }
        }
        return resultReservationList;
    }

    public Map<String, List<Integer>> extractListOfReservationsPerTourist(List<Tourist> touristList,
                                                                          List<Reservation> reservationList) {
        Map<String, List<Integer>> resultMap = new HashMap<>();
        for (Tourist t : touristList) {
            List<Integer> reservationIdList = new ArrayList<>();
            for (Reservation r : reservationList) {
                if (t.getNationalIdNumber().equals(r.getReservationId())) {
                    reservationIdList.add(r.getReservationId());
                }
            }
            resultMap.put(t.getNationalIdNumber(), reservationIdList);
        }
        return resultMap;
    }

    public Map<String, List<Integer>> extractListOfReservationsByDestCity(List<TourismOffer> tourismOffers,
                                                                          List<Reservation> reservationList) {
        Map<String, List<Integer>> resultMap = new HashMap<>();
        Set<String> destinationCitySet = new HashSet<>();
        for (TourismOffer t : tourismOffers) {
            destinationCitySet.add(t.getDestinationCity());
        }
        for (String destinationCity : destinationCitySet) {
            List<Integer> reservationIdList = new ArrayList<>();
            for (TourismOffer to : tourismOffers) {
                if (to.getDestinationCity().equals(destinationCity)) {
                    for (Reservation r : reservationList) {
                        if (r.getOfferId() == to.getOfferId()) {
                            reservationIdList.add(r.getReservationId());
                        }
                    }
                }
            }
            resultMap.put(destinationCity, reservationIdList);

        }
        return resultMap;
    }
}




package main;

import data.DataCreator;
import data.DataReader;
import data.GenerateReservation;
import manager.OfferManager;
import manager.RezervationManager;
import manager.TouristManager;
import model.Reservation;
import model.TourismOffer;
import model.Tourist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static model.AccomodationType.GUESTHOUSE;
import static model.AccomodationType.HOTEL;
import static model.TransportType.PLANE;
import static model.Type.*;

public class Main {
    public static void main(String[] args){
        DataCreator dataCreator = new DataCreator();
        List<Tourist> touristList = dataCreator.createTouristList();
        List<Reservation> reservationList = dataCreator.createReservationList();
        System.out.println("Tourist list is: " + touristList);
        System.out.println("Reservation list is: " + reservationList);

        DataReader dataReader = new DataReader();
        List<TourismOffer> tourismOffers = dataReader.readOffersFromFile();

        GenerateReservation generateReservationFile = new GenerateReservation();
        Reservation r = reservationList.get(0);
        Tourist t = touristList.get(0);
        Tourist t2 = touristList.get(1);
        List<Tourist> listTourist2 = new ArrayList<>();
        listTourist2.add(t);
        listTourist2.add(t2);
        generateReservationFile.generateReservationFile(r, listTourist2);


        OfferManager offerManager = new OfferManager();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String futureDateString = "01/07/2021";
        Date futureDate = null;
        try {
            futureDate = format.parse(futureDateString);
        }
        catch (ParseException e) {
            System.out.println("Invalid input string for date");
        }
        offerManager.updateDepartureDateOfOfferById(tourismOffers, 3, futureDate);
        System.out.println();
        offerManager.updatePricePerPersonByOfferId(tourismOffers, 7, 300);
        System.out.println();
        offerManager.updateAvailabilityOfOfferById(tourismOffers, 2, true);
        System.out.println();
        offerManager.updateTransportCostOfOfferById(tourismOffers, 1, 200);
        System.out.println();
        offerManager.updateAccomodationTypeOfOfferById(tourismOffers, 5, HOTEL);
        System.out.println();
        boolean findOffer = offerManager.findTouristicOfferByCity(tourismOffers, "Marbella");
        System.out.println(findOffer);
        boolean searchForXPrice = offerManager.searchForXPricePerPerson(tourismOffers, 600);
        System.out.println(searchForXPrice);
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        String departureFutureDate = "05/07/2021";
        Date departureDate = null;
        try {
            departureDate = format.parse(futureDateString);
        }
        catch (ParseException e) {
            System.out.println("Invalid input string for date");
        }
        String arrivalFutureDate = "05/07/2021";
        Date arrivalDate = null;
        try {
            arrivalDate = format.parse(futureDateString);
        }
        catch (ParseException e) {
            System.out.println("Invalid input string for date");
        }
        boolean findTouristicOffer = offerManager.findTouristicOfferByDate(tourismOffers, departureDate, arrivalDate);
        System.out.println(findTouristicOffer);
        List<TourismOffer> filterOffers = offerManager.filterOffersByTransportationType(tourismOffers, PLANE);
        System.out.println(filterOffers);
        List<TourismOffer> filterOffers2 = offerManager.filterOffersByType(tourismOffers, SEA);
        System.out.println(filterOffers2);
        List<TourismOffer> filterOffers3 = offerManager.filterOffersByAccomodationType(tourismOffers, GUESTHOUSE);
        System.out.println(filterOffers3);
        List<TourismOffer> filterOffers4 = offerManager.filterOffersByFutureDepartureDate(tourismOffers);
        System.out.println(filterOffers4);
        List<TourismOffer> filterOffers5 = offerManager.filterOffersByAvailability(tourismOffers, true);
        System.out.println(filterOffers5);
        Map<String, List<TourismOffer>> extractList = offerManager.extractListOfAvailableOffersByDestCity(tourismOffers);
        System.out.println(extractList);
        TourismOffer offer1 = new TourismOffer(2, CITYBREAK, "Malaga", departureDate, arrivalDate,
                340, true, "Malaga street", "Malaga Hotel", HOTEL);
        offerManager.addOfferIdToList(tourismOffers, offer1);
        System.out.println();
        offerManager.removeOfferIdFromList(tourismOffers, 4);
        System.out.println();

        RezervationManager rezervationManager = new RezervationManager();
        rezervationManager.updateIsPaidRezervation(reservationList, 344, true);
        Reservation findRezervation = rezervationManager.findReservationById(reservationList, 200);
        System.out.println(findRezervation);
        boolean findRezervation2 = rezervationManager.findReservationByOfferId(reservationList, 5);
        System.out.println(findRezervation2);
        boolean findRezervation3 = rezervationManager.findReservationByDestinationCity(reservationList, "Marbella");
        System.out.println(findRezervation3);
        List<Reservation> filterRezervation = rezervationManager.filterReservationByDestinationCity(reservationList, "Miami");
        System.out.println(filterRezervation);
        List<Reservation> filterRezervation2 = rezervationManager.filterReservationByXOfferId(reservationList, 2);
        System.out.println(filterRezervation2);
        List<Reservation> filterRezervation3 = rezervationManager.filterReservationCheaperThanXPrice(reservationList, 350);
        System.out.println(filterRezervation3);
        SimpleDateFormat format3 = new SimpleDateFormat("dd/MM/yyyy");
        String futureDateString2 = "15/07/2021";
        Date futureDate2 = null;
        try {
            futureDate2 = format.parse(futureDateString);
        }
        catch (ParseException e) {
            System.out.println("Invalid input string for date");
        }
        List<Reservation> filterRezervation4 = rezervationManager.filterReservationByDate(reservationList, futureDate2);
        System.out.println(filterRezervation4);
        Map<String, List<Integer>> extractListOfRezervations = rezervationManager.extractListOfReservationsPerTourist(touristList, reservationList);
        System.out.println(extractListOfRezervations);
        Map<String, List<Integer>> extractListOfRezervations2 = rezervationManager.extractListOfReservationsByDestCity(tourismOffers, reservationList);
        System.out.println(extractListOfRezervations2);

        TouristManager touristManager = new TouristManager();
        touristManager.updateEmailOfTouristByIdNumber(touristList, "2880928124778", "johnsnow@yahoo.com");
        System.out.println();
        touristManager.findTouristByNationalID(touristList, "2860318124998");
        System.out.println();
        touristManager.findTouristByCountry(touristList, "Romania");
        System.out.println();
    }
}


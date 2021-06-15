package manager;

import model.*;

import java.util.*;

public class OfferManager {
    public void updateDepartureDateOfOfferById(List<TourismOffer> offerList, int offerID,
                                                    Date departureDate){
        for(TourismOffer t: offerList){
            if(t.getOfferId() == offerID){
                t.setDepartureDate(departureDate);
            }
        }
    }
    public void updatePricePerPersonByOfferId(List<TourismOffer> offerList, int offerId, double
            pricePerPerson){
        for(TourismOffer t: offerList){
            if(t.getOfferId() == offerId){
                t.setPricePerPerson(pricePerPerson);
            }
        }
    }
    public void updateAvailabilityOfOfferById(List<TourismOffer> offerList, int offerId, boolean
                                                   isAvailable){
        for(TourismOffer t: offerList){
            if(t.getOfferId() == offerId){
                t.setIsAvailable(isAvailable);
            }
        }
    }
    public void updateTransportCostOfOfferById(List<TourismOffer> offerList, int offerId,
                                                    double transportCost){
        for(TourismOffer t: offerList){
            if(t.getOfferId() == offerId){
                if(t instanceof InternationalTourismOffer){
                    InternationalTourismOffer internationalTourismOffer = (InternationalTourismOffer) t;
                    internationalTourismOffer.setTransportCost(transportCost);
                }
            }
        }
    }
    public void updateAccomodationTypeOfOfferById(List<TourismOffer> offerList, int offerId, AccomodationType
                                       accomodationType){
        for(TourismOffer t: offerList){
            if(t.getOfferId() == offerId){
                t.setAccomodationType(accomodationType);
            }
        }

    }
    public boolean findTouristicOfferByCity(List<TourismOffer> tourismOfferList, String destinationCity){
        boolean touristicOffer = false;
        for(TourismOffer t: tourismOfferList){
            if(t.getDestinationCity() == destinationCity){
                touristicOffer = true;
            }
        }
        return touristicOffer;
    }

    public boolean searchForXPricePerPerson(List<TourismOffer> tourismOffers, double pricePerPerson){
        boolean xPricePerPerson = false;
        for(TourismOffer t: tourismOffers){
            if(t.getPricePerPerson() == pricePerPerson){
                xPricePerPerson = true;
            }
        }
        return xPricePerPerson;
    }

    public boolean findTouristicOfferByDate(List<TourismOffer> tourismOffers, Date departureDate, Date
                                         arrivalDate){
        boolean touristicOfferByDate = false;
        for(TourismOffer t: tourismOffers){
            if((t.getDepartureDate() == departureDate) && (t.getArrivalDate() == arrivalDate)){
                touristicOfferByDate = true;
            }
        }
        return touristicOfferByDate;
    }
    public List<TourismOffer> filterOffersByTransportationType(List<TourismOffer> offerList, TransportType
                                                               transportType){
        List<TourismOffer> resultTourismOfferList = new ArrayList<>();
        for(TourismOffer t: offerList){
            if(t instanceof InternationalTourismOffer){
                InternationalTourismOffer internationalTourismOffer = (InternationalTourismOffer) t;
                internationalTourismOffer.setTransportType(transportType);
                resultTourismOfferList.add(t);
            }
        }
        return resultTourismOfferList;
    }

    public List<TourismOffer> filterOffersByType(List<TourismOffer> offerList, Type type){
        List<TourismOffer> resultTourismOfferList = new ArrayList<>();
        for(TourismOffer t: offerList){
            if(t.getType() == type){
                resultTourismOfferList.add(t);
            }
        }
        return resultTourismOfferList;
    }
    public List<TourismOffer> filterOffersByAccomodationType(List<TourismOffer> offerList,
                                                             AccomodationType accomodationType){
        List<TourismOffer> resultTourismOfferList = new ArrayList<>();
        for(TourismOffer t: offerList){
            if(t.getAccomodationType() == accomodationType){
                resultTourismOfferList.add(t);
            }
        }
        return resultTourismOfferList;
    }
    public List<TourismOffer> filterOffersByFutureDepartureDate(List<TourismOffer> offerList){
        List<TourismOffer> resultTourismOfferList = new ArrayList<>();
        Date currentDate = new Date();
        for(TourismOffer t: offerList){
            if(t.getDepartureDate().after(currentDate)){
                resultTourismOfferList.add(t);
            }
        }
        return resultTourismOfferList;
    }
    public List<TourismOffer> filterOffersByAvailability(List<TourismOffer> offerList, boolean isAvailable){
        List<TourismOffer> resultTourismOfferList = new ArrayList<>();
        for(TourismOffer t: offerList){
            if(t.getIsAvailable() == isAvailable){
                resultTourismOfferList.add(t);
            }
        }
        return resultTourismOfferList;
    }
    public Map<String, List<TourismOffer>> extractListOfAvailableOffersByDestCity(List<TourismOffer> offerList){
        Map<String, List<TourismOffer>> resultMap = new HashMap<>();
        Set<String> destinationCitySet = new HashSet<>();
        for(TourismOffer t: offerList){
            destinationCitySet.add(t.getDestinationCity());
        }
        for (String destinationCity : destinationCitySet) {
            for(TourismOffer to: offerList){
                if(to.getDestinationCity().equals(destinationCity)){
                    if(to.getIsAvailable() == true){
                        if(resultMap.containsKey(destinationCity)){
                            List<TourismOffer> newOfferList = resultMap.get(destinationCity);
                            newOfferList.add(to);
                        }
                        else{
                            List<TourismOffer> newOffersList = new ArrayList<>();
                            newOffersList.add(to);
                            resultMap.put(destinationCity, newOffersList);
                        }
                    }
                }
            }
        }
        return resultMap;

    }
    public void addOfferIdToList(List<TourismOffer> offerList, TourismOffer newOffer){
        offerList.add(newOffer);
    }

    public void removeOfferIdFromList(List<TourismOffer> offerList, int offerIdToBeRemoved){
        Iterator<TourismOffer> iterator = offerList.iterator();
        while(iterator.hasNext()){
            TourismOffer offerId = iterator.next();
            if(offerId.getOfferId() == offerIdToBeRemoved){
                offerList.remove(offerId);
                break;
            }
        }
    }
}

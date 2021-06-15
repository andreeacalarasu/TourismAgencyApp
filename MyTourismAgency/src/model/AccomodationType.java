package model;

public enum AccomodationType {
    GUESTHOUSE(1, "guest house"),
    HOTEL(2, "hotel"),
    MOTEL(3, "motel"),
    BANDB(4, "bed and breakfast");

    private int accomodationId;
    private String accomodationType;

    AccomodationType(int accomodationId, String accomodationType){
        this.accomodationId = accomodationId;
        this.accomodationType = accomodationType;
    }

    public int getAccomodationId(){
        return accomodationId;
    }
    public String getAccomodationType(){
        return accomodationType;
    }
}

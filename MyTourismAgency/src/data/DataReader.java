package data;

import model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//lista de oferte turistice citita dintr-un fisier cu rezultat lista (Lista de oferte)
public class DataReader {
    private static final String PATH = "./resources/Offers.txt";
    public List<TourismOffer> readOffersFromFile(){
        List<TourismOffer> offersList = new ArrayList<>();
        File file = new File(PATH);

        if(!file.exists()){
            System.out.println("The file doesn't exist, verify the path.");
            return offersList;
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split(",");

                String offerIdString = words[0].trim();
                String typeString = words[1].trim();
                String destinationCity = words[2].trim();
                String departureDateString = words[3].trim();
                String arrivalDateString = words[4].trim();
                String pricePerPersonString = words[5].trim();
                String isAvailableString = words[6].trim();
                String accomodationAddress = words[7].trim();
                String accomodationName = words[8].trim();
                String accomodationTypeString = words[9].trim();

                int offerId = Integer.parseInt(offerIdString);
                double pricePerPerson = Double.parseDouble(pricePerPersonString);
                boolean isAvailable = Boolean.parseBoolean(isAvailableString);

                Date departureDate = null;
                try{
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    departureDate = sdf.parse(departureDateString);
                }
                catch (ParseException e){
                    System.out.println("Invalid departure date!");
                }

                Date arrivalDate = null;
                try{
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    arrivalDate = sdf.parse(arrivalDateString);
                }
                catch(ParseException e){
                    System.out.println("Invalid arrival date!");
                }

                Type type = Type.valueOf(typeString);
                AccomodationType accomodationType = AccomodationType.valueOf(accomodationTypeString);

                if(words.length == 13){
                    String transportTypeString = words[10].trim();
                    String departureCity = words[11].trim();
                    String transportCostString = words[12].trim();
                    double transportCost = Double.parseDouble(transportCostString);
                    TransportType transportType = TransportType.valueOf(transportTypeString);
                    InternationalTourismOffer internationalTourismOffer = new InternationalTourismOffer(offerId,
                            type, destinationCity, departureDate, arrivalDate, pricePerPerson, isAvailable,
                            accomodationAddress, accomodationName, accomodationType, transportType, departureCity,
                            transportCost);
                    offersList.add(internationalTourismOffer);
                }
                else {
                    TourismOffer tourismOffer = new TourismOffer(offerId,
                            type, destinationCity, departureDate, arrivalDate, pricePerPerson, isAvailable,
                            accomodationAddress, accomodationName, accomodationType);
                    offersList.add(tourismOffer);
                }
            }

        }
        catch(IOException e){
            System.out.println("Invalid reading!");
        }
        finally {
            try {
                if(fileReader != null){
                    fileReader.close();
                }
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch(IOException e){

            }
        }
        return offersList;
    }
}

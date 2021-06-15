package manager;

import model.Tourist;

import java.util.ArrayList;
import java.util.List;

public class TouristManager {
    public void updateEmailOfTouristByIdNumber(List<Tourist> touristList, String nationalIdNumber,
                                                   String emailAddress){
        for(Tourist t: touristList){
            if(t.getNationalIdNumber().equals(nationalIdNumber)){
                t.setEmailAddress(emailAddress);
            }
        }
    }
    public Tourist findTouristByNationalID(List<Tourist> touristList, String nationalIdNumber){
        Tourist tourist = null;
        for(Tourist t: touristList){
            if(t.getNationalIdNumber().equals(nationalIdNumber)){
                tourist = t;
            }
        }
        return tourist;
    }
    public List<Tourist> findTouristByCountry(List<Tourist> touristList, String countryOfResidence){
        List<Tourist> resultTouristList = new ArrayList<>();
        for(Tourist t: touristList){
            if(t.getCountryOfResidence().equals(countryOfResidence)){
                resultTouristList.add(t);
            }
        }
        return resultTouristList;
    }
}

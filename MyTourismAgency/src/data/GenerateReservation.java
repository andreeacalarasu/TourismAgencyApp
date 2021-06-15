package data;

import model.Reservation;
import model.Tourist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateReservation {
    public void generateReservationFile(Reservation reservation, List<Tourist> touristList){
            String directoryName = "./reservations";
            String fileName = "/Reservation.txt";

            File dir = new File(directoryName);
            //we use ! for negation - if the directory doesn't exist then create it
            if(!dir.exists()){
                dir.mkdir();
            }
            File file = new File(dir, fileName);
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("The file failed to create.");
                    //e.printStackTrace();
                }
            }
            //"Reservation ID: " + reservationId + ", Offer ID: " + offerId + ", Reservation Date: " +
        //                reservationDate + ", Is Paid: " + isPaid + ", Final Price: " + finalPrice + ",
        //                Tourist List: " +
        //                touristList;
            FileWriter fw = null;
            BufferedWriter bw = null;
            try{
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);

                bw.write("Your reservation was created successfully in " +
                        reservation.getReservationDate());
                bw.newLine();
                bw.write("ID number: " + reservation.getReservationId());
                bw.newLine();
                bw.write("Offer ID " + reservation.getOfferId());
                bw.newLine();
                bw.write("The payment of the reservation was successfully: " + reservation.getIsPaid());
                bw.newLine();
                bw.write("The final price is: " + reservation.getFinalPrice());
                bw.newLine();
                for(Tourist t : touristList){
                    bw.write("First name of the tourist: " + t.getFirstName());
                    bw.newLine();
                    bw.write("Last name of the tourist: " + t.getLastName());
                    bw.newLine();
                    bw.write("Age of the tourist: " + t.getAge());
                    bw.newLine();
                    bw.write("National ID number of the tourist: " + t.getNationalIdNumber());
                    bw.newLine();
                    bw.write("E-mail address of the tourist is: " + t.getEmailAddress());
                    bw.newLine();
                    bw.write("City of residence of the tourist: " + t.getCityOfResidence());
                    bw.newLine();
                    bw.write("Country of residence of the tourist: " + t.getCountryOfResidence());
                    bw.newLine();
                    bw.write("Phone number of the tourist: " + t.getPhoneNumber());
                    bw.newLine();
                }

                bw.flush();
            }
            catch(IOException e){
                System.out.println("The writing in the file failed.");
            }
            finally {
                try {
                    if(fw != null){
                        fw.close();
                    }
                    if(bw != null) {
                        bw.close();
                    }
                }
                catch(IOException e){

                }
            }

        }
}


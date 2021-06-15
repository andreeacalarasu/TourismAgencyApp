package data;

import model.Reservation;
import model.Tourist;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//creare de ob turisti (list)
public class DataCreator {

        public List<Tourist> createTouristList() {
            Tourist tourist1 = new Tourist("Ana", "Pop", 32, "anapop@gmail.com",
                    "Cluj-Napoca", "Romania", "0755786984",
                    "2890415126778");
            Tourist tourist2 = new Tourist("Carmen", "Enescu", 35,
                    "carmenenescu@gmail.com", "Bucuresti", "Romania",
                    "0756900788", "2860318124998");
            Tourist tourist3 = new Tourist("Florin", "Ghenea", 26,
                    "floring@yahoo.com", "Suceava", "Romania",
                    "0788910455", "1930830124667");
            Tourist tourist4 = new Tourist("Andrei", "Neag", 40, "andrein@gmail.com",
                    "Timisoara", "Romania", "0788934678",
                    "1820912125776");
            Tourist tourist5 = new Tourist("Vasile", "Corujan", 55, "vasile55@yahoo.com",
                    "Arad", "Romania", "0753123777",
                    "1650428125667");
            Tourist tourist6 = new Tourist("John", "Snow", 37, "johnsnow@gmail.com",
                    "Cluj-Napoca", "Romania", "0765899899",
                    "1840123124566");
            Tourist tourist7 = new Tourist("Emma", "Krauss", 34, "emmaK@gmail.com",
                    "Cluj-Napoca", "Romania", "0754571833",
                    "2870328124777");
            Tourist tourist8 = new Tourist("Cristina", "Vasilescu", 60, "crisv@gmail.com",
                    "Constanta", "Romania", "0767889256",
                    "2600629123777");
            Tourist tourist9 = new Tourist("Mihai", "Pop", 35, "mihaip@yahoo.com",
                    "Brasov", "Romania", "0788455267",
                    "1861212124667");
            Tourist tourist10 = new Tourist("Elena", "Chereches", 33, "elenach@gmail.com",
                    "Bucuresti", "Romania", "0788435999",
                    "2880305124778");

            List<Tourist> touristList = new ArrayList<>();
            touristList.add(tourist1);
            touristList.add(tourist2);
            touristList.add(tourist3);
            touristList.add(tourist4);
            touristList.add(tourist5);
            touristList.add(tourist6);
            touristList.add(tourist7);
            touristList.add(tourist8);
            touristList.add(tourist9);
            touristList.add(tourist10);
            return touristList;
        }

        public List<Reservation> createReservationList(){
            List<Tourist> allTouristList = createTouristList();

            List<Tourist> touristList1 = new ArrayList<>();
            touristList1.add(allTouristList.get(0));
            touristList1.add(allTouristList.get(1));
            Date reservationDate1 = new Date();
            Reservation reservation1 = new Reservation(1, 256, reservationDate1,
                    true, 350, touristList1);

            List<Tourist> touristList2 = new ArrayList<>();
            touristList2.add(allTouristList.get(2));
            touristList2.add(allTouristList.get(3));
            Date reservationDate2 = new Date();
            Reservation reservation2 = new Reservation(2, 344, reservationDate2,
                    true, 400, touristList2);

            List<Tourist> touristList3 = new ArrayList<>();
            touristList3.add(allTouristList.get(4));
            touristList3.add(allTouristList.get(5));
            Date reservationDate3 = new Date();
            Reservation reservation3 = new Reservation(3, 543, reservationDate3,
                    true, 700, touristList3);

            List<Tourist> touristList4 = new ArrayList<>();
            touristList4.add(allTouristList.get(6));
            touristList4.add(allTouristList.get(7));
            Date reservationDate4 = new Date();
            Reservation reservation4 = new Reservation(4, 233, reservationDate4,
                    true, 2500, touristList4);

            List<Tourist> touristList5 = new ArrayList<>();
            touristList5.add(allTouristList.get(8));
            touristList5.add(allTouristList.get(9));
            Date reservationDate5 = new Date();
            Reservation reservation5 = new Reservation(5, 122, reservationDate5,
                    true, 1200, touristList5);
            List<Reservation> reservationList = new ArrayList<>();
            reservationList.add(reservation1);
            reservationList.add(reservation2);
            reservationList.add(reservation3);
            reservationList.add(reservation4);
            reservationList.add(reservation5);
            return reservationList;
        }
}

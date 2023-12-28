package src.main.lesson8.presenters;

import src.main.lesson8.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    void cancelReservation(int reservationNo);

    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

}

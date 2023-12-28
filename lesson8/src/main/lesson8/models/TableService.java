package src.main.lesson8.models;

import src.main.lesson8.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableService implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {

        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                if (isTableOccupied(table, reservationDate)) {
                    throw new RuntimeException("Столик уже занят. Попробуйте забронировать другой столик.");
                }

                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    private boolean isTableOccupied(Table table, Date reservationDate) {
        for (Reservation reservation : table.getReservations()) {
            if (reservation.getDate().equals(reservationDate)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void cancelReservation(int reservationNo) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == reservationNo) {
                    reservation.cancel();
                    return;
                }
            }
        }
        throw new RuntimeException("Некорректный номер бронирования");
    }

    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservation && !reservation.isCancelled()) {
                    table.cancelReservation(oldReservation);
                    Reservation newReservation = new Reservation(table, reservationDate, name);
                    table.getReservations().add(newReservation);
                    return newReservation.getId();
                }
            }
        }
        throw new RuntimeException("Некорректный номер бронирования или бронь уже отменена");
    }
}
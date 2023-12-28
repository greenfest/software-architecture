package src.main.lesson8.presenters;

import src.main.lesson8.models.Table;

import java.util.Collection;

public interface View {

    void showTables(Collection<Table> tables);

    void showReservationTableResult(int reservationNo, String errorMessage);

    void showCancelReservationTableResult(int reservationNo);

    void showChangeReservationResult(int reservationNo);

    void registerObserver(ViewObserver observer);

}

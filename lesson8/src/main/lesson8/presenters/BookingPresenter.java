package src.main.lesson8.presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateUILoadTables(){
        view.showTables(model.loadTables());
    }

    private void updateUIReservationTableResult(int reservationNo, String errorMessage) {
        view.showReservationTableResult(reservationNo, errorMessage);
    }

    public void updateUIChangeReservationTableResult(int reservationNo){
        view.showChangeReservationResult(reservationNo);
    }

    public void updateUICancelReservationTableResult(int reservationNo){
        view.showCancelReservationTableResult(reservationNo);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIReservationTableResult(reservationNo, null);
        } catch (Exception e) {
            updateUIReservationTableResult(-1, e.getMessage());
        }
    }

    @Override
    public void onCancelReservation(int reservationNo) {
        try {
            model.cancelReservation(reservationNo);
            updateUICancelReservationTableResult(reservationNo);
        } catch (Exception e) {
            updateUICancelReservationTableResult(-1);
        }
    }

    @Override
    public void onChangeReservation(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int newReservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            updateUIChangeReservationTableResult(newReservationNo);
        } catch (Exception e) {
            updateUIChangeReservationTableResult(-1);
        }
    }

}

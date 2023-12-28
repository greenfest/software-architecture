package src.main.lesson8.views;

import src.main.lesson8.models.Table;
import src.main.lesson8.presenters.View;
import src.main.lesson8.presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class BookingView implements View {

    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo, String errorMessage) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        } else {
            System.out.println(errorMessage);
        }
    }

    @Override
    public void showCancelReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Бронь столика #%d успешно отменена.\n", reservationNo);
        else
            System.out.println("Не удалось отменить бронь. Повторите попытку позже.");
    }

    @Override
    public void showChangeReservationResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Бронь успешно изменена. Новый номер брони: #%d\n", reservationNo);
        else
            System.out.println("Не удалось изменить бронь. Повторите попытку позже.");
    }

    public void cancelReservationTable(int reservationNo) {
        for (ViewObserver observer : observers) {
            observer.onCancelReservation(reservationNo);
        }
    }

    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (ViewObserver observer : observers) {
            observer.onChangeReservation(oldReservation, reservationDate, tableNo, name);
        }
    }


    public void reservationTable(Date orderDate, int tableNo, String name){
        for (ViewObserver observer : observers){
            observer.onReservationTable(orderDate, tableNo, name);
        }
    }

}

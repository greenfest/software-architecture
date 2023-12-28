package src.main.lesson8;

import src.main.lesson8.models.TableService;
import src.main.lesson8.presenters.BookingPresenter;
import src.main.lesson8.presenters.Model;
import src.main.lesson8.views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Model tableService = new TableService();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableService, bookingView);
        bookingPresenter.updateUILoadTables();
        Date date = new Date();
        bookingView.reservationTable(date, 3, "Станислав");
        bookingView.reservationTable(date, 3, "Виктор");
        bookingView.changeReservationTable(1001, new Date(), 1, "Станислав");
        bookingView.cancelReservationTable(1002);
        bookingView.reservationTable(date, 3, "Виктор");

    }

}

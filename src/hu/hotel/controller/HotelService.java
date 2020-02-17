package hu.hotel.controller;

import hu.hotel.model.domain.Book;

import java.util.List;

public class HotelService {

    private List<Book> booking;

    public HotelService(List<Book> booking) {
        this.booking = booking;
    }

    public int getBooksCount() {
        return booking.size();
    }
}

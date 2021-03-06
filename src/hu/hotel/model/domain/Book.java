package hu.hotel.model.domain;

import hu.hotel.model.service.DayUtil;
import hu.hotel.model.service.PriceCalculator;

import java.util.Map;
import java.util.TreeMap;

public class Book {

    private final int id;
    private final int room;
    private final int arrival;
    private final int departure;
    private final int numberOfGuest;
    private final boolean breakfast;
    private final String name;

    public Book(int id, int room, int arrival, int departure, int numberOfGuest, boolean breakfast, String name) {
        this.id = id;
        this.room = room;
        this.arrival = arrival;
        this.departure = departure;
        this.numberOfGuest = numberOfGuest;
        this.breakfast = breakfast;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getRoom() {
        return room;
    }

    public int getArrival() {
        return arrival;
    }

    public int getDeparture() {
        return departure;
    }

    public int getNumberOfGuest() {
        return numberOfGuest;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return departure - arrival;
    }

    public int getTotalPrice() {
        return PriceCalculator.getTotalPrice(this);
    }

    public Map<Integer, Integer> getGuestNightMap() {
        Map<Integer, Integer> guestNights = new TreeMap<>();
        for (int day = arrival; day < departure; day++) {
            int key = DayUtil.getMonth(day);
            int value = guestNights.containsKey(key) ? guestNights.get(key) + numberOfGuest : numberOfGuest;
            guestNights.put(key, value);
        }
        return guestNights;
    }
}

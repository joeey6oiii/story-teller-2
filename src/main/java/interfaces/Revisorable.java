package interfaces;

import places.Hotel;

public interface Revisorable {
    void getHotelRoomsInfo();
    void comparisonRoomCost(Hotel hotel, Hotel... hotels);
    void lackOfInhabitants(Hotel hotel, Hotel... hotels);
}

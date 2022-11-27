public interface IHotelInfo {
    void getHotelRoomInfo(TimeExpression time, Status status);
    void comparisonRoomCost(Hotel hotel, Hotel ... hotels);
    void lackOfInhabitants(Hotel hotel, Hotel ... hotels);
}

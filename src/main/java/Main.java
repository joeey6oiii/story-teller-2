public class Main {
    public static void main(String[] args) {
        Human traveler1 = new Neznayka("Незнайка");
        Human traveler2 = new Kozlik("Козлик");

        They they = new They(traveler1, traveler2);

        Currency santik = new Currency("Сантик");

        Hotel hotel = new Hotel("Гостиница \"Экономическая\"");
        Room room = new Room("Номер");
        hotel.setRoom(room);
        room.setRoomCost(50);
        hotel.setCurrency(santik);

        Hotel hotel2 = new Hotel();
        Room room2 = new Room();
        hotel2.setRoom(room2);
        room2.setRoomCost(95);

        hotel.arrive(they);
        System.out.println(traveler1.getLocation());
        hotel.famous(Status.CHEAPNESS);

        hotel.getHotelRoom(TimeExpression.OVERNIGHT, Status.CONVENIENT);
        hotel.comparisonRoomCost(hotel, hotel2);
    }
}

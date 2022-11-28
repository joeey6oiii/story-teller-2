public class Main {
    public static void main(String[] args) {
        Human traveler1 = new Neznayka("Незнайка");
        Human traveler2 = new Kozlik("Козлик");
        Every every = new Every("Каждый");
        They they = new They(traveler1, traveler2);

        Hotel hotel = new Hotel("Гостиница \"Экономическая\"");
        Room room = new Room("Номер", 1);
        hotel.setRoom(room);
        room.setRoomCost(50);
        room.setItems(new Table("Стол"), new Chair("Стулья"),
                new Cabinet("Платяной шкаф"), new WaterDispenser("Рукомойник"),
                new Mirror("Зеркало"), new Televisor("Телевизор"));
        hotel.setCurrency(new Money("Сантик"));
        hotel.setTenants(new Human("Житель 1"), new Human("Житель 2"),
                new Human("Житель 3"));

        Hotel hotel2 = new Hotel("другая гостиница 1");
        Room room2 = new Room();
        hotel2.setRoom(room2);
        room2.setRoomCost(95);
        hotel2.addTenants(new Human("1"), new Human("2"),
                new Human("3"), new Human("4"));
        hotel.setSignBoard(new SignBoard(new Inscription("\"Самые дешевые номера на свете\"")));

        Hotel hotel3 = new Hotel("другая гостиница 2");
        Room room3 = new Room();
        hotel3.setRoom(room3);
        room3.setRoomCost(85);
        hotel3.addTenants(new Human("1"), new Human("2"));

        hotel.takeArrive(they);
        hotel.famous(Status.CHEAPNESS);

        hotel.getHotelRoomInfo(TimeExpression.OVERNIGHT, Status.CONVENIENT);
        hotel.comparisonRoomCost(hotel, hotel2, hotel3);

        hotel.lackOfInhabitants(hotel, hotel2, hotel3);

        every.read(hotel.getSignBoard(0));
        every.go(hotel);

        they.findPlace(hotel.getRoom());
        room.setName("Комната");

        room.getItems();

        room.addItems(new Shelf("полочка"));
    }
}

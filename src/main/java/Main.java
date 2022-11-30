public class Main {
    public static void main(String[] args) {
        Human traveler1 = new Neznayka("Незнайка");
        Human traveler2 = new Kozlik("Козлик");
        They they = new They(traveler1, traveler2);
        Human human1 = new Human("Человек 1");
        Human human2 = new Human("Человек 2");
        Human human3 = new Human("Человек 3");
        They humans = new They(human1, human2, human3);

        Hat hatTraveler1 = new Hat("Шляпа");
        Hat hatTraveler2 = new Hat("Шляпа");

        traveler1.setItems(new Money("Сантик", 40), hatTraveler1);
        traveler2.setItems(new Money("Сантик", 40), hatTraveler2);

        Hotel hotel = new Hotel("Гостиница \"Экономическая\"");
        Room room = new Room("Номер", 1);
        room.setRoomCost(50);
        Cabinet cabinet = new Cabinet("Платяной шкаф");
        room.setItems(new Table("Стол"), new Chair("Стулья"),
                cabinet, new WaterDispenser("Рукомойник"),
                new Mirror("Зеркало"), new Televisor("Телевизор"));
        hotel.setRooms(room);
        hotel.setCurrency(new Money("Сантик"));
        hotel.setTenants(new Human("Житель 1"), new Human("Житель 2"),
                new Human("Житель 3"));

        Hotel hotel2 = new Hotel("другая гостиница 1");
        Room room2 = new Room("Номер", 1);
        room2.setRoomCost(95);
        hotel2.setRooms(room2);
        hotel2.addTenants(new Human("1"), new Human("2"),
                new Human("3"), new Human("4"));
        hotel.setSignBoard(new SignBoard("Вывеска", 7,
                new Inscription("\"Самые дешевые номера на свете\"")));

        Hotel hotel3 = new Hotel("другая гостиница 2");
        Room room3 = new Room("Номер", 1);
        room3.setRoomCost(85);
        hotel3.setRooms(room3);
        hotel3.addTenants(new Human("житель 1"), new Human(" житель 2"));

        hotel.takeArrive(they.getEntities());
        hotel.famous(Status.CHEAPNESS);

        hotel.getHotelRoomsInfo();
        hotel.comparisonRoomCost(hotel, hotel2, hotel3);

        hotel.lackOfInhabitants(hotel, hotel2, hotel3);

        humans.read(hotel.getSignBoard(7));
        humans.go(hotel);

        they.payToGet(new Key("Ключ", room.getRoomCost(), room.getId()));

        they.find(hotel.getRoom(1));
        they.tryAccess(room);

        room.setName("Комната");
        room.getItems();

        they.open(cabinet);
        Shelf shelf = new Shelf("полочка");
        room.addItems(shelf);
        traveler1.put(hatTraveler1, shelf);
        traveler2.put(hatTraveler2, shelf);

    }
}

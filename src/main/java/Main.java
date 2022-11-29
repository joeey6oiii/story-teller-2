public class Main {
    public static void main(String[] args) {
        Human traveler1 = new Neznayka("Незнайка");
        Human traveler2 = new Kozlik("Козлик");
        They they = new They(traveler1, traveler2);
        Human human1 = new Human("Человек 1");
        Human human2 = new Human("Человек 2");
        Human human3 = new Human("Человек 3");
        They humans = new They(human1, human2, human3);

        traveler1.setItems(new Money("Сантик", 41), new Hat("Шляпа", 1));
        traveler2.setItems(new Money("Сантик", 40), new Hat("Шляпа", 2));

        Hotel hotel = new Hotel("Гостиница \"Экономическая\"");
        Room room = new Room("Номер", 1);
        room.setRoomCost(50);
        room.setItems(new Table("Стол", 3), new Chair("Стулья"),
                new Cabinet("Платяной шкаф", 5), new WaterDispenser("Рукомойник", 6),
                new Mirror("Зеркало", 7), new Televisor("Телевизор", 6));
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
        hotel.setSignBoard(new SignBoard("Вывеска", 8,
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

        humans.read(hotel.getSignBoard(8));
        humans.go(hotel);

        they.payToGet(new Key("Ключ", room.getId(), room.getRoomCost()));

        they.findPlace(hotel.getRoom(1));
        room.setName("Комната");

        room.getItems();

        room.addItems(new Shelf("полочка", 9));
    }
}

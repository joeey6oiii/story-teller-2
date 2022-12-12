import entities.*;
import enums.*;
import items.*;
import items.forItems.*;
import places.*;

public class Main {
    public static void main(String[] args) {
        Human traveler1 = new Neznayka("Незнайка");
        Human traveler2 = new Kozlik("Козлик");
        They they = new They(traveler1, traveler2);
        They humans = new They();
        for(int i = 0; i < Math.round((Math.random() * 5)); i++){
            Human human = new Human();
            humans.addPeople(human);
        }

        Hat hatTraveler1 = new Hat("Шляпа");
        Hat hatTraveler2 = new Hat("Шляпа");

        traveler1.setItems(new Money("Сантик",
                Math.round((Math.random() * 35 + 20))), hatTraveler1);
        traveler2.setItems(new Money("Сантик",
                 Math.round((Math.random() * 35 + 10))), hatTraveler2);

        Soup soup = new Soup("Перловый суп");
        Pie pie = new Pie("Пирог"); // TODO: plural forms of meals - every meal is a new obj
        Porridge porridge = new Porridge("Гречневая каша");
        Butter butter = new Butter("Масло");

        Canteen canteen = new Canteen("Столовая"); // TODO: meal list
        traveler1.setLocation(canteen);
        traveler2.setLocation(canteen);

        Hotel hotel = new Hotel("Гостиница \"Экономическая\"");
        Room room = new Room("Номер", 1);
        room.setRoomCost(Math.round(((Math.random() + 24) * 2)));
        Cabinet cabinet = new Cabinet("Платяной шкаф");
        Bell bell = new Bell("Звонок");
        Peephole peephole = new Peephole("Глазок");
        ElectricSwitch electricSwitch = new ElectricSwitch("Электрический выключатель");
        Uvula uvula = new Uvula("Язычок", new Inscription("Сантик"));
        Hole hole = new Hole("Отверстие");
        Wall wall = new Wall("Стена", hole);
        wall.setHole(hole);
        cabinet.setShelves(new Shelf("полочка"), new Shelf("полка"));
        room.setItems(new Table("Стол"), new Chair("Стулья"),
                cabinet, new WaterDispenser("Рукомойник"),
                new Mirror("Зеркало"), new Televisor("Телевизор"), electricSwitch);
        hotel.setRooms(room);
        for(int i = room.getId() + 1; i < Math.round((Math.random() * 6)); i++){
            Room room1 = new Room("Номер", i);
            room1.setRoomCost((int) ((Math.random() + 49) * 1.06));
            hotel.setRooms(room1);
        }
        for (int i = 0; i < Math.round((Math.random() * 5)); i++){
            Human tenant = new Human();
            hotel.addTenants(tenant);
        }
        hotel.setCurrency(new Money("Сантик"));
        hotel.setSignBoard(new SignBoard("Вывеска", 7,
                new Inscription("\"Самые дешевые номера на свете\"")));

        Hotel hotel2 = new Hotel("Другая гостиница 1");
        for(int i = 0; i < Math.round((Math.random() * 5)); i++){
            Room room2 = new Room();
            room2.setRoomCost(Math.round(((Math.random() + 85) * 1.162)));
            hotel2.addRooms(room2);
        }
        for(int i = 0; i < Math.round((Math.random() * 3)); i++) {
            Human tenant = new Human();
            hotel2.addTenants(tenant);
        }

        Hotel hotel3 = new Hotel("Другая гостиница 2");
        for(int i = 0; i < Math.round((Math.random() * 5)); i++){
            Room room3 = new Room();
            room3.setRoomCost(Math.round(((Math.random() + 75) * 1.12)));
            hotel3.addRooms(room3);
        }
        for(int i = 0; i < Math.round((Math.random() * 6) - 1); i++) {
            Human tenant = new Human();
            hotel3.addTenants(tenant);
        }

        they.eat(soup, pie, porridge, butter); // TODO: they eat special meals from meal list
        traveler1.praise(soup, porridge, pie); // TODO: random praise (meals list dependency)

        hotel.takeArrive(they.getEntities());
        hotel.famous(Status.CHEAPNESS);

        hotel.getHotelRoomsInfo();
        hotel.comparisonRoomCost(hotel, hotel2, hotel3);

        hotel.lackOfInhabitants(hotel, hotel2, hotel3);

        humans.read(hotel.getSignBoard(7));
        humans.go(hotel);

        they.payToGet(new Key("Ключ", room.getRoomCost(), room.getId()));

        they.find(hotel.getRoom(1));
        they.tryAccess(hotel.getRoom(1));

        room.setName("Комната");
        room.getItems();

        they.open(cabinet);
        traveler1.put(hatTraveler1, cabinet.getShelf(0));
        traveler2.put(hatTraveler2, cabinet.getShelf(0));
        they.wantRest();

        bell.ring(TimeExpression.RIGHT_NOW);

        room.replaceItem(electricSwitch, peephole);
        peephole.blink(Colors.randomColor());

        they.see(peephole);
        uvula.leanOut(wall.getHole());
        they.notice(uvula);
        uvula.getInscription(0).blink(Colors.randomColor());
    }
}
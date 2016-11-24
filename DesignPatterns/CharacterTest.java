
public class CharacterTest {

    public static void main(String[] args) {
        Character dan = new King();
        dan.setWeapon(new SwordBehavior());
        dan.fight();
        Character mary = new Queen();
        mary.setWeapon(new BowAndArrowBehavior());
        mary.fight();
        Character beinz = new Troll();
        beinz.setWeapon(new AxeBehavior());
        beinz.fight();
        Character winnah = new Knight();
        winnah.setWeapon(new KnifeBehavior());
        winnah.fight();
    }


}

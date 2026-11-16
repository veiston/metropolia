package flyweight.rpg;

public class RoadTile extends Tile {
    public RoadTile() {
        super('R', "road");
    }

    @Override
    public void action() {
        System.out.println("Walking along the road");
    }
}

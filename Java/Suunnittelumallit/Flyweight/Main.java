import java.util.Random;

public class Main {
    private static final int MAP_WIDTH = 30;
    private static final int MAP_HEIGHT = 10;

    public static void main(String[] args) {
        // Test shared tile types
        TileFactory factory = new TileFactory();
        GameMap map = new GameMap(MAP_WIDTH, MAP_HEIGHT, factory, new Random());

        map.render();

        System.out.println();
        System.out.println("Tiles on map: " + map.getTileCount());
        System.out.println("TileType objects created: " + factory.getCreatedCount());
    }
}

import java.util.List;
import java.util.Random;

// Grid position is the extrinsic state; the TileType itself is shared
public class GameMap {
    private final TileType[][] tiles;

    public GameMap(int width, int height, TileFactory factory, Random random) {
        tiles = new TileType[height][width];
        List<String> tileNames = factory.getTileNames();
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                String name = tileNames.get(random.nextInt(tileNames.size()));
                tiles[row][column] = factory.getTileType(name);
            }
        }
    }

    public int getTileCount() {
        return tiles.length * tiles[0].length;
    }

    public void render() {
        for (TileType[] row : tiles) {
            StringBuilder line = new StringBuilder();
            for (TileType tile : row) {
                line.append(tile.symbol());
            }
            System.out.println(line);
        }
    }
}

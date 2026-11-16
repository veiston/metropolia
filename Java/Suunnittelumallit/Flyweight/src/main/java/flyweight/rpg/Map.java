package flyweight.rpg;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public abstract class Map {
    private Tile[][] tiles;
    private Random random = new Random();

    public Map(int width, int height) {
        tiles = new Tile[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                tiles[row][column] = createTile();
            }
        }
    }

    // Factory method
    protected abstract Tile createTile();

    protected Tile createRandomTile(List<Supplier<Tile>> tileTypes) {
        return tileTypes.get(random.nextInt(tileTypes.size())).get();
    }

    public Tile getTile(int row, int column) {
        return tiles[row][column];
    }

    public int getWidth() {
        return tiles[0].length;
    }

    public int getHeight() {
        return tiles.length;
    }

    public void display() {
        for (Tile[] row : tiles) {
            StringBuilder line = new StringBuilder();
            for (Tile tile : row) {
                line.append(tile.getCharacter()).append(' ');
            }
            System.out.println(line);
        }
    }
}

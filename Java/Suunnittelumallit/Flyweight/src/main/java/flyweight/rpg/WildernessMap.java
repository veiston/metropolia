package flyweight.rpg;

import java.util.List;
import java.util.function.Supplier;

public class WildernessMap extends Map {
    private static final List<Supplier<Tile>> TILE_TYPES = List.of(SwampTile::new, WaterTile::new, ForestTile::new);

    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        return createRandomTile(TILE_TYPES);
    }
}

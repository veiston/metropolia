package flyweight.rpg;

import java.util.List;
import java.util.function.Supplier;

public class CityMap extends Map {
    private static final List<Supplier<Tile>> TILE_TYPES = List.of(RoadTile::new, ForestTile::new, BuildingTile::new);

    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        return createRandomTile(TILE_TYPES);
    }
}

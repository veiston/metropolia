import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileFactory {
    private static final Map<String, Character> SYMBOLS_BY_NAME = Map.of(
            "grass", '.',
            "forest", 'T',
            "water", '~',
            "mountain", '^',
            "road", '#');

    private final Map<String, TileType> createdTypes = new HashMap<>();

    // Returns the shared instance, creating it only on first request
    public TileType getTileType(String name) {
        return createdTypes.computeIfAbsent(name, this::createTileType);
    }

    public List<String> getTileNames() {
        return List.copyOf(SYMBOLS_BY_NAME.keySet());
    }

    public int getCreatedCount() {
        return createdTypes.size();
    }

    private TileType createTileType(String name) {
        Character symbol = SYMBOLS_BY_NAME.get(name);
        if (symbol == null) {
            throw new IllegalArgumentException("Unknown tile: " + name);
        }
        return new TileType(name, symbol);
    }
}

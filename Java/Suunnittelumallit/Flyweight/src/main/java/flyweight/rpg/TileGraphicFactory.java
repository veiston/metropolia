package flyweight.rpg;

import java.util.HashMap;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

// Flyweight factory: one shared graphic per tile type
public class TileGraphicFactory {
    public static final int TILE_SIZE = 32;

    private HashMap<String, Color> colorsByType = new HashMap<>();
    private HashMap<String, Image> graphicsByType = new HashMap<>();

    public TileGraphicFactory() {
        colorsByType.put("swamp", Color.DARKOLIVEGREEN);
        colorsByType.put("water", Color.STEELBLUE);
        colorsByType.put("road", Color.TAN);
        colorsByType.put("forest", Color.FORESTGREEN);
        colorsByType.put("building", Color.FIREBRICK);
    }

    public Image getGraphic(Tile tile) {
        return graphicsByType.computeIfAbsent(tile.getType(), type -> createGraphic(tile));
    }

    public int getGraphicCount() {
        return graphicsByType.size();
    }

    private Image createGraphic(Tile tile) {
        System.out.println("Graphic created for " + tile.getType());
        Canvas canvas = new Canvas(TILE_SIZE, TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(colorsByType.getOrDefault(tile.getType(), Color.GRAY));
        gc.fillRect(0, 0, TILE_SIZE, TILE_SIZE);
        gc.setFill(Color.WHITE);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText(String.valueOf(tile.getCharacter()), TILE_SIZE / 2.0, TILE_SIZE / 2.0);

        return canvas.snapshot(null, null);
    }
}

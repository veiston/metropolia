package flyweight.rpg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {
    private static final boolean IS_CITY_MAP = true;
    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 15;

    private TileGraphicFactory graphicFactory = new TileGraphicFactory();

    public static void main(String[] args) {
        launch(args);
    }

    // Factory method
    public Map createMap() {
        if (IS_CITY_MAP) {
            return new CityMap(MAP_WIDTH, MAP_HEIGHT);
        }
        return new WildernessMap(MAP_WIDTH, MAP_HEIGHT);
    }

    @Override
    public void start(Stage stage) {
        Map map = createMap();
        map.display();

        int tileSize = TileGraphicFactory.TILE_SIZE;
        Canvas canvas = new Canvas(map.getWidth() * tileSize, map.getHeight() * tileSize);
        render(map, canvas.getGraphicsContext2D());
        System.out.println("Tiles: " + map.getWidth() * map.getHeight() + ", shared graphics: " + graphicFactory.getGraphicCount());

        stage.setScene(new Scene(new StackPane(canvas)));
        stage.setTitle("Flyweight RPG Map");
        stage.show();
    }

    // Tile position is the extrinsic state, the graphic is shared
    private void render(Map map, GraphicsContext gc) {
        int tileSize = TileGraphicFactory.TILE_SIZE;
        for (int row = 0; row < map.getHeight(); row++) {
            for (int column = 0; column < map.getWidth(); column++) {
                gc.drawImage(graphicFactory.getGraphic(map.getTile(row, column)), column * tileSize, row * tileSize);
            }
        }
    }
}

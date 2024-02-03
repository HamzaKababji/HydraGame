package se2203.hydragame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class HydraHead extends ImageView {
    private int headSize;
    private int currentGridX;
    private int currentGridY;

    public HydraHead(Image image, int size){
        super(image);
        this.headSize = size;
        this.setFitHeight(40);
        this.setFitWidth(40);
    }

    public void putIn(int gridX, int gridY, GridPane board){
        this.currentGridX = gridX;
        this.currentGridY = gridY;
        board.add(this, gridX, gridY);
    }

    public int getHeadSize() {
        return headSize;
    }

    public int getCurrentGridX() {
        return currentGridX;
    }

    public int getCurrentGridY() {
        return currentGridY;
    }

}

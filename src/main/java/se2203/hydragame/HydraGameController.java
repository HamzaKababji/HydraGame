package se2203.hydragame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class HydraGameController implements Initializable {

    @FXML
    public Slider headSizeSlider;
    @FXML
    public Button playButton;
    @FXML
    public GridPane grid;
    @FXML
    public Label totalCutsLabel;

    private int[][] gridArr = new int[16][16];
    private int totalCuts = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        totalCutsLabel.setDisable(true);
        for (int[] row : gridArr) Arrays.fill(row, 0);
    }

    @FXML
    public void reset(ActionEvent event) {
        totalCutsLabel.setDisable(true);
        totalCutsLabel.setText("");
        headSizeSlider.setValue(4);
        playButton.setDisable(false);
        headSizeSlider.setDisable(false);
        grid.getChildren().clear();
        for (int[] row : gridArr) Arrays.fill(row, 0);
        totalCuts = 0;
    }

    @FXML
    public void play(ActionEvent event) {
        playButton.setDisable(true);
        headSizeSlider.setDisable(true);
        generateHead(HydraHeadsFactory.getHead((int) headSizeSlider.getValue()));
    }

    public void generateHead(HydraHead head) {
        Random random = new Random();
        int gridX, gridY;

        do {
            gridX = random.nextInt(16);
            gridY = random.nextInt(16);
        } while (gridArr[gridY][gridX] != 0);

        gridArr[gridY][gridX] = head.getHeadSize();
        head.putIn(gridX, gridY, grid);
        head.setOnMouseClicked(this::addNextHead);
    }

    public void addNextHead(MouseEvent event) {
        HydraHead thisHead = (HydraHead) event.getSource();
        int gridX = thisHead.getCurrentGridX();
        int gridY = thisHead.getCurrentGridY();
        grid.getChildren().remove(thisHead);
        gridArr[gridY][gridX] = 0;
        totalCuts++;

        if (thisHead.getHeadSize() > 1) {
            int numberOfHeads = new Random().nextInt(2) + 2; // Generates 2 or 3

            for (int i = 0; i < numberOfHeads; i++) {
                generateHead(HydraHeadsFactory.getHead(thisHead.getHeadSize() - 1));
            }
        }

        if (checkWinCondition()) {
            totalCutsLabel.setDisable(false);
            totalCutsLabel.setText("Good Job! - You have cut " + totalCuts + " Hydra Heads");
        }
    }

    private boolean checkWinCondition() {
        for (int i = 0; i < gridArr.length; i++) {
            for (int j = 0; j < gridArr[i].length; j++) {
                if (gridArr[i][j] != 0) return false;
            }
        }
        return true;
    }
}

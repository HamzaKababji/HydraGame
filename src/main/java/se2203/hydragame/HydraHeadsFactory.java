package se2203.hydragame;

import javafx.scene.image.Image;

public class HydraHeadsFactory {

    private static final Image HeadSize1 = new Image("file:src/main/resources/se2203/hydragame/HeadSize1.png");
    private static final Image HeadSize2 = new Image("file:src/main/resources/se2203/hydragame/HeadSize2.png");
    private static final Image HeadSize3 = new Image("file:src/main/resources/se2203/hydragame/HeadSize3.png");
    private static final Image HeadSize4 = new Image("file:src/main/resources/se2203/hydragame/HeadSize4.png");
    private static final Image HeadSize5 = new Image("file:src/main/resources/se2203/hydragame/HeadSize5.png");
    private static final Image HeadSize6 = new Image("file:src/main/resources/se2203/hydragame/HeadSize6.png");


    private HydraHeadsFactory(){
    }

    public static HydraHead getHead(int size){
        return switch (size){
            case 1 -> new HydraHead(HeadSize1, 1);
            case 2 -> new HydraHead(HeadSize2, 2);
            case 3 -> new HydraHead(HeadSize3, 3);
            case 4 -> new HydraHead(HeadSize4, 4);
            case 5 -> new HydraHead(HeadSize5, 5);
            case 6 -> new HydraHead(HeadSize6, 6);
            default -> throw new IllegalArgumentException("Invalid Size");
        };
    }
}

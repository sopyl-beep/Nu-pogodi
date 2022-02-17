package sample;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Kurak extends Label {
    public Kurak(){

        this.setPrefSize(52,53);
        Image chick = new Image("images/kurak.png");
        BackgroundImage a = new BackgroundImage(chick, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background aa = new Background(a);
        this.setBackground(aa);
        this.setVisible(false);
    }


}

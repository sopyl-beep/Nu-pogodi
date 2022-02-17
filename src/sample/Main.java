package sample;


import javafx.fxml.FXMLLoader;


import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {


    static Pane pane = new Pane();
    static Label left_wolf = new Label();
    static Label left_upper_basket = new Label();
    static Label left_lower_basket = new Label();
    static Label right_wolf = new Label();
    static Label right_upper_basket = new Label();
    static Label right_lower_basket = new Label();
    static Kurak first = new Kurak();
    static Kurak second = new Kurak();
    static Kurak third = new Kurak();
    static Label score_label = new Label("яйца: 0");


    @Override
    public void start(Stage primaryStage) throws IOException {

        Image background = new Image("images/background-empty.png");
        BackgroundImage back = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background bbb = new Background(back);
        pane.setBackground(bbb);


        //DODAJEMY RUCHOME CZĘSCI WILCZKA(4 pozycje koszyka i 2 pozycje ciała)

        //lewy wilczek
        left_wolf.setLayoutX(563);
        left_wolf.setLayoutY(358);
        left_wolf.setPrefSize(140,243);
        Image l_w= new Image("images/l_wolf.png");
        BackgroundImage l_www = new BackgroundImage(l_w, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background l_ww = new Background(l_www);
        left_wolf.setBackground(l_ww);
        pane.getChildren().add(left_wolf);

        //prawy wilczek
        right_wolf.setLayoutX(682);
        right_wolf.setLayoutY(362);
        right_wolf.setPrefSize(132,242);
        Image r_w= new Image("images/r_wolf.png");
        BackgroundImage r_www = new BackgroundImage(r_w, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background r_ww = new Background(r_www);
        right_wolf.setBackground(r_ww);
        right_wolf.setVisible(false);
        pane.getChildren().add(right_wolf);

        //lewy górny koszyk
        left_upper_basket.setLayoutX(480);
        left_upper_basket.setLayoutY(350);
        left_upper_basket.setPrefSize(122,122);
        Image lu_b = new Image("images/lu_basket.png");
        BackgroundImage lu_bbb = new BackgroundImage(lu_b, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background lu_bb = new Background(lu_bbb);
        left_upper_basket.setBackground(lu_bb);
        pane.getChildren().add(left_upper_basket);

        //lewy dolny koszyk
        left_lower_basket.setLayoutX(473);
        left_lower_basket.setLayoutY(473);
        left_lower_basket.setPrefSize(132,107);
        Image ll_b = new Image("images/ll_basket.png");
        BackgroundImage ll_bbb = new BackgroundImage(ll_b, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background ll_bb = new Background(ll_bbb);
        left_lower_basket.setBackground(ll_bb);
        left_lower_basket.setVisible(false);
        pane.getChildren().add(left_lower_basket);

        //prawy górny koszyk
        right_upper_basket.setLayoutX(793);
        right_upper_basket.setLayoutY(371);
        right_upper_basket.setPrefSize(103,114);
        Image ru_b = new Image("images/ru_basket.png");
        BackgroundImage ru_bbb = new BackgroundImage(ru_b, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background ru_bb = new Background(ru_bbb);
        right_upper_basket.setBackground(ru_bb);
        right_upper_basket.setVisible(false);
        pane.getChildren().add(right_upper_basket);

        //prawy dolny koszyk
        right_lower_basket.setLayoutX(779);
        right_lower_basket.setLayoutY(485);
        right_lower_basket.setPrefSize(115,100);
        Image rl_b = new Image("images/rl_basket.png");
        BackgroundImage rl_bbb = new BackgroundImage(rl_b, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background rl_bb = new Background(rl_bbb);
        right_lower_basket.setBackground(rl_bb);
        right_lower_basket.setVisible(false);
        pane.getChildren().add(right_lower_basket);


        //robimy 3 kuraki, które pokazują, ile szans już się straciło
        first.setLayoutX(711);
        first.setLayoutY(291);
        second.setLayoutX(711+52);
        second.setLayoutY(291);
        third.setLayoutX(711+104);
        third.setLayoutY(291);
        pane.getChildren().addAll(first,second,third);

        //panel wyniku
        score_label.setPrefSize(235, 100);
        score_label.setLayoutX(709);
        score_label.setLayoutY(188);
        score_label.setFont(new Font(35));
        pane.getChildren().add(score_label);


        //robimy proste kontrolki na przyciskach "konsoli"
        Button lu = new Button();
        lu.setLayoutX(150);
        lu.setLayoutY(500);
        lu.setPrefSize(100,100);
        lu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                set_lu();
                Driver.pos = 0;
            }
        });
        lu.setOpacity(0);
        pane.getChildren().add(lu);

        Button ll = new Button();
        ll.setLayoutX(150);
        ll.setLayoutY(640);
        ll.setPrefSize(100,100);
        ll.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                set_ll();
                Driver.pos = 1;
            }
        });
        ll.setOpacity(0);
        pane.getChildren().add(ll);

        Button rl = new Button();
        rl.setLayoutX(1120);
        rl.setLayoutY(640);
        rl.setPrefSize(100,100);
        rl.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                set_rl();
                Driver.pos = 3;
            }
        });
        rl.setOpacity(0);
        pane.getChildren().add(rl);

        Button ru = new Button();
        ru.setLayoutX(1120);
        ru.setLayoutY(500);
        ru.setPrefSize(100,100);
        ru.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                set_ru();
                Driver.pos = 2;
            }
        });
        ru.setOpacity(0);
        pane.getChildren().add(ru);


        //TWORZENIE SCENY
        Scene scene = new Scene(pane, 1360,816);
        primaryStage.setScene(scene);
        primaryStage.show();
        //primaryStage.onClose

        Driver driver = new Driver();
        driver.start();
    }
    public static void main(String[] args) {
        launch(args);

    }



    //funkcyjki do przestawiania grafiki wilczka
    public static void set_lu(){

        right_wolf.setVisible(false);
        left_wolf.setVisible(true);
        left_lower_basket.setVisible(false);
        left_upper_basket.setVisible(true);
        right_lower_basket.setVisible(false);
        right_upper_basket.setVisible(false);
    }
    public static void set_ll(){

        right_wolf.setVisible(false);
        left_wolf.setVisible(true);
        left_lower_basket.setVisible(true);
        left_upper_basket.setVisible(false);
        right_lower_basket.setVisible(false);
        right_upper_basket.setVisible(false);

    }
    public static void set_ru(){

        right_wolf.setVisible(true);
        left_wolf.setVisible(false);
        left_lower_basket.setVisible(false);
        left_upper_basket.setVisible(false);
        right_lower_basket.setVisible(false);
        right_upper_basket.setVisible(true);
    }
    public static void set_rl(){

        right_wolf.setVisible(true);
        left_wolf.setVisible(false);
        left_lower_basket.setVisible(false);
        left_upper_basket.setVisible(false);
        right_lower_basket.setVisible(true);
        right_upper_basket.setVisible(false);
    }



    //odpalanie animacji jajek!
    public static void egg_lu(){

        Circle egg = new Circle();
        egg.setRadius(15);
        egg.setLayoutX(386);
        egg.setLayoutY(328);
        Image eggage = new Image("images/egg.png");
        egg.setFill(new ImagePattern(eggage));

        //ROBIMY ANIMACJĘ!

        //Poruszanie się!
        Path path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(100, 65));

        PathTransition pathTransition = new PathTransition(Duration.seconds(5), egg);
        pathTransition.setPath(path);
        pathTransition.setNode(egg);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);

        //OBROTY
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), egg);
        rotateTransition.setByAngle(720);

        //ŁĄCZENIE OBU ANIMACJI!
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(pathTransition,rotateTransition);

        //a teraz zniknięcie jajka, żeby nie zostawało na środku
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.01), egg);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(parallelTransition,fadeTransition);
        sequentialTransition.play();

        pane.getChildren().add(egg);

    }

    public static void egg_ll(){

        Circle egg = new Circle();
        egg.setRadius(15);
        egg.setLayoutX(386);
        egg.setLayoutY(448);
        Image eggage = new Image("images/egg.png");
        egg.setFill(new ImagePattern(eggage));

        Path path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(100, 65));

        PathTransition pathTransition = new PathTransition(Duration.seconds(5), egg);
        pathTransition.setPath(path);
        pathTransition.setNode(egg);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), egg);
        rotateTransition.setByAngle(720);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(pathTransition,rotateTransition);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.01), egg);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(parallelTransition,fadeTransition);
        sequentialTransition.play();

        pane.getChildren().add(egg);

    }

    public static void egg_rl(){

        Circle egg = new Circle();
        egg.setRadius(15);
        egg.setLayoutX(992);
        egg.setLayoutY(438);
        Image eggage = new Image("images/egg.png");
        egg.setFill(new ImagePattern(eggage));

        Path path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(-105, 67));

        PathTransition pathTransition = new PathTransition(Duration.seconds(5), egg);
        pathTransition.setPath(path);
        pathTransition.setNode(egg);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), egg);
        rotateTransition.setByAngle(-720);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(pathTransition,rotateTransition);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.01), egg);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(parallelTransition,fadeTransition);
        sequentialTransition.play();

        pane.getChildren().add(egg);

    }

    public static void egg_ru(){

        Circle egg = new Circle();
        egg.setRadius(15);
        egg.setLayoutX(992);
        egg.setLayoutY(325);
        Image eggage = new Image("images/egg.png");
        egg.setFill(new ImagePattern(eggage));

        Path path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(-102, 66));

        PathTransition pathTransition = new PathTransition(Duration.seconds(5), egg);
        pathTransition.setPath(path);
        pathTransition.setNode(egg);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), egg);
        rotateTransition.setByAngle(-720);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(pathTransition,rotateTransition);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.01), egg);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(parallelTransition,fadeTransition);
        sequentialTransition.play();

        pane.getChildren().add(egg);
    }


    //funkcyjki do pokazywania kuraków

    public static void first_k(){
        first.setVisible(true);
    }
    public static void second_k(){
        second.setVisible(true);
    }
    public static void third_k(){
        third.setVisible(true);
    }

    public static void update_score(){
        score_label.setText("яйца: " + Driver.score);
    }

}

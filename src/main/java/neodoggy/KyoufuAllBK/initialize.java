package neodoggy.KyoufuAllBK;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class initialize {
    public static void leafINIT(ImageView leaf,int y){
        leaf.setLayoutX(-25);
        leaf.setLayoutY(y);
        leaf.setFitWidth(25);
        leaf.setPreserveRatio(true);
    }

    public static void stageINIT(Stage stage){
        stage.getIcons().add(new Image(Objects.requireNonNull(main.class.getResourceAsStream("icon-512.png"))));
        stage.setTitle("強風オールバック");
    }

    public static void characterINIT(ImageView character){
        character.setX(-510);
        character.setY(30);
        character.setFitHeight(720);
        character.setPreserveRatio(true);
    }

    public static void hitINIT(ImageView what){
        what.setX(-150);
        what.setY(330);
        what.setFitWidth(150);
        what.setPreserveRatio(true);
    }

    public static void playButtonINIT(Button playBT){
        playBT.setGraphic(new ImageView(new Image(Objects.requireNonNull(main.class.getResourceAsStream("playBT.png")))));
        playBT.setLayoutX(250);
        playBT.setLayoutY(260);
        playBT.setBackground(null);
    }

    public static void againButtonINIT(Button playBT){
        playBT.setGraphic(new ImageView(new Image(Objects.requireNonNull(main.class.getResourceAsStream("playBT.png")))));
        playBT.setLayoutX(250);
        playBT.setLayoutY(500);
        playBT.setBackground(null);
    }

    public static void changeSButtonINIT(Button changeBT){
        ImageView imgV=new ImageView(new Image(Objects.requireNonNull(main.class.getResourceAsStream("norMD.png"))));
        imgV.setPreserveRatio(true);
        imgV.setFitWidth(150);
        changeBT.setGraphic(imgV);
        changeBT.setLayoutX(570);
        changeBT.setLayoutY(595);
        changeBT.setBackground(null);
    }

    public static void creditButtonINIT(Button credBT){
        ImageView imgV=new ImageView(new Image(Objects.requireNonNull(main.class.getResourceAsStream("usagi.png"))));
        imgV.setPreserveRatio(true);
        imgV.setFitWidth(100);
        credBT.setGraphic(imgV);
        credBT.setLayoutX(0);
        credBT.setLayoutY(610);
        credBT.setBackground(null);
    }

    public static void changeSbuttonIMGvINIT(ImageView imgV){
        imgV.setPreserveRatio(true);
        imgV.setFitWidth(150);
    }

    public static void deadBoomINIT(ImageView deadBoom){
        deadBoom.setFitHeight(900);
        deadBoom.setPreserveRatio(true);
        deadBoom.setX(-240);
        deadBoom.setY(-50);
        deadBoom.setOpacity(0);
        deadBoom.setScaleX(1);
    }

    public static void textINIT(Text text, int size, String what, int x, int y){
        text.setX(x);
        text.setY(y);
        text.setText(what);
        text.setFill(Color.WHITE);
        text.setFont(Font.loadFont(main.class.getResourceAsStream("GN-KillGothic-U-KanaNA.ttf"),size));
    }

    public static void pachiINIT(ImageView pachi){
        pachi.setX(520);
        pachi.setY(520);
        pachi.setFitHeight(200);
        pachi.setPreserveRatio(true);
        pachi.setOpacity(0);
    }

    public static void imgvINIT(ImageView imageView,int x,int y,int w){
        imageView.setFitWidth(w);
        imageView.setPreserveRatio(true);
        imageView.setX(x);
        imageView.setY(y);
    }
}

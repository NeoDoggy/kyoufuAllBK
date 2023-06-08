package neodoggy.KyoufuAllBK;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Objects;

public class animations {
    private static final Image frame1=new Image(Objects.requireNonNull(main.class.getResourceAsStream("sprite-sheet15.png")));
    private static final Image frame2=new Image(Objects.requireNonNull(main.class.getResourceAsStream("sprite-sheet14.png")));
    private static final Image frame3=new Image(Objects.requireNonNull(main.class.getResourceAsStream("sprite-sheet13.png")));
    private static final Image frame4=new Image(Objects.requireNonNull(main.class.getResourceAsStream("sprite-sheet12.png")));
    private static final Image frame5=new Image(Objects.requireNonNull(main.class.getResourceAsStream("sprite-sheet11.png")));
    private static final Image frame6=new Image(Objects.requireNonNull(main.class.getResourceAsStream("sprite-sheet9.png")));
    private static final Image frame7=new Image(Objects.requireNonNull(main.class.getResourceAsStream("sprite-sheet10.png")));

    private static final Image s1=new Image(Objects.requireNonNull(main.class.getResourceAsStream("trS15.png")));
    private static final Image s2=new Image(Objects.requireNonNull(main.class.getResourceAsStream("trS14.png")));
    private static final Image s3=new Image(Objects.requireNonNull(main.class.getResourceAsStream("trS13.png")));
    private static final Image s4=new Image(Objects.requireNonNull(main.class.getResourceAsStream("trS12.png")));
    private static final Image s5=new Image(Objects.requireNonNull(main.class.getResourceAsStream("trS11.png")));
    private static final Image s6=new Image(Objects.requireNonNull(main.class.getResourceAsStream("trS9.png")));
    private static final Image s7=new Image(Objects.requireNonNull(main.class.getResourceAsStream("trS10.png")));

    private static final Image dead1=new Image(Objects.requireNonNull(main.class.getResourceAsStream("爆炸-sheet0.png")));
    private static final Image dead2=new Image(Objects.requireNonNull(main.class.getResourceAsStream("爆炸-sheet1.png")));
    private static final Image dead3=new Image(Objects.requireNonNull(main.class.getResourceAsStream("爆炸-sheet2.png")));
    private static final Image dead4=new Image(Objects.requireNonNull(main.class.getResourceAsStream("爆炸-sheet3.png")));
    private static final Image dead5=new Image(Objects.requireNonNull(main.class.getResourceAsStream("爆炸-sheet4.png")));
    private static final Image dead6=new Image(Objects.requireNonNull(main.class.getResourceAsStream("爆炸-sheet5.png")));
    private static final Image dead7=new Image(Objects.requireNonNull(main.class.getResourceAsStream("爆炸-sheet6.png")));
    private static final Image dead8=new Image(Objects.requireNonNull(main.class.getResourceAsStream("爆炸-sheet7.png")));
    private static final Image birdF1=new Image(Objects.requireNonNull(main.class.getResourceAsStream("birdF1.png")));
    private static final Image birdF2=new Image(Objects.requireNonNull(main.class.getResourceAsStream("birdF2.png")));
    private static final Image ballon=new Image(Objects.requireNonNull(main.class.getResourceAsStream("ballon.png")));
    private static final Image pachi1=new Image(Objects.requireNonNull(main.class.getResourceAsStream("pachi1.png")));
    private static final Image pachi2=new Image(Objects.requireNonNull(main.class.getResourceAsStream("pachi2.png")));

    public static void pachiPachi(Timeline timeline,ImageView pachi){
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,new KeyValue(pachi.imageProperty(),pachi1)),//2
                new KeyFrame(Duration.millis(175),new KeyValue(pachi.imageProperty(),pachi2)),
                new KeyFrame(Duration.millis(350),new KeyValue(pachi.imageProperty(),pachi1))
        );
    }

    public static void charMoving1(Timeline timeline, ImageView sprite,boolean isShih) {
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,new KeyValue(sprite.imageProperty(),isShih?s2:frame2)),//2
                new KeyFrame(Duration.millis(175),new KeyValue(sprite.imageProperty(),isShih?s4:frame4)),//4
                new KeyFrame(Duration.millis(325),new KeyValue(sprite.imageProperty(),isShih?s3:frame3)),//3
                new KeyFrame(Duration.millis(375),new KeyValue(sprite.imageProperty(),isShih?s3:frame3)),//3
                new KeyFrame(Duration.millis(525),new KeyValue(sprite.imageProperty(),isShih?s4:frame4)),//4
                new KeyFrame(Duration.millis(675),new KeyValue(sprite.imageProperty(),isShih?s1:frame1)),//1
                new KeyFrame(Duration.millis(725),new KeyValue(sprite.imageProperty(),isShih?s1:frame1)),//1
                new KeyFrame(Duration.millis(875),new KeyValue(sprite.imageProperty(),isShih?s4:frame4)),//4
                new KeyFrame(Duration.millis(1025),new KeyValue(sprite.imageProperty(),isShih?s5:frame5)),//5
                new KeyFrame(Duration.millis(1075),new KeyValue(sprite.imageProperty(),isShih?s5:frame5)),//5
                new KeyFrame(Duration.millis(1225),new KeyValue(sprite.imageProperty(),isShih?s4:frame4)),//4
                new KeyFrame(Duration.millis(1375),new KeyValue(sprite.imageProperty(),isShih?s2:frame2)),//2
                new KeyFrame(Duration.millis(1425),new KeyValue(sprite.imageProperty(),isShih?s2:frame2))//2
        );
    }

    public static void flyAway1(Timeline timeline,ImageView sprite,boolean isShih){
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,new KeyValue(sprite.imageProperty(),isShih?s6:frame6)),
                new KeyFrame(Duration.millis(175),new KeyValue(sprite.imageProperty(),isShih?s7:frame7)),
                new KeyFrame(Duration.millis(325),new KeyValue(sprite.imageProperty(),isShih?s6:frame6))
        );
    }

    public static void hitFly(Timeline timeline,ImageView sprite){
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(500),new KeyValue(sprite.layoutYProperty(),-50)),
                new KeyFrame(Duration.millis(750),new KeyValue(sprite.layoutYProperty(),0)),
                new KeyFrame(Duration.millis(875),new KeyValue(sprite.layoutYProperty(),-10)),
                new KeyFrame(Duration.millis(1000),new KeyValue(sprite.layoutYProperty(),0))
        );
    }

    public static void bobbing(Timeline timeline, Button sprite){
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,new KeyValue(sprite.layoutYProperty(),595)),
                new KeyFrame(Duration.millis(500),new KeyValue(sprite.layoutYProperty(),585)),
                new KeyFrame(Duration.millis(750),new KeyValue(sprite.layoutYProperty(),595)),
                new KeyFrame(Duration.millis(875),new KeyValue(sprite.layoutYProperty(),590)),
                new KeyFrame(Duration.millis(1000),new KeyValue(sprite.layoutYProperty(),595))
        );
    }

    public static void deadBoom(Timeline timeline,ImageView sprite){
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,new KeyValue(sprite.imageProperty(),dead1)),
                new KeyFrame(Duration.millis(100),new KeyValue(sprite.imageProperty(),dead2)),
                new KeyFrame(Duration.millis(200),new KeyValue(sprite.imageProperty(),dead3)),
                new KeyFrame(Duration.millis(300),new KeyValue(sprite.imageProperty(),dead4)),
                new KeyFrame(Duration.millis(400),new KeyValue(sprite.imageProperty(),dead5)),
                new KeyFrame(Duration.millis(500),new KeyValue(sprite.imageProperty(),dead6)),
                new KeyFrame(Duration.millis(600),new KeyValue(sprite.imageProperty(),dead7)),
                new KeyFrame(Duration.millis(700),new KeyValue(sprite.imageProperty(),dead8))
        );
    }

    public static void leafFlowing(Timeline timeline,ImageView leaf,double startS){
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,new KeyValue(leaf.xProperty(),10),new KeyValue(leaf.rotateProperty(),0)),
                new KeyFrame(Duration.seconds(startS+2),new KeyValue(leaf.xProperty(),745),new KeyValue(leaf.rotateProperty(),360))
        );
    }

    public static void hitFlying(Timeline timeline,ImageView hit,int what){
        if(what==1){
            timeline.getKeyFrames().clear();
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,new KeyValue(hit.imageProperty(),birdF1)),
                    new KeyFrame(Duration.millis(150),new KeyValue(hit.imageProperty(),birdF2)),
                    new KeyFrame(Duration.millis(300),new KeyValue(hit.imageProperty(),birdF1))
            );
        }
        else if(what==2){
            timeline.getKeyFrames().clear();
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,new KeyValue(hit.imageProperty(),ballon),new KeyValue(hit.rotateProperty(),0)),
                    new KeyFrame(Duration.millis(150),new KeyValue(hit.imageProperty(),ballon),new KeyValue(hit.rotateProperty(),45)),
                    new KeyFrame(Duration.millis(300),new KeyValue(hit.imageProperty(),ballon),new KeyValue(hit.rotateProperty(),0))
            );
        }
    }
}

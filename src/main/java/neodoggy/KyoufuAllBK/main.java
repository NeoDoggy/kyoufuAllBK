package neodoggy.KyoufuAllBK;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class main extends Application {
    //dirs
    String rcDir="lib\\mp3\\";

    //-----------------------------------------------------------------------------------------------------------------------
    //SpritesDefault
    private final Image leaf1=new Image(Objects.requireNonNull(main.class.getResourceAsStream("leaf0.png")));
    private final Image leaf2=new Image(Objects.requireNonNull(main.class.getResourceAsStream("leaf1.png")));
    private final Image leaf3=new Image(Objects.requireNonNull(main.class.getResourceAsStream("leaf2.png")));
    private final Image leaf4=new Image(Objects.requireNonNull(main.class.getResourceAsStream("leaf3.png")));
    private final Image leaf5=new Image(Objects.requireNonNull(main.class.getResourceAsStream("leaf4.png")));
    private final Image leaf6=new Image(Objects.requireNonNull(main.class.getResourceAsStream("leaf5.png")));
    private final Image bird =new Image(Objects.requireNonNull(main.class.getResourceAsStream("birdF1.png")));
    private final Image birdH =new Image(Objects.requireNonNull(main.class.getResourceAsStream("birdH.png")));
    private final Image ballon=new Image(Objects.requireNonNull(main.class.getResourceAsStream("ballon.png")));
    private final Image dead1=new Image(Objects.requireNonNull(main.class.getResourceAsStream("爆炸-sheet0.png")));
    private final Image charaHit=new Image(Objects.requireNonNull(main.class.getResourceAsStream("sprite-sheet1.png")));
    private final Image frame1=new Image(Objects.requireNonNull(main.class.getResourceAsStream("sprite-sheet15.png")));
    private final Image charaHitS=new Image(Objects.requireNonNull(main.class.getResourceAsStream("trS1.png")));
    private final Image frame1S=new Image(Objects.requireNonNull(main.class.getResourceAsStream("trS15.png")));
    private final Image pachiImg=new Image(Objects.requireNonNull(main.class.getResourceAsStream("pachi1.png")));
    private final Image teacherS=new Image(Objects.requireNonNull(main.class.getResourceAsStream("S.png")));
    private final Image cngBTnor=new Image(Objects.requireNonNull(main.class.getResourceAsStream("norMD.png")));
    private final Image cngBTs=new Image(Objects.requireNonNull(main.class.getResourceAsStream("sMD.png")));
    private final Image credBG=new Image(Objects.requireNonNull(main.class.getResourceAsStream("credBG.png")));

    //-----------------------------------------------------------------------------------------------------------------------
    //media
    private Media popM=new Media(new File(rcDir+"0.mp3").toURI().toString());
    private Media popC=new Media(new File(rcDir+"2.mp3").toURI().toString());
    private Media popS=new Media(new File(rcDir+"1.mp3").toURI().toString());
    private Media powM=new Media(new File(rcDir+"P.mp3").toURI().toString());
    private Media bgm=new Media(new File(rcDir+"bgm.mp3").toURI().toString());
    private Media deadM=new Media(new File(rcDir+"pp.mp3").toURI().toString());
    private Media pachiM=new Media(new File(rcDir+"c.mp3").toURI().toString());
    //media player
    MediaPlayer pop0=new MediaPlayer(popM);
    MediaPlayer pop1=new MediaPlayer(popS);
    MediaPlayer pop2=new MediaPlayer(popC);
    MediaPlayer mPlayer=new MediaPlayer(bgm);
    MediaPlayer powMplayer=new MediaPlayer(powM);
    MediaPlayer deadMplayer=new MediaPlayer(deadM);
    MediaPlayer pachiMplayer=new MediaPlayer(pachiM);

    //-----------------------------------------------------------------------------------------------------------------------
    //panes
    private Pane gamePane =new Pane();
    private Pane menuPane =new Pane();
    private Pane diedPane =new Pane();
    private Pane credPane =new Pane();

    //-----------------------------------------------------------------------------------------------------------------------
    //sprites
    //ImageViews
    private ImageView hit=new ImageView(bird);
    private ImageView mainC=new ImageView(frame1);
    private ImageView menuC=new ImageView(frame1);
    private ImageView deadBoom=new ImageView(dead1);
    private ImageView pachi=new ImageView(pachiImg);
    private ImageView cngIMGVnor=new ImageView(cngBTnor);
    private ImageView cngIMGVs=new ImageView(cngBTs);
    private ImageView credBGIMGV=new ImageView(credBG);
    private ImageView leafI1=new ImageView(leaf1);
    private ImageView leafI2=new ImageView(leaf2);
    private ImageView leafI3=new ImageView(leaf3);
    private ImageView leafI4=new ImageView(leaf4);
    private ImageView leafI5=new ImageView(leaf5);
    private ImageView leafI6=new ImageView(leaf6);
    private Group leafs=new Group(leafI1,leafI2,leafI3,leafI4,leafI5,leafI6);
    //texts
    private Text score=new Text();
    private Text bgTxt=new Text();
    private Text menuTxt=new Text();
    private Text diedTxt=new Text();
    private Text finScore=new Text();
    private Text worldRankTxt=new Text();
    private Text worldRankScore=new Text();
    private Text overThousandText=new Text();
    private Text creditText=new Text();
    private Text newHighScoreTxt=new Text();
    //Rectangles
    private Rectangle bgMain=new Rectangle(720,720);
    private Rectangle bgMenu=new Rectangle(720,720);
    private Rectangle bgDied=new Rectangle(720,720);
    private Rectangle bgCred=new Rectangle(720,720);
    private Rectangle faderDN =new Rectangle(720,720);
    private Rectangle faderUP=new Rectangle(720,720);

    //-----------------------------------------------------------------------------------------------------------------------
    //buttons
    private Button playBT=new Button();
    private Button againBT=new Button();
    private Button chngSBT=new Button();
    private Button crediBT=new Button();
    private Button crediBTbk=new Button();

    //-----------------------------------------------------------------------------------------------------------------------
    //stages
    private Stage mainStage;

    //-----------------------------------------------------------------------------------------------------------------------
    //scenes
    private Scene menuS=menuScene();
    private Scene gameS=gameScene();
    private Scene diedS=diedScene();
    private Scene credS=credScene();

    //-----------------------------------------------------------------------------------------------------------------------
    //vars
    private HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
    private long tmpNowT=0;
    private long tmpNowT2=0;
    private long tmpNowT3=0;
    private long startTime=System.currentTimeMillis();
    private double nowSpeed=0;
    private double nowScore=0;
    private int rnd=5;
    private int nowScene=2;
    private int nowHit=1;
    private int nextThousand=1;
    private boolean hitChar=false;
    private boolean hitCanFly=false;
    private boolean running=true;
    private boolean clickAB=true;
    private boolean overThousand=false;
    private boolean isShih=false;

    //-----------------------------------------------------------------------------------------------------------------------
    //functions
    private void initial(){
        initialize.creditButtonINIT(crediBTbk);
        initialize.creditButtonINIT(crediBT);
        initialize.changeSbuttonIMGvINIT(cngIMGVnor);
        initialize.changeSbuttonIMGvINIT(cngIMGVs);
        initialize.changeSButtonINIT(chngSBT);
        initialize.leafINIT(leafI1, 50);
        initialize.leafINIT(leafI2,160);
        initialize.leafINIT(leafI3,270);
        initialize.leafINIT(leafI4,380);
        initialize.leafINIT(leafI5,490);
        initialize.leafINIT(leafI6,600);
        initialize.stageINIT(mainStage);
        initialize.characterINIT(mainC);
        initialize.characterINIT(menuC);
        initialize.playButtonINIT(playBT);
        initialize.deadBoomINIT(deadBoom);
        initialize.textINIT(score,20,"0",20,30);
        initialize.textINIT(bgTxt,100,"強風オールバック",10,360);
        initialize.textINIT(menuTxt,100,"強風オールバック",10,360);
        initialize.textINIT(overThousandText,100,"0",20,105);
        initialize.textINIT(diedTxt,100,"SCORE",20,105);
        initialize.textINIT(finScore,75,"0",20,200);
        initialize.textINIT(worldRankTxt,100,"世界ランク",20,330);
        initialize.textINIT(worldRankScore,75,"NULL",20,425);
        initialize.textINIT(creditText,55,"本家様：\nYukopi-強風オールバック\n\nプログラミング：\nニオ/Ivan\n\n絵：\nACh/ナコ/ニオ",20,120);
        initialize.textINIT(newHighScoreTxt,30,"NEW HIGH!!",355,160);
        initialize.hitINIT(hit);
        initialize.againButtonINIT(againBT);
        initialize.pachiINIT(pachi);
        initialize.imgvINIT(credBGIMGV,360,475,350);

        mPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        pop0.setCycleCount(1);
        deadMplayer.setCycleCount(1);
        powMplayer.setCycleCount(1);
        powMplayer.setOnEndOfMedia(powMplayer::stop);

        faderDN.setFill(Color.valueOf("#ffde5c"));
        faderDN.setOpacity(0.4);
        faderUP.setFill(Color.valueOf("#ffde5c"));
        faderUP.setOpacity(0);
        bgMain.setFill(Color.valueOf("#ffde5c"));
        bgMenu.setFill(Color.valueOf("#ffde5c"));
        bgDied.setFill(Color.valueOf("#ffde5c"));
        bgCred.setFill(Color.valueOf("#ffde5c"));

        gamePane.getChildren().addAll(bgMain,bgTxt,leafs,overThousandText,mainC,deadBoom,score,pachi,hit,faderUP);
        menuPane.getChildren().addAll(bgMenu,menuTxt,menuC,faderDN,playBT,chngSBT,crediBT);
        diedPane.getChildren().addAll(bgDied,finScore,diedTxt,worldRankTxt,worldRankScore,newHighScoreTxt,againBT);
        credPane.getChildren().addAll(bgCred,credBGIMGV,creditText,crediBTbk);
    }

    private void changeTOshih(){
        leafI1.setImage(isShih?teacherS:leaf1);
        leafI2.setImage(isShih?teacherS:leaf2);
        leafI3.setImage(isShih?teacherS:leaf3);
        leafI4.setImage(isShih?teacherS:leaf4);
        leafI5.setImage(isShih?teacherS:leaf5);
        leafI6.setImage(isShih?teacherS:leaf6);
    }

    private void afterInit(){
        startTime=System.currentTimeMillis();
        mainC.setLayoutX(0);
        mainC.setOpacity(1);
        faderUP.setOpacity(0);
        score.setOpacity(1);
        overThousandText.setOpacity(0);
        running=true;
        hitChar=false;
        hitCanFly=false;
        hit.setOpacity(1);
        hit.setLayoutX(-150);
        rnd=5;
        nowHit=1;
        nowScene=2;
        nowScore=0;
        nowSpeed=0;
        nextThousand=1;
        mPlayer.stop();
        menuC.setImage(isShih?frame1S:frame1);
        mainC.setImage(isShih?frame1S:frame1);
        deadMplayer.setOnEndOfMedia(deadMplayer::stop);
    }

    private void fadeAway(){
        FadeTransition ft=new FadeTransition(Duration.millis(250),playBT);ft.setFromValue(1.0);ft.setToValue(0);ft.setCycleCount(1);
        FadeTransition ft2=new FadeTransition(Duration.millis(250),crediBT);ft2.setFromValue(1.0);ft2.setToValue(0);ft2.setCycleCount(1);
        FadeTransition ft3=new FadeTransition(Duration.millis(250),chngSBT);ft3.setFromValue(1.0);ft3.setToValue(0);ft3.setCycleCount(1);
        FadeTransition ftF=new FadeTransition(Duration.millis(250), faderDN);ftF.setFromValue(0.4);ftF.setToValue(0);ftF.setCycleCount(1);
        ft2.play();ft3.play();ftF.play();ft.play();
        ft.setOnFinished(e->{
            afterInit();
            gameStart();
            changeToScene(gameS);
            crediBT.setOpacity(1);
            chngSBT.setOpacity(1);
            playBT.setOpacity(1);
            faderDN.setOpacity(0.4);
        });
    }

    private void fadeUp(){
        FadeTransition ftF=new FadeTransition(Duration.millis(2000), faderUP);
        ftF.setFromValue(0);
        ftF.setToValue(1);
        ftF.setCycleCount(1);
        ftF.play();
        ftF.setOnFinished(e->{
            finScore.setText(score.getText());
            try {
                newHighScoreTxt.setOpacity(getNewHigh.isNewHigh(score.getText())?1:0);
                worldRankScore.setText(getWorldRank.getRank(score.getText()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            changeToScene(diedS);
            afterInit();
        });
    }

    private void gameStart(){
        Timeline leaf1TL     =new Timeline(); leaf1TL.setCycleCount(1);      animations.leafFlowing(leaf1TL,leafI1,0);
        Timeline leaf2TL     =new Timeline(); leaf2TL.setCycleCount(1);      animations.leafFlowing(leaf2TL,leafI2,2);
        Timeline leaf3TL     =new Timeline(); leaf3TL.setCycleCount(1);      animations.leafFlowing(leaf3TL,leafI3,1.7);
        Timeline leaf4TL     =new Timeline(); leaf4TL.setCycleCount(1);      animations.leafFlowing(leaf4TL,leafI4,0.9);
        Timeline leaf5TL     =new Timeline(); leaf5TL.setCycleCount(1);      animations.leafFlowing(leaf5TL,leafI5,3);
        Timeline leaf6TL     =new Timeline(); leaf6TL.setCycleCount(1);      animations.leafFlowing(leaf6TL,leafI6,0.5);
        Timeline mainC_tml_KP=new Timeline(); mainC_tml_KP.setCycleCount(1); animations.charMoving1(mainC_tml_KP,mainC,isShih);
        Timeline mainC_tml_KR=new Timeline(); mainC_tml_KR.setCycleCount(1); animations.flyAway1(mainC_tml_KR,mainC,isShih);
        Timeline dead        =new Timeline(); dead.setCycleCount(1);         animations.deadBoom(dead,deadBoom);
        Timeline hitFly      =new Timeline(); hitFly.setCycleCount(1);       animations.hitFlying(hitFly,hit,nowHit);
        Timeline charHit     =new Timeline(); charHit.setCycleCount(1);      animations.hitFly(charHit,mainC);
        Timeline pachiAni    =new Timeline(); pachiAni.setCycleCount(6);     animations.pachiPachi(pachiAni,pachi);
        FadeTransition fdT   =new FadeTransition(); fdT.setCycleCount(6);    fdT.setFromValue(0);fdT.setToValue(1);fdT.setAutoReverse(true);fdT.setDuration(Duration.millis(350));fdT.setNode(overThousandText);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                leaf1TL.setRate(Math.max(1,nowSpeed/2));leaf1TL.play();
                leaf2TL.setRate(Math.max(1,nowSpeed/2));leaf2TL.play();
                leaf3TL.setRate(Math.max(1,nowSpeed/2));leaf3TL.play();
                leaf4TL.setRate(Math.max(1,nowSpeed/2));leaf4TL.play();
                leaf5TL.setRate(Math.max(1,nowSpeed/2));leaf5TL.play();
                leaf6TL.setRate(Math.max(1,nowSpeed/2));leaf6TL.play();
                if (!hitChar&&clickAB&&((System.currentTimeMillis() - startTime)-tmpNowT)>325||((System.currentTimeMillis() - startTime)-tmpNowT2)>325) {
                    mainC_tml_KR.play();
                }
                else if(!hitChar){
                    mainC_tml_KP.play();
                }
                if(!hitChar){
                    hitFly.play();
                    tmpNowT3=(System.currentTimeMillis()-startTime);
                }
                else{
                    powMplayer.play();
                    switch (nowHit){
                        case 1->hit.setImage(birdH);
                        case 2->hit.setImage(ballon);
                    }
                    mainC.setImage(isShih?charaHitS:charaHit);
                    charHit.play();
                    clickAB=false;
                    if(((System.currentTimeMillis() - startTime)-tmpNowT3)<=25){
                        nowScore+=50*nowSpeed;
                    }
                    if(((System.currentTimeMillis() - startTime)-tmpNowT3)>=1000){
                        rnd=getRandomNum();
                        switch (rnd%2){
                            case 0->nowHit=1;
                            case 1->nowHit=2;
                        }
                        hitChar=false;
                        clickAB=true;
                    }
                }
                if(!hitCanFly){
                    animations.hitFlying(hitFly,hit,nowHit);
                }
                if(overThousand){
                    pachiMplayer.play();
                    pachi.setOpacity(1);
                    pachiAni.play();
                    pachiAni.setOnFinished(e->{
                        pachi.setOpacity(0);
                        pachiMplayer.stop();
                    });
                    score.setOpacity(0);
                    fdT.play();
                    fdT.setOnFinished(e->{
                        score.setOpacity(1);
                        overThousand=false;
                    });
                }
                update();
                switch (nowScene) {
                    case 2 -> bgMain.setFill(Color.valueOf("#ffde5c"));
                    case 1 -> bgMain.setFill(Color.valueOf("#63c0f7"));
                    case 3 -> bgMain.setFill(Color.valueOf("#f39a8f"));
                }
                if(!running){ //touched borders
                    hit.setOpacity(0);
                    mainC.setOpacity(0);
                    mPlayer.stop();
                    deadBoom.setOpacity(1);
                    deadMplayer.play();
                    dead.play();
                    this.stop();
                    dead.setOnFinished(e->{
                        gameEnd();
                    });
                }
            }
        };
        timer.start();
        mPlayer.play();
    }

    private void gameEnd(){
        fadeUp();
    }

    private void update(){
        nowScore+=0.025*nowSpeed;
        nowSpeed=Math.max(1,Math.log((System.currentTimeMillis() - startTime))-6);
        if(isPressed(KeyCode.SPACE)&&clickAB&&mainC.getLayoutX()>-360){
            clickAB=false;
            nowScore+=nowSpeed;
            mainC.setLayoutX(mainC.getLayoutX()-Math.min(25*nowSpeed,50));
        }
        mainC.setLayoutX(mainC.getLayoutX()+(!hitChar?nowSpeed:Math.min(2.5*nowSpeed,15)));

        score.setText(String.valueOf((int)nowScore));//(int)nowScore)//14.6
        overThousandText.setText(score.getText());

        if(mainC.getLayoutX()>=360){
            if(nowScene<3){
                nowScene+=1;
                mainC.setLayoutX(-300);
            }
            else{
                deadBoom.setScaleX(1);
                deadBoom.setX(-240);
                running=false;
            }
        }
        if(mainC.getLayoutX()<=-360){
            if(nowScene>1){
                nowScene-=1;
                mainC.setLayoutX(300);
            }
            else {
                deadBoom.setScaleX(-1);
                deadBoom.setX(-270);
                running=false;
            }
        }
//        System.out.println(hit.getLayoutX());
        if((System.currentTimeMillis()/1000)%rnd==0){
            hitCanFly=true;
        }
        if(hitCanFly){
            hit.setLayoutX(hit.getLayoutX()+10);
            if(Math.abs((hit.getLayoutX())-(mainC.getLayoutX()+360))<=30){
                hitChar=true;
            }
            if(hit.getLayoutX()>870){
                hitCanFly=false;
                hit.setLayoutX(-150);
            }
        }
        if((int)(nowScore/1000)==nextThousand){
            nextThousand++;
            overThousand=true;
        }
    }

    private int getRandomNum(){
        return (int)Math.floor(Math.random() * (15 - 5 + 1) + 5);
    }

    private boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    public void changeToScene(Scene scene){
        mainStage.setScene(scene);
    }

    //-----------------------------------------------------------------------------------------------------------------------
    //scenes
    private Scene diedScene(){
        Scene scene=new Scene(diedPane,720,720);
        againBT.setOnAction(e ->  {
            pop0.stop();pop0.play();
            afterInit();
            changeToScene(menuS);
        });
        return scene;
    }

    private Scene gameScene(){
        Scene scene = new Scene(gamePane,720,720);
        scene.setOnKeyPressed(event -> {
            tmpNowT=(System.currentTimeMillis() - startTime);
            keys.put(event.getCode(), true);
        });
        scene.setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
            tmpNowT2=(System.currentTimeMillis() - startTime);
            clickAB=true;
        });
        return scene;
    }

    private Scene credScene(){
        RotateTransition rt=new RotateTransition(Duration.millis(1500));
        rt.setNode(crediBTbk);rt.setToAngle(360);rt.setCycleCount(-1);rt.play();
        Scene scene = new Scene(credPane,720,720);
        crediBTbk.setOnMouseClicked(e->{
            pop2.stop();pop2.play();
            changeToScene(menuS);
        });
        return scene;
    }

    private Scene menuScene(){
        Timeline bobbing=new Timeline();bobbing.setCycleCount(-1);animations.bobbing(bobbing,chngSBT);bobbing.play();
        RotateTransition rt=new RotateTransition(Duration.millis(1500));
        rt.setNode(crediBT);rt.setToAngle(360);rt.setCycleCount(-1);rt.play();
        Timeline timeline=new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        animations.charMoving1(timeline,menuC,isShih);
        timeline.play();
        Scene scene=new Scene(menuPane,720,720);
        crediBT.setOnMouseClicked(e->{
            pop2.stop();pop2.play();
            changeToScene(credS);
        });
        chngSBT.setOnMouseClicked(e->{
            pop1.stop();pop1.play();
            isShih=!isShih;
            chngSBT.setGraphic(isShih?cngIMGVs:cngIMGVnor);
            timeline.stop();
            animations.charMoving1(timeline,menuC,isShih);
            timeline.play();
        });
        playBT.setOnMouseClicked(e ->  {
            pop0.stop();pop0.play();
            changeTOshih();
            fadeAway();
        });
        return scene;
    }

    //-----------------------------------------------------------------------------------------------------------------------
    //main
    @Override
    public void start(Stage stage) throws Exception {
        generateHash.genHash();
        mainStage=stage;
        initial();
        changeToScene(menuS);
        mainStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
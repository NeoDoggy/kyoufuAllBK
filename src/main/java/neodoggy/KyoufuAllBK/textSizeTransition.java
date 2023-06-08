package neodoggy.KyoufuAllBK;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.control.Labeled;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class textSizeTransition extends Transition {
    private Text UIcontrol;
    private int start, end;

    public textSizeTransition(Text UIcontrol, int start, int end, Duration duration) {
        this.UIcontrol = UIcontrol;
        this.start = start;
        this.end = end - start;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
        setCycleCount(3);
    }

    @Override
    protected void interpolate(double frac) {
        int size = (int) ((end * frac) + start);
        if(size<=end) {
            UIcontrol.setFont(Font.loadFont(main.class.getResourceAsStream("GN-KillGothic-U-KanaNA.ttf"),end));
        }else {
            UIcontrol.setFont(Font.loadFont(main.class.getResourceAsStream("GN-KillGothic-U-KanaNA.ttf"),start));
        }
    }
}

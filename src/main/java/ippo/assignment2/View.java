package ippo.assignment2;

import javafx.scene.image.Image;
import java.util.concurrent.Phaser;

public class View {
    private int direction;
    private Image view;
    private String nextLocation;

    public View(int direction, Image view, String nextLocation){
        this.direction=direction;
        this.view=view;
        this.nextLocation=nextLocation;
    }

    public Image getView() {
        return view;
    }

    public int getDirection() {
        return direction;
    }

    public String getNextLocation() {
        return nextLocation;
    }


    public void setView(Image view) {
        this.view = view;
    }
}

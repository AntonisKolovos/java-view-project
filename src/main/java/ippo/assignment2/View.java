package ippo.assignment2;

import javafx.scene.image.Image;
import java.util.concurrent.Phaser;

public class View {
    private int direction;
    private Image view;
    private boolean hasExit;
    private String nextLocation;

    public View(int direction, Image view, boolean exit, String nextLocation){
        this.direction=direction;
        this.view=view;
        this.hasExit= hasExit;
        this.nextLocation=nextLocation;
    }

    public Image getView() {
        return view;
    }

    public int getDirection() {
        return direction;
    }

    public boolean hasExit() {
        return hasExit;
    }

    public String getNextLocation() {
        return nextLocation;
    }


    public void setView(Image view) {
        this.view = view;
    }
}

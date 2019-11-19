package ippo.assignment2;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.concurrent.Phaser;

public class Direction {
    private int direction;
    private Image view;
    private String nextLocation;

    public Direction(int direction, Image view, String nextLocation){
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

}

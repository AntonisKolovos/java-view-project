package ippo.assignment2;

import javafx.scene.image.Image;
import java.util.ArrayList;

public class Location {
    private String name ;
    private ArrayList<View> views= new ArrayList<View>(4);
    private int noDirections;

    public Location(String name,int noDirections){
        this.name=name;
        this.noDirections=noDirections;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoDirections(int noDirections) {
        this.noDirections = noDirections;
    }

    public void addView(View newView){
        views.add(newView.getDirection(), newView);

    }

    public Image getViewImage(int direction){
        return views.get(direction).getView();
    }

    public int turn(int currDirection,int offset){
        int newDir = (currDirection+offset)%noDirections;
        //Modulus in java returns a negative number for negative inputs, so we adjust
        if (newDir<0){
            newDir+=noDirections;
        }
        return views.get(newDir).getDirection();
    }

    public String getNextLocation(int direction){
        return views.get(direction).getNextLocation();
    }

    public boolean hasExit(int direction){
        return views.get(direction).hasExit();

    }



}

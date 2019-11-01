package ippo.assignment2;

import java.util.HashMap;
import javafx.scene.image.Image;


public class World {
    HashMap<String,Location> locations = new HashMap<String,Location>();
    Player player ;



    public void initialize(){
        System.out.println("World Initializing..");
        player = new Player("room1",0);
        Location room1= new Location("room1",4);
        View newView = new View(0,new Image("R1D1.png"),false,null);
        room1.addView(newView);
        newView = new View(1,new Image("R1D2.png"),true,"room2");
        room1.addView(newView);
        newView = new View(2,new Image("R1D3.png"),false,null);
        room1.addView(newView);
        newView = new View(3,new Image("R1D4.png"),false,null);
        room1.addView(newView);
        this.locations.put("room1",room1);


    }

    public void turn(int offset){
        int oldDirection=player.getCurrentDirection();
        int newDirection=locations.get(player.getCurrentLocation()).turn(oldDirection,offset);
        player.setCurrentDirection(newDirection);
    }

    public void goForward(){

    }

    public Image getViewImage(){
        Location currLocation= locations.get(player.getCurrentLocation());
        return currLocation.getViewImage(player.getCurrentDirection());
    }

    public boolean hasExit(){
        return locations.get(player.getCurrentLocation()).hasExit(player.getCurrentDirection());
    }


}


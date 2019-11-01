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
        View newView = new View(0,new Image("R1D1.png"),null);
        room1.addView(newView);
        newView = new View(1,new Image("R1D2.png"),"room2");
        room1.addView(newView);
        newView = new View(2,new Image("R1D3.png"),null);
        room1.addView(newView);
        newView = new View(3,new Image("R1D4.png"),null);
        room1.addView(newView);
        this.locations.put("room1",room1);


        Location room2= new Location("room2",4);
        newView = new View(0,new Image("R2D1.png"),null);
        room2.addView(newView);
        newView = new View(1,new Image("R2D2.png"),null);
        room2.addView(newView);
        newView = new View(2,new Image("R2D3.png"),null);
        room2.addView(newView);
        newView = new View(3,new Image("R2D4.png"),"room1");
        room2.addView(newView);
        this.locations.put("room2",room2);


    }

    public void turn(int offset){
        int oldDirection=player.getCurrentDirection();
        int newDirection=locations.get(player.getCurrentLocation()).turn(oldDirection,offset);
        player.setCurrentDirection(newDirection);
    }

    public void goForward(){

        if(locations.get(player.getCurrentLocation()).getNextLocation(player.getCurrentDirection())!=null){

            String nextLocation=locations.get(player.getCurrentLocation()).getNextLocation(player.getCurrentDirection());
            player.setCurrentLocation(nextLocation);

        }else{
            System.out.println("No exit!");
        }


    }

    public Image getViewImage(){
        Location currLocation= locations.get(player.getCurrentLocation());
        return currLocation.getViewImage(player.getCurrentDirection());
    }

    public Boolean hasExit(){
        if(locations.get(player.getCurrentLocation()).getNextLocation(player.getCurrentDirection())!=null){
            return true ;
        }
        else{
            return false ;
        }
    }


}


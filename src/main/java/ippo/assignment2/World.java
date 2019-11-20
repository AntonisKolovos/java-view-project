package ippo.assignment2;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;


public class World {
    private HashMap<String,Location> locations = new HashMap<String,Location>();
    private Player player ;



    public void initialize(){
        System.out.println("World Initializing..");
        player = new Player("livingroom",0);
        Location room1= new Location("livingroom",4);
        Direction newDirection = new Direction(0,new Image("living1.jpg"),"corridor");
        room1.addDirection(newDirection);
        newDirection = new Direction(1,new Image("living2.jpg"),null);
        room1.addDirection(newDirection);
        newDirection = new Direction(2,new Image("living3.jpg"),null);
        room1.addDirection(newDirection);
        newDirection = new Direction(3,new Image("living4.jpg"),null);
        room1.addDirection(newDirection);
        this.locations.put("livingroom",room1);


        Location room2= new Location("corridor",4);
        newDirection = new Direction(0,new Image("corridor1.jpg"),"bedroom");
        room2.addDirection(newDirection);
        newDirection = new Direction(1,new Image("corridor2.jpg"),"gameroom");
        room2.addDirection(newDirection);
        newDirection = new Direction(2,new Image("corridor3.jpg"),"livingroom");
        room2.addDirection(newDirection);
        newDirection = new Direction(3,new Image("corridor4.jpg"),"wc");
        room2.addDirection(newDirection);
        this.locations.put("corridor",room2);


        Location room3= new Location("bedroom",4);
        newDirection = new Direction(0,new Image("bedroom1.jpg"),null);
        room3.addDirection(newDirection);
        newDirection = new Direction(1,new Image("bedroom2.jpg"),null);
        room3.addDirection(newDirection);
        newDirection = new Direction(2,new Image("bedroom3.jpg"),"corridor");
        room3.addDirection(newDirection);
        newDirection = new Direction(3,new Image("bedroom4.jpg"),null);
        room3.addDirection(newDirection);
        this.locations.put("bedroom",room3);

        Location room4= new Location("wc",4);
        newDirection = new Direction(0,new Image("wc1.jpg"),null);
        room4.addDirection(newDirection);
        newDirection = new Direction(1,new Image("wc2.jpg"),"corridor");
        room4.addDirection(newDirection);
        newDirection = new Direction(2,new Image("wc3.jpg"),null);
        room4.addDirection(newDirection);
        newDirection = new Direction(3,new Image("wc4.jpg"),null);
        room4.addDirection(newDirection);
        this.locations.put("wc",room4);

        Location room5= new Location("gameroom",4);
        newDirection = new Direction(0,new Image("gameroom1.jpg"),null);
        room5.addDirection(newDirection);
        newDirection = new Direction(1,new Image("gameroom2.jpg"),null);
        room5.addDirection(newDirection);
        newDirection = new Direction(2,new Image("gameroom3.jpg"),null);
        room5.addDirection(newDirection);
        newDirection = new Direction(3,new Image("gameroom4.jpg"),"corridor");
        room5.addDirection(newDirection);
        this.locations.put("gameroom",room5);






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

        }


    }

    public Image getDirectionImage(){
        Location currLocation= locations.get(player.getCurrentLocation());
        return currLocation.getDirectionImage(player.getCurrentDirection());
    }

    public Boolean hasExit(){
        if(locations.get(player.getCurrentLocation()).getNextLocation(player.getCurrentDirection())!=null){
            return true ;
        }
        else{
            return false ;
        }
    }

    public void pickItem(Item item){
        player.addItem(item);
        locations.get(player.getCurrentLocation()).removeItem(item);
    }

    public void dropItem(Item item){
        player.dropItem(item);
        locations.get(player.getCurrentLocation()).addItem(item);
    }

    public ArrayList<Item> getLocationItems(){

        return locations.get(player.getCurrentLocation()).getItemList();


    }

    public ArrayList<Item> getPlayerItems(){

        return player.getItems();

    }







}


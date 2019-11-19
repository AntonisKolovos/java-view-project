package ippo.assignment2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;


public class WorldController {
    @FXML
    private Pane itemPane;
    @FXML
    private Menu pickupMenu;

    @FXML
    private Menu dropMenu;

    @FXML
    private ImageView mainView;

    @FXML
    private Button buttonForward;
    private World world;
    private ArrayList<Item> locationItems= new ArrayList<Item>();
    private ArrayList<Item> playerItems= new ArrayList<Item>();


    public void initialize(World world){
        this.world=world;
        this.update();


    }
    public void goForward(ActionEvent event) {
        world.goForward();
        this.update();
    }

    public void turnLeft(ActionEvent event){
        world.turn(-1);
        this.update();

    }

    public void turnRight(ActionEvent event){
        world.turn(1);
        this.update();

    }

    public void update(){
        if(!world.hasExit()){
            buttonForward.setDisable(true);

        }
        else {
            buttonForward.setDisable(false);
        }
        Image image = world.getDirectionImage();
        mainView.setImage(image);

        this.setLocationItems();
        this.setPlayerItems();





    }
    public void dropItem(Item item){
        world.dropItem(item);
        this.update();
    }

    public void pickItem(Item item){
        world.pickItem(item);
        this.update();
    }


    public void setLocationItems(){
        pickupMenu.getItems().clear();
        itemPane.getChildren().clear();
        locationItems=world.getLocationItems();
        int i=1;
        for(Item item:locationItems){

            MenuItem menuItem = new MenuItem(item.getName());
            menuItem.setOnAction(event -> {
                pickItem(item);
            });
            pickupMenu.getItems().add(menuItem);
            ImageView itemView = new ImageView(item.getIcon());
            itemView.relocate(30+i,10);
            itemPane.getChildren().add(itemView);
            i+=100;
        }
    }

    public void setPlayerItems(){
        dropMenu.getItems().clear();
        playerItems=world.getPlayerItems();
        for(Item item:playerItems){
            MenuItem menuItem = new MenuItem(item.getName());
            menuItem.setOnAction(event -> {
                dropItem(item);
            });
            dropMenu.getItems().add(menuItem);
        }
    }


}

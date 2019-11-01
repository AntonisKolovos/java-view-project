package ippo.assignment2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class WorldController {

    @FXML
    private ImageView mainView;

    @FXML
    private Button buttonForward;
    private World world;
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
        Image image = world.getViewImage();
        mainView.setImage(image);
    }

}

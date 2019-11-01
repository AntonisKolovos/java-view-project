package ippo.assignment2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class WorldController {

    @FXML
    private ImageView mainView;
    private World world;
    public void initialize(World world){
        this.world=world;


    }
    public void buttonForward(ActionEvent event) {

        System.out.println("Hello World");
        Image image = world.getViewImage();
        mainView.setImage(image);
    }

    public void buttonLeft(ActionEvent event){
        world.turn(-1);
        Image image = world.getViewImage();
        mainView.setImage(image);

    }

    public void buttonRight(ActionEvent event){
        world.turn(1);
        Image image = world.getViewImage();
        mainView.setImage(image);

    }

}

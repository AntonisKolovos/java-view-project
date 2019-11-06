package ippo.assignment2;

import javafx.scene.image.Image;

public class Item {
    private Image icon;
    private String name;


    public  Item(Image icon, String name){
        this.icon=icon;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public Image getIcon() {
        return icon;
    }
}

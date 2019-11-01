package ippo.assignment2;

public class Player {
    private String currentLocation;
    private int currentDirection;

    public Player(String location,int direction){
        this.currentDirection=direction;
        this.currentLocation=location;
    }
    public int getCurrentDirection() {
        return currentDirection;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

}

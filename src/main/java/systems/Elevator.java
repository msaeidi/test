package systems;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Elevator {
	
    private Direction direction;
    
    private Floor currentFloor;
    
    private State state;
    
    boolean open;
    
    private Map<Floor, Boolean> stopRequestedFloor = new ConcurrentHashMap<Floor, Boolean>();
    
    private int capacity;
   
    public void moveToNext() {}
    
    public State getState() { 
    	return state; 
    }
   
    public void setState(State state) { 
    	this.state = state; 
    }
   
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Floor getCurrentFloor() {
    	return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
    	this.currentFloor = currentFloor;
    }

    public void open() {
    	open = true;
    }
    
    public void close() {
    	open = false;
    }
   
    public void stopRequested(Floor floor) {
    	stopRequestedFloor.put(floor, true);
    }

}

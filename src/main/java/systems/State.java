package systems;

public enum State {
    STOP(0),
    GOINGUP(1),
    GOINGDOWN(-1),
    EMERGENCY(911);
    
    private final int value;
    
    State(int value) {
    	this.value = value;
    }

	public int getValue() {
		return value;
	}
}

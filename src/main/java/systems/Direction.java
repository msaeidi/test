package systems;

public enum Direction {
    UP(1),
    DOWN(-1),
    STOPPED(0);
    
    private final int value;
    
	private Direction(int value) {
    	this.value = value;
    }
	
	public int getValue() {
		return value;
	}
}

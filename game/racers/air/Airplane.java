package game.racers.air;

import game.racers.IRacer;
import game.racers.Racer;
import utilities.EnumContainer.Color;

public class Airplane extends Racer implements IAerialRacer {
	private static final String CLASS_NAME = "Airplane";

	private static final int DEFAULT_WHEELS = 3;
	private static final double DEFAULT_MAX_SPEED = 885;
	private static final double DEFAULT_ACCELERATION = 100;
	private static final Color DEFAULT_color = Color.BLACK;

	/*public Airplane() {
		this(CLASS_NAME + " #" + lastSerialNumber, DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color,
				DEFAULT_WHEELS);
	}*/
	
	public Airplane() {
		this(CLASS_NAME + " #" + lastSerialNumber, DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION);
	}
	
	public Airplane(String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color,
			int numOfWheels) {
		super(name, maxSpeed, acceleration, color);
	}
	
	public Airplane(String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color){
		super(name, maxSpeed, acceleration, color);
	}
	
	
	public Airplane(String name, double maxSpeed, double acceleration) {
		super(name, maxSpeed, acceleration);
	}
	
	@Override
	public Racer clone() {
        return new Airplane();
    }
	
	@Override
	public String className() {
		return CLASS_NAME;
	}

	@Override
	public String describeSpecific() {
		return "";
	}

}

package game.racers.land;

import game.racers.IRacer;
import game.racers.Racer;
import game.racers.air.Airplane;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Engine;

public class Car extends Racer implements ILandRacer {

	private static final String CLASS_NAME = "Car";

	private static final int DEFAULT_WHEELS = 4;
	private static final double DEFAULT_MAX_SPEED = 400;
	private static final double DEFAULT_ACCELERATION = 20;
	private static final Color DEFAULT_color = Color.RED;

	private Engine engine;

	/*public Car() {
		this(CLASS_NAME + " #" + lastSerialNumber, DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color,
				DEFAULT_WHEELS);
	}*/
	
	public Car() {
		this(CLASS_NAME + " #" + lastSerialNumber, DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION);
	}
	
	
	public Car(String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color,
			int numOfWheels) {
		super(name, maxSpeed, acceleration, color);
		this.setEngine(Engine.MOUNTAIN);
	}
	
	public Car(String name, double maxSpeed, double acceleration) {
		super(name, maxSpeed, acceleration);
		this.setEngine(Engine.MOUNTAIN);
	}
	
	@Override
	public Racer clone() {
        return new Car();
    }
	
	@Override
	public String className() {
		return CLASS_NAME;
	}

	@Override
	public String describeSpecific() {
		String s = "";
		//s += this.wheeled.describeSpecific();
		s += ", Engine Type: " + this.engine;
		return s;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}

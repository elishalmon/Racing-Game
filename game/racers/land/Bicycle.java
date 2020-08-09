package game.racers.land;

import game.racers.IRacer;
import game.racers.Racer;
import game.racers.air.Airplane;
import utilities.EnumContainer;
import utilities.EnumContainer.BicycleType;
import utilities.EnumContainer.Color;

public class Bicycle extends Racer implements ILandRacer {

	private static final String CLASS_NAME = "Bicycle";
	private static final String DEFUALT_NAME = CLASS_NAME + " #" + lastSerialNumber;

	private static final int DEFAULT_WHEELS = 2;
	private static final double DEFAULT_MAX_SPEED = 270;
	private static final double DEFAULT_ACCELERATION = 10;
	private static final Color DEFAULT_color = Color.GREEN;

	private EnumContainer.BicycleType type;

	public Bicycle() {
		this(DEFUALT_NAME, DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color, DEFAULT_WHEELS);
	}

	public Bicycle(String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color,
			int numOfWheels) {
		super(name, maxSpeed, acceleration, color);
		this.setType(BicycleType.MOUNTAIN);
	}
	
	@Override
	public Racer clone() {
        return new Bicycle();
    }

	@Override
	public String className() {
		return CLASS_NAME;
	}

	@Override
	public String describeSpecific() {
		String s = "";
		//s += this.wheeled.describeSpecific();
		s += ", Bicycle Type: " + this.type;
		return s;
	}

	public EnumContainer.BicycleType getType() {
		return type;
	}

	public void setType(EnumContainer.BicycleType type) {
		this.type = type;
	}

}

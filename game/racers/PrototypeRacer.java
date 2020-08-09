package game.racers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import game.racers.air.Airplane;
import game.racers.air.Helicopter;
import game.racers.land.Bicycle;
import game.racers.land.Car;
import game.racers.land.Horse;
import game.racers.naval.RowBoat;
import game.racers.naval.SpeedBoat;

public class PrototypeRacer {
		
	private static final Map<String, Racer> prototypes = new HashMap<>();
	private static ArrayList<String> types = new ArrayList<String>() {{
		add("Airplane");
		add("Helicopter");
		add("Bicycle");
		add("Horse");
		add("Car");
		add("RowBoat");
		add("SpeedBoat");
	}};
	
	public static void setPrototypes(String type, Racer racer) throws Exception {
		if (types.contains(type))
			prototypes.put(type, racer);
		else
			throw new Exception("Invalid type of racer");
	}
	
	public static Map<String, Racer> getPrototypes(){
		return prototypes;
	}
	
	public static Racer getPrototype(String type) {
		try {
			return prototypes.get(type).clone();
		} catch (NullPointerException ex) {
			System.out.println("Prototype with type # " + type + ", doesn't exist");
			return null;
		}
	}
}

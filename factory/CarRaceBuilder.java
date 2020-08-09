package factory;

import java.util.ArrayList;

import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;

/**
* class CarRaceBuilder - build a default car race builde
*
* @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
* @version 1 11/06/2018
*/

public class CarRaceBuilder implements RaceBuilder{
	private Race race;
	private int numOfRacers;
	
	/**
	 * ctor-  initialize parmeters
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 * @param numofracers
	 */
	public CarRaceBuilder(int numOfRacers) {
		this.race= new Race();
		this.numOfRacers = numOfRacers;
	}
	
	/**
	 * buildArena - build new Arena by using set arena
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 */
	
	@Override
	public void buildArena() {
		race.setArena("Land", numOfRacers);
	}
	
	/**
	 * buildRacers - build new racers
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 */
	@Override
	public void buildRacers() throws RacerLimitException, RacerTypeException {
		race.setRacers(numOfRacers);
	}
	
	
	/**
	 * getRace - return the race
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 * @return race
	 */
	public Race getRace() {
		return this.race;
	}

}

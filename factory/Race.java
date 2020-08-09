package factory;

import java.util.ArrayList;

import game.arenas.Arena;
import game.arenas.ArenaFactory;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.IRacer;
import game.racers.PrototypeRacer;
import game.racers.Racer;
import game.racers.land.Car;

/**
* class Race - build a default Race with arena and racers
*
* @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
* @version 1 11/06/2018
*/

public class Race implements RacePlan{
	private Arena arena;
	private ArrayList<Racer> racers;
	private ArenaFactory arenaFactory;
	
	
	/**
	 * ctor-  initialize parameters
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 */
	public Race() {
		arenaFactory = new ArenaFactory();
		racers = new ArrayList<Racer>();
	}
	
	/**
	 * setArena
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 * @param arenaType, numOfRacers
	 */
	@Override
	public void setArena(String arenaType, int numOfRacers) {
		arena = arenaFactory.getArena(arenaType, numOfRacers);
	}
	
	/**
	 * setRacers
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 * @param numOfRacers
	 * @throws RacerLimitException RacerTypeException
	 */
	
	@Override
	public void setRacers(int numOfRacers) throws RacerLimitException, RacerTypeException  {
		racers.add(new Car());
		for (int i = 0; i < numOfRacers - 1; i++)
			racers.add(PrototypeRacer.getPrototype("Car"));
		this.addRacersToArena();
	}
	
	/**
	 * setRacers
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 * @throws RacerLimitException RacerTypeException
	 */
	private void addRacersToArena() throws RacerLimitException, RacerTypeException {
		for (Racer racer: racers)
			arena.addRacer(racer);
	}
	
	/**
	 * getArena
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 * @return arena
	 */
	public Arena getArena() {
		return this.arena;
	}
	
	public ArrayList<Racer> getRacers(){
		return racers;
	}
}

package game.arenas;

import game.arenas.air.AerialArena;
import game.arenas.land.LandArena;
import game.arenas.naval.NavalArena;

/**
 * class ArenaFactory - factory design pattern, return new arena
 *
 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
 * @version 1 11/06/2018
 */

public class ArenaFactory {
	
	/**
	 * getArena return new arena
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 * @param arenaType
	 * @return new arena
	 */
	public Arena getArena(String arenaType) {
		if (arenaType == null)
			return null;
		else if (arenaType == "Air")
			return new AerialArena();
		else if (arenaType == "Land")
			return new LandArena();
		else if (arenaType == "Navy")
			return new NavalArena();
		return null;
	}
	
	
	/**
	 * getArena return new arena
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 * @param arenaType, numOfRacers
	 * @return new arena
	 */
	public Arena getArena(String arenaType, int numOfRacers) {
		if (arenaType == null)
			return null;
		else if (arenaType == "Air")
			return new AerialArena(numOfRacers);
		else if (arenaType == "Land")
			return new LandArena(numOfRacers);
		else if (arenaType == "Navy")
			return new NavalArena(numOfRacers);
		return null;
	}
}

package factory;

import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;

/**
* interface RaceBuilder
*
* @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
* @version 1 11/06/2018
*/
public interface RaceBuilder {
	public void buildArena();
	public void buildRacers() throws RacerLimitException, RacerTypeException;
}

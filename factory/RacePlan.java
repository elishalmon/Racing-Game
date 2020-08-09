package factory;
import game.arenas.*;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;


/**
* interface RacePlan
*
* @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
* @version 1 11/06/2018
*/
public interface RacePlan {
	public void setArena(String arenaType, int numOfRacers);
	public void setRacers(int numOfRacers) throws RacerLimitException, RacerTypeException;
}

package game.racers.stats;

import game.racers.Racer;

/**
* class ActiveState
*
* @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
* @version 1 11/06/2018
*/
public class ActiveState implements RacerState{

	@Override
	public void stateUpdate(Racer racer) {
		System.out.println(racer.getName()+" is active now and he is on the "+ 
				racer.getArena().getRacerLocation(racer) +" place");
	}
}

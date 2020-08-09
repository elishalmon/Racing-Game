package game.racers.stats;

import game.racers.Racer;

/**
* class BrokenState
*
* @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
* @version 1 11/06/2018
*/
public class BrokenState implements RacerState {

	@Override
	public void stateUpdate(Racer racer) {
		System.out.println(racer.getName()+" is broken now, "+racer.getTimePass()+" seconds allready passed");
	}

}

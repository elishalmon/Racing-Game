package game.racers.stats;

import game.racers.Racer;

/**
* class CompletedState
*
* @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
* @version 1 11/06/2018
*/
public class CompletedState implements RacerState{

	@Override
	public void stateUpdate(Racer racer) {
		System.out.println(racer.getName()+" complete the race!!");
	}
}

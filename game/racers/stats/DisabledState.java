package game.racers.stats;

import game.racers.Racer;


/**
* class DisabledState
*
* @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
* @version 1 11/06/2018
*/
public class DisabledState implements RacerState{

	@Override
	public void stateUpdate(Racer racer) {
		System.out.println(racer.getName()+" is disabled");
	}
	

}

package game.racers;

import game.racers.air.Airplane;

/**
* class WheeledRacer - add color decorate to racer
*
* @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
* @version 1 11/06/2018
*/
public class WheeledRacer extends RacerDecorator{
	
	private static final String ATTRIBUTENAME = "numOfWheels";
	/**
	 * ctor-  initialize parameters and updates attributes
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 */
	public WheeledRacer(IRacer decoratorRacer, int numOfWheels) {
		super(decoratorRacer);
		decoratorRacer.addAttribute(ATTRIBUTENAME, numOfWheels);
	}

	@Override
	public void introduce() {
		decorateRacer.introduce();
	}
	
	
}

package game.racers;

/**
* class ColoredRacer - add color decorate to racer
*
* @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
* @version 1 11/06/2018
*/
public class ColoredRacer extends RacerDecorator{
	
	private static final String ATTRIBUTENAME = "color";
	
	/**
	 * ctor-  initialize parameters and updates attributes
	 * 
	 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
	 */
	public ColoredRacer(IRacer decoratorRacer, utilities.EnumContainer.Color color) {
		super(decoratorRacer);
		decoratorRacer.addAttribute(ATTRIBUTENAME, color);
	}
	
	@Override
	public void introduce() {
		decorateRacer.introduce();
	}

}

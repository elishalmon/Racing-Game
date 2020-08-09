package game.racers;

public abstract class RacerDecorator implements IRacer{
	
	protected IRacer decorateRacer;
	
	public RacerDecorator(IRacer decoratorRacer) {
		this.decorateRacer = decoratorRacer;
	}
	public void addAttribute(String atrName, Object atrVal) {
		decorateRacer.addAttribute(atrName, atrVal);
	}
}

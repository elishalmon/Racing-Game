package utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import factory.CarRaceBuilder;
import factory.Race;
import game.arenas.Arena;
import game.arenas.ArenaFactory;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.ColoredRacer;
import game.racers.IRacer;
import game.racers.PrototypeRacer;
import game.racers.Racer;
import game.racers.WheeledRacer;
import game.racers.air.Airplane;
import game.racers.air.Helicopter;
import game.racers.land.Bicycle;
import game.racers.land.Car;
import game.racers.land.Horse;
import game.racers.naval.RowBoat;
import game.racers.naval.SpeedBoat;
import utilities.EnumContainer.Color;

/**
 * class Program - run the program
 *
 * @author Elad Ben Avraham 303071302, Elisha Shalmon 301834206
 * @version 1 11/06/2018
 */

public class Program {
	
	public static void main(String[] args) {
		ArrayList<String> options = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		
		/*Build a new default car race by using builder design pattern, 
		 * user should choose how many racers to add*/
		
		System.out.println("The first race will be a default car race by using builder design pattern:");
		System.out.println("Please enter the maximum number of racers:");
		Collections.addAll(options,"1","2","3","4","5","6","7","8","9","10");
		int choose = Program.checkInput(options);
		CarRaceBuilder carRaceBuilder = new CarRaceBuilder(choose);
		carRaceBuilder.buildArena();
		try {
			carRaceBuilder.buildRacers();
		} catch (RacerLimitException e2) {
			System.out.println(e2.getMessage());
		} catch (RacerTypeException e2) {
			System.out.println(e2.getMessage());
		}
		Race race = carRaceBuilder.getRace();
		try {
			System.out.println("Strat Race");
			race.getArena().startRace();
		} catch (InterruptedException e2) {
			System.out.println(e2.getMessage());
		}
		race.getArena().showResults();
		
		/*Car race finishd, now user should build a new race*/
		
		System.out.println("Car race is completed!!!\n");
		System.out.println("Now we will build a new race by using factory design pattern,\n"
				+ "the racers can be decorated by decorator design pattern\n"
				+ "and can be cloned by using Prototype design pattern\n");
		ArenaFactory af = new ArenaFactory();  //use of factory design pattern
		Arena arena = null;
		System.out.println("Please enter the kind of the arena (1- Air /2- Land /3- Naval:)");
		options.clear();
		Collections.addAll(options,"1","2","3");
		int arenaType = Program.checkInput(options);
		switch (arenaType) {
		case 1:
			arena = af.getArena("Air");
			break;
		case 2:
			arena = af.getArena("Land");
			break;
		case 3:
			arena = af.getArena("Navy");
			break;
		default:
			break;
		}

		System.out.println("Now we will add racers to the arena, this arena contains maximum "
				+ arena.getMaxRacers()+ " racers");
		boolean addMore = true;
		int racerType;
		IRacer newRacer = null;
		IRacer clonedRacer = null;
		boolean racerAdded = true;
		for (int i = 0; i < arena.getMaxRacers() && addMore == true; i++) {
			System.out.println("Please Choose the type of the #"+(i+1)+ " new racer: 1- AirPlane, 2- Helicopter, "
					+ "3-Car, 4-Horse, 5-Bicycle, 6-SpeedBoat, 7-RowBoat");
			if(arenaType == 2)
				System.out.println("You can also add wheels to the racer and than choose any type!!");
			options.clear();
			Collections.addAll(options,"1","2","3","4","5","6","7");
			racerType = Program.checkInput(options);
			String racerTypeStr = null;
			switch (racerType) {
			case 1:
				newRacer = new Airplane();
				racerTypeStr = "Airplane";
				break;
			case 2:
				newRacer = new Helicopter();
				racerTypeStr = "Helicopter";
				break;
			case 3:
				newRacer = new Car();
				racerTypeStr = "Car";
				break;
			case 4:
				newRacer = new Horse();
				racerTypeStr = "Horse";
				break;
			case 5:
				newRacer = new Bicycle();
				racerTypeStr = "Bicycle";
				break;
			case 6:
				newRacer = new SpeedBoat();
				racerTypeStr = "SpeedBoat";
				break;	
			case 7:
				newRacer = new RowBoat();
				racerTypeStr = "RowBoat";
				break;
			default:
				break;
			}
			Program.decorateRacer(newRacer);
			try {
				arena.addRacer((Racer)newRacer);
			}catch(RacerTypeException e) {
				System.out.println("Racer not added!! Racer type is not matching to arena type");
				i-=1;
				racerAdded = false;
			}catch(RacerLimitException e) {
				System.out.println(e.getMessage());
				break;
			}
			
			if (racerAdded == true) {
				System.out.println("Racer #"+(i+1)+" added!!");
				System.out.println("Do you want to clone a prototype of this racer? 0- No 1- Yes");
				options.clear();
				Collections.addAll(options,"0","1");
				choose = Program.checkInput(options);
				if(choose == 1) {
					clonedRacer = PrototypeRacer.getPrototype(racerTypeStr);
					Program.decorateRacer(clonedRacer);
					try {
						arena.addRacer((Racer)clonedRacer);
					}catch(RacerTypeException e) {
						System.out.println("Racer not added!! Racer type is not matching to arena type");
						racerAdded = false;
					}catch(RacerLimitException e) {
						System.out.println(e.getMessage());
						break;
					}
					if(racerAdded == true) {
						i+=1;
						System.out.println("Racer #"+(i+1)+" added!!");
					}
				}
			}
			racerAdded = true;
			if(arena.getActiveRacers().size() > 0 && addMore == true) {
				System.out.println("Do you want to start the race allready? 0- No, 1- Yes");
				options.clear();
				Collections.addAll(options,"0","1");
				int begin = Program.checkInput(options);
				if(begin == 1)
					break;
			}
		}
		System.out.println("Race is ready to start, press any key when you ready!");
		in.nextLine();
		System.out.println("Start Race!");
		try {
			arena.startRace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		arena.showResults();
	}
	
	public static int checkInput(ArrayList<String> arr) {
		Scanner in = new Scanner(System.in);
		String choose = in.nextLine();
		while(arr.contains(choose) == false) {
			System.out.println("Wrong input! try again");
			choose = in.nextLine();
		}
		return Integer.parseInt(choose);
	}
	
	public static void decorateRacer(IRacer racer) {
		ArrayList<String> options = new ArrayList<>();
		int choose;
		System.out.println("Do you Want to decorate the racer? 0- No 1- wheels, 2- color:");
		options.clear();
		Collections.addAll(options,"0","1","2");
		choose = Program.checkInput(options);
		while (choose != 0) {
			if (choose == 1) {
				System.out.println("Enter how many wheels to add (1 / 2 / 3 / 4):");
				options.clear();
				Collections.addAll(options,"1","2","3","4");
				int wheels = Program.checkInput(options);
				new WheeledRacer(racer, wheels);
				}
			else if (choose == 2) {
				System.out.println("Enter color to add (1-RED ,2- GREEN ,3- BLUE ,4- BLACK ,5- YELLOW)");
				options.clear();
				Collections.addAll(options,"1","2","3","4","5");
				int colorChoose = Program.checkInput(options);
				switch(colorChoose) {
				case 1:
					new ColoredRacer(racer, Color.RED);
					break;
				case 2:
					new ColoredRacer(racer, Color.GREEN);
					break;
				case 3:
					new ColoredRacer(racer, Color.BLUE);
					break;
				case 4:
					new ColoredRacer(racer, Color.BLACK);
					break;
				case 5:
					new ColoredRacer(racer, Color.YELLOW);
					break;
				default:
					break;
				}
			}
			System.out.println("Do you want to add more decorator to the racer? 0- No 1- wheels, 2- color:");
			options.clear();
			Collections.addAll(options,"0","1","2");
			choose = Program.checkInput(options);
		}
	}
}



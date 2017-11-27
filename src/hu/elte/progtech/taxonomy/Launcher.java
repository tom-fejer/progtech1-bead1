package hu.elte.progtech.taxonomy;

public class Launcher {

	public static void main(String[] args) {
		Simulation simulation = new Simulation(new FileParser());
		simulation.run();
	}

}

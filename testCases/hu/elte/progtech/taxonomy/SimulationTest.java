package hu.elte.progtech.taxonomy;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SimulationTest {

	@Test
	void testSingleChainOneDay() {
		Simulation testSim = new Simulation(new FileParser("resources/SingleChain.txt"));
		testSim.run(1);
		Assert.assertEquals("Lepus europaeus", testSim.animals.get(0).getFullName());
	}

	@Test
	void testTwoSpeciesNoPreyOneDay() {
		Simulation testSim = new Simulation(new FileParser("resources/TwoSpeciesNoPrey.txt"));
		testSim.run(1);
		Assert.assertTrue(testSim.animals.size() == 2);
	}

	@Test
	void testThreeSpeciesWithPreyOneDay() {
		Simulation testSim = new Simulation(new FileParser("resources/ThreeSpeciesWithPrey.txt"));
		testSim.run(1);
		Assert.assertTrue(testSim.animals.size() == 3);
	}

	@Test
	void testPreyPrecedence() {
		Simulation testSim = new Simulation(new FileParser("resources/PreyPrecedence.txt"));
		testSim.run(3);
		boolean firstPopulation = testSim.animals.get(0).getPopulation() == 0;
		boolean secondPopulation = testSim.animals.get(1).getPopulation() == 5;
		Assert.assertTrue(firstPopulation && secondPopulation);
	}
}
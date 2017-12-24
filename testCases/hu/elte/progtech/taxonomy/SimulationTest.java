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
	void testTwoSpeciesNoPrey() {
		Simulation testSim = new Simulation(new FileParser("resources/TwoSpeciesNoPrey.txt"));
		testSim.run(1);
		Assert.assertTrue(testSim.animals.size() == 2);
	}

	@Test
	void testThreeSpeciesWithPrey() {
		Simulation testSim = new Simulation(new FileParser("resources/ThreeSpeciesWithPrey.txt"));
		testSim.run(1);
		Assert.assertTrue(testSim.animals.size() == 3);
		Assert.assertTrue(testSim.animals.get(2).getPreys().size() == 2);
	}

	@Test
	void testReproduction() {
		Simulation testSim = new Simulation(new FileParser("resources/Reproduction.txt"));
		testSim.run(5);
		Assert.assertEquals(3, testSim.animals.get(0).getPopulation());
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
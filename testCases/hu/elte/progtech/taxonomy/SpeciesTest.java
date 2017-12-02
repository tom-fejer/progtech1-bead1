package hu.elte.progtech.taxonomy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SpeciesTest {

	@Test
	public void testGetHunName() {
		Species testSpecies = new Species();
		testSpecies.setHunName("Indiai bíborbéka");
		String expected = "Indiai bíborbéka";
		Assert.assertEquals(expected, testSpecies.getHunName());
	}

	@Test
	public void testEmptyPreyList() {
		List<Taxon> expected = new ArrayList<Taxon>();
		Species testSpecies = new Species();
		Assert.assertEquals(expected, testSpecies.getPreys());
	}

	@Test
	public void testPreyManipulation() {
		Taxon preyToAdd = new Species();
		Species testSpecies = new Species();
		testSpecies.addPrey(preyToAdd);
		List<Taxon> expected = new ArrayList<Taxon>();
		expected.add(preyToAdd);
		Assert.assertEquals(expected, testSpecies.getPreys());
	}

	@Test
	public void testInitPopulation() {
		Species testSpecies = new Species();
		testSpecies.setInitPopulation(15);
		Assert.assertEquals(15, testSpecies.getInitPopulation());
	}

	@Test
	public void testInvalidInitPop() {
		Species testSpecies = new Species();
		boolean exceptionCaught = false;
		try {
			testSpecies.setInitPopulation(-42);
		} catch (IllegalArgumentException e) {
			exceptionCaught = true;
		} finally {
			Assert.assertTrue(exceptionCaught);
		}

	}

	@Test
	public void testGrowthRateManipulation() {
		Species testSpecies = new Species();
		testSpecies.setGrowthRate(666);
		int expected = 666;
		Assert.assertEquals(expected, testSpecies.getGrowthRate());
	}

	@Test
	public void testGetFullName() {
		Species testSpecies = new Species();
		testSpecies.setName("Fulgens");
		Genus parent = new Genus();
		parent.setName("Ailurus");
		testSpecies.setParent(parent);
		String expected = "Ailurus fulgens";
		Assert.assertEquals(expected, testSpecies.getFullName());
	}

}

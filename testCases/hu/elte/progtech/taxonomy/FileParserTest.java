package hu.elte.progtech.taxonomy;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FileParserTest {

	@Test
	public void testNonExistingFileParse() throws FileNotFoundException {
		FileParser fileParser = new FileParser("resources/nosuchfile.txt");
		Assert.assertEquals(null, fileParser.getTree());
	}

	@Test
	public void testEmptyFileParse() {
		FileParser fileParser = new FileParser("resources/empty.txt");
		fileParser.parse();
		Assert.assertTrue(fileParser.getTree().getRoot().getChildren().size() == 0);
	}

	@Test
	public void testSingleLineParse() {
		FileParser fileParser = new FileParser("resources/SingleLine.txt");
		fileParser.parse();
		Assert.assertEquals(1, fileParser.getTree().getRoot().getChildren().size());
	}

	@Test
	public void testSingleSpeciesNoPreyParse() {
		FileParser fileParser = new FileParser("resources/SingleSpeciesNoPrey.txt");
		fileParser.parse();
		Species actual = (Species) fileParser.getTree().getRoot().getChildren().get(0);
		Assert.assertEquals("TestName", actual.getName());
		Assert.assertEquals("Teszt Nev", actual.getHunName());
		Assert.assertEquals(2, actual.getPopulation());
		Assert.assertEquals(6, actual.getGrowthRate());
	}
	
	@Test
	public void testSingleSpeciesWithPreyParse() {
		FileParser fileParser = new FileParser("resources/SingleSpeciesWithPrey.txt");
		fileParser.parse();
		Species actual = (Species) fileParser.getTree().getRoot().getChildren().get(0).getChildren().get(1);
		Assert.assertEquals("TestName", actual.getName());
		Assert.assertEquals("Teszt Nev", actual.getHunName());
		Assert.assertEquals("Prey preda", actual.getPreys().get(0));
		Assert.assertEquals(2, actual.getPopulation());
		Assert.assertEquals(6, actual.getGrowthRate());
	}
	
}

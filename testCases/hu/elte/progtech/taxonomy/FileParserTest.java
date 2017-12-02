package hu.elte.progtech.taxonomy;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class FileParserTest {

	@Test
	public void testNonExistingFileParse() throws FileNotFoundException {
		FileParser fileParser = new FileParser("resources/nosuchfile.txt");
		Assert.assertEquals(null, fileParser.parse());
	}
	
	@Test
	public void testEmptyFileParse() throws FileNotFoundException {
		FileParser fileParser = new FileParser("resources/empty.txt");
		// TODO: create HierarchyTree THEN generate its hashCode/equals methods so it can be tested
		HierarchyTree emptyTree = new HierarchyTree();
		Assert.assertEquals(emptyTree , fileParser.parse());
	}
}

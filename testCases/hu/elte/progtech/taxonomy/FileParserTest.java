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
		HierarchyTree emptyTree = new HierarchyTree();
		Assert.assertEquals(emptyTree, fileParser.parse());
	}

	@Test
	public void testOneLineParse() {
		FileParser fileParser = new FileParser("resources/OneLine.txt");
		HierarchyTree expected = new HierarchyTree();
		expected.addRoot("P", new Phylum());
		Assert.assertEquals(expected, fileParser.parse());
	}
}

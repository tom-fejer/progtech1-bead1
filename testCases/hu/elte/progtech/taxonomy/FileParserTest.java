package hu.elte.progtech.taxonomy;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class FileParserTest {

	@Test
	public void testNonExistingFileParse() throws FileNotFoundException {
		FileParser fileParser = new FileParser("resources/nosuchfile.txt");
		Assert.assertEquals(null, fileParser.getTree());
	}

	@Test
	public void testEmptyFileParse() throws FileNotFoundException {
		FileParser fileParser = new FileParser("resources/empty.txt");
		fileParser.parse();
		Assert.assertTrue(fileParser.getTree().getRoot().getChildren().size() == 0);
	}

}

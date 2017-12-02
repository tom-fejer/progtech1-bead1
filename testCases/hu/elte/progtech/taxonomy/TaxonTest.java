package hu.elte.progtech.taxonomy;

import org.junit.Assert;
import org.junit.Test;

public class TaxonTest {

	@Test
	public void testParentManipulation() {
		Taxon child = new Classis();
		Taxon parent = new Phylum();
		child.setParent(parent);
		Assert.assertEquals(parent, child.getParent());
	}

	@Test
	public void testChildManipulation() {
		Taxon child = new Classis();
		Taxon parent = new Phylum();
		parent.setChild(child);
		Assert.assertTrue(parent.getChildren().contains(child));
	}

	@Test
	public void testNameManipulation() {
		Taxon taxon = new Phylum();
		taxon.setName("testius phylum");
		String testName = "testius phylum";
		Assert.assertEquals(testName, taxon.getName());
	}
}

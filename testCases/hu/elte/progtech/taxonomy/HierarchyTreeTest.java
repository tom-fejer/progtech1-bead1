package hu.elte.progtech.taxonomy;

import org.junit.Assert;
import org.junit.Test;

public class HierarchyTreeTest {

	@Test
	public void testAddRoot() {
		Taxon expected = new Phylum();
		String taxonType = "P";
		HierarchyTree tree = new HierarchyTree(expected);
		Assert.assertEquals(expected, tree.getRoot());
	}

	@Test
	public void testAddNode() {
		HierarchyTree tree = new HierarchyTree();
		String taxonType = "G";
		Taxon node = new Species();
		tree.addRoot(taxonType, node);
	}
}

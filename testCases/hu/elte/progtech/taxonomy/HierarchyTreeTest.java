package hu.elte.progtech.taxonomy;

import org.junit.Assert;
import org.junit.Test;

public class HierarchyTreeTest {

	@Test
	public void testEmptyTree() {
		HierarchyTree tree = new HierarchyTree();
		Assert.assertEquals(null, tree.getRoot());
	}
	
	@Test
	public void testAddRoot() {
		HierarchyTree tree = new HierarchyTree();
		Taxon expected = new Phylum();
		String taxonName = "Lepus";
		tree.addNode(taxonName, expected);
		Assert.assertEquals(expected, tree.getRoot());
	}

	@Test
	public void testAddNode() {
		HierarchyTree tree = new HierarchyTree();
		String parent = "Lepus";
		Taxon node = new Species();
		tree.addNode(parent, node);
	}
}

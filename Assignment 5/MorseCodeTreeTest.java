package assignment5;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest {
	 
	LinkedConverterTreeInterface<String> treeMorse;
	TreeNode<String> treeRoot;
	
	@Before
	public void setUp() throws Exception {

		treeMorse = new MorseCodeTree();
		treeRoot = new TreeNode<String>("jason");
	}
	
	@After
	public void tearDown() throws Exception {
		treeRoot = null;
		treeMorse = null;
	}
	
	@Test
	public void testGetRoot()
	{
		assertTrue(treeMorse.getRoot().getData().equals(""));
	
	}
	
	@Test
	public void testSetRoot()
	{
		treeMorse.setRoot(treeRoot);
		assertEquals(treeMorse.getRoot().getData(), "jason");
	}
		
	@Test
    public void testAddToNode() {
  
        treeMorse.addNode(treeMorse.getRoot(), ".--", "jason fotso");
        assertEquals(treeMorse.fetch(".--"), "jason fotso");
            
        treeMorse.addNode(treeMorse.getRoot(), "..--", "studentTest");
        assertEquals(treeMorse.fetch("..--"), "studentTest");      
    }
	@Test
	public void testFetchNode()
	{
		System.out.println(treeMorse.getRoot().getLChild().getLChild().getData());
		assertEquals(treeMorse.fetchNode(treeMorse.getRoot(),"."), "e");
		assertEquals(treeMorse.fetchNode(treeMorse.getRoot(),".-"), "a");
	}
	
	@Test
	public void testArrayList()
	{
		ArrayList <String> treeList  = treeMorse.toArrayList();
		System.out.print(treeList);
		assertEquals(treeList.get(4), "f");
	} 

}
package lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	GradeBook g1;
    GradeBook g2;

	@BeforeEach
	void setUp() throws Exception {
		
		g1 = new GradeBook(3);
		
		g1.addScore(20);
		g1.addScore(40);
		g1.addScore(60);
		
		g2 = new GradeBook(5);
	
		g2.addScore(45);
		g2.addScore(50);
		g2.addScore(77);
		g2.addScore(93);
		g2.addScore(100);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		g1 = null;
		g2 = null;
	    
	}

	@Test
	void testAddScore() {
		
		  assertEquals(3, g1.getScoreSize(), 0.001);
	      assertEquals(5, g2.getScoreSize(), 0.001);
		
		assertTrue(g1.toString().equals("20.0 40.0 60.0 "));
        assertTrue(g2.toString().equals("45.0 50.0 77.0 93.0 100.0 "));

	}

	@Test
	void testSum() {
		
		assertEquals(120.0, g1.sum(), 0.001);
        assertEquals(365.0, g2.sum(), 0.001);
        
	}

	@Test
	void testMinimum() {
		
		assertEquals(20.0, g1.minimum(), 0.001);
        assertEquals(45.0, g2.minimum(), 0.001);
        
	}

	@Test
	void testFinalScore() {
	
		assertEquals(100, g1.finalScore(), 0.001);
        assertEquals(320, g2.finalScore(), 0.001);
	
	}
	
}

package gameTests;

import java.util.Random;
import java.util.ArrayList;

import org.junit.Test;

import api.Direction;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import hw3.GameUtil;

import api.TilePosition;
import api.Move;

/**
 * @author Megan Hill
 * These test cases primarily focus on checking GameUtil methods
 * Note: I may have messed up the order in the assertEquals statements, so you might have to look through
 * the code to figure out which one is the actual and which one is expected
 */

public class Test1 {
	/**
	 * The number of iterations done for tests that check by probability not value directly
	 */
	private final static int NUM_ITERATIONS = 250;
	
	/**
	 * How close a number has to be to be "correct" used for probability checks
	 */
	private final static double EPSILON = 0.05;
	
	/**
	 * Random objects with seed that can be initialized to control test results
	 */
	private final static Random RANDOM_1 = new Random(1);
	private final static Random RANDOM_2 = new Random(19);
	
	/**
	 * Grids that can have operations performed on them
	 */
	private final static int[][] GRID_1 = {{2,0,0},{0,0,0},{1,0,0}}; //Possible starting 3*3 grid
	private final static int[][] GRID_2 = {{0,0,0,0},{0,0,0,0},{0,0,0,1},{0,0,0,2}}; // Possible starting 4*4 grid
	
	/**
	 * A GameUtil object that all of the methods are called on
	 */
	private GameUtil util;
	
	/**
	 * This runs before all tests and is necessary so that other methods may be called
	 */
	@Before
	public void createBoard() {
		util = new GameUtil();
	}
	
	
	/**
	 * This test checks that the correct values are being returned correctly in the
	 * getScoreForValue methods. It checks the first 5 numbers with actual scores as
	 * well as 1 and 2
	 */
	@Test
	public void getScoreTest() {
		assertEquals(util.getScoreForValue(1), 0);
		assertEquals(util.getScoreForValue(2), 0);
		assertEquals(util.getScoreForValue(3), 3);
		assertEquals(util.getScoreForValue(6), 9);
		assertEquals(util.getScoreForValue(12), 27);
		assertEquals(util.getScoreForValue(24), 81);
		assertEquals(util.getScoreForValue(48), 243);
	}
	
	/**
	 * This tests that tile positions are being generated in a way that could statistically be correct
	 * You could happen to pass this test without actually generating you results randomly, but if your
	 * method is correct it should pass this test the vast majority of the time
	 */
	@Test
	public void generateRandomTilePositionTest() {
		//Should return null since there is no direction
		assertNull(util.generateRandomTilePosition(GRID_1, RANDOM_1, null));
		
		//Only one possible set of coordinates
		TilePosition tp = util.generateRandomTilePosition(GRID_1, RANDOM_2, Direction.RIGHT);
		assertEquals(tp.getRow(), 1);
		assertEquals(tp.getCol(), 0);
		
		//Checks distribution is fairly even among all possible positions (when all are open) size 4*4
		int [] frequency = new int[GRID_2.length];
		for(int i = 0; i<NUM_ITERATIONS; i++) {
			tp = util.generateRandomTilePosition(GRID_2, RANDOM_2, Direction.RIGHT);
			frequency[tp.getRow()] = frequency[tp.getRow()] + 1;
		}
		for(int i = 0; i<frequency.length; i++) {
			assertEquals(1.0/GRID_2.length,(double)frequency[i]/(double)NUM_ITERATIONS,EPSILON);
		}
		
		//Tests frequency when there are two possible positions
		frequency = new int[GRID_1.length];
		for(int i = 0; i<NUM_ITERATIONS; i++) {
			tp = util.generateRandomTilePosition(GRID_1, RANDOM_1, Direction.DOWN);
			frequency[tp.getCol()] = frequency[tp.getCol()] + 1;
		}
		for(int i = 1; i<frequency.length; i++) {
			assertEquals(.5,(double)frequency[i]/(double)NUM_ITERATIONS,EPSILON);
		}
	}
	
	@Test
	/**
	 * This tests that random tile values are being generated in a frequency similar to that
	 * which is mentioned in the specs for this project
	 */
	public void generateRandomTileValueTest() {
		int[] frequency = new int[7];
		for(int i = 0; i<NUM_ITERATIONS; i++) {
			int value = util.generateRandomTileValue(RANDOM_1);
			frequency[value] = frequency[value]+1;
		}
		assertEquals(frequency[1] / (double)NUM_ITERATIONS, .4, EPSILON);
		assertEquals(frequency[2] / (double)NUM_ITERATIONS, .4, EPSILON);
		assertEquals(frequency[3] / (double)NUM_ITERATIONS, .1, EPSILON);
		assertEquals(frequency[6] / (double)NUM_ITERATIONS, .1, EPSILON);
	}
	
	/**
	 * This test tests that shiftArray is working properly with five of the most basic cases.
	 * THIS MAY ACTUALLY BE WRONG
	 * These are not all of the cases, so passing this method, does not necessarily mean that
	 * the method is working entirely correctly (e.g) this has no matrices of length 3
	 */
	@Test
	public void shiftArrayTest() {
		// Shift where no merges are accomplished only shifting
		int[] arr1 = {0,0,1,0};
		ArrayList<Move> moves = util.shiftArray(arr1);
		Move move1 = new Move(2,1,1);
		assertEquals(move1, moves.get(0));
		assertEquals(1,moves.size());
		
		// Shift where a merge does not take place because of empty cells
		int[] arr2 = {0,1,2,0};
		moves = util.shiftArray(arr2);
		move1 = new Move(1,0,1);
		Move move2 = new Move(2,1,2);
		assertEquals(move1, moves.get(0));
		assertEquals(move2, moves.get(1));
		assertEquals(2,moves.size());
		
		// Shift where a 2 and 1 are merged
		int[] arr3 = {2,1,3,6};
		moves = util.shiftArray(arr3);
		move1 = new Move(1,0,1,2,3);
		move2 = new Move(2,1,3);
		Move move3 = new Move(3,2,6);
		assertEquals(move1, moves.get(0));
		assertEquals(move2, moves.get(1));
		assertEquals(move3, moves.get(2));
		assertEquals(3,moves.size());
		
		// Shift where 2 of the same are merged and a 1 and 2 after them are not
		int[] arr4 = {3,6,6,1,2};
		moves = util.shiftArray(arr4);
		move1 = new Move(2,1,6,6,12);
		move2 = new Move(3,2,1);
		move3 = new Move(4,3,2);
		assertEquals(move1, moves.get(0));
		assertEquals(move2, moves.get(1));
		assertEquals(move3, moves.get(2));
		assertEquals(3,moves.size());
	}
}

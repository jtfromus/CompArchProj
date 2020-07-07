package team3Proj;

/*This class is a representation of a cash.
 * Diver should initialize a cash object
 * 
 * 
 * TODO provide function that return:
 * num of blocks
 * tag size
 * index size
 * num of rows
 * overhead size
 * and the cost
 * functions should be called in the Diver class
*/


public class Cache {
	//cashSize and blockSize are in bytes
	private int cashSize;
	private int blockSize;
	private int associativity;
	private final int DATABUS = 32;
	
	
	public Cache(int cashSize, int blockSize, int associativity) {
		this.blockSize = blockSize;
		this.cashSize = cashSize;
		this.associativity = associativity;
	};

	
	public int getNumOfBlocks() {return cashSize/blockSize;}
	public int getTagSize() {return DATABUS - getIndexSize() - getBlockOffset();}
	public int getBlockOffset() {return (int) (Math.log(blockSize)/Math.log(2));}
	public int getIndexSize() {return (int) (Math.log(getNumOfRows())/Math.log(2));}
	public int getNumOfRows() {return getNumOfBlocks()/associativity;}
	//public int getOverheadSize() {}
	//public double getCost() {}
	
	//Getters
	public int getCashSize() {return cashSize;}
	public int getBlockSize() {return blockSize;}
	public int getAssociativity() {return associativity;}
	
	//Setters
	public void setCashSize(int cashSize) {this.cashSize = cashSize;}
	public void setBlockSize(int blockSize) {this.blockSize = blockSize;}
	public void setAssociativity(int associativity) {this.associativity = associativity;}
}

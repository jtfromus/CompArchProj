package team3Proj;

/**
 * Version 1
 * This class is a representation of a Cache, as for right now this class provides the functions
 * to give the user the size of different elements in the cache
 * 7/7/2020
 * 
 * @author Jonathan Tan
 *
 */
public class Cache {
	//cacheSize and blockSize are in bytes
	private int cacheSize;
	private int blockSize;
	private int associativity;
	private final int DATABUS = 32, BYTE = 8; 
	private final double CACHECOST = 0.07;
	
	/**
	* @param  cacheSize the size of the cache in KB
	* @param  blockSize the size of the block in bytes
	* @param  associativity number of blocks per row in the cache
	*/
	public Cache(int cacheSize, int blockSize, int associativity) {
		this.blockSize = blockSize;
		this.cacheSize = (int) (cacheSize * Math.pow(2, 10));
		this.associativity = associativity;
	};
	
	/**
	 * formula: cache size / block size
	 * 
	 * @return	the number of blocks
	 */
	public int getNumOfBlocks() {return cacheSize/blockSize;}
	
	/**
	 * formula: number of total bits - index bits - block offset bits
	 * 
	 * @return	number of bits the tag has
	 */
	public int getTagSize() {return DATABUS - getIndexSize() - getBlockOffset();}
	
	/**
	 * formula: log base2 (block size)
	 * 
	 * @return	number of bits the block offset has
	 */
	public int getBlockOffset() {return (int) (Math.log(blockSize)/Math.log(2));}
	
	/**
	 * formula: log base2 (number of rows)
	 * 
	 * @return	number of bits the index has
	 */
	public int getIndexSize() {return (int) (Math.log(getNumOfRows())/Math.log(2));}
	
	/**
	 * formula: number of blocks / associativity
	 * 
	 * @return	the number of rows in the cache
	 */
	public int getNumOfRows() {return getNumOfBlocks()/associativity;}
	
	/**
	 * formula: [associativity * (valid bit + tag bit) * number of rows] / byte
	 * 
	 * @return the extra space that the memory has to accommodate for the header (without data) in byte
	 */
	public int getOverheadSize() {return associativity*(1+getTagSize())*getNumOfRows()/BYTE;}
	
	/**
	 * formula: cache size + overhead size
	 * 
	 * @return	the space required for the whole cache to be implemented in memory (include data) in byte
	 */
	public int getImplementationSize() {return getOverheadSize() + cacheSize;}
	
	/**
	 * formula: dollar per KB * implementation size(byte) / 2^10
	 * 
	 * @return	the cost (in dollars) to implement the cache in memory
	 */
	public double getCost() {return CACHECOST * getImplementationSize()/Math.pow(2, 10);}
	
	//Getters---------------------------------------------------------------------------------------------
	/**
	 * 
	 * @return the cache size in bytes
	 */
	public int getCashSize() {return cacheSize;}
	
	/**
	 * 
	 * @return the block size in bytes
	 */
	public int getBlockSize() {return blockSize;}
	
	/**
	 * 
	 * @return associativity
	 */
	public int getAssociativity() {return associativity;}
	
	
	//Setters---------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param cashSize the size of cache in KB
	 */
	public void setCacheSize(int cashSize) {this.cacheSize = (int) (cacheSize * Math.pow(2, 10));}
	
	/**
	 * 
	 * @param blockSize the size of block in bytes
	 */
	public void setBlockSize(int blockSize) {this.blockSize = blockSize;}
	
	/**
	 * 
	 * @param associativity
	 */
	public void setAssociativity(int associativity) {this.associativity = associativity;}
	
	/**
	 * @return the string representation of the cache
	 */
	public String toString() {
		return "Cache size: " + cacheSize/Math.pow(2, 10) + "KB\nBlock size: " + blockSize + "byte(s)\nAssociativity: " + associativity;
	}
}

package team3Proj;

public class Cache {
	//cashSize and blockSize are in bytes
	private int cacheSize;
	private int blockSize;
	private int associativity;
	private final int DATABUS = 32, BYTE = 8; 
	private final double CACHECOST = 0.07;
	
	/**
	* @param  cacheSize		the size of the cache in KB
	* @param  blockSize 	the size of the block in bytes
	* @param  associativity	number of block per row in the cache
	*/
	public Cache(int cashSize, int blockSize, int associativity) {
		this.blockSize = blockSize;
		this.cacheSize = (int) (cashSize * Math.pow(2, 10));
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
	
	//Getters
	public int getCashSize() {return cacheSize;}
	public int getBlockSize() {return blockSize;}
	public int getAssociativity() {return associativity;}
	
	//Setters
	public void setCacheSize(int cashSize) {this.cacheSize = cashSize;}
	public void setBlockSize(int blockSize) {this.blockSize = blockSize;}
	public void setAssociativity(int associativity) {this.associativity = associativity;}
}

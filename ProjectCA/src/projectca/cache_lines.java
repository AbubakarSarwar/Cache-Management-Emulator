/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectca;

/**
 *
 * @author k132212
 */
public class cache_lines {
    private int set;
    private int tag;
    private int valid;
    private int[] data = new int[16];

    /**
     * This method returns the set number of the cache line.
     * @return Set Number of the Cache line
     */
    public int getSet() {
        return set;
    }

    /**
     * Returns the Tag of the Cache Line
     * @return tag of the cache line
     */
    public int getTag() {
        return tag;
    }

    /**
     * This method puts the tag in the cache line.
     * @param tag Integer tag
     */
    public void setTag(int tag) {
        this.tag = tag;
    }

    /**
     * Checks the valid bit and return the value of valid at that particular cache line
     * @return valid bit value
     */
    public int getValid() {
        return valid;
    }

    /**
     * Sets the valid bit
     * @param valid value to be set as a valid bit.
     */
    public void setValid(int valid) {
        this.valid = valid;
    }

    /**
     * Returns the Data line of the Cache.
     * @return Integer array containing the data of the cache.
     */
    public int[] getData() {
        return data;
    }

    /**
     * Sets the data in the cache line.
     * @param data Integer array
     */
    public void setData(int[] data) {
        this.data = data;
    }
    /**
     * Initializes the Cache Lines by receiving the set number.
     * @param set The cache set number for which the cache lines are to be initialized.
     * @return The object of cache_lines.
     */
    public cache_lines init_cache_lines(int set) {
            this.set = set;
            this.tag = -99;
            this.valid = 0;
            for(int i=0;i< this.data.length;i++)
            {
                this.data[i] = 0;
            }
            return this;
    }
}


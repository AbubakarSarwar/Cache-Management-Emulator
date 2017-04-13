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
public class memory {
    public static int[][] memory = new int[global.memory_blocks][global.memory_blocks];

    /**
     * Initializing Memory
     */
    public static void init_memory()
    {
        for(int i=0;i<global.memory_blocks;i++){
            for(int j=0;j<global.memory_blocks;j++){
                memory[i][j] = i*10+j;
            }
        }
    }

    /**
     * Printing Memory
     */
    public static void print()
    {
        System.out.println("Memory Block");
        for(int[] row : memory){
            for(int col : row){
                System.out.print(col+"\t");
            }
            System.out.println();
        }
    }

    /**
     * Gets the data at a particular memory line
     * @param block_number the block number accessed
     * @return the data in the block accessed
     */
    public static int[] getMemory(int block_number){
        return memory[block_number];
    }
}

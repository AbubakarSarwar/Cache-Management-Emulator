/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectca;

/**
 *
 * @author k132212
 */import java.util.Arrays;

/**
 */
public class cache {

    /* Cache Line Object created */
    static cache_lines[][] lines = new cache_lines[global.sets][global.associativity];
    private static cache_lines temp = new cache_lines();

    /**
     * Initializing Cache.
     */
    public static void init_cache(){
        for(int set=0; set<global.getSets();set++) {
            for (int assoc = 0; assoc < global.getAssociativity(); assoc++) {
                lines[set][assoc] = temp.init_cache_lines(set);
                temp = new cache_lines();
            }
        }
    }

    /**
     * Printing the Cache
     */
    public static void print()
    {
        System.out.println("Cache Block:");
        for(cache_lines[] line_block : lines){
            for(cache_lines line : line_block)
            System.out.println("Set="+line.getSet()+" valid= "+line.getValid()+" Tag= "+line.getTag()+"\t"
                    + Arrays.toString(line.getData())+"");
        }
    }

    /**
     * Checks if there is a cache hit
     * @param block_number the block number from he memory on which operation is performed
     * @param action Type of operation (Read or Write)
     * @return true or false
     */
    public static boolean is_cache_hit(int block_number, String action){

        int set_number = global.setNumber(block_number);
        int line_counter=0;
        /* Looping through the Cache Lines of a particular set */
        for(cache_lines line_of_set : lines[set_number]){

            /* Checking where the tag is equal to the block number access and valid bit is true */
            if(line_of_set.getValid() != 0 && line_of_set.getTag() == block_number ) {
                    if (action.equals(global.READ)) {
                        global.readHit();
                        return true;
                    } else if (action.equals(global.WRITE)) {
                        global.writeHit();
                        global.write_hit_line = line_counter;
                        return true;
                    } else
                        return true;
                }
            line_counter++;
            }
        return false;
    }

    /**
     * Loads data from memory into Cache if there was a Cache Read Miss
     * @param block_number the Block to be accessed from memory
     */
    public static void load_from_memory(int block_number){
        int set_number = global.setNumber(block_number);
        boolean line_added = false;
        int[] memory_line = memory.getMemory(block_number);

        /* If any cache line is still empty in a set it will be filled otherwise any line will be replaced randomly */
        for(cache_lines line_of_set : lines[set_number]) {
            if (line_of_set.getValid() == 0) {
                line_of_set.setValid(1);
                line_of_set.setTag(block_number);
                line_of_set.setData(memory_line);
                line_added = true;
                break;
            }
        }
        if(!line_added){
            int random_line = (int) ( Math.random() * 2 + 1);
            lines[set_number][random_line-1].setTag(block_number);
            lines[set_number][random_line-1].setData(memory_line);
        }
    }

    /**
     * Writes the user entered value at a particular offset in the cache data on a Write Hit
     * @param block_number The block number of the memory
     * @param offset the value offset in the block
     * @param value the user provided value that has to be added
     */
    public static void write_to_cache(int block_number, int offset, int value){
        int set_number = global.setNumber(block_number);
        int[] data = lines[set_number][global.write_hit_line].getData();
        data[offset] = value;
        lines[set_number][global.write_hit_line].setData(data);
    }

}

package projectca;

public class global {

    public static final String READ = "Read";
    public static final String WRITE = "Write";

    static int associativity;
    static int sets;
    static int memory_blocks = 16;
    static int cache_lines = 8;
    static int read_hit = 0;
    static int read_miss = 0;
    static int write_hit = 0;
    static int write_miss = 0;
    static int write_hit_line = 0;

    /**
     * Returns the Associativity of the Cache
     * @return
     */
    public static int getAssociativity() {
        return associativity;
    }

    /**
     * Sets the user provided associativity
     * @param associativity User input passed from the main class
     */
    public static void setAssociativity(int associativity) {
        global.associativity = associativity;
    }

    /**
     * Get the number of sets formed in the cache based on the associativity
     * @return sets Number of sets in Cache
     */
    public static int getSets() {
        return sets;
    }

    /**
     * Method calculates the number of sets based on the cache lines and user provided associativity
     */
    public static void setSets() {
        global.sets = cache_lines/associativity;
    }

    /**
     * Increases the Read Hit Counter
     */
    public static void readHit() {
        read_hit++;
    }

    /**
     * Increases the Read Miss Counter
     */
    public static void readMiss(){
        read_miss++;
    }

    /**
     * Increases the Write Hit Counter
     */
    public static void writeHit(){
        write_hit++;
    }

    /**
     * Increases the Write Miss Counter
     */
    public static void writeMiss(){
        write_miss++;
    }

    /**
     * Returns the set number for a particular block access from memory
     * @param block the block number to be accessed from memory
     * @return the set number calculate using the block number and number of sets
     */
    public static int setNumber(int block){ return  block % getSets(); }

    /**
     * Prints the Hit and Miss Records.
     */
    public static void printHitMiss(){
        System.out.println( "\nRead Hit: \t\t"   + read_hit
                          + "\nRead Miss: \t\t"  + read_miss
                          + "\nWrite Hit: \t\t"  + write_hit
                          + "\nWrite Miss: \t\t" + write_miss);
    }

    /**
     * Provides a line break with a heading
     * @param Banner Heading to be assigned to the page break
     */
    public static void screenBreak(String Banner){
        System.out.println("<<<<<<<<<<<<<<********************************"+Banner+"******************************>>>>>>>>>>>>>>");
    }

}


package goocraft4evr.nonamedyes;

public class UtilIdRegistrar {
    private static final int block_id = 1000;
    private static final int item_id = 17000;
    private static int curr_id = 0;

    public static int nextId() {
        return curr_id++;
    }
    public static void setIdToBlock() {curr_id = block_id;}
    public static void setIdToItem() {curr_id = item_id;}
}

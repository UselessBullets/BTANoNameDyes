package goocraft4evr.nonamedyes;

public class UtilIdRegistrar {
    private static int block_id;
    private static int item_id;
    private static int gui_id;
    public static int curr_id = 0;

    public static void initIds(int blockId, int itemId, int guiId) {
        block_id = blockId;
        item_id = itemId;
        gui_id = guiId;
    }

    public static int nextId() {
        return curr_id++;
    }
    public static void setIdToBlock() {curr_id = block_id;}
    public static void setIdToItem() {curr_id = item_id;}
	public static void setIdToGUI(){
		curr_id = gui_id;
	}
}

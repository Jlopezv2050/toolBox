package javaCore;

/**
 * "has-a" relationship
 * As a general rule, use Composition instead of Inheritance to give more flexibility
 * -----line----</>
 */
public class _11_b_Composition {

    private class Forniture {

        private String material;
        private int size;

        public Forniture(String material, int size) {
            this.material = material;
            this.size = size;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

    }

    private class Table extends Forniture {


        private boolean settedTable;

        public Table(String material, int size, int numLegs, String color, boolean settedTable) {
            super(material, size);
            this.settedTable = settedTable;
        }

        public boolean getSettedTable() {
            return settedTable;
        }

        public void setSettedTable(boolean settedTable) {
            this.settedTable = settedTable;
        }

    }

    private class Room {

        private Table mainTable = new Table("wood", 78, 4, "grey", true);

        public Room() {
        }

        public void clearTable() {
            if (mainTable.getSettedTable()) {
                mainTable.setSettedTable(false);
                System.out.println("Table Cleared");
            } else {
                System.out.println("Table already cleared");
            }
        }

    }

    public static void main(String[] args) {

        _11_b_Composition room = new _11_b_Composition();
        Room room1 = room.new Room();

        //the best practise is not access directly to the table, managed by room
        room1.clearTable();
    }


}

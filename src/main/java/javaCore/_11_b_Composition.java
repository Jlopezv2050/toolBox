package javaCore;

/**
 * "HAS-A" relationship
 * As a general rule, think first Composition before of Inheritance to give more flexibility
 * -----line----</>
 */
public class _11_b_Composition {

    private class Forniture {

        private String material;
        private int size;

        public Forniture(String material, int size) {
            this.material = material;
            this.size = size;

            System.out.println("You've created a forniture make by: " + this.material + " and its size is: " + this.size);
        }
    }

    private class Table extends Forniture {

        private boolean settedTable;

        public Table(String material, int size, boolean settedTable) {
            super(material, size);
            this.settedTable = settedTable;
        }

        //Unless you need more logic, access table from room directly
        @SuppressWarnings("unused")
        public boolean getSettedTable() {
            return settedTable;
        }

        public void setSettedTable(boolean settedTable) {
            this.settedTable = settedTable;
        }

    }

    private class Room {

        private Table mainTable = new Table("wood", 78, true);

        public Room() {
        }

        public void clearTable() {
            if (mainTable.settedTable) {
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

        //wrong way
        room1.mainTable.setSettedTable(true);
        //the best practise is not access directly to the table, managed by room
        room1.clearTable();
    }
}
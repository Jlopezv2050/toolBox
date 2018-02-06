package basis;

public class _14_b_Abstraction {

    abstract class ListItem<T extends ListItem> {
        ListItem nextItem;
        ListItem previousItem;

        Object value;

        abstract void moveToNext();

        abstract void moveToPrevious();


        abstract int compareTo(T listItem);
    }

    class ItemString extends ListItem<ItemString> {

        String value;

        ItemString previousItem;
        ItemString nextItem;

        public ItemString(String value) {
            this.value = value;
        }

        @Override
        void moveToNext() {
        }

        @Override
        void moveToPrevious() {
        }

        @Override
        int compareTo(ItemString listItem) {
            return this.value.compareTo(listItem.value);
        }
    }

    class LinkItemList {
        ItemString headItem = null;
        ItemString currentItem = null;

        void addItem(ItemString itemToAdd) {
            if (headItem == null) {
                headItem = itemToAdd;
                currentItem = itemToAdd;
            } else {
                if (itemToAdd.compareTo(currentItem) > 0) {
                    if (!(currentItem.nextItem != null && itemToAdd.value.equals(currentItem.nextItem.value))) {
                        currentItem.nextItem = itemToAdd;
                        itemToAdd.previousItem = currentItem;
                        currentItem = itemToAdd;
                    }
                } else {
                    while (currentItem.compareTo(itemToAdd) > 0) {
                        currentItem = currentItem.previousItem;
                    }
                    itemToAdd.nextItem = currentItem.nextItem;
                    itemToAdd.previousItem = currentItem;
                    currentItem.nextItem.previousItem = itemToAdd;
                    currentItem.nextItem = itemToAdd;
                }
            }
        }

        void printList() {
            ItemString itemToPrint = headItem;
            while (itemToPrint != null) {
                System.out.print(itemToPrint.value + ", ");
                itemToPrint = itemToPrint.nextItem;
            }
        }
    }

    public static void main(String[] args) {

        _14_b_Abstraction b_abstraction = new _14_b_Abstraction();
        LinkItemList linkItemList = b_abstraction.new LinkItemList();
        linkItemList.addItem(b_abstraction.new ItemString("a"));
        linkItemList.addItem(b_abstraction.new ItemString("c"));
        linkItemList.addItem(b_abstraction.new ItemString("d"));
        linkItemList.addItem(b_abstraction.new ItemString("e"));
        linkItemList.addItem(b_abstraction.new ItemString("b"));
        linkItemList.addItem(b_abstraction.new ItemString("b"));

        linkItemList.printList();
    }
}

//iteration pattern implementation
public class OfferingIterator implements ListIterator{

    private final OfferingList offList;
    int offIter;

    public OfferingIterator(OfferingList list) {
    	System.out.println("Iterator Implemented - Meat");
        this.offList = list;
        offIter = 0;
    }

    @Override
    public boolean hasNext() {
        return offIter < offList.size();
    }

    @Override
    public Object next() {
        return offList.get(offIter);
    }

    @Override
    public void moveToHead() {
        offIter = 0;
    }

    @Override
    public void remove() {
        offList.remove(offIter);
    }
}

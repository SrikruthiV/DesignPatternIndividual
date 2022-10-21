//iteration pattern implementation
public class ProductIterator implements ListIterator {

    private final ClassProductList prodList;
    int listIter;

    public ProductIterator(ClassProductList list) {
    	System.out.println("Iterator Pattern for Product Successfull");
        this.prodList = list;
        listIter = 0;
    }

    @Override
    public boolean hasNext() {
        return listIter < prodList.size();
    }

    @Override
    public Object next() {
        return prodList.get(listIter);
    }

    @Override
    public void moveToHead() {
        listIter = 0;
    }

    @Override
    public void remove() {
        prodList.remove(listIter);
    }
}

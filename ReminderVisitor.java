//Implementation Iterator Pattern
public class ReminderVisitor extends  NodeVisitor{
    private Reminder remVis;

    public ReminderVisitor(Reminder remin, Facade facad, ClassProductList clsProd, Trading trad) {
        this.remVis = remin;
    }

    @Override
    public void visitProduct(Product prodObj) {
        prodObj.accept(this);
    }

    @Override
    public void visitTrading(Trading tradeObj) {
        tradeObj.accept(this);
    }

    @Override
    public void visitFacade(Facade facadeObj) {
        facadeObj.accept(this);
    }
}



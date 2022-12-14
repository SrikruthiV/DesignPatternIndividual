//Implementation of Iterator Pattern
public abstract class NodeVisitor {
    public abstract void visitProduct(Product product);
    public abstract void visitTrading(Trading product);
    public abstract void visitFacade(Facade product);
}


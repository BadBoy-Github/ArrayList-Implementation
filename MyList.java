

public interface MyList {
    
//    Collection Interface methods
    public abstract void add(Object x);
    public abstract void remove(Object x);
    public abstract boolean contains(Object x);
   
    
    
//    List Interface Methods
    public abstract void add(int index, Object x);
    public abstract Object get(int index);
    public abstract void set(int index, Object x);
    public abstract void remove(int index);
    public abstract void sort();
    public abstract void reverse();
    
}

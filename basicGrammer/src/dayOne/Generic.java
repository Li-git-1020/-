package dayOne;

public class Generic<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    //泛型方法改进
    public <T> void show(T t){
        System.out.println(t);
    }
}

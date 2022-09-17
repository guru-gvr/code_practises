package main.java.org.example.SINGLETON;

public enum Singleton {
//    private int value;
//
//    public int getValue() {
//        return value;
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
    INSTANCE;
    int value;

    private Singleton() {
        System.out.println("Here");
    }

    public void setValue(int value) {
        this.value = value;
    }
}

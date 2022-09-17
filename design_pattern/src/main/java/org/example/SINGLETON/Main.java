package main.java.org.example.SINGLETON;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.setValue(100);

        Singleton singleton3 = Singleton.INSTANCE;
        singleton3.setValue(100);

        Singleton singleton2 = Singleton.INSTANCE;
        singleton2.setValue(101);

        Integer aal = new Integer(100);
        Integer aaa2 = new Integer(100);

        Map<Integer, String> aaa = new HashMap<>();
        aaa.put(aal,"first one");
        aaa.put(aaa2,"Second");

        System.out.println(aaa);

        System.out.println(singleton2.value+" "+singleton.value+" "+singleton3.value);
    }
}

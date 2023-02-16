package de.telran.springdemo.model;


public class Greeting {
    private long id;
    private String value;

    private int count;

    public Greeting() {}

    public Greeting(String value, int count) {
        this.value = value;
        this.count = count;
    }
    public Greeting(long id, String value, int count) {
        this.id = id;
        this.value = value;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id='" + id + '\'' +
                "value='" + value + '\'' +
                ", repeatCount=" + count +
                '}';
    }
}

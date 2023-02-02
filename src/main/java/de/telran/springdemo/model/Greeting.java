package de.telran.springdemo.model;

public class Greeting {
    private String value;

    private int count;

    public Greeting(String value, int count) {
        this.value = value;
        this.count = count;
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
                "value='" + value + '\'' +
                ", repeatCount=" + count +
                '}';
    }
}

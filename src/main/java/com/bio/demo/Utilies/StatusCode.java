package com.bio.demo.Utilies;

public enum StatusCode {
    SUCCESS(4000, "Success");

    private final int value;
    private final String name;

    private StatusCode(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int value() {
            return this.value;
        }
    public String toString() {
            return this.name;
        }
}

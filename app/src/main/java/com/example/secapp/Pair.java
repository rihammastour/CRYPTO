package com.example.secapp;

class Pair {

    public char[] first;

    public char[] second;

    Pair(char[] first, char[] second) {
        this.first = first;
        this.second = second;
    }

    public char[] getFirst() {
        return first;
    }

    public void setFirst(char[] first) {
        this.first = first;
    }

    public char[] getSecond() {
        return second;
    }

    public void setSecond(char[] second) {
        this.second = second;
    }

    @Override
    public String toString() {
        int size = first.length + second.length;
        String str = "";
        for (int i = 0; i < first.length; i++) {
            str += first[i] + " ";
        }
        for (int i = 0; i < second.length; i++) {
            str += second[i] + " ";
        }
        return str;
    }

}

package thintkinginjava4.chapter_21.other;

public class Atomicity {
    int i;
    void f1(){
        i++;
    }
    void f2(){
        i += 3;
    }
}

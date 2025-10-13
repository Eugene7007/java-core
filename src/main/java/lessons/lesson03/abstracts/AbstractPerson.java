package lessons.lesson03.abstracts;

import lombok.Data;

@Data
public abstract class AbstractPerson {

    public abstract void print();


    public final void printName(){
        System.out.println("Name");
    }
}

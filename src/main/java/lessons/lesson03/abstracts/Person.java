package lessons.lesson03.abstracts;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends AbstractPerson {

    @Override
    public void print() {
        System.out.println( "Person");
        printName();
    }
}

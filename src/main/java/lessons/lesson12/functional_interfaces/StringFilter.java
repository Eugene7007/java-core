package lessons.lesson12.functional_interfaces;

import java.util.function.Predicate;

public enum StringFilter {
    NON_EMPTY(s -> !s.isEmpty()),
    STARTS_WITH_A(s -> s.startsWith("A")),
    LONGER_THAN_3(s -> s.length() > 3);

    private final Predicate<String> predicate;

    StringFilter(Predicate<String> predicate) {
        this.predicate = predicate;
    }

    public boolean test(String s) {
        return predicate.test(s);
    }
}
package lessons.lesson12.functional_interfaces;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

public enum DataSource {
    TIME(LocalDateTime::now),
    UUID_GEN(UUID::randomUUID),
    CONSTANT(() -> "STATIC_VALUE");

    private final Supplier<?> supplier;

    DataSource(Supplier<?> supplier) {
        this.supplier = supplier;
    }

    public Object get() {
        return supplier.get();
    }
}

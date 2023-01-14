package tu.varna.table.impl;

import org.jdom2.Element;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Table<R, C, V> {

    boolean contains(Object rowKey, Object columnKey);

    boolean containsRow(Object rowKey);

    boolean containsColumn(Object columnKey);

    boolean containsValue(Object value);

    V get(Object rowKey, Object columnKey);

    boolean isEmpty();

    int size();

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();

    void clear();

    void put(R rowKey, C columnKey, V value);

    void putAll(Table<? extends R, ? extends C, ? extends V> table);

    void remove(Object rowKey, Object columnKey);

    Map<C, V> row(R rowKey);

    Map<R, V> column(C columnKey);

    Set<Cell<R, C, V>> cellSet();

    Set<R> rowKeySet();

    Set<C> columnKeySet();

    Collection<V> values();

    Map<R, Map<C, V>> rowMap();

    Map<C, Map<R, V>> columnMap();

    Element toXml();

    interface Cell<R, C, V> {
        R getRowKey();

        C getColumnKey();

        V getValue();

        @Override
        boolean equals(Object obj);

        @Override
        int hashCode();
    }
}

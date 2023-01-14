package tu.varna.table.impl;

import org.jdom2.Element;

import java.util.*;

import static tu.varna.util.Preconditions.checkNotNull;

public class HashBasedImpl<R, C, V> implements Table<R, C, V> {

    private Map<R, Map<C, V>> table;

    public HashBasedImpl() {
        table = new HashMap<>();
    }

    @Override
    public boolean contains(Object rowKey, Object columnKey) {
        checkNotNull(rowKey, columnKey);
        return table.containsKey(rowKey) && table.get(rowKey).containsKey(columnKey);
    }

    @Override
    public boolean containsRow(Object rowKey) {
        checkNotNull(rowKey);
        return table.containsKey(rowKey);
    }

    @Override
    public boolean containsColumn(Object columnKey) {
        checkNotNull(columnKey);
        for (Map<C, V> row : table.values()) {
            if (row.containsKey(columnKey)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        checkNotNull(value);
        for (Map<C, V> row : table.values()) {
            if (row.containsValue(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object rowKey, Object columnKey) {
        checkNotNull(rowKey, columnKey);
        if (contains(rowKey, columnKey)) {
            return table.get(rowKey).get(columnKey);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return table.isEmpty();
    }

    @Override
    public int size() {
        int size = 0;
        for (Map<C, V> row : table.values()) {
            size += row.size();
        }
        return size;
    }

    @Override
    public void clear() {
        table.clear();
    }

    @Override
    public void put(R rowKey, C columnKey, V value) {
        checkNotNull(rowKey, columnKey, value);
        if (!table.containsKey(rowKey)) {
            table.put(rowKey, new HashMap<>());
        }
        table.get(rowKey).put(columnKey, value);
    }

    @Override
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        checkNotNull(table);
        for (Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
            put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    @Override
    public void remove(Object rowKey, Object columnKey) {
        checkNotNull(rowKey, columnKey);
        if (contains(rowKey, columnKey)) {
            table.get(rowKey).remove(columnKey);
        }
    }

    @Override
    public Map<C, V> row(R rowKey) {
        checkNotNull(rowKey);
        return table.get(rowKey);
    }

    @Override
    public Map<R, V> column(C columnKey) {
        checkNotNull(columnKey);
        Map<R, V> column = new HashMap<>();
        for (R rowKey : table.keySet()) {
            if (table.get(rowKey).containsKey(columnKey)) {
                column.put(rowKey, table.get(rowKey).get(columnKey));
            }
        }
        return column;
    }

    @Override
    public Set<Cell<R, C, V>> cellSet() {
        Set<Cell<R, C, V>> cellSet = new HashSet<>();
        for (R rowKey : table.keySet()) {
            for (C columnKey : table.get(rowKey).keySet()) {
                cellSet.add(new CellImpl<>(rowKey, columnKey, table.get(rowKey).get(columnKey)));
            }
        }
        return cellSet;
    }

    @Override
    public Set<R> rowKeySet() {
        return table.keySet();
    }

    @Override
    public Set<C> columnKeySet() {
        Set<C> columnKeySet = new HashSet<>();
        for (R rowKey : table.keySet()) {
            columnKeySet.addAll(table.get(rowKey).keySet());
        }
        return columnKeySet;
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (R rowKey : table.keySet()) {
            values.addAll(table.get(rowKey).values());
        }
        return values;
    }

    @Override
    public Map<R, Map<C, V>> rowMap() {
        return table;
    }

    @Override
    public Map<C, Map<R, V>> columnMap() {
        Map<C, Map<R, V>> columnMap = new HashMap<>();
        for (R rowKey : table.keySet()) {
            for (C columnKey : table.get(rowKey).keySet()) {
                if (!columnMap.containsKey(columnKey)) {
                    columnMap.put(columnKey, new HashMap<>());
                }
                columnMap.get(columnKey).put(rowKey, table.get(rowKey).get(columnKey));
            }
        }
        return columnMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashBasedImpl<?, ?, ?> hashBased = (HashBasedImpl<?, ?, ?>) o;
        return Objects.equals(table, hashBased.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table);
    }

    @Override
    public String toString() {
        //print only values in table format with row and column keys as headers
       /* StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (C columnKey : columnKeySet()) {
            sb.append(columnKey).append(" ");
        }
        sb.append("\n");
        for (R rowKey : rowKeySet()) {
            sb.append(rowKey).append(" ");
            for (C columnKey : columnKeySet()) {
                sb.append(get(rowKey, columnKey)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
*/

        /*sb.append("  ");
        for (C columnKey : columnKeySet()) {
            sb.append(columnKey).append(" ");
        }
        sb.append("\n");
        for (R rowKey : rowKeySet()) {
            sb.append(rowKey).append(" ");
            for (C columnKey : columnKeySet()) {
                sb.append(get(rowKey, columnKey) == null ? " " : get(rowKey, columnKey)).append(",");
            }
            sb.append("\n");
        }
        return sb.toString();*/
        //print only values in table format,split values with , replace null with empty string
        StringBuilder sb = new StringBuilder();
        for (R rowKey : rowKeySet()) {
            for (C columnKey : columnKeySet()) {
                sb.append(get(rowKey, columnKey) == null ? " " : get(rowKey, columnKey)).append(",");
            }
            sb.append("\n");
        }
        return sb.toString();

    }
    @Override
    public Element toXml() {
        Element root = new Element("table");
        for (R rowKey : table.keySet()) {
            Element row = new Element("row");
            row.setAttribute("key", rowKey.toString());
            for (C columnKey : table.get(rowKey).keySet()) {
                Element column = new Element("column");
                column.setAttribute("key", columnKey.toString());
                Element value = new Element("value");
                value.setText(table.get(rowKey).get(columnKey).toString());
                column.addContent(value);
                row.addContent(column);
            }
            root.addContent(row);
        }
        return root;
    }
}

package tu.varna.table.impl;

public class CellImpl<R, C, V> implements Table.Cell<R, C, V> {

    private R rowKey;
    private C columnKey;
    private V value;

    public CellImpl(R rowKey, C columnKey, V value) {
        this.rowKey = rowKey;
        this.columnKey = columnKey;
        this.value = value;
    }

    @Override
    public R getRowKey() {
        return rowKey;
    }

    @Override
    public C getColumnKey() {
        return columnKey;
    }

    @Override
    public V getValue() {
        return value;
    }
}

package Conversion;

import com.mongodb.DBObject;

public interface RowCursor<T> {
    /**
     * 将Object类转化为bean
     *
     * @param dbObject
     * @return
     */

    public T cursorRow(DBObject dbObject);
}

package Core.Entities;

import java.sql.ResultSet;

public interface Callback extends Runnable {
    public void setResultSet(ResultSet rs);
}

package jeaQueue;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseConnectionPool connectionPool=new DataBaseConnectionPool();
        connectionPool.releaseConnection(connectionPool.getConnection());
        connectionPool.getConnection();
    }
}

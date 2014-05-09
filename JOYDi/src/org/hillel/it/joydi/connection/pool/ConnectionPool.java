package org.hillel.it.joydi.connection.pool;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
	Connection getConnection() throws SQLException;

	void destroy();

}

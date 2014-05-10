package org.hillel.it.joydi.connection.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hillel.it.joydi.infra.config.Configuration;

public class ReUsableConnectionPool implements ConnectionPool {

	private boolean available;
	private int maxConnections;
	private String url;
	private List<ReUseableConnection> connections;
	Configuration config;

	public ReUsableConnectionPool() {
		connections = new ArrayList<>();
		this.maxConnections = 10;
		available = true;
		config = Configuration.getInstance();
		this.url = config.getPropertie("url");

	}

	private Connection connectionCreate() throws SQLException {
		Connection con = DriverManager.getConnection(url);
		ReUseableConnection connection = new ReUseableConnection(con);
		connections.add(connection);
		return connection;

	}

	@Override
	public Connection getConnection() throws SQLException {
		for (ReUseableConnection rc : connections) {
			if (!rc.isBusy()) {
				return rc;
			}
		}
		if (maxConnections > connections.size()) {
			return connectionCreate();
		} else {
			throw new RuntimeException("Connection limit reached");
		}
	}

	@Override
	public void destroyAllConnections() throws SQLException {
		for (ReUseableConnection rc : connections) {
			if (rc.isBusy()){
				rc.rollback(); // rollback() cancel all queries
				rc.close();
			}
		}

	}

}

package org.hillel.it.joydi.connection.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

	public ReUsableConnectionPool(int maxConnections) {
		connections = new ArrayList<>();
		this.maxConnections = Integer.valueOf(
				config.getPropertie("maxConnections")).intValue();
		available = true;
		config = Configuration.getInstance();
		this.url = config.getPropertie("url");

	}

	private Connection connectionCreate() {
		ReUseableConnection connection = null;
		try {
			connection = (ReUseableConnection) DriverManager
					.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public void destroy() {

	}
}

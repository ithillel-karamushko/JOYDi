package org.hillel.it.joydi.persistance.inmemory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hillel.it.joydi.connection.pool.ReUsableConnectionPool;
import org.hillel.it.joydi.model.entities.Picture;
import org.hillel.it.joydi.persistance.repository.PictureRepository;

public class InMemoryPictureRepository implements PictureRepository {

	private ReUsableConnectionPool rc;
	private Connection connection;

	/*
	 * ¬€«Œ¬  ŒÕ—“–” “Œ–¿ ¡≈« CONNECTIONPOOL!!!
	 * 
	 * public InMemoryPictureRepository() throws SQLException { try (Connection
	 * connection = DriverManager
	 * .getConnection("jdbc:derby:DerbyDb;create=true")) { try (Statement st =
	 * connection.createStatement()) { st.executeUpdate("" +
	 * "create table Pictures(" +
	 * "id int primary key , fileUrl varchar(1024), creatingDate datetime))"); }
	 * } }
	 */

	// ¬€«Œ¬ — CONNECTIONPOOL

	public InMemoryPictureRepository() throws SQLException {
		try {
			rc = new ReUsableConnectionPool();
			connection = rc.getConnection();
			try (Statement st = connection.createStatement()) {
				st.executeUpdate("CREATE DATABASE IF NOT EXISTS JoydiPictures;");
				st.executeUpdate("USE JoydiPictures;");
				st.executeUpdate("CREATE TABLE IF NOT EXISTS Pictures (id integer not null auto_increment,"
						+ " creatingDate Date, fileUrl varchar(256), primary key(id));");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void addPicture(Picture picture) throws SQLException {
		try (Connection connection = rc.getConnection()) {
			try (PreparedStatement st = connection
					.prepareStatement("INSERT INTO Pictures (creatingDate, fileUrl) VALUE (? ,?)")) {
				try {
					st.setString(1, picture.getCreatingDate());
					st.setString(2, picture.getFileUrl());
					st.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deletePicture(Picture picture) {
		try (Connection connection = rc.getConnection()) {
			try (PreparedStatement st = connection
					.prepareStatement("DELETE FROM Pictures WHERE fileUrl=?")) {
				st.setString(1, picture.getFileUrl());
				st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void getPicture() {
		try (Connection connection = rc.getConnection()) {
			try (Statement st = connection.createStatement()) {
				ResultSet rs = st.executeQuery("SELECT * FROM Pictures");
				while (!rs.next()) {
					int id = rs.getInt(rs.findColumn("id"));
					String name = rs.getString(rs.findColumn("fileUrl"));
					System.out.println("Id=" + id + ",fileUrl=" + name);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

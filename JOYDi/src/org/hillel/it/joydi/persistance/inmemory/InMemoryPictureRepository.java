package org.hillel.it.joydi.persistance.inmemory;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hillel.it.joydi.connection.pool.ReUsableConnectionPool;
import org.hillel.it.joydi.model.entities.Picture;
import org.hillel.it.joydi.persistance.repository.PictureRepository;

public class InMemoryPictureRepository implements PictureRepository,
		Serializable {

	private static final long serialVersionUID = -7778698168546753795L;
	private ReUsableConnectionPool rc;
	private Connection connection;
	private int idCount;

	public InMemoryPictureRepository() {
	}

	// public InMemoryPictureRepository() throws SQLException {
	// try {
	// rc = new ReUsableConnectionPool();
	// connection = rc.getConnection();
	// try (Statement st = connection.createStatement()) {
	// st.executeUpdate("CREATE DATABASE IF NOT EXISTS JoydiPictures;");
	// st.executeUpdate("USE JoydiPictures;");
	// st.executeUpdate("CREATE TABLE IF NOT EXISTS Pictures (id integer not null auto_increment,"
	// + " creatingDate Date, fileUrl varchar(256), primary key(id));");
	// }
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// }
	// }

	public ReUsableConnectionPool getRc() {
		return rc;
	}

	public void setRc(ReUsableConnectionPool rc) {
		this.rc = rc;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public int getIdCount() {
		return idCount;
	}

	public void setIdCount(int idCount) {
		this.idCount = idCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void createDatabase() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection connection = rc.getConnection()) {
				try (Statement st = connection.createStatement()) {
					st.executeUpdate("CREATE DATABASE IF NOT EXISTS JoydiPictures;");
					st.executeUpdate("USE JoydiPictures;");
					st.executeUpdate("CREATE TABLE IF NOT EXISTS Pictures (id integer not null auto_increment,"
							+ " creatingDate Date, fileUrl varchar(256), primary key(id));");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void savePicture(Picture picture) throws SQLException {
		createDatabase();
		picture.setId(idCount);
		idCount++;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try (Connection connection = rc.getConnection()) {
			try (PreparedStatement st = connection
					.prepareStatement("INSERT INTO Pictures (id, creatingDate, fileUrl) VALUE (?, ? ,?)")) {
				try {
					st.setInt(1, picture.getId());
					st.setString(2, picture.getCreatingDate());
					st.setString(3, picture.getFileUrl());
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

	@Override
	public String returnPictureById(int id) {
		String result = null;
		try (Connection connection = rc.getConnection()) {
			try (Statement st = connection.createStatement()) {
				ResultSet rs = st
						.executeQuery("SELECT fileUrl FROM Pictures where 'id'=?");
				while (!rs.next()) {
					String name = rs.getString(rs.findColumn("fileUrl"));
					result = name;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public void deletePictureById(int id) {
		try (Connection connection = rc.getConnection()) {
			try (PreparedStatement st = connection
					.prepareStatement("DELETE FROM Pictures WHERE id = ?;")) {
				st.setInt(1, id);
				st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

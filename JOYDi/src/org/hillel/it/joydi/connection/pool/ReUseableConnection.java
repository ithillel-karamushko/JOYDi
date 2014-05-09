package org.hillel.it.joydi.connection.pool;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ReUseableConnection implements Connection {

	private boolean busy;
	private Connection cnt;

	public ReUseableConnection(Connection cnt) {
		busy = true;
		this.cnt = cnt;
	}

	public boolean isBusy() {
		return busy;
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		boolean iwf = cnt.isWrapperFor(arg0);
		return iwf;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		T unwarp = cnt.unwrap(arg0);
		return unwarp;
	}

	@Override
	public void abort(Executor arg0) throws SQLException {
		cnt.abort(arg0);

	}

	@Override
	public void clearWarnings() throws SQLException {
		cnt.clearWarnings();

	}

	@Override
	public void close() throws SQLException {
		busy = false;

	}

	@Override
	public void commit() throws SQLException {
		cnt.commit();

	}

	@Override
	public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
		Array arr = cnt.createArrayOf(arg0, arg1);
		return arr;
	}

	@Override
	public Blob createBlob() throws SQLException {
		Blob b = cnt.createBlob();
		return b;
	}

	@Override
	public Clob createClob() throws SQLException {
		Clob c = cnt.createClob();
		return c;
	}

	@Override
	public NClob createNClob() throws SQLException {
		NClob nc = cnt.createNClob();
		return nc;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		SQLXML xml = cnt.createSQLXML();
		return xml;
	}

	@Override
	public Statement createStatement() throws SQLException {
		Statement statement = cnt.createStatement();
		return statement;
	}

	@Override
	public Statement createStatement(int arg0, int arg1) throws SQLException {
		Statement s = cnt.createStatement();
		return s;
	}

	@Override
	public Statement createStatement(int arg0, int arg1, int arg2)
			throws SQLException {
		Statement s = cnt.createStatement(arg0, arg1, arg2);
		return s;
	}

	@Override
	public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
		Struct s = cnt.createStruct(arg0, arg1);
		return s;
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		boolean b = cnt.getAutoCommit();
		return b;
	}

	@Override
	public String getCatalog() throws SQLException {
		String s = cnt.getCatalog();
		return s;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		Properties prop = cnt.getClientInfo();
		return prop;
	}

	@Override
	public String getClientInfo(String arg0) throws SQLException {
		String s = getClientInfo(arg0);
		return s;
	}

	@Override
	public int getHoldability() throws SQLException {
		int i = cnt.getHoldability();
		return i;
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		DatabaseMetaData dmd = cnt.getMetaData();
		return dmd;
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		int i = cnt.getNetworkTimeout();
		return i;
	}

	@Override
	public String getSchema() throws SQLException {
		String s = cnt.getSchema();
		return s;
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		int i = cnt.getTransactionIsolation();
		return i;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		Map<String, Class<?>> map = cnt.getTypeMap();
		return map;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		SQLWarning warn = cnt.getWarnings();
		return warn;
	}

	@Override
	public boolean isClosed() throws SQLException {
		boolean c = cnt.isClosed();
		return c;
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		boolean iro = cnt.isReadOnly();
		return iro;
	}

	@Override
	public boolean isValid(int arg0) throws SQLException {
		boolean valid = cnt.isValid(arg0);
		return valid;
	}

	@Override
	public String nativeSQL(String arg0) throws SQLException {
		String n = cnt.nativeSQL(arg0);
		return n;
	}

	@Override
	public CallableStatement prepareCall(String arg0) throws SQLException {
		CallableStatement pc = cnt.prepareCall(arg0);
		return pc;
	}

	@Override
	public CallableStatement prepareCall(String arg0, int arg1, int arg2)
			throws SQLException {
		CallableStatement pc = cnt.prepareCall(arg0, arg1, arg2);
		return pc;
	}

	@Override
	public CallableStatement prepareCall(String arg0, int arg1, int arg2,
			int arg3) throws SQLException {
		CallableStatement pc = cnt.prepareCall(arg0, arg1, arg2, arg3);
		return pc;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0) throws SQLException {
		PreparedStatement ps = cnt.prepareStatement(arg0);
		return ps;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0, int arg1)
			throws SQLException {
		PreparedStatement ps = cnt.prepareStatement(arg0, arg1);
		return ps;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0, int[] arg1)
			throws SQLException {
		PreparedStatement ps = cnt.prepareStatement(arg0, arg1);
		return ps;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0, String[] arg1)
			throws SQLException {
		PreparedStatement ps = cnt.prepareStatement(arg0, arg1);
		return ps;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0, int arg1, int arg2)
			throws SQLException {
		PreparedStatement ps = cnt.prepareStatement(arg0, arg1, arg2);
		return ps;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0, int arg1, int arg2,
			int arg3) throws SQLException {
		PreparedStatement ps = cnt.prepareStatement(arg0, arg1, arg2, arg3);
		return ps;
	}

	@Override
	public void releaseSavepoint(Savepoint arg0) throws SQLException {
		cnt.releaseSavepoint(arg0);

	}

	@Override
	public void rollback() throws SQLException {
		cnt.rollback();

	}

	@Override
	public void rollback(Savepoint arg0) throws SQLException {
		cnt.rollback(arg0);

	}

	@Override
	public void setAutoCommit(boolean arg0) throws SQLException {
		cnt.setAutoCommit(arg0);

	}

	@Override
	public void setCatalog(String arg0) throws SQLException {
		cnt.setCatalog(arg0);

	}

	@Override
	public void setClientInfo(Properties arg0) throws SQLClientInfoException {
		cnt.setClientInfo(arg0);

	}

	@Override
	public void setClientInfo(String arg0, String arg1)
			throws SQLClientInfoException {
		cnt.setClientInfo(arg0, arg1);

	}

	@Override
	public void setHoldability(int arg0) throws SQLException {
		cnt.setHoldability(arg0);

	}

	@Override
	public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
		cnt.setNetworkTimeout(arg0, arg1);

	}

	@Override
	public void setReadOnly(boolean arg0) throws SQLException {
		cnt.setReadOnly(arg0);

	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		Savepoint ssp = cnt.setSavepoint();
		return ssp;
	}

	@Override
	public Savepoint setSavepoint(String arg0) throws SQLException {
		Savepoint ssp = cnt.setSavepoint(arg0);
		return ssp;
	}

	@Override
	public void setSchema(String arg0) throws SQLException {
		cnt.setSchema(arg0);

	}

	@Override
	public void setTransactionIsolation(int arg0) throws SQLException {
		cnt.setTransactionIsolation(arg0);

	}

	@Override
	public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
		cnt.setTypeMap(arg0);

	}

}

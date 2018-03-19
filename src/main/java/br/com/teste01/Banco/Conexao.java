package br.com.teste01.Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {

	static public final String SQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static public final String MySQL_DRIVER = "";
	static public final String ORACLE_DRIVER = "";

	String JDBC_DRIVER;
	String DB_URL; // "jdbc:sqlserver://localhost:1433;databaseName=Brad806";
	String USER; // "brad806";
	String PASS; // "brad806";

	Connection conn;
	Statement stmt;
	ResultSet rs;

	// Construtor 01...
	public Conexao() {
		JDBC_DRIVER = "";
		DB_URL = "";
		USER = "";
		PASS = "";
		conn = null;
		stmt = null;
	}

	// Construtor 02...
	public Conexao(String _JDBC_DRIVER, String _DB_URL, String _USER, String _PASS) {
		JDBC_DRIVER = _JDBC_DRIVER;
		DB_URL = _DB_URL;
		USER = _USER;
		PASS = _PASS;

		Conectar();
	}

	// Construtor 03...
	public Conexao(String _DB_URL, String _USER, String _PASS) {
		JDBC_DRIVER = "";
		DB_URL = _DB_URL;
		USER = _USER;
		PASS = _PASS;

		Conectar();
	}

	// GETs e SETs...
	public String getJDBC_DRIVER() {
		return JDBC_DRIVER;
	}

	public void setJDBC_DRIVER(String jDBC_DRIVER) {
		JDBC_DRIVER = jDBC_DRIVER;
	}

	public String getDB_URL() {
		return DB_URL;
	}

	public void setDB_URL(String dB_URL) {
		DB_URL = dB_URL;
	}

	public String getUSER() {
		return USER;
	}

	public void setUSER(String uSER) {
		USER = uSER;
	}

	public String getPASS() {
		return PASS;
	}

	public void setPASS(String pASS) {
		PASS = pASS;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	// Métodos...
	public boolean Conectar() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	public boolean Desconectar() {
		try {
			this.rs.close();
			this.stmt.close();
			this.conn.close();
		}
		catch(Exception ex) {
			return false;
		}
		return true;
	}
}

package br.com.teste01.Tabela01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.com.teste01.Banco.*;

public class Tabela01 {

	Conexao cn;

	int id;
	String nome;
	Date dataNasc;
	int idade;
	double altura;
	double peso;

	// Construtor...
	public Tabela01() {
		id = 0;
		nome = "";
		dataNasc = null;
		idade = 0;
		altura = (float) 0.00;
		peso = (float) 0.00;

		cn = null;
	}

	// GETs e SETs...
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public String getDataNascString() {
		return "1990-12-18"; // TO DO...
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public boolean setDataNasc(String dataNasc) {
		return true; // TO DO...
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Conexao getCn() {
		return cn;
	}

	public void setCn(Conexao cn) {
		this.cn = cn;
	}

	// Métodos...
	public boolean MostrarRegistros() {
		try {
			if (cn == null)
				cn = new Conexao(cn.SQL_DRIVER, "jdbc:sqlserver://localhost:1433;databaseName=Brad806", "brad806",
						"brad806");

			cn.setRs(cn.getStmt().executeQuery("SELECT * FROM TABELA01 ORDER BY ID"));

			while (cn.getRs().next()) {
				this.id = cn.getRs().getInt("ID");
				this.nome = cn.getRs().getString("NOME");
				this.dataNasc = cn.getRs().getDate("DATA_NASC");
				this.idade = cn.getRs().getInt("IDADE");
				this.altura = cn.getRs().getDouble("ALTURA");
				this.peso = cn.getRs().getDouble("PESO");

				System.out.println(this.id + " / " + this.nome + " / " + this.dataNasc + " / " + this.idade + " / "
						+ this.altura + " / " + this.peso);
			}			
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public boolean IncluirRegistro() {
		try {
			if (cn == null)
				cn = new Conexao(cn.SQL_DRIVER, "jdbc:sqlserver://localhost:1433;databaseName=Brad806", "brad806",
						"brad806");

			String sql = "INSERT INTO TABELA01 VALUES (";
			sql += "'" + this.nome + "', ";
			sql += "'" + this.getDataNascString() + "', ";
			sql += "" + this.idade + " , ";
			sql += "" + this.altura + " , ";
			sql += "" + this.peso + "  )";

			cn.getStmt().execute(sql);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public boolean ExcluirRegistro() {
		try {
			if (cn == null)
				cn = new Conexao(cn.SQL_DRIVER, "jdbc:sqlserver://localhost:1433;databaseName=Brad806", "brad806",
						"brad806");

			String sql = "DELETE FROM TABELA01 WHERE ID = " + this.id;

			cn.getStmt().execute(sql);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public boolean AlterarRegistro() {
		try {
			if (cn == null)
				cn = new Conexao(cn.SQL_DRIVER, "jdbc:sqlserver://localhost:1433;databaseName=Brad806", "brad806",
						"brad806");

			String sql = "UPDATE TABELA01 SET ";
			sql += " NOME      = '" + this.nome + "', ";
			sql += " DATA_NASC = '" + "1990-12-18" + "', ";
			sql += " IDADE     =  " + this.idade + ", ";
			sql += " ALTURA    =  " + this.altura + ", ";
			sql += " PESO      =  " + this.peso + " ";
			sql += " WHERE ID  =  " + this.id; 

			cn.getStmt().execute(sql);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}

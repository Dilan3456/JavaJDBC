package com.alura.jdbc.controller;

import com.alura.jdbc.CreaConexion;
import com.alura.jdbc.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoController {

	public void modificar(String nombre, String descripcion, Integer id) {
		// TODO
	}

	public int eliminar(Integer id) throws SQLException {
		Connection conec = new CreaConexion().ConnectionRecovery();
		Statement statement=conec.createStatement();
		statement.execute("DELETE FROM PRODUCTO WHERE ID="+id);
		return statement.getUpdateCount();

	}

	public List<Map<String,String>> listar() throws SQLException {

		Connection conec = new CreaConexion().ConnectionRecovery();



			Statement statement=conec.createStatement();
			boolean result = statement.execute("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");

			ResultSet resultSet = statement.getResultSet();
			List<Map<String,String>> resultado = new ArrayList<>();
			while(resultSet.next())
			{
				Map <String, String> fila = new HashMap<>();
				 fila.put("ID",String.valueOf(resultSet.getInt("ID")));
				fila.put("NOMBRE",resultSet.getString("NOMBRE"));
				fila.put("DESCRIPCION",(resultSet.getString("DESCRIPCION")));
				fila.put("CANTIDAD",String.valueOf(resultSet.getInt("CANTIDAD")));
				resultado.add(fila);
			}
			System.out.println(result);


		conec.close();
		// TODO
		return resultado;
	}

    public void guardar(Producto producto) throws SQLException {
		// TODO
		Connection conec = new CreaConexion().ConnectionRecovery();
		Statement statement = conec.createStatement();
		statement.execute("INSERT INTO PRODUCTO (nombre, descripcion, cantidad)"+
				"VALUES('"+ producto.get("NOMBRE")+"', '"
				+ producto.get("DESCRIPCION")+ "', "
				+producto.get("CANTIDAD")+ ")",Statement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = statement.getGeneratedKeys();
		while(resultSet.next())
		{
			System.out.println(
					String.format("Fue insertado el producto ID %d", resultSet.getInt(1))
			);
		}

	}

}

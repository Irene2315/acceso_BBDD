package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	private static final String HOST= "localhost";
	private static final String BBDD= "2dser_1ebal_exa";
	private static final String USERNAME="root";
	private static final String PASSWORD="";
	
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException{
		Scanner scan = new Scanner (System.in);
		
		try {
			
		System.out.println("Introduce un nombre de animal");
		String nombreAnimal= scan.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection ("jdbc:mysql://"+HOST+ "/"+BBDD,USERNAME,PASSWORD);

		Statement st= con.createStatement();
		
		//INSERT INTO animales (nombre) VALUES ('gato')
		String sentenciaInsert =("INSERT INTO animales (nombre) VALUES ('"+ nombreAnimal +"')");
		
		st.execute(sentenciaInsert);
		
		
		//UPDATE animales SET nombre='aaa' WHERE id= 1;
		
		String senteciaUpdate = "UPDATE animales SET nombre='elefante' WHERE id=2";
		st.executeUpdate(senteciaUpdate);
		
		
		// DELETE FROM animales WHERE nombre= 'gato'
		String senteciaDelete =  "DELETE FROM animales WHERE nombre= 'gato'";
		st.execute(senteciaDelete);
		
		//SELECT *FROM animales
		String senteciaSelect ="SELECT * FROM animales";
		ResultSet resultado = st.executeQuery(senteciaSelect);
		while (resultado.next()) {
			System.out.println(resultado.getInt(1) + "-" +resultado.getString(2));
		}
		con.close();
		//INSERT INTO `animales` (`nombre`) VALUES ('gato');
} catch (SQLException e) {
	e.printStackTrace();
}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
		
		
	}	

}

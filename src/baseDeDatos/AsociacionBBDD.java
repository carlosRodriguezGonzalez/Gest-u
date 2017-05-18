package baseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ClasesTabla.Actividad;
import ClasesTabla.Asociacion;
import ClasesTabla.Subvencion;

public class AsociacionBBDD {
	private static Connection conexion;
	
	
	public ArrayList<Asociacion> getAsociaciones(){
		ArrayList<Asociacion> asoc=new ArrayList<Asociacion>();
		try{
			Statement st= conexion.createStatement();
			ResultSet rs=st.executeQuery("Select * from asociacion");
			while(rs.next()){
				Asociacion p=new Asociacion(rs.getInt("id_asociacion"),rs.getString("nombre"),rs.getString("cif"),rs.getInt("cp"), rs.getString("direccion"),rs.getInt("telef_fijo"),rs.getString("email"),rs.getInt("fax"),rs.getString("fecha_solicitud"));
				asoc.add(p);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return asoc;
	}
	public ArrayList<Subvencion> getSubvenciones(){
		ArrayList<Subvencion> sub=new ArrayList<Subvencion>();
		try{
			Statement st= conexion.createStatement();
			ResultSet rs=st.executeQuery("Select * from subvencion");
			while(rs.next()){
				Subvencion p=new Subvencion(rs.getInt("id_solicitud"),rs.getString("fecha_solicitud"),rs.getInt("importe"),null);
				sub.add(p);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return sub;
	}
	
	public ArrayList<Actividad> getActividades(){
		ArrayList<Actividad> act=new ArrayList<Actividad>();
		try{
			Statement st= conexion.createStatement();
			ResultSet rs=st.executeQuery("Select * from actividad");
			while(rs.next()){
				Actividad p=new Actividad(rs.getInt("id_actividad"), rs.getString("fecha"), rs.getString("tipo"), rs.getString("nombre_actividad"), rs.getString("lugar"), rs.getString("descripcion"));
				act.add(p);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return act;
	}
	
	
	
	

	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		AsociacionBBDD.conexion = conexion;
	}
}

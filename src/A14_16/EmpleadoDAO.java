package A14_16;
//Resuelta 14.11

import java.sql.*;

public class EmpleadoDAO {//implements EmpleadoDAO{

    private static Connection conectar() {
        Connection con = null;
        String url = "jdbc:mysql://localhost/Empresa";
        try {
            con = DriverManager.getConnection(url, "Pepe", "12345");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }

    public static boolean existeEmpleado(int numemp) {
        String sql = "SELECT COUNT(*) FROM Empleados WHERE numemp = ?";
        Connection conexion = conectar();



        //funciona cuando numemp coincide con el calor proporcionado
        try  {
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, numemp);
            //se asigna numemp como parámetro de consulta, creo que esto es lo que pedía al final del ejercicio,
            // pero no lo tengo muy claro. -->(campo a controlar "numemp")
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {//next mueve cursor hacia delante . True hay fila disponible
                return rs.getInt(1) >0;
                //se que tengo que coger el valor de la primera columna...le he puesto el mayor a 0 por poner algo la verdad...
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
    //Método que inserta el empleado pasado como parámetro como un registro de la tabla Empleados.


    public static void create(Empleado empleado) {
        //Si el empleado pasado es nulo no podemos hacer nada
        if (empleado != null) {
            Connection conexion = conectar(); //Si hay empleado, se establece la conexión para introducirlo en BD
            //Insertar los datos en B
            String sql = "INSERT INTO Empleados (numemp, nombre, edad, oficina, puesto, contrato) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                //Igual que en el ejercicio anterior
                sentencia.setInt(1, empleado.getNumemp());
                sentencia.setString(2, empleado.getNombre());
                sentencia.setInt(3, empleado.getEdad());
                sentencia.setInt(4, empleado.getOficina());
                sentencia.setString(5, empleado.getPuesto()); //En BD data yyyy-mm-dd
                sentencia.setString(6, empleado.getContrato().toString());
                sentencia.executeUpdate();//RESUELTO 14.10
                System.out.println("Se ha registrado empleado correctamente.");

            } catch (
                    SQLException EX) {
                System.out.println(EX);//saber porque falla si falla.
            }
        }
    }
}

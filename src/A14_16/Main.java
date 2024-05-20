package A14_16;// la BD Empleados, modifica la actividad 14.15 para que el programa utilice mapeo
// objeto-relacional, para insertar los datos de un empleado,
// creando previamente un objeto de tipo Empleado. Utiliza un objeto tipo DAO para la inserción,
// no hace falta implementar otros métodos DAO. El programa controlará si el empleado a
// insertar ya existe en la BD, (campo a controlar "numemp")
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();

        System.out.println("Vamos a insertar un empleado nuevo en la BD.");
        System.out.println("Introduzca el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el número de empleado: ");
        int numemp = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduzca la edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduzca el puesto: ");
        String puesto = sc.nextLine();
        System.out.println("Introduzca el número de la oficina: ");
        int oficina = sc.nextInt();
        sc.nextLine();
        LocalDate fechaContrato = LocalDate.now();

        Empleado nuevoEmpleado = new Empleado(numemp, nombre, edad, puesto, oficina, fechaContrato);

        if (!empleadoDAO.existeEmpleado(numemp)) {
            boolean insercionExitosa = empleadoDAO.insertarEmpleado(nuevoEmpleado);
            if (insercionExitosa) {
                System.out.println("Se ha registrado empleado correctamente.");
            } else {
                System.out.println("Error al insertar empleado.");
            }
        } else {
            System.out.println("El empleado ya existe en la base de datos.");
        }
    }
}
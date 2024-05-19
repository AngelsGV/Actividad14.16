package A14_16;

import java.util.Optional;

public interface EmpleadoDAO {
    boolean insertarEmpleado(Empleado empleado);
    boolean existeEmpleado(int numEmp);
}

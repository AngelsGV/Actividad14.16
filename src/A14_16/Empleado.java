package A14_16;
import java.time.*;

public class Empleado {//se que poniendo los atributos en private es la forma más correcta de programar.
    // Pero si me falla los quitaré como siempre jeje. No debería porque estará all dentro del mismo package
    private int numemp;
    private String nombre;
    private int edad;
    private String puesto;
    private int oficina;
    private  LocalDate contrato;

    //Constructor
    public Empleado(int numemp, String nombre, int edad, String puesto, int oficina, LocalDate contrato){
        this.numemp = numemp;
        this.nombre = nombre;
        this.edad = edad;
        this.puesto = puesto;
        this.oficina = oficina;
        this.contrato = contrato;
    }
    //Aquí pondremos los getters y setters que harán falta
    // (los voy a definir todos por el momento y si veo que me sobran cosas, lo borraré (si me acuerdo))
    public int getNumemp(){
        return numemp;
    }
    public void  setNumemp(int numemp){
        this.numemp = numemp;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getOficina() {
        return oficina;
    }

    public void setOficina(int oficina) {
        this.oficina = oficina;
    }

    public LocalDate getContrato() {
        return contrato;
    }

    public void setContrato(LocalDate contrato) {
        this.contrato = contrato;
    }
}
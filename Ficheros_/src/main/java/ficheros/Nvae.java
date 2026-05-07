package ficheros;

import java.io.Serializable;

public class Nvae implements Serializable {


    private String nombre;
    private transient double peso;
    private double velovidad;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVelovidad() {
        return velovidad;
    }

    public void setVelovidad(double velovidad) {
        this.velovidad = velovidad;
    }



    @Override
    public String toString() {
        return "Nvae{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", velovidad=" + velovidad +
                '}';
    }



    public Nvae (String nombre, double peso, double velovidad){

        this.nombre=nombre;
        this.peso=peso;
        this.velovidad=velovidad;



    }
}

package proyectomeia.Clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ObjectLista {

    /**
     * @return the Nombre_lista
     */
    public String getNombre_lista() {
        return Nombre_lista;
    }

    /**
     * @param Nombre_lista the Nombre_lista to set
     */
    public void setNombre_lista(String Nombre_lista) {
        this.Nombre_lista = Nombre_lista;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Numero_usuarios
     */
    public int getNumero_usuarios() {
        return Numero_usuarios;
    }

    /**
     * @param Numero_usuarios the Numero_usuarios to set
     */
    public void setNumero_usuarios(int Numero_usuarios) {
        this.Numero_usuarios = Numero_usuarios;
    }

    /**
     * @return the Fecha_Creacion
     */
    public String getFecha_Creacion() {
        return Fecha_Creacion;
    }

    /**
     * @param Fecha_Creacion the Fecha_Creacion to set
     */
    public void setFecha_Creacion(String Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }

    /**
     * @return the Estatus
     */
    public boolean isEstatus() {
        return Estatus;
    }

    /**
     * @param Estatus the Estatus to set
     */
    public void setEstatus(boolean Estatus) {
        this.Estatus = Estatus;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(rightpad(Nombre_lista, 30));
        str.append("|");
        str.append(rightpad(Usuario, 20));
        str.append("|");
        str.append(rightpad(Descripcion, 40));
        str.append("|");
        str.append(rightpad(String.valueOf(Numero_usuarios), 4));
        str.append("|");
        str.append(rightpad(String.valueOf(Fecha_Creacion), 20));
        str.append("|");
        if (Estatus) {
            str.append("1");
        } else {
            str.append("0");
        }

        return str.toString();

    }

    public void CreateFromString(String origin) {
        String[] Atributes = origin.split("\\|");
        this.Nombre_lista = Atributes[0];
        this.Usuario = Atributes[1];
        this.Descripcion = Atributes[2];
        this.Numero_usuarios = Integer.valueOf(Atributes[3].trim());
        this.Fecha_Creacion = Atributes[4];
        this.Estatus = Atributes[5].equals("1");

    }

    public ObjectLista(String nombre, String Descripcion) {
        this.Nombre_lista = nombre;
        this.Descripcion = Descripcion;
        this.Numero_usuarios = 0;
        this.Fecha_Creacion = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        this.Estatus = true;
    }

    public ObjectLista() {

    }
    private String Nombre_lista, Usuario, Descripcion;
    private int Numero_usuarios;
    private String Fecha_Creacion;
    private boolean Estatus;

    private String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }
}
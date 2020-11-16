package proyectomeia.Clases;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class Usuario {

    /**
     * @return the rol
     */
    public boolean isRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(boolean rol) {
        this.rol = rol;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the correo_alterno
     */
    public String getCorreo_alterno() {
        return correo_alterno;
    }

    /**
     * @param correo_alterno the correo_alterno to set
     */
    public void setCorreo_alterno(String correo_alterno) {
        this.correo_alterno = correo_alterno;
    }

    /**
     * @return the path_fotografia
     */
    public String getPath_fotografía() {
        return path_fotografia;
    }

    /**
     * @param path_fotografia the path_fotografia to set
     */
    public void setPath_fotografía(String path_fotografia) {
        this.path_fotografia = path_fotografia;
    }

    /**
     * @return the status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the fecha_nacimiento
     */
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    private String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    @Override
    /**
     * Retorna el objeto como string formateada para archivo Secuencial
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(rightpad(this.username, 20));
        str.append("|");
        str.append(rightpad(this.nombre, 30));
        str.append("|");
        str.append(rightpad(this.apellido, 30));
        str.append("|");
        str.append(rightpad(this.password, 40));
        str.append("|");
        if (rol == true) {
            str.append("1");
        } else {
            str.append("0");
        }
        str.append("|");
        str.append(rightpad(String.valueOf(fecha_nacimiento), 18));
        str.append("|");
        str.append(rightpad(correo_alterno, 40));
        str.append("|");
        str.append(String.valueOf(telefono));
        str.append("|");
        str.append(rightpad(path_fotografia, 200));
        str.append("|");
        if (status == true) {
            str.append(rightpad("1", 3));
        } else {
            str.append(rightpad("0", 3));
        }
        return str.toString();
    }

    public void CreatefromString(String object) throws ParseException {
        String[] Atributes = object.split("\\|");
        this.username = Atributes[0];
        this.nombre = Atributes[1];
        this.apellido = Atributes[2];
        this.password = Atributes[3];
        this.rol = Atributes[4].equals("1");
        this.fecha_nacimiento = Atributes[5];
        this.correo_alterno = Atributes[6];
        this.telefono = Integer.parseInt(Atributes[7]);
        this.path_fotografia = Atributes[8];
        this.status = Atributes[9].contains("1");
    }

    /**
     * Retorna el objeto como string formateada para archivo Apilo
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public String ToString() {
        StringBuilder str = new StringBuilder();
        str.append(rightpad(this.username, 20));
        str.append("|");
        str.append(rightpad(this.nombre, 30));
        str.append("|");
        str.append(rightpad(this.apellido, 30));
        str.append("|");
        str.append(rightpad(this.password, 40));
        str.append("|");
        if (rol == true) {
            str.append("1");
        } else {
            str.append("0");
        }
        str.append("|");
        str.append(rightpad(String.valueOf(fecha_nacimiento), 18));
        str.append("|");
        str.append(rightpad(correo_alterno, 40));
        str.append("|");
        str.append(String.valueOf(telefono));
        str.append("|");
        str.append(rightpad(path_fotografia, 200));
        str.append("|");
        if (status == true) {
            str.append(rightpad("1", 3));
        } else {
            str.append(rightpad("0", 3));
        }
        return str.toString();
    }

    private boolean rol;
    private String username;
    private String nombre;
    private String apellido;
    private String password;
    private String correo_alterno;
    private String path_fotografia;
    private boolean status;
    private int telefono;
    private String fecha_nacimiento;

}
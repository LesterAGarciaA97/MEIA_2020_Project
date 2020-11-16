package proyectomeia.Clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NodoBinario {

    private String Izquierdo;
    private String Derecho;
    private String UsuarioEmisor;
    private String UsuarioReceptor;
    private String FechaTransaccion;
    private String Asunto;
    private String Mensaje;
    private String Adjunto;
    private String Estatus;

    /**
     *
     * @param UsuarioEmisor
     * @param UsuarioReceptor
     * @param Asunto
     * @param Mensaje
     * @param Adjunto
     */
    public NodoBinario(String UsuarioEmisor, String UsuarioReceptor, String Asunto, String Mensaje, String Adjunto) {
        this.UsuarioEmisor = UsuarioEmisor;
        this.UsuarioReceptor = UsuarioReceptor;
        this.FechaTransaccion = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
        this.Asunto = Asunto;
        this.Mensaje = Mensaje;
        this.Adjunto = Adjunto;
        this.Estatus = "1";
    }

    public NodoBinario() {
    }

    public void CreateFromString(String object) {
        String[] parts = object.split("\\|");
        setIzquierdo(parts[0]);
        setDerecho(parts[1]);
        setUsuarioEmisor(parts[2]);
        setUsuarioReceptor(parts[3]);
        setAsunto(parts[4]);
        setMensaje(parts[5]);
        setAdjunto(parts[6]);
        setFechaTransaccion(parts[7]);
        setEstatus(parts[8]);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(rightpad(Izquierdo, 30));
        str.append("|");
        str.append(rightpad(Derecho, 30));
        str.append("|");
        str.append(rightpad(UsuarioEmisor, 20));
        str.append("|");
        str.append(rightpad(UsuarioReceptor, 20));
        str.append("|");
        str.append(rightpad(Asunto, 40));
        str.append("|");
        str.append(rightpad(Mensaje, 50));
        str.append("|");
        str.append(rightpad(Adjunto, 60));
        str.append("|");
        str.append(FechaTransaccion);
        str.append("|");
        str.append(Estatus);
        return str.toString();
    }

    private String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    /**
     * @return the Izquierdo
     */
    public String getIzquierdo() {
        return Izquierdo;
    }

    /**
     * @param Izquierdo the Izquierdo to set
     */
    public void setIzquierdo(String Izquierdo) {
        this.Izquierdo = Izquierdo;
    }

    /**
     * @return the Derecho
     */
    public String getDerecho() {
        return Derecho;
    }

    /**
     * @param Derecho the Derecho to set
     */
    public void setDerecho(String Derecho) {
        this.Derecho = Derecho;
    }

    /**
     * @return the UsuarioEmisor
     */
    public String getUsuarioEmisor() {
        return UsuarioEmisor;
    }

    /**
     * @param UsuarioEmisor the UsuarioEmisor to set
     */
    public void setUsuarioEmisor(String UsuarioEmisor) {
        this.UsuarioEmisor = UsuarioEmisor;
    }

    /**
     * @return the UsuarioReceptor
     */
    public String getUsuarioReceptor() {
        return UsuarioReceptor;
    }

    /**
     * @param UsuarioReceptor the UsuarioReceptor to set
     */
    public void setUsuarioReceptor(String UsuarioReceptor) {
        this.UsuarioReceptor = UsuarioReceptor;
    }

    /**
     * @return the FechaTransaccion
     */
    public String getFechaTransaccion() {
        return FechaTransaccion;
    }

    /**
     * @param FechaTransaccion the FechaTransaccion to set
     */
    public void setFechaTransaccion(String FechaTransaccion) {
        this.FechaTransaccion = FechaTransaccion;
    }

    /**
     * @return the Asunto
     */
    public String getAsunto() {
        return Asunto;
    }

    /**
     * @param Asunto the Asunto to set
     */
    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    /**
     * @return the Mensaje
     */
    public String getMensaje() {
        return Mensaje;
    }

    /**
     * @param Mensaje the Mensaje to set
     */
    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    /**
     * @return the Adjunto
     */
    public String getAdjunto() {
        return Adjunto;
    }

    /**
     * @param Adjunto the Adjunto to set
     */
    public void setAdjunto(String Adjunto) {
        this.Adjunto = Adjunto;
    }

    /**
     * @return the Estatus
     */
    public String getEstatus() {
        return Estatus;
    }

    /**
     * @param Estatus the Estatus to set
     */
    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }
}
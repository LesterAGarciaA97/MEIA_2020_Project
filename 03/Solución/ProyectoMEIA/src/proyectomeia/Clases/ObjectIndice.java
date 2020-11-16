package proyectomeia.Clases;

public class ObjectIndice {

    public ObjectIndice() {
    }

    public ObjectIndice(String nlista, String nusario, String nusasociado) {
        Nlista = nlista;
        Nusuario = nusario;
        Usuarioasociado = nusasociado;
        nregistro = "0";
        posicion = "0";
        estatus = "1";
        siguiente = "0";
    }

    /**
     * @return the nregistro
     */
    public String getNregistro() {
        return nregistro;
    }

    /**
     * @param nregistro the nregistro to set
     */
    public void setNregistro(String nregistro) {
        this.nregistro = nregistro;
    }

    /**
     * @return the posicion
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the Nlista
     */
    public String getNlista() {
        return Nlista;
    }

    /**
     * @param Nlista the Nlista to set
     */
    public void setNlista(String Nlista) {
        this.Nlista = Nlista;
    }

    /**
     * @return the Nusuario
     */
    public String getNusuario() {
        return Nusuario;
    }

    /**
     * @param Nusuario the Nusuario to set
     */
    public void setNusuario(String Nusuario) {
        this.Nusuario = Nusuario;
    }

    /**
     * @return the Usuarioasociado
     */
    public String getUsuarioasociado() {
        return Usuarioasociado;
    }

    /**
     * @param Usuarioasociado the Usuarioasociado to set
     */
    public void setUsuarioasociado(String Usuarioasociado) {
        this.Usuarioasociado = Usuarioasociado;
    }

    /**
     * @return the siguiente
     */
    public String getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(String siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void CreateFromString(String object) {
        String[] parts = object.split("\\|");
        nregistro = parts[0];
        posicion = parts[1];
        Nlista = parts[2];
        Nusuario = parts[3];
        Usuarioasociado = parts[4];
        siguiente = parts[5];
        estatus = parts[6];

    }

    protected String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(rightpad(nregistro, 4));
        str.append("|");
        str.append(rightpad(posicion, 6));
        str.append("|");
        str.append(rightpad(Nlista, 30));
        str.append("|");
        str.append(rightpad(Nusuario, 20));
        str.append("|");
        str.append(rightpad(Usuarioasociado, 20));
        str.append("|");
        str.append(rightpad(siguiente, 6));
        str.append("|");
        str.append(estatus);
        return str.toString();
    }

    private String nregistro, posicion, Nlista, Nusuario, Usuarioasociado, siguiente, estatus;
}
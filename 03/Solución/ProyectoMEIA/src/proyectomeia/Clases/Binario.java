package proyectomeia.Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Binario {

    private File archivoBinario;
    private File descriptor;
    RandomAccessFile archivoMaster;
    NodoBinario nodoIzquierdo, nodoDerecho, nodoRaiz;
    long tamanio = 0;
    int cantRegistros = 0;
    NodoBinario padre = new NodoBinario("", "", "", "", "");
    NodoBinario anterior = new NodoBinario("", "", "", "", "");
    NodoBinario raizArbol = new NodoBinario("", "", "", "", "");

    public Binario(String RutaBinario, String RutaDescriptor) throws IOException {
        archivoBinario = new File(RutaBinario);
        descriptor = new File(RutaDescriptor);
        nodoRaiz = new NodoBinario("", "", "", "", "");
    }

    public void Insertar(NodoBinario nuevoNodo) throws FileNotFoundException, IOException {
        cantRegistros = CantidadRegistrosArbol();
        archivoMaster = new RandomAccessFile(archivoBinario, "rw");
        tamanio = archivoMaster.length();
        archivoMaster.seek(tamanio);
        NodoBinario viejo = new NodoBinario("", "", "", "", "");
        try {
            nodoRaiz.CreateFromString(obtenerPadre(RetornarRaizRegistro()).toString());

        } catch (Exception e) {

        }
        //Nodo Raiz
        if (verificarEliminarTodos() && CantidadRegistrosArbol() != 0) {
            nuevoNodo.setDerecho("-1");
            nuevoNodo.setIzquierdo("-1");
            nodoRaiz.CreateFromString(nuevoNodo.toString());
            raizArbol.CreateFromString(nuevoNodo.toString());
            archivoMaster.writeBytes(nodoRaiz.toString());
            archivoMaster.writeBytes(System.lineSeparator());
            archivoMaster.close();
            cantRegistros++;
            CrearDescriptor();
        } else {
            if (tamanio == 0) {
                nuevoNodo.setDerecho("-1");
                nuevoNodo.setIzquierdo("-1");
                nodoRaiz.CreateFromString(nuevoNodo.toString());
                raizArbol.CreateFromString(nuevoNodo.toString());
                archivoMaster.writeBytes(nodoRaiz.toString());
                archivoMaster.writeBytes(System.lineSeparator());
                archivoMaster.close();
                cantRegistros++;
                CrearDescriptor();
            } else {
                nuevoNodo.setDerecho("-1");
                nuevoNodo.setIzquierdo("-1");
                if ((nodoRaiz.getUsuarioEmisor().compareTo(nuevoNodo.getUsuarioEmisor()) > 0)
                        || (nodoRaiz.getUsuarioReceptor().compareTo(nuevoNodo.getUsuarioReceptor()) > 0)
                        || (nodoRaiz.getFechaTransaccion().compareTo(nuevoNodo.getFechaTransaccion()) > 0)) {
                    if (nodoRaiz.getDerecho().trim().contains("-1")) {
                        cantRegistros++;
                        viejo.CreateFromString(nodoRaiz.toString());
                        nodoRaiz.setDerecho(String.valueOf(cantRegistros));
                        Modificar(viejo.toString(), nodoRaiz.toString());
                        archivoMaster.writeBytes(nuevoNodo.toString());
                        archivoMaster.writeBytes(System.lineSeparator());
                        archivoMaster.close();

                    } else {
                        nodoDerecho = obtenerPadre(Integer.parseInt(nodoRaiz.getDerecho().trim()));
                        InsertarInterno(nuevoNodo, nodoDerecho);
                    }

                } else {
                    if ((nodoRaiz.getUsuarioEmisor().compareTo(nuevoNodo.getUsuarioEmisor()) < 0)
                            || (nodoRaiz.getUsuarioReceptor().compareTo(nuevoNodo.getUsuarioReceptor()) < 0)
                            || (nodoRaiz.getFechaTransaccion().compareTo(nuevoNodo.getFechaTransaccion()) < 0)) {
                        if (nodoRaiz.getIzquierdo().trim().contains("-1")) {
                            cantRegistros++;
                            viejo.CreateFromString(nodoRaiz.toString());
                            nodoRaiz.setIzquierdo(String.valueOf(cantRegistros));
                            Modificar(viejo.toString(), nodoRaiz.toString());
                            archivoMaster.writeBytes(nuevoNodo.toString());
                            archivoMaster.writeBytes(System.lineSeparator());
                            archivoMaster.close();
                        } else {
                            nodoIzquierdo = obtenerPadre(Integer.parseInt(nodoRaiz.getIzquierdo().trim()));
                            InsertarInterno(nuevoNodo, nodoIzquierdo);
                        }
                    }
                }
            }
        }
    }//FIN DEL METODO

    private void InsertarInterno(NodoBinario nuevoNodo, NodoBinario nodoRaiz) throws IOException {
        NodoBinario viejo = new NodoBinario("", "", "", "", "");
        nuevoNodo.setDerecho("-1");
        nuevoNodo.setIzquierdo("-1");
        if ((nodoRaiz.getUsuarioEmisor().compareTo(nuevoNodo.getUsuarioEmisor()) > 0)
                || (nodoRaiz.getFechaTransaccion().compareTo(nuevoNodo.getFechaTransaccion()) > 0)
                || (nodoRaiz.getUsuarioReceptor().compareTo(nuevoNodo.getUsuarioReceptor()) > 0)) {
            if (nodoRaiz.getDerecho().trim().contains("-1")) {
                cantRegistros++;
                viejo.CreateFromString(nodoRaiz.toString());
                nodoRaiz.setDerecho(String.valueOf(cantRegistros));
                Modificar(viejo.toString(), nodoRaiz.toString());
                archivoMaster.writeBytes(nuevoNodo.toString());
                archivoMaster.writeBytes(System.lineSeparator());
                archivoMaster.close();
            } else {
                nodoDerecho = obtenerPadre(Integer.parseInt(nodoRaiz.getDerecho().trim()));
                InsertarInterno(nuevoNodo, nodoDerecho);
            }

        } else {
            if ((nodoRaiz.getUsuarioEmisor().compareTo(nuevoNodo.getUsuarioEmisor()) < 0)
                    || (nodoRaiz.getFechaTransaccion().compareTo(nuevoNodo.getFechaTransaccion()) < 0)
                    || (nodoRaiz.getUsuarioReceptor().compareTo(nuevoNodo.getUsuarioReceptor()) < 0)) {
                if (nodoRaiz.getIzquierdo().trim().contains("-1")) {
                    cantRegistros++;
                    viejo.CreateFromString(nodoRaiz.toString());
                    nodoRaiz.setIzquierdo(String.valueOf(cantRegistros));
                    Modificar(viejo.toString(), nodoRaiz.toString());
                    archivoMaster.writeBytes(nuevoNodo.toString());
                    archivoMaster.writeBytes(System.lineSeparator());
                    archivoMaster.close();
                } else {
                    nodoIzquierdo = obtenerPadre(Integer.parseInt(nodoRaiz.getIzquierdo().trim()));
                    InsertarInterno(nuevoNodo, nodoIzquierdo);
                }
            }
        }
    } //FIN DEL METODO 

    public void Eliminar(NodoBinario nodoEliminar) throws FileNotFoundException, IOException {
        NodoBinario viejo = new NodoBinario("", "", "", "", "");
        NodoBinario nuevaRaiz = new NodoBinario("", "", "", "", "");
        nodoEliminar = Busqueda(nodoEliminar);
        int posicion = 0;
        raizArbol.CreateFromString(obtenerPadre(RetornarRaizRegistro()).toString());
        //Elimina Nodo Raiz sin hijo derecho        
        if ((nodoEliminar.getUsuarioEmisor().contains(raizArbol.getUsuarioEmisor()))
                && (nodoEliminar.getUsuarioReceptor().contains(raizArbol.getUsuarioReceptor()))
                && (nodoEliminar.getFechaTransaccion().contains(raizArbol.getFechaTransaccion()))
                && (nodoEliminar.getDerecho().trim().contains("-1"))) {
            nodoIzquierdo = obtenerPadre(Integer.parseInt(nodoEliminar.getIzquierdo().trim()));
            viejo.CreateFromString(nodoEliminar.toString());
            raizArbol.CreateFromString(nodoIzquierdo.toString());
            nodoEliminar.setIzquierdo("-1");
            nodoEliminar.setEstatus("0");
            Modificar(viejo.toString(), nodoEliminar.toString());
            CrearDescriptor();
        } else {
            //Eliminar Nodo Raiz sin hijo Izquierdo
            if ((nodoEliminar.getUsuarioEmisor().contains(raizArbol.getUsuarioEmisor()))
                    && (nodoEliminar.getUsuarioReceptor().contains(raizArbol.getUsuarioReceptor()))
                    && (nodoEliminar.getFechaTransaccion().contains(raizArbol.getFechaTransaccion()))
                    && (nodoEliminar.getIzquierdo().trim().contains("-1"))) {
                nodoDerecho = obtenerPadre(Integer.parseInt(nodoEliminar.getDerecho().trim()));
                viejo.CreateFromString(nodoEliminar.toString());
                raizArbol.CreateFromString(nodoDerecho.toString());
                nodoEliminar.setDerecho("-1");
                nodoEliminar.setEstatus("0");
                Modificar(viejo.toString(), nodoEliminar.toString());
                CrearDescriptor();
            } else {

                nodoIzquierdo = obtenerPadre(Integer.parseInt(nodoEliminar.getIzquierdo().trim()));
                raizArbol.CreateFromString(obtenerPadre(RetornarRaizRegistro()).toString());
                //Eliminar Raiz con Hijos
                if ((nodoEliminar.getUsuarioEmisor().contains(raizArbol.getUsuarioEmisor()))
                        && (nodoEliminar.getUsuarioReceptor().contains(raizArbol.getUsuarioReceptor()))
                        && (nodoEliminar.getFechaTransaccion().contains(raizArbol.getFechaTransaccion()))) {
                    nodoIzquierdo = obtenerPadre(Integer.parseInt(nodoEliminar.getIzquierdo().trim()));
                    raizArbol = BusquedaMasDerecho(nodoIzquierdo); //Obtengo nuevo nodoRaiz
                    if (anterior.getDerecho() == null || anterior.getIzquierdo() == null) {
                        anterior.CreateFromString(raizArbol.toString());
                        posicion = PosicionRegistroEliminar(anterior.toString());
                        padre = BusquedaPadre(raizArbol, posicion);
                        viejo.CreateFromString(raizArbol.toString());
                        raizArbol = asignarRaiz(viejo.toString());
                        raizArbol.setDerecho(nodoEliminar.getDerecho());
                        raizArbol.setIzquierdo("-1");
                        nuevaRaiz.CreateFromString(nodoEliminar.toString());
                        nodoEliminar.setDerecho("-1");
                        nodoEliminar.setIzquierdo("-1");
                        nodoEliminar.setEstatus("0");
                        Modificar(nuevaRaiz.toString(), nodoEliminar.toString());
                        Modificar(viejo.toString(), raizArbol.toString());
                        viejo.CreateFromString(anterior.toString());
                        anterior.setDerecho("-1");
                        Modificar(viejo.toString(), anterior.toString());
                        CrearDescriptor();
                    } else {
                        posicion = PosicionRegistroEliminar(anterior.toString());
                        padre = BusquedaPadre(raizArbol, posicion);
                        viejo.CreateFromString(raizArbol.toString());
                        raizArbol = asignarRaiz(viejo.toString());
                        raizArbol.setDerecho(nodoEliminar.getDerecho());
                        raizArbol.setIzquierdo(nodoEliminar.getIzquierdo());
                        nuevaRaiz.CreateFromString(nodoEliminar.toString());
                        nodoEliminar.setDerecho("-1");
                        nodoEliminar.setIzquierdo("-1");
                        nodoEliminar.setEstatus("0");
                        Modificar(nuevaRaiz.toString(), nodoEliminar.toString());
                        Modificar(viejo.toString(), raizArbol.toString());
                        viejo.CreateFromString(anterior.toString());
                        anterior.setDerecho("-1");
                        Modificar(viejo.toString(), anterior.toString());
                        CrearDescriptor();
                    }
                } else {
                    //Eliminacion Nodo Hoja
                    if (nodoEliminar.getIzquierdo().trim().contains("-1") && nodoEliminar.getDerecho().trim().contains("-1")) {
                        //Si es nodo hoja
                        viejo.CreateFromString(nodoEliminar.toString());
                        nodoEliminar.setEstatus("0");
                        Modificar(viejo.toString(), nodoEliminar.toString());
                        posicion = PosicionRegistroEliminar(nodoEliminar.toString());
                        padre = BusquedaPadre(nodoEliminar, posicion);
                        posicion = PosicionRegistroEliminar(nodoEliminar.toString());
                        viejo.CreateFromString(padre.toString());
                        if (padre.getDerecho().trim().contains(String.valueOf(posicion))) {
                            padre.setDerecho("-1");
                        } else if (padre.getIzquierdo().trim().contains(String.valueOf(posicion))) {
                            padre.setIzquierdo("-1");
                        }
                        Modificar(viejo.toString(), padre.toString());
                        //Eliminacion Nodo padre izquierdo
                    } else if (nodoEliminar.getIzquierdo().trim().contains("-1")) {
                        //Si no tiene hijo derecho
                        nodoDerecho = obtenerPadre(Integer.parseInt(nodoEliminar.getDerecho().trim()));
                        viejo.CreateFromString(nodoEliminar.toString());
                        nodoEliminar.setEstatus("0");
                        nodoEliminar.setDerecho("-1");
                        Modificar(viejo.toString(), nodoEliminar.toString());
                        posicion = PosicionRegistroEliminar(nodoEliminar.toString());
                        padre = BusquedaPadre(nodoDerecho, posicion);
                        posicion = PosicionRegistroEliminar(nodoDerecho.toString());
                        viejo.CreateFromString(padre.toString());
                        padre.setDerecho(String.valueOf(posicion));
                        Modificar(viejo.toString(), padre.toString());
                        //Eliminacion Nodo izquierdo
                    } else if (nodoEliminar.getDerecho().trim().contains("-1")) {
                        //Si no tiene hijo derecho
                        nodoIzquierdo = obtenerPadre(Integer.parseInt(nodoEliminar.getIzquierdo().trim()));
                        viejo.CreateFromString(nodoEliminar.toString());
                        nodoEliminar.setEstatus("0");
                        nodoEliminar.setIzquierdo("-1");
                        Modificar(viejo.toString(), nodoEliminar.toString());
                        posicion = PosicionRegistroEliminar(nodoEliminar.toString());
                        padre = BusquedaPadre(nodoIzquierdo, posicion);
                        viejo.CreateFromString(padre.toString());
                        Modificar(viejo.toString(), padre.toString());
                    } else {

                        nodoIzquierdo = obtenerPadre(Integer.parseInt(nodoEliminar.getIzquierdo().trim()));
                        //Dos hijos
                        if (nodoIzquierdo.getDerecho().trim().contains("-1")) {
                            viejo.CreateFromString(nodoEliminar.toString());
                            nodoEliminar.setDerecho("-1");
                            nodoEliminar.setIzquierdo("-1");
                            nodoEliminar.setEstatus("0");
                            Modificar(viejo.toString(), nodoEliminar.toString());
                            posicion = PosicionRegistroEliminar(nodoEliminar.toString());
                            padre = BusquedaPadre(nodoIzquierdo, posicion);
                            nuevaRaiz.CreateFromString(padre.toString());
                            padre.setIzquierdo(viejo.getIzquierdo());
                            Modificar(nuevaRaiz.toString(), padre.toString());
                            nuevaRaiz.CreateFromString(nodoIzquierdo.toString());
                            nodoIzquierdo.setDerecho(viejo.getDerecho());
                            Modificar(nuevaRaiz.toString(), nodoIzquierdo.toString());
                        } else {
                            viejo.CreateFromString(obtenerRaiz().toString());
                            nodoRaiz.setDerecho("-1");
                            nodoRaiz.setIzquierdo("-1");
                            nodoRaiz.setEstatus("0");
                            Modificar(viejo.toString(), nodoRaiz.toString());
                            nodoRaiz = BusquedaMasDerecho(nodoIzquierdo); //Obtengo nuevo nodoRaiz
                            posicion = PosicionRegistroEliminar(anterior.toString());
                            padre = BusquedaPadre(nodoRaiz, posicion);
                            nuevaRaiz.CreateFromString(nodoRaiz.toString());
                            nodoRaiz.setDerecho(viejo.getDerecho());
                            nodoRaiz.setIzquierdo(viejo.getIzquierdo());
                            Modificar(nuevaRaiz.toString(), nodoRaiz.toString());
                            viejo.CreateFromString(anterior.toString());
                            anterior.setDerecho("-1");
                            Modificar(viejo.toString(), anterior.toString());
                        }
                    }
                }
            }
        }
    }//FIN DEL METODO

    private NodoBinario obtenerRaiz() throws IOException {
        if (raizArbol.getDerecho() == null && raizArbol.getIzquierdo() == null) {
            return obtenerPadre(RetornarRaizRegistro());
        } else {
            return raizArbol;
        }
    }

    private NodoBinario asignarRaiz(String raiz) {
        NodoBinario raizArbol = new NodoBinario("", "", "", "", "");
        raizArbol.CreateFromString(raiz);
        return raizArbol;
    }

    private NodoBinario BusquedaMasDerecho(NodoBinario nodoBuscado) throws IOException {
        if (nodoBuscado.getDerecho().trim().contains("-1")) {
            return nodoBuscado;
        } else {
            nodoDerecho = obtenerPadre(Integer.parseInt(nodoBuscado.getDerecho().trim()));
            int posicion = PosicionRegistroEliminar(nodoBuscado.toString());
            anterior = BusquedaPadre(nodoBuscado, posicion);
            BusquedaMasDerecho(nodoDerecho);
        }
        return nodoDerecho;
    }

    private NodoBinario BusquedaPadre(NodoBinario nodoBuscado, int posicion) throws FileNotFoundException, IOException {
        String[] atributos = null;
        NodoBinario buscado = new NodoBinario("", "", "", "", "");
        RandomAccessFile archivo = new RandomAccessFile(archivoBinario, "rw");
        String inputLine;
        while ((inputLine = archivo.readLine()) != null) {
            atributos = inputLine.split("\\|");
            if (atributos[0].contains(String.valueOf(posicion))) {
                buscado.CreateFromString(inputLine);
                return buscado;
            } else if (atributos[1].contains(String.valueOf(posicion))) {
                buscado.CreateFromString(inputLine);
                return buscado;
            }
        }
        archivo.close();
        return buscado;
    }

    /**
     * Metodo que retorna la cantidad de Registros en el indice
     *
     * @return cantidadRegistrosIndice
     * @throws FileNotFoundException
     * @throws IOException
     */
    private int CantidadRegistrosArbol() throws FileNotFoundException, IOException {
        int cantidadRegistrosArbol = 0;
        RandomAccessFile archivo = new RandomAccessFile(archivoBinario, "rw");
        String inputLine;
        while ((inputLine = archivo.readLine()) != null) {
            if (inputLine != null) {
                cantidadRegistrosArbol++;
            }
        }
        archivo.close();
        return cantidadRegistrosArbol;
    }

    /**
     * Metodo que retorna la cantidad de Registros inactivos en el indice
     *
     * @return cantidadRegistrosInactivosLista
     * @throws FileNotFoundException
     * @throws IOException
     */
    private int CantidadRegistrosInactivosArbol() throws IOException {
        int cantidadRegistrosInactivosArbol = 0;
        String[] atributos = null;
        RandomAccessFile archivo = new RandomAccessFile(archivoBinario, "rw");
        String inputLine;
        while ((inputLine = archivo.readLine()) != null) {
            atributos = inputLine.split("\\|");
            if (atributos[8].contains("0")) {
                cantidadRegistrosInactivosArbol++;
            }
        }
        archivo.close();
        return cantidadRegistrosInactivosArbol;
    }

    /**
     * Metodo que retorna la cantidad de Registros inactivos en el indice
     *
     * @return cantidadRegistrosInactivosLista
     * @throws FileNotFoundException
     * @throws IOException
     */
    private int CantidadRegistrosActivosArbol() throws IOException {
        int cantidadRegistrosInactivosArbol = 0;
        String[] atributos = null;
        RandomAccessFile archivo = new RandomAccessFile(archivoBinario, "rw");
        String inputLine;
        while ((inputLine = archivo.readLine()) != null) {
            atributos = inputLine.split("\\|");
            if (atributos[8].contains("1")) {
                cantidadRegistrosInactivosArbol++;
            }
        }
        archivo.close();
        return cantidadRegistrosInactivosArbol;
    }

    public void CrearDescriptor() throws FileNotFoundException, IOException {
        RandomAccessFile archivo = new RandomAccessFile(descriptor, "rw");
        StringBuilder descriptorArbol = new StringBuilder();
        descriptorArbol.append("Numero de Registros:" + rightpad(String.valueOf(CantidadRegistrosArbol()), 4));
        descriptorArbol.append(System.lineSeparator());
        descriptorArbol.append("Raiz:" + rightpad(String.valueOf(PosicionRaiz(obtenerRaiz())), 4)); //Raiz
        descriptorArbol.append(System.lineSeparator());
        descriptorArbol.append("Registros Activos:" + rightpad(String.valueOf(CantidadRegistrosActivosArbol()), 4));
        descriptorArbol.append(System.lineSeparator());
        descriptorArbol.append("Registros Inactivos:" + rightpad(String.valueOf(CantidadRegistrosInactivosArbol()), 4));
        archivo.writeBytes(descriptorArbol.toString());
    }

    protected String rightpad(String text, int length) {

        return String.format("%-" + length + "." + length + "s", text);

    }

    /**
     * Modifica un dato del Indice
     *
     * @param viejo
     * @param Nuevo
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void Modificar(String viejo, String Nuevo) throws FileNotFoundException, IOException {
        int posicion = PosicionRegistro(viejo);
        RandomAccessFile archivo = new RandomAccessFile(archivoBinario, "rw");
        for (int i = -1; i < posicion; i++) {
            archivo.readLine();
        }
        long rewrite = archivo.getFilePointer();
        archivo.seek(rewrite);
        archivo.writeBytes(Nuevo);
        archivo.close();

    }//FIN DEL METODO

    private NodoBinario obtenerPadre(int posicion) throws FileNotFoundException, IOException {
        RandomAccessFile archivo = new RandomAccessFile(archivoBinario, "rw");
        for (int i = 0; i < posicion; i++) {
            padre.CreateFromString(archivo.readLine());
        }
        return padre;
    }//FIN DEL METODO

    private int PosicionRegistro(String registro) {
        int posicion = -1;
        try {
            RandomAccessFile contador = new RandomAccessFile(archivoBinario, "r");
            String line;
            while ((line = contador.readLine()) != null) {
                if (line.equals(registro)) {
                    contador.close();
                    return posicion;
                }
                posicion++;
            }
            contador.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return posicion;
    }//FIN DEL METODO

    private int PosicionRaiz(NodoBinario registro) {
        int posicion = 0;
        try {
            RandomAccessFile contador = new RandomAccessFile(archivoBinario, "r");
            String line;
            String[] atributos;
            while ((line = contador.readLine()) != null) {
                atributos = line.split("\\|");
                if (atributos[2].contains(registro.getUsuarioEmisor())
                        && atributos[3].contains(registro.getUsuarioReceptor())
                        && atributos[7].contains(registro.getFechaTransaccion())) {
                    contador.close();
                    posicion++;
                    return posicion;
                }
                posicion++;
            }
            contador.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return posicion;
    }//FIN DEL METODO

    private int PosicionRegistroEliminar(String registro) {
        int posicion = 0;
        try {
            RandomAccessFile contador = new RandomAccessFile(archivoBinario, "r");
            String line;
            while ((line = contador.readLine()) != null) {
                if (line.equals(registro)) {
                    contador.close();
                    posicion++;
                    return posicion;
                }
                posicion++;
            }
            contador.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return posicion;
    }//FIN DEL METODO   

    private int RetornarRaizRegistro() throws FileNotFoundException, IOException {
        String linea;
        RandomAccessFile archive = new RandomAccessFile(descriptor, "rw");
        String[] raiz;
        while ((linea = archive.readLine()) != null) {
            raiz = linea.split(":");
            if (raiz[0].contains("Raiz")) {
                return Integer.parseInt(raiz[1].trim());
            }
        }
        return 0;
    }

    public void Reorganizar() throws IOException {
        int inicio = RetornarRaizRegistro();
        raizArbol = obtenerPadre(inicio);
        RecorrerArbol(raizArbol);
    }

    private void RecorrerArbol(NodoBinario raiz) throws IOException {
        RecorrerArbol(obtenerPadre(Integer.valueOf(raiz.getIzquierdo().trim())));
        RecorrerArbol(raiz);
        RecorrerArbol(obtenerPadre(Integer.valueOf(raiz.getDerecho().trim())));
    }

    private NodoBinario Busqueda(NodoBinario nodoBuscado) throws FileNotFoundException, IOException {
        String[] atributos = null;
        NodoBinario buscado = new NodoBinario("", "", "", "", "");
        RandomAccessFile archivo = new RandomAccessFile(archivoBinario, "rw");
        String inputLine;
        while ((inputLine = archivo.readLine()) != null) {
            atributos = inputLine.split("\\|");
            nodoBuscado.setDerecho(atributos[1]);
            nodoBuscado.setIzquierdo(atributos[0]);
            if (atributos[2].contains(nodoBuscado.getUsuarioEmisor())
                    && atributos[3].contains(nodoBuscado.getUsuarioReceptor())
                    && atributos[4].contains(nodoBuscado.getAsunto())
                    && atributos[5].contains(nodoBuscado.getMensaje())
                    && atributos[8].trim().contains("1")) {
                buscado.CreateFromString(inputLine);
                return buscado;
            }
        }
        archivo.close();
        return buscado;
    }

    public ArrayList<String> BusquedaBandejaSalida(String usuarioEmisor) throws FileNotFoundException, IOException {

        ArrayList<String> listaBandejaSalida = new ArrayList<>();
        String[] atributos = null;
        RandomAccessFile archivo = new RandomAccessFile(archivoBinario, "rw");
        String inputLine;
        while ((inputLine = archivo.readLine()) != null) {
            atributos = inputLine.split("\\|");
            if (atributos[2].trim().equals(usuarioEmisor) && atributos[atributos.length - 1].equals("1")) {
                listaBandejaSalida.add(inputLine);
            }
        }
        archivo.close();
        return listaBandejaSalida;
    }

    public ArrayList<String> BusquedaBandejaEntrada(String usuarioReceptor) throws FileNotFoundException, IOException {

        ArrayList<String> listaBandejaEntrada = new ArrayList<>();
        String[] atributos = null;
        NodoBinario buscado = new NodoBinario("", "", "", "", "");
        RandomAccessFile archivo = new RandomAccessFile(archivoBinario, "r");
        String inputLine;
        while ((inputLine = archivo.readLine()) != null) {
            atributos = inputLine.split("\\|");
            if (atributos[3].trim().equals(usuarioReceptor) && atributos[atributos.length - 1].equals("1")) {
                listaBandejaEntrada.add(inputLine);
            }
        }
        archivo.close();
        return listaBandejaEntrada;
    }

    private boolean verificarEliminarTodos() throws FileNotFoundException, IOException {
        int cantidadRegistrosInactivosArbol = 0;
        String[] atributos = null;
        RandomAccessFile archivo = new RandomAccessFile(archivoBinario, "rw");
        String inputLine;
        while ((inputLine = archivo.readLine()) != null) {
            atributos = inputLine.split("\\|");
            if (atributos[8].contains("0")) {
                cantidadRegistrosInactivosArbol++;
            }
        }
        archivo.close();
        if (cantidadRegistrosInactivosArbol == CantidadRegistrosArbol()) {
            return true;
        }
        return false;
    }

    public void ReorganizarArbol() throws IOException {
        int raiz = RetornarRaizRegistro();
        Map<Integer, Integer> refactor = new HashMap();
        InputStream f = new FileInputStream(archivoBinario);
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        String line;
        int counter = 1;
        List<String> activos = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            if (line.split("\\|")[line.split("\\|").length - 1].contains("1")) {
                activos.add(line);
                refactor.put(counter, refactor.size() + 1);
            }
            counter++;
        }
        br.close();
        refactor.put(0, 0);
        if (activos.size() == 0) {
            FileChannel.open(Paths.get(archivoBinario.getPath()), StandardOpenOption.WRITE).truncate(0).close();
            RewriteDesc();
        } else {
            FileChannel.open(Paths.get(archivoBinario.getPath()), StandardOpenOption.WRITE).truncate(0).close();
            OutputStream out = new FileOutputStream(archivoBinario);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            NodoBinario temp = new NodoBinario();
            NodoBinario active = new NodoBinario();
            for (String activo : activos) {

                temp.CreateFromString(activo);
                active.CreateFromString(activo);
                if (!temp.getIzquierdo().trim().equals("-1")) {
                    active.setIzquierdo(String.valueOf(refactor.get(Integer.valueOf(temp.getIzquierdo().trim()))));
                }
                if (!temp.getDerecho().trim().equals("-1")) {
                    active.setDerecho(String.valueOf(refactor.get(Integer.valueOf(temp.getDerecho().trim()))));
                }
                bw.write(active.toString());
                bw.write(System.lineSeparator());
            }
            bw.close();
            raiz = refactor.get(raiz);
            RefactorDescriptor(raiz, activos.size());

        }

    }

    private void RefactorDescriptor(int nraiz, int activos) {
        try {
            FileChannel.open(Paths.get(descriptor.getPath()), StandardOpenOption.WRITE).truncate(0).close();
            RandomAccessFile archivo = new RandomAccessFile(descriptor, "rw");
            StringBuilder descriptorArbol = new StringBuilder();
            descriptorArbol.append("Numero de Registros:" + rightpad(String.valueOf(activos), 4));
            descriptorArbol.append(System.lineSeparator());
            descriptorArbol.append("Raiz:" + rightpad(String.valueOf(nraiz), 4)); //Raiz
            descriptorArbol.append(System.lineSeparator());
            descriptorArbol.append("Registros Activos:" + rightpad(String.valueOf(activos), 4));
            descriptorArbol.append(System.lineSeparator());
            descriptorArbol.append("Registros Inactivos:" + rightpad(String.valueOf(0), 4));
            archivo.writeBytes(descriptorArbol.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Binario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Binario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void RewriteDesc() {
        try {
            FileChannel.open(Paths.get(descriptor.getPath()), StandardOpenOption.WRITE).truncate(0).close();
            RandomAccessFile archivo = new RandomAccessFile(descriptor, "rw");
            StringBuilder descriptorArbol = new StringBuilder();
            descriptorArbol.append("Numero de Registros:" + rightpad(String.valueOf(CantidadRegistrosArbol()), 4));
            descriptorArbol.append(System.lineSeparator());
            descriptorArbol.append("Raiz:" + rightpad(String.valueOf(0), 4)); //Raiz
            descriptorArbol.append(System.lineSeparator());
            descriptorArbol.append("Registros Activos:" + rightpad(String.valueOf(CantidadRegistrosActivosArbol()), 4));
            descriptorArbol.append(System.lineSeparator());
            descriptorArbol.append("Registros Inactivos:" + rightpad(String.valueOf(0), 4));
            archivo.writeBytes(descriptorArbol.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Binario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Binario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
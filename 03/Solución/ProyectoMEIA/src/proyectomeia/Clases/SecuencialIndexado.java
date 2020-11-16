package proyectomeia.Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecuencialIndexado {

    //VARIBALES GLOBALES
    private RandomAccessFile archivo;
    private File DescriptorIndice;
    private File Indice;
    private File DescriptorMasterFile;
    private File masterFile;
    private int nPosicion = 1;
    public boolean flag;
    ArrayList<String> lineas = new ArrayList<>();

    /**
     * Metodo constructor
     *
     * @param nuevoUsuarioLista usuario
     * @param desc_indice_ruta RUTA DESCRIPTOR INDICE
     * @param indice_ruta RUTA INDICE
     * @param desc_lista_ruta RUTA DESCRIPTOR LISTA
     * @param lista_ruta RUTA LISTA
     */
    public SecuencialIndexado(String desc_indice_ruta, String indice_ruta, String desc_lista_ruta, String lista_ruta) {
        Indice = new File(indice_ruta);
        masterFile = new File(lista_ruta);
        DescriptorIndice = new File(desc_indice_ruta);
        DescriptorMasterFile = new File(desc_lista_ruta);
    }

    /**
     * Metodo que permite insertar en el indice y rerganizar las entradas
     *
     * @param nombreLista nombre de la lista
     * @param Usuario nombre de usuario
     * @param UsuarioAsociado nombre del usuario asociado
     * @param Siguiente registro siguiente
     * @param Estatus estatus
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void InsertarIndice(String Object) throws IOException, FileNotFoundException {
        String Posicion = "1.";
        archivo = new RandomAccessFile(Indice, "rw");
        long tamanio = archivo.length();
        //Primera Posicion
        if (tamanio == 0) {
            archivo.seek(tamanio);
            ObjectIndice newv = new ObjectIndice();
            newv.CreateFromString(Object);
            newv.setNregistro(String.valueOf(nPosicion));
            newv.setPosicion(Posicion + nPosicion);
            newv.setSiguiente(String.valueOf(-1));
            archivo.writeBytes(newv.toString());
            archivo.writeBytes(System.lineSeparator());
            nPosicion++;
            CrearDescriptorIndice();
            flag = true;
            archivo.close();
        } else {
            //Dos posiciones o mas
            if (CantidadRegistrosIndice() >= 1) {
                archivo.seek(tamanio);
                nPosicion = CantidadRegistrosIndice();
                nPosicion++;
                archivo.seek(tamanio);
                ObjectIndice newv = new ObjectIndice();
                newv.CreateFromString(Object);
                newv.setNregistro(String.valueOf(nPosicion));
                newv.setPosicion(Posicion + nPosicion);
                newv.setSiguiente(ObtenerDSiguiente(newv.toString()));
                String nuevo = newv.toString();
                archivo.writeBytes(nuevo);
                archivo.writeBytes(System.lineSeparator());
                archivo.close();
                UpdateDescriptorIndice();
                flag = false;
            }
        }
    }

    /**
     * Metodo que permite insertar en una lista
     *
     * @param nombreLista nombre de la lista
     * @param usuario nombre del usuario creador
     * @param usuarioAsociado nombre del usuario asociado
     * @param descriptor nombre de la descripcion
     * @param Status estatus
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void InsertarLista(String object) {
        try {
            archivo = new RandomAccessFile(masterFile, "rw");
            long tamanio = archivo.length();
            archivo.seek(tamanio);
            archivo.writeBytes(object);
            archivo.writeBytes(System.lineSeparator());
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    Retorna la posición del siguiente dato en el archivo Indice
     */
    private int Next(String find) {
        String[] positions = find.split("\\|");
        int next = Integer.parseInt(positions[5].trim());
        return next;
    }

    /**
     * retorna el dato localizado en la posición indicada
     *
     * @param position posición del dato en el Indice
     * @return dato encontrado
     * @throws IOException
     */
    private String siguiente(int position) throws IOException {
        String line = "";
        InputStream f = new FileInputStream(Indice);
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        String inputLine;
        for (int i = 0; i < position; i++) {
            inputLine = br.readLine();
            if (i == position - 1) {
                line = inputLine;
            }
        }

        br.close();
        return line;
    }

    public void EliminarUsuarioLista(String NombreLista, String nombreUsuario, String usuarioEliminar) throws FileNotFoundException, IOException {
        RandomAccessFile archivo = new RandomAccessFile(Indice, "rw");
        String lineaModificar;
        String[] data;
        long tam = 0;
        while ((lineaModificar = archivo.readLine()) != null) {
            data = lineaModificar.split("\\|");
            if (data[2].contains(NombreLista) && data[3].contains(nombreUsuario) && data[4].contains(usuarioEliminar)) {
                ReorganizarEliminacion(lineaModificar);
                ObjectIndice nuevo = new ObjectIndice();
                nuevo.CreateFromString(lineaModificar);
                nuevo.setEstatus("0");
                nuevo.setSiguiente("-2");
                Modificar(lineaModificar, nuevo.toString());
                String inlista = Blista_Usuario(data[1]);
                EliminarnLista(inlista);
                UpdateDescriptorIndice();
            }
        }
        archivo.close();
    }

    /**
     * Metodo que recibe como parametro las claves e inactiva una lista
     *
     * @param NombreLista clave 1
     * @param nombreUsuario clave 2
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void EliminarEnEjecucion(String NombreLista, String nombreUsuario) throws FileNotFoundException, IOException {
        RandomAccessFile archivo = new RandomAccessFile(Indice, "rw");
        String lineaModificar;
        String[] data = null;
        long tam = 0;
        while ((lineaModificar = archivo.readLine()) != null) {
            data = lineaModificar.split("\\|");
            if (data[2].contains(NombreLista) && data[3].contains(nombreUsuario)) {
                ReorganizarEliminacion(lineaModificar);
                ObjectIndice nuevo = new ObjectIndice();
                nuevo.CreateFromString(lineaModificar);
                nuevo.setEstatus("0");
                nuevo.setSiguiente("-2");
                /*archivo.seek(archivo.getFilePointer()-3);                
                archivo.writeBytes("0");
                archivo.seek(archivo.getFilePointer()+2);
                archivo.seek(archivo.getFilePointer()-10);
                archivo.writeBytes("-2");
                archivo.seek(archivo.getFilePointer()+9); */
                Modificar(lineaModificar, nuevo.toString());
                String inlista = Blista_Usuario(data[1]);
                EliminarnLista(inlista);
                UpdateDescriptorIndice();
            }
        }
        archivo.close();
    }

    private void ReorganizarEliminacion(String object) {
        try {
            ObjectIndice eliminar = new ObjectIndice();
            eliminar.CreateFromString(object);
            String nsiguiente = eliminar.getSiguiente();
            String posreplace = eliminar.getNregistro();
            refactorEliminar(posreplace, nsiguiente);
        } catch (IOException ex) {
            Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refactorEliminar(String posremplazar, String nuevos) throws IOException {
        boolean found = false;
        int b = ObtenerInicio();
        String in = siguiente(b);
        while (found == false) {
            found = csig(posremplazar.trim(), in);
            if (found) {

                ObjectIndice cambiar = new ObjectIndice();
                cambiar.CreateFromString(in);
                cambiar.setSiguiente(nuevos);
                Modificar(in, cambiar.toString());

            } else {
                ObjectIndice elfound = new ObjectIndice();
                elfound.CreateFromString(in);
                int next = Next(in);
                if (next == -1) {
                    NuevoInicio(elfound.getSiguiente());
                    found = true;
                } else {
                    in = siguiente(next);
                }
            }
        }
    }

    /**
     * Elimina todas las listas desactivadas, inserta nuevamente las listas
     * activas, y la reorganiza
     *
     * @throws IOException
     */
    public void EliminacionLogicaAlCerrar(String user) throws IOException {
        ArrayList<String> lineasIndice = new ArrayList<>();
        ArrayList<String> lineasMaster = new ArrayList<>();
        ArrayList<String> lineasMasterSeleccionadas = new ArrayList<>();
        File temp1 = new File(Indice.getPath());
        File temp2 = new File(masterFile.getPath());
        RandomAccessFile indice = new RandomAccessFile(Indice, "rw");
        RandomAccessFile master = new RandomAccessFile(masterFile, "rw");
        String dataIndice, dataMaster;
        String[] acumulado, masterLista;
        while ((dataIndice = indice.readLine()) != null) {
            acumulado = dataIndice.split("\\|");
            if (acumulado[6].contains("1")) {
                lineasIndice.add(acumulado[1] + "|" + acumulado[2] + "|" + acumulado[3] + "|" + acumulado[4] + "|" + acumulado[6]);//almacena las listas activas                
            }
        }
        String[] posicion = new String[lineasIndice.size()];
        for (int i = 0; i < posicion.length; i++) {
            posicion[i] = lineasIndice.get(i).split("\\|")[0];
        }

        while ((dataMaster = master.readLine()) != null) {
            lineasMaster.add(dataMaster);
        }
        for (int i = 0; i < posicion.length; i++) {
            String h = String.valueOf(posicion[i].charAt(2));
            int j = Integer.valueOf(h);
            lineasMasterSeleccionadas.add(lineasMaster.get(j - 1));
        }
        //Se eliminan los anteriores
        indice.close();
        master.close();
        Indice.delete();
        masterFile.delete();
        //Se crean los archivos        
        temp1.createNewFile();
        temp2.createNewFile();
        FileChannel.open(Paths.get(DescriptorIndice.getPath()), StandardOpenOption.WRITE).truncate(0).close();
        Indice = temp1;
        masterFile = temp2;
        nPosicion = 1;
        for (int i = 0; i < lineasMasterSeleccionadas.size(); i++) {
            ObjectIndice nuevo = new ObjectIndice(lineasIndice.get(i).split("\\|")[1],
                    lineasIndice.get(i).split("\\|")[2],
                    lineasIndice.get(i).split("\\|")[3]);
            UsuarioIndexado newi = new UsuarioIndexado(lineasMasterSeleccionadas.get(i).split("\\|")[0],
                    lineasMasterSeleccionadas.get(i).split("\\|")[1],
                    lineasMasterSeleccionadas.get(i).split("\\|")[2],
                    lineasMasterSeleccionadas.get(i).split("\\|")[3]);
            InsertarIndice(nuevo.toString());
            InsertarLista(newi.toString());
            FileChannel.open(Paths.get(DescriptorMasterFile.getPath()), StandardOpenOption.WRITE).truncate(0).close();
            CrearDescriptorLista(user);
        }

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
        RandomAccessFile archivo = new RandomAccessFile(Indice, "rw");
        for (int i = -1; i < posicion; i++) {
            archivo.readLine();
        }
        long rewrite = archivo.getFilePointer();
        archivo.seek(rewrite);
        archivo.writeBytes(Nuevo);
        archivo.close();

    }

    public void ModLista(String viejo, String Nuevo) throws FileNotFoundException, IOException {
        int posicion = PosicionRegister(viejo);
        RandomAccessFile archivo = new RandomAccessFile(masterFile, "rw");
        for (int i = -1; i < posicion; i++) {
            archivo.readLine();
        }
        long rewrite = archivo.getFilePointer();
        archivo.seek(rewrite);
        archivo.writeBytes(Nuevo);
        archivo.close();

    }

    private void EliminarnLista(String viejo) {
        try {
            UsuarioIndexado nuevo = new UsuarioIndexado();
            nuevo.CreateFromString(viejo);
            nuevo.setStatus("0");
            ModLista(viejo, nuevo.toString());
        } catch (IOException ex) {
            Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Esta función retorna un elemento del
     *
     * @param object
     * @return
     * @throws IOException
     */
    public String Busqueda(String object) throws IOException {
        String exists = "";
        if (Indice.exists()) {
            int iterator = 0;
            try {
                iterator = ObtenerInicio();
            } catch (IOException ex) {
                Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
            }
            String siguiente = "";
            try {
                siguiente = siguiente(iterator);
            } catch (IOException ex) {
                Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (exists.equals("")) {
                int comparate = compare(object, siguiente);
                if (comparate == 0) {
                    exists = siguiente;
                } else {
                    int mfound = Next(siguiente);
                    if (mfound == -1) {
                        break;
                    } else {
                        siguiente = siguiente(mfound);
                    }
                }
            }
        }

        return exists;

    }

    public List<String> BusuariosLista(String object) throws IOException {
        List<String> users = new ArrayList<>();
        if (Indice.exists()) {
            int iterator = 0;
            iterator = ObtenerInicio();
            String siguiente = "";
            siguiente = siguiente(iterator);
            boolean flag = true;
            while (flag == true) {
                int comparate = compare1(object, siguiente);
                if (comparate == 0) {
                    users.add(siguiente);
                }
                int mfound = Next(siguiente);
                if (mfound == -1) {
                    flag = false;
                } else {
                    siguiente = siguiente(mfound);
                }
            }
        }

        return users;
    }

    public String Blista_Usuario(String position) {
        InputStream f = null;
        String result = "";
        try {
            String temp = "1.";
            String nuevo = position.substring(temp.length(), position.length());
            int pos = Integer.parseInt(nuevo.trim());
            f = new FileInputStream(masterFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(f));
            for (int i = 0; i < pos; i++) {
                String line = br.readLine();
                if (i == pos - 1) {
                    result = line;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public boolean existeUsuario(String object) throws IOException {
        boolean exists = false;
        if (Indice.exists()) {
            int iterator = 0;
            try {
                iterator = ObtenerInicio();
            } catch (IOException ex) {
                Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
            }
            String siguiente = "";
            try {
                siguiente = siguiente(iterator);
            } catch (IOException ex) {
                Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (exists == false) {
                int comparate = compare(object, siguiente);
                if (comparate == 0) {
                    exists = true;
                } else {
                    int mfound = Next(siguiente);
                    if (mfound == -1) {
                        break;
                    } else {
                        siguiente = siguiente(mfound);
                    }
                }
            }
        }

        return exists;
    }

    /**
     * Sobreescrbe el descriptor LISTA, lo actualiza, sin problemas
     *
     * @param usuario coloca el utltimo usuario
     * @throws IOException
     */
    public void CrearDescriptorLista(String usuario) throws IOException {
        archivo = new RandomAccessFile(DescriptorMasterFile, "rw");
        StringBuilder descriptorLista = new StringBuilder();
        descriptorLista.append("Usuario Creado:" + rightpad(usuario, 20));
        descriptorLista.append(System.lineSeparator());
        descriptorLista.append("Fecha Creacion:" + new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
        descriptorLista.append(System.lineSeparator());
        descriptorLista.append("Numero de Registros:" + rightpad(String.valueOf(CantidadRegistrosLista()), 4));
        descriptorLista.append(System.lineSeparator());
        descriptorLista.append("Registros Activos:" + rightpad(String.valueOf(CantidadRegistrosActivosLista()), 4));
        descriptorLista.append(System.lineSeparator());
        descriptorLista.append("Registros Inactivos:" + rightpad(String.valueOf(CantidadRegistrosInactivosLista()), 4));
        archivo.writeBytes(descriptorLista.toString());

    }

    public void UpdateDescriptorLista(String usuario) {
        try {
            FileChannel.open(Paths.get(DescriptorMasterFile.getPath()), StandardOpenOption.WRITE).truncate(0).close();
            archivo = new RandomAccessFile(DescriptorMasterFile, "rw");
            StringBuilder descriptorLista = new StringBuilder();
            descriptorLista.append("Usuario Creado:" + rightpad(usuario, 20));
            descriptorLista.append(System.lineSeparator());
            descriptorLista.append("Fecha Creacion:" + new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
            descriptorLista.append(System.lineSeparator());
            descriptorLista.append("Numero de Registros:" + rightpad(String.valueOf(CantidadRegistrosLista()), 4));
            descriptorLista.append(System.lineSeparator());
            descriptorLista.append("Registros Activos:" + rightpad(String.valueOf(CantidadRegistrosActivosLista()), 4));
            descriptorLista.append(System.lineSeparator());
            descriptorLista.append("Registros Inactivos:" + rightpad(String.valueOf(CantidadRegistrosInactivosLista()), 4));
            archivo.writeBytes(descriptorLista.toString());

        } catch (IOException ex) {
            Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que crea el descriptor del indice, lo va actualizando
     *
     * @throws IOException
     */
    public void CrearDescriptorIndice() throws IOException {
        RandomAccessFile archivo = new RandomAccessFile(DescriptorIndice, "rw");
        StringBuilder descriptorLista = new StringBuilder();
        descriptorLista.append("Numero de Registros:" + rightpad(String.valueOf(CantidadRegistrosIndice()), 4));
        descriptorLista.append(System.lineSeparator());
        descriptorLista.append("Registro Inicio:" + rightpad("1", 4));
        descriptorLista.append(System.lineSeparator());
        descriptorLista.append("Registros Activos:" + rightpad(String.valueOf(CantidadRegistrosActivosIndice()), 4));
        descriptorLista.append(System.lineSeparator());
        descriptorLista.append("Registros Inactivos:" + rightpad(String.valueOf(CantidadRegistrosInactivosIndice()), 4));
        archivo.writeBytes(descriptorLista.toString());

    }

    private void UpdateDescriptorIndice() {
        try {
            int inicio = ObtenerInicio();
            if (inicio == -2) {
                nPosicion = 1;
                FileChannel.open(Paths.get(DescriptorIndice.getPath()), StandardOpenOption.WRITE).truncate(0).close();
                FileChannel.open(Paths.get(Indice.getPath()), StandardOpenOption.WRITE).truncate(0).close();
                FileChannel.open(Paths.get(DescriptorMasterFile.getPath()), StandardOpenOption.WRITE).truncate(0).close();
                FileChannel.open(Paths.get(masterFile.getPath()), StandardOpenOption.WRITE).truncate(0).close();
            } else {

                FileChannel.open(Paths.get(DescriptorIndice.getPath()), StandardOpenOption.WRITE).truncate(0).close();
                RandomAccessFile archivo = new RandomAccessFile(DescriptorIndice, "rw");
                StringBuilder descriptorLista = new StringBuilder();
                descriptorLista.append("Numero de Registros:" + rightpad(String.valueOf(CantidadRegistrosIndice()), 4));
                descriptorLista.append(System.lineSeparator());
                descriptorLista.append("Registro Inicio:" + rightpad(String.valueOf(inicio), 4));
                descriptorLista.append(System.lineSeparator());
                descriptorLista.append("Registros Activos:" + rightpad(String.valueOf(CantidadRegistrosActivosIndice()), 4));
                descriptorLista.append(System.lineSeparator());
                descriptorLista.append("Registros Inactivos:" + rightpad(String.valueOf(CantidadRegistrosInactivosIndice()), 4));
                archivo.writeBytes(descriptorLista.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene la posición de inicio del Indice
     *
     * @return posición de inicio
     * @throws FileNotFoundException
     * @throws IOException
     */
    private int ObtenerInicio() throws FileNotFoundException, IOException {
        int inicio = 0;
        String line;
        InputStream f = new FileInputStream(DescriptorIndice);
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        while ((line = br.readLine()) != null) {
            if (line.contains("Registro Inicio")) {
                String temp = "Registro Inicio:";
                String ini = line.substring(temp.length(), line.length());
                inicio = Integer.parseInt(ini.trim());
            }

        }
        return inicio;
    }

    /**
     * Modifica el Inicio del Indice cuando es necesario
     *
     * @param nInicio nuevo inicio
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void NuevoInicio(String nInicio) throws FileNotFoundException, IOException {
        String line;
        RandomAccessFile r = new RandomAccessFile(DescriptorIndice, "rw");
        while ((line = r.readLine()) != null) {
            if (line.contains("Numero de Registros")) {
                long mod = r.getFilePointer();
                r.seek(mod);
                String newval = "Registro Inicio:" + rightpad(nInicio, 4);
                r.writeBytes(newval);

            }
        }
        r.close();

    }

    /**
     * verifica si la posición evaluada es el inicio
     *
     * @param t
     * @return
     */
    private boolean esInicio(int t) {
        boolean is = false;
        try {
            int inicio = ObtenerInicio();
            if (t == inicio) {
                is = true;
            }

        } catch (IOException ex) {
            Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return is;
    }

    protected String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    /**
     * Obtiene el siguiente que se le debe asignar al nuevo elemento del Indice
     *
     * @param object
     * @return
     * @throws IOException
     */
    private String ObtenerDSiguiente(String object) throws IOException {
        int inicio = ObtenerInicio();
        String siguiente = "";
        String comparate = siguiente(inicio);
        boolean found = false;
        while (found == false) {
            int compare = compare(object, comparate);
            if (compare < 0) {
                int nxt = Integer.parseInt(comparate.split("\\|")[0].trim());
                boolean is = esInicio(nxt);
                if (is) {
                    siguiente = comparate.split("\\|")[0];
                    found = true;
                    //falta cambiar el inicio
                    String nin = object.split("\\|")[0];
                    NuevoInicio(nin);
                } else {
                    int next = Integer.parseInt(comparate.split("\\|")[0].trim());
                    siguiente = comparate.split("\\|")[0];
                    found = true;
                    RefactornI(next, object);

                }
            } else {
                int mfound = Next(comparate);
                if (mfound == -1) {
                    siguiente = String.valueOf(mfound);
                    found = true;
                    String nnext = object.split("\\|")[0];
                    RefactorF(mfound, nnext);
                } else {
                    comparate = siguiente(mfound);
                }

            }
        }

        return siguiente;
    }

    /**
     * Refactoriza el Indice cuando se debe cambiar el inicio
     *
     * @param i
     * @param n
     */
    private void RefactornI(int i, String n) {
        try {
            int inicio = ObtenerInicio();
            String comparacion = siguiente(inicio);
            boolean found = false;
            while (!found) {
                found = csig(String.valueOf(i), comparacion);
                if (found) {
                    String news = n.split("\\|")[0];
                    ObjectIndice change = new ObjectIndice();
                    change.CreateFromString(comparacion);
                    change.setSiguiente(news);
                    Modificar(comparacion, change.toString());
                } else {
                    int mfound = Next(comparacion);
                    comparacion = siguiente(mfound);
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(SecuencialIndexado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Refactoriza el Indice cuando se debe cambiar el final
     *
     * @param vfin
     * @param nfin
     * @throws IOException
     */
    private void RefactorF(int vfin, String nfin) throws IOException {
        int inicio = ObtenerInicio();
        String comparacion = siguiente(inicio);
        boolean found = false;
        while (!found) {
            found = foundfin(vfin, comparacion);
            if (found) {
                ObjectIndice change = new ObjectIndice();
                change.CreateFromString(comparacion);
                change.setSiguiente(nfin);
                Modificar(comparacion, change.toString());
            } else {
                int mfound = Next(comparacion);
                comparacion = siguiente(mfound);
            }
        }
    }

    /**
     * Revisa si la linea es la última del Indice
     *
     * @param i
     * @param comp
     * @return
     */
    private boolean foundfin(int i, String comp) {
        String l1 = String.valueOf(i);
        String l2 = comp.split("\\|")[5].trim();
        boolean found = false;
        int result = l1.compareTo(l2);
        if (result == 0) {
            found = true;
        }
        return found;

    }

    private int PosicionRegistro(String registro) {
        int posicion = -1;
        try {
            RandomAccessFile contador = new RandomAccessFile(Indice, "r");
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
    }

    private int PosicionRegister(String registro) {
        int posicion = -1;
        try {
            RandomAccessFile contador = new RandomAccessFile(masterFile, "r");
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
    }

    private int compare(String o1, String o2) {
        String l1 = o1.split("\\|")[2];
        String l2 = o2.split("\\|")[2];
        int result = l1.compareTo(l2);
        if (result == 0) {
            l1 = o1.split("\\|")[3];
            l2 = o2.split("\\|")[3];
            result = l1.compareTo(l2);
            if (result == 0) {
                l1 = o1.split("\\|")[4];
                l2 = o2.split("\\|")[4];
                result = l1.compareTo(l2);
            }
        }
        return result;

    }

    private int compare1(String o1, String o2) {
        String l1 = o1.split("\\|")[2];
        String l2 = o2.split("\\|")[2];
        int result = l1.compareTo(l2);
        if (result == 0) {
            l1 = o1.split("\\|")[3];
            l2 = o2.split("\\|")[3];
            result = l1.compareTo(l2);
        }
        return result;
    }

    /**
     * verifica si se cambia el siguiente
     *
     * @param o1
     * @param o2
     * @return
     */
    private boolean csig(String o1, String o2) {
        boolean found = false;
        String l1 = o1;
        String l2 = o2.split("\\|")[5].trim();

        int result = l1.compareTo(l2);
        if (result == 0) {
            found = true;
        }
        return found;
    }

    /**
     * Metodo que retorna la cantidad de Registros en la lista
     *
     * @return cantidadRegistrosLista
     * @throws FileNotFoundException
     * @throws IOException
     */
    private int CantidadRegistrosLista() throws FileNotFoundException, IOException {
        int cantidadRegistrosIndice = 0;
        InputStream f = new FileInputStream(masterFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            if (inputLine != null) {
                cantidadRegistrosIndice++;
            }
        }
        br.close();
        return cantidadRegistrosIndice;
    }

    /**
     * Metodo que retorna la cantidad de Registros activos en la lista
     *
     * @return cantidadRegistrosActivosLista
     * @throws FileNotFoundException
     * @throws IOException
     */
    private int CantidadRegistrosActivosLista() throws FileNotFoundException, IOException {
        int cantidadRegistrosActivosIndice = 0;
        String[] atributos = null;
        InputStream f = new FileInputStream(Indice);
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            atributos = inputLine.split("\\|");
            if (atributos[6].contains("1")) {
                cantidadRegistrosActivosIndice++;
            }
        }
        br.close();
        return cantidadRegistrosActivosIndice;
    }

    /**
     * Metodo que retorna la cantidad de Registros inactivos en la lista
     *
     * @return cantidadRegistrosInactivosLista
     * @throws FileNotFoundException
     * @throws IOException
     */
    private int CantidadRegistrosInactivosLista() throws IOException {
        int cantidadRegistrosActivosIndice = 0;
        String[] atributos = null;
        InputStream f = new FileInputStream(Indice);
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            atributos = inputLine.split("\\|");
            if (atributos[6].contains("0")) {
                cantidadRegistrosActivosIndice++;
            }
        }
        br.close();
        return cantidadRegistrosActivosIndice;
    }

    /**
     * Metodo que retorna la cantidad de Registros inactivos en el indice
     *
     * @return cantidadRegistrosInactivosLista
     * @throws FileNotFoundException
     * @throws IOException
     */
    private int CantidadRegistrosInactivosIndice() throws IOException {
        int cantidadRegistrosInactivosIndice = 0;
        String[] atributos = null;
        InputStream f = new FileInputStream(Indice);
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            atributos = inputLine.split("\\|");
            if (atributos[6].contains("0")) {
                cantidadRegistrosInactivosIndice++;
            }
        }
        br.close();
        return cantidadRegistrosInactivosIndice;
    }

    /**
     * Metodo que retorna la cantidad de Registros activos en el indice
     *
     * @return cantidadRegistrosActivosLista
     * @throws FileNotFoundException
     * @throws IOException
     */
    private int CantidadRegistrosActivosIndice() throws FileNotFoundException, IOException {
        int cantidadRegistrosActivosIndice = 0;
        String[] atributos = null;
        InputStream f = new FileInputStream(Indice);
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            atributos = inputLine.split("\\|");
            if (atributos[6].contains("1")) {
                cantidadRegistrosActivosIndice++;
            }
        }
        br.close();
        return cantidadRegistrosActivosIndice;
    }

    /**
     * Metodo que retorna la cantidad de Registros en el indice
     *
     * @return cantidadRegistrosIndice
     * @throws FileNotFoundException
     * @throws IOException
     */
    private int CantidadRegistrosIndice() throws FileNotFoundException, IOException {
        int cantidadRegistrosIndice = 0;
        InputStream f = new FileInputStream(Indice);
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            if (inputLine != null) {
                cantidadRegistrosIndice++;
            }
        }
        br.close();
        return cantidadRegistrosIndice;
    }
}
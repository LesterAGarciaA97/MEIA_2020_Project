package proyectomeia.Clases;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.swing.JOptionPane;
import proyectomeia.Clases.Usuario;

public class SequentialFile {

    private RandomAccessFile ArchivoUsuario;
    public File descriptorUsuario;
    private File masterfileUsuario;
    public ApiloFile bitacora;
    private String[] usuario;
    private String usuario_;
    public boolean flag;

    /**
     * Constructor del archivo Sequential
     *
     * @param Masterfile ruta del archivo Sequential
     */
    public SequentialFile(String Masterfile, ApiloFile file) {
        this.masterfileUsuario = new File(Masterfile);
        this.descriptorUsuario = new File(this.masterfileUsuario.getParent() + "/" + "desc_" + this.masterfileUsuario.getName().replaceAll(".txt", "") + ".txt");
        this.bitacora = file;
        this.usuario_ = "";
    }

    /**
     * Inserta un valor a la bitácora
     *
     * @param valor valor a guardar
     * @throws IOException en caso no pueda leer el archivo
     */
    public void Insertar(String valor) throws IOException {
        if (bitacora.masterfile.exists()) {
            List<String> results = bitacora.Busqueda(valor);
            if (results.isEmpty() && this.masterfileUsuario.exists()) {
                String result = Buscar(valor);
                if (result == null || result.isEmpty()) {
                    if (bitacora.getNoRegistros() == bitacora.ReturnMaxreg()) {
                        refactorBitacora();
                        flag = true;
                    }
                    bitacora.Insertar(valor);
                }
            } else if (results.isEmpty()) {
                if (bitacora.getNoRegistros() == bitacora.ReturnMaxreg()) {
                    refactorBitacora();
                    flag = true;
                }
                bitacora.Insertar(valor);
            }
        } else {
            bitacora.Insertar(valor);
        }

    }

    public void refactorBitacora() throws IOException {
        bitacora.Reorganizar();
        LinkedList<String> strings = new LinkedList<>();
        RandomAccessFile archive = new RandomAccessFile(bitacora.masterfile, "r");
        String line;
        while ((line = archive.readLine()) != null) {
            strings.add(line);
        }
        archive.close();
        bitacora.empty();
        line = "";
        if (masterfileUsuario.exists()) {
            RandomAccessFile file = new RandomAccessFile(masterfileUsuario, "r");
            while ((line = file.readLine()) != null) {
                strings.add(line);
            }
            file.close();
            Collections.sort(strings, (o1, o2) -> o1.split("\\|")[0].compareToIgnoreCase(o2.split("\\|")[0]));
            FileChannel.open(Paths.get(masterfileUsuario.getPath()), StandardOpenOption.WRITE).truncate(0).close();
            RandomAccessFile file_ = new RandomAccessFile(masterfileUsuario, "rw");

            for (int i = 0; i < strings.size(); i++) {
                file_.writeBytes(strings.get(i));
                file_.writeBytes(System.lineSeparator());
            }
            file_.close();
            UpdateDescriptor(String.valueOf(RegistrosActivos()), String.valueOf(RegistrosInactivos()), new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));

        } else {
            Collections.sort(strings, (o1, o2) -> o1.split("\\|")[0].compareToIgnoreCase(o2.split("\\|")[0]));
            RandomAccessFile file_ = new RandomAccessFile(masterfileUsuario, "rw");

            for (int i = 0; i < strings.size(); i++) {
                file_.writeBytes(strings.get(i));
                file_.writeBytes(System.lineSeparator());
            }
            file_.close();
            UpdateDescriptor(String.valueOf(RegistrosActivos()), String.valueOf(RegistrosInactivos()), new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
        }

    }

    /**
     * Metodo ObtenerCantidadUsuarios Funcion: Este metodo permite obtener la
     * cantidad de usurioas registrados en el archivo secuencial
     */
    public int ObtenerCantidadUsuarios() {
        int registros = 0;
        try {
            RandomAccessFile contador = new RandomAccessFile(masterfileUsuario, "r");
            String linea;
            while ((linea = contador.readLine()) != null) {
                if (!linea.contains("/0")) {
                    registros++;
                }
            }
            contador.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    /**
     * Metodo InsertarArchivo
     *
     * @param llave Funcion: Este metodo permite leer el archivo de usuarios y
     * buscar el usuarios deseado segun su llave
     */
    public String Buscar(String llave) {
        Usuario usuarioBuscado;
        String resultado = "";
        try {
            ArchivoUsuario = new RandomAccessFile(masterfileUsuario, "r");
            String inputLine;
            while ((inputLine = ArchivoUsuario.readLine()) != null) {
                usuario = inputLine.split("\\|");
                if (usuario[0].trim().equals(llave.trim())) {
                    usuarioBuscado = new Usuario();
                    usuarioBuscado.CreatefromString(inputLine);
                    resultado = usuarioBuscado.ToString();
                    return resultado;
                }

            }
            ArchivoUsuario.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el usuario deseado");
        }
        return resultado;
    }

    /**
     * Metodo Modificar
     *
     * @param FechaNacimiento
     * @param Telefono
     * @param correoAlterno
     * @param password
     * @param rutaFoto
     * @param status Funcion: Este metodo permite modificar el archivo
     * secuencial, dependiendo los atributos que el usuarios indique o el cambio
     * de informacion que desee
     */
    public void Modificar(String nuevo, String Antiguo) throws FileNotFoundException, IOException {
        List<String> busqueda = bitacora.Busqueda(Antiguo.split("\\|")[0]);
        if (busqueda.isEmpty()) {
            int position = PosicionRegistro(Antiguo);
            ArchivoUsuario = new RandomAccessFile(masterfileUsuario, "rw");
            for (int i = -1; i < position; i++) {
                ArchivoUsuario.readLine();
            }
            long rewrite = ArchivoUsuario.getFilePointer();
            ArchivoUsuario.seek(rewrite);
            ArchivoUsuario.writeBytes(nuevo);
            ArchivoUsuario.close();
            flag = true;
            UpdateDescriptor(String.valueOf(RegistrosActivos()), String.valueOf(RegistrosInactivos()), new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
        } else {
            bitacora.UpdateRegister(Antiguo, nuevo);
            flag = false;
        }

    }

    private int PosicionRegistro(String registro) {
        int posicion = -1;
        try {
            RandomAccessFile contador = new RandomAccessFile(masterfileUsuario, "r");

            String line;
            while ((line = contador.readLine()) != null) {
                if (line.equals(registro)) {
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

    public void CrearDescriptor(String Autor, int Maxregistros) {
        this.usuario_ = Autor;
        StringBuilder atributos = new StringBuilder();
        atributos.append("Nombre_simbolico:" + masterfileUsuario.getPath());
        atributos.append(System.lineSeparator());
        atributos.append("fecha_creacion:" + new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
        atributos.append(System.lineSeparator());
        atributos.append("usuario_creacion:" + rightpad(Autor, 20));
        atributos.append(System.lineSeparator());
        atributos.append("fecha_modificacion:" + new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
        atributos.append(System.lineSeparator());
        atributos.append("usuario_modificacion:" + rightpad(Autor, 20));
        atributos.append(System.lineSeparator());
        atributos.append("#_registros:" + rightpad("0", 6));
        atributos.append(System.lineSeparator());
        atributos.append("Registros Activos:" + rightpad("0", 6));
        atributos.append(System.lineSeparator());
        atributos.append("Registros Inactivos:" + rightpad("0", 6));
        atributos.append(System.lineSeparator());
        atributos.append("Registros Máximos:" + rightpad(String.valueOf(Maxregistros), 6));
        try {
            ArchivoUsuario = new RandomAccessFile(descriptorUsuario, "rw");
            ArchivoUsuario.writeBytes(atributos.toString());
            ArchivoUsuario.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    private int RegistrosActivos() throws FileNotFoundException, IOException {
        ArchivoUsuario = new RandomAccessFile(masterfileUsuario, "r");
        String linea;
        int records = 0;
        while ((linea = ArchivoUsuario.readLine()) != null) {
            String[] check = linea.split("\\|");

            if (check[check.length - 1].contains("1") && !check[check.length - 1].contains("/0")) {
                records++;
            }
        }
        ArchivoUsuario.close();

        return records;
    }

    private int RegistrosInactivos() throws FileNotFoundException, IOException {
        ArchivoUsuario = new RandomAccessFile(masterfileUsuario, "r");
        int registers = 0;
        String linea;
        while ((linea = ArchivoUsuario.readLine()) != null) {
            String[] check = linea.split("\\|");
            if (check[check.length - 1].contains("0") && !check[check.length - 1].contains("/0")) {
                registers++;
            }
        }
        ArchivoUsuario.close();
        return registers;
    }

    private void UpdateDescriptor(String registrosA, String registrosI, String fechamod) throws FileNotFoundException, IOException {
        ArchivoUsuario = new RandomAccessFile(descriptorUsuario, "rw");
        String linea;
        while ((linea = ArchivoUsuario.readLine()) != null) {
            if (linea.contains("usuario_creacion:")) {
                long mod = ArchivoUsuario.getFilePointer();
                ArchivoUsuario.seek(mod);
                String newsvalue = "fecha_modificacion:" + fechamod;
                ArchivoUsuario.writeBytes(newsvalue);
            }
        }
        linea = null;
        ArchivoUsuario.close();
        ArchivoUsuario = null;
        ArchivoUsuario = new RandomAccessFile(descriptorUsuario, "rw");
        while ((linea = ArchivoUsuario.readLine()) != null) {
            if (linea.contains("usuario_modificacion")) {
                long aregis = ArchivoUsuario.getFilePointer();
                ArchivoUsuario.seek(aregis);
                String replace = "#_registros:" + rightpad(String.valueOf(ObtenerCantidadUsuarios()), 6);
                ArchivoUsuario.writeBytes(replace);
            }
        }
        linea = null;
        ArchivoUsuario.close();
        ArchivoUsuario = null;
        ArchivoUsuario = new RandomAccessFile(descriptorUsuario, "rw");
        while ((linea = ArchivoUsuario.readLine()) != null) {
            if (linea.contains("#_registros")) {
                long iregs = ArchivoUsuario.getFilePointer();
                ArchivoUsuario.seek(iregs);
                String newvalue = "Registros Activos:" + rightpad(registrosA, 6);
                ArchivoUsuario.writeBytes(newvalue);
            }
        }
        linea = null;
        ArchivoUsuario.close();
        ArchivoUsuario = null;
        ArchivoUsuario = new RandomAccessFile(descriptorUsuario, "rw");
        while ((linea = ArchivoUsuario.readLine()) != null) {
            if (linea.contains("Registros Activos")) {
                long iregs = ArchivoUsuario.getFilePointer();
                ArchivoUsuario.seek(iregs);
                String newvalue = "Registros Inactivos:" + rightpad(registrosI, 6);
                ArchivoUsuario.writeBytes(newvalue);
            }
        }
        ArchivoUsuario.close();

    }

    public void updateAutor(String autor) throws FileNotFoundException, IOException {
        ArchivoUsuario = new RandomAccessFile(descriptorUsuario, "rw");
        String linea;
        long bytestosave = 0;
        while ((linea = ArchivoUsuario.readLine()) != null) {

            if (linea.contains("fecha_creacion")) {
                bytestosave = ArchivoUsuario.getFilePointer();
                ArchivoUsuario.seek(bytestosave);
                String newvalue = "usuario_creacion:" + rightpad(autor, 20);
                ArchivoUsuario.writeBytes(newvalue);
                ArchivoUsuario.close();
                return;
            }

        }

    }

    public void updateAutorMod(String autor) throws FileNotFoundException, IOException {
        ArchivoUsuario = new RandomAccessFile(descriptorUsuario, "rw");
        String linea;
        long bytestosave = 0;
        while ((linea = ArchivoUsuario.readLine()) != null) {

            if (linea.contains("fecha_modificacion")) {
                bytestosave = ArchivoUsuario.getFilePointer();
                ArchivoUsuario.seek(bytestosave);
                String newvalue = "usuario_modificacion:" + rightpad(autor, 20);
                ArchivoUsuario.writeBytes(newvalue);
                ArchivoUsuario.close();
                return;
            }

        }

    }
}
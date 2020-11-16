package proyectomeia.Clases;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ApiloFile {

    protected RandomAccessFile Archivo;
    protected File descriptor;
    public File masterfile;
    private int registros;
    public int maxregistros;
    protected String[] llave;
    protected String[] atributos;

    /**
     * Constructor del archivo Apilo
     *
     * @param Masterfile ruta del archivo
     * @param descripcion descripción de función de archivo
     * @param tipoFile tipo de archivo
     * @param Autor Autor del archivo
     * @param Maxregistros Máx registros para reorganizar
     * @param llave parametro para hacer búsquedas en el archivo
     * @param Atributos Atributos que contendrá el archivo en formato
     * "atributo|atributo|etc...."
     */
    public ApiloFile(String Masterfile, String descripcion, String tipoFile, String Autor, int Maxregistros, String[] llave, String Atributos) {
        this.masterfile = new File(Masterfile);
        this.descriptor = new File(this.masterfile.getParent() + "/" + "desc_" + this.masterfile.getName().replaceAll(".txt", "") + ".txt");
        this.llave = llave;
        atributos = Atributos.split("\\|");
        if (!descriptor.exists()) {
            CrearDescriptor(descripcion, tipoFile, Autor, Maxregistros);
        }
        registros = 0;
        maxregistros = Maxregistros;
    }

    public void Insertar(String value) {
        try {
            Archivo = new RandomAccessFile(masterfile, "rw");
            long size = Archivo.length();
            Archivo.seek(size);
            Archivo.writeBytes(value);
            Archivo.writeBytes(System.lineSeparator());
            Archivo.close();
            //Falta actualización del descriptor
            UpdateDescriptor(String.valueOf(RegistrosActivos()), String.valueOf(RegistrosInactivos()), new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getNoRegistros() {
        registros = 0;
        try {
            Archivo = new RandomAccessFile(masterfile, "r");
            String linea;
            while ((linea = Archivo.readLine()) != null) {
                if (!linea.contains("/0")) {
                    registros++;
                }
            }
            Archivo.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public List<String> Busqueda(String value) {
        List<String> found = new ArrayList<>();
        try {
            Archivo = new RandomAccessFile(masterfile, "r");
            String line;
            int busqueda = 0;
            for (int j = 0; j < atributos.length; j++) {
                if (llave[0].equals(atributos[j])) {
                    busqueda = j;
                }
            }
            while ((line = Archivo.readLine()) != null) {
                String compare = line.split("\\|")[busqueda];
                if (compare.trim().equals(value.trim())) {
                    found.add(line);
                }
            }
            Archivo.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return found;
    }

    /**
     * Crea el archivo descriptor de este archivo
     *
     * @param descripcion descripcion del archivo
     * @param tipoFile tipo de archivo
     * @param Autor Autor del archivo
     * @param Maxregistros máximo de registros para reorganizar en un archivo
     * secuencial
     */
    private void CrearDescriptor(String descripcion, String tipoFile, String Autor, int Maxregistros) {
        StringBuilder atributos = new StringBuilder();
        atributos.append("Archivo:" + masterfile.getPath());
        atributos.append(System.lineSeparator());
        atributos.append("Descripción:" + descripcion);
        atributos.append(System.lineSeparator());
        atributos.append("Tipo:" + tipoFile);
        atributos.append(System.lineSeparator());
        atributos.append("Organización:" + "Apilo");
        atributos.append(System.lineSeparator());
        atributos.append("Autor:" + rightpad(Autor, 20));
        atributos.append(System.lineSeparator());
        atributos.append("Creado:" + new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
        atributos.append(System.lineSeparator());
        atributos.append("Modificado:" + new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
        atributos.append(System.lineSeparator());
        atributos.append("Separador de Campos:" + "|");
        atributos.append(System.lineSeparator());
        atributos.append("Registros Activos:" + rightpad("0", 6));
        atributos.append(System.lineSeparator());
        atributos.append("Registros Inactivos:" + rightpad("0", 6));
        atributos.append(System.lineSeparator());
        atributos.append("Registros Máximos:" + rightpad(String.valueOf(Maxregistros), 6));
        try {
            Archivo = new RandomAccessFile(descriptor, "rw");
            Archivo.writeBytes(atributos.toString());
            Archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Actualiza un registro del archivo através de la eliminación lógica del
     * registro anterior
     *
     * @param anterior registro a eliminar
     * @param nuevo registro que se inserta en reemplazo
     * @throws IOException
     */
    public void UpdateRegister(String anterior, String nuevo) throws IOException {
        EliminacionLogica(anterior);
        Insertar(nuevo);
        UpdateDescriptor(String.valueOf(RegistrosActivos()), String.valueOf(RegistrosInactivos()), new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
    }

    protected int PosicionRegistro(String registro) {
        int posicion = -1;
        try {
            Archivo = new RandomAccessFile(masterfile, "r");

            String line;
            while ((line = Archivo.readLine()) != null) {
                if (line.equals(registro)) {
                    return posicion;
                }
                posicion++;
            }
            Archivo.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiloFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return posicion;
    }

    protected void EliminacionLogica(String registro) throws FileNotFoundException, IOException {
        int position = PosicionRegistro(registro);
        Archivo = new RandomAccessFile(masterfile, "rw");
        for (int i = -1; i < position; i++) {
            Archivo.readLine();
        }
        long rewriting = Archivo.getFilePointer();
        Archivo.seek(rewriting);
        String registroEliminado = registro.substring(0, registro.length() - 2) + "/0";
        Archivo.writeBytes(registroEliminado);
        Archivo.close();
        UpdateDescriptor(String.valueOf(RegistrosActivos()), String.valueOf(RegistrosInactivos()), new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
    }

    protected int RegistrosActivos() throws FileNotFoundException, IOException {
        Archivo = new RandomAccessFile(masterfile, "r");
        String linea;
        int records = 0;
        while ((linea = Archivo.readLine()) != null) {
            String[] check = linea.split("\\|");

            if (check[check.length - 1].contains("1") && !check[check.length - 1].contains("/0")) {
                records++;
            }
        }
        Archivo.close();

        return records;
    }

    protected int RegistrosInactivos() throws FileNotFoundException, IOException {
        Archivo = new RandomAccessFile(masterfile, "r");
        int registers = 0;
        String linea;
        while ((linea = Archivo.readLine()) != null) {
            String[] check = linea.split("\\|");
            if (check[check.length - 1].contains("0") && !check[check.length - 1].contains("/0")) {
                registers++;
            }
        }
        Archivo.close();
        return registers;
    }

    public void updateAutor(String autor) throws FileNotFoundException, IOException {
        Archivo = new RandomAccessFile(descriptor, "rw");
        String linea;
        long bytestosave = 0;
        while ((linea = Archivo.readLine()) != null) {

            if (linea.contains("Organización")) {
                bytestosave = Archivo.getFilePointer();
                Archivo.seek(bytestosave);
                String newvalue = "Autor:" + rightpad(autor, 20);
                Archivo.writeBytes(newvalue);
                Archivo.close();
                return;
            }
        }
    }

    protected void UpdateDescriptor(String registrosA, String registrosI, String fechamod) throws FileNotFoundException, IOException {
        Archivo = new RandomAccessFile(descriptor, "rw");
        String linea;
        while ((linea = Archivo.readLine()) != null) {
            if (linea.contains("Creado")) {
                long mod = Archivo.getFilePointer();
                Archivo.seek(mod);
                String newsvalue = "Modificado:" + fechamod;
                Archivo.writeBytes(newsvalue);
            }
        }
        linea = null;
        Archivo.close();
        Archivo = null;
        Archivo = new RandomAccessFile(descriptor, "rw");
        while ((linea = Archivo.readLine()) != null) {
            if (linea.contains("Separador de Campos")) {
                long aregis = Archivo.getFilePointer();
                Archivo.seek(aregis);
                String replace = "Registros Activos:" + rightpad(registrosA, 6);
                Archivo.writeBytes(replace);
            }
        }
        linea = null;
        Archivo.close();
        Archivo = null;
        Archivo = new RandomAccessFile(descriptor, "rw");
        while ((linea = Archivo.readLine()) != null) {
            if (linea.contains("Registros Activos")) {
                long iregs = Archivo.getFilePointer();
                Archivo.seek(iregs);
                String newvalue = "Registros Inactivos:" + rightpad(registrosI, 6);
                Archivo.writeBytes(newvalue);
            }
        }

    }

    public void Reorganizar() throws FileNotFoundException, IOException {
        Archivo = new RandomAccessFile(masterfile, "r");
        Queue<String> refactor = new LinkedList<>();
        String keepath = masterfile.getPath();
        String linea;
        while ((linea = Archivo.readLine()) != null) {
            if (!linea.contains(("/0"))) {
                refactor.add(linea);
            }
        }
        Archivo.close();
        masterfile.delete();
        File tempfile = new File(keepath);
        Archivo = new RandomAccessFile(tempfile, "rw");
        String decoy;
        decoy = refactor.poll();
        while (decoy != null) {
            Archivo.writeBytes(decoy);
            Archivo.writeBytes(System.lineSeparator());
            decoy = refactor.poll();
        }
        Archivo.close();
        masterfile = tempfile;
    }

    public void empty() throws IOException {
        FileChannel.open(Paths.get(masterfile.getPath()), StandardOpenOption.WRITE).truncate(0).close();
        UpdateDescriptor("0", "0", new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
    }

    protected String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    public int ReturnMaxreg() throws FileNotFoundException, IOException {
        String linea;
        int result = 0;
        RandomAccessFile archive = new RandomAccessFile(descriptor, "rw");
        while ((linea = archive.readLine()) != null) {
            if (linea.contains("Registros Inactivos")) {
                long iregs = archive.getFilePointer();
                archive.seek(iregs);
                String score = archive.readLine();
                String temp = "Registros Máximos:";
                score = score.substring(temp.length(), score.length());
                result = Integer.parseInt(score.trim());
            }
        }
        return result;
    }
}
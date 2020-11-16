package proyectomeia.Clases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bitacora_lista extends ApiloFile {

    protected RandomAccessFile File;

    /**
     * Constructor heredado (modificado)
     *
     * @param Masterfile
     * @param descripcion
     * @param tipoFile
     * @param Autor
     * @param Maxregistros
     * @param llave
     * @param Atributos
     */
    public Bitacora_lista(String Masterfile, String descripcion, String tipoFile, String Autor, int Maxregistros, String[] llave, String Atributos) {
        super(Masterfile, descripcion, tipoFile, Autor, Maxregistros, llave, Atributos);

    }

    @Override
    /**
     * Realiza una busqueda de registros según el número de llaves que debe
     * cumplir Parametro: linea completa registro a buscar Retorna, lista con
     * todos los registros, activos o eliminados
     */
    public List<String> Busqueda(String line) {
        List<String> instances = new ArrayList<String>();
        try {

            int[] busquedas = new int[llave.length];
            for (int i = 0; i < busquedas.length; i++) {
                for (int j = 0; j < atributos.length; j++) {
                    if (llave[i].equals(atributos[j])) {
                        busquedas[i] = j;
                    }
                }

            }
            File = new RandomAccessFile(masterfile, "r");
            String linea;
            int counter = 0;
            while ((linea = File.readLine()) != null) {
                for (int k = 0; k < busquedas.length; k++) {
                    String compare = linea.split("\\|")[busquedas[k]];
                    String tocompare = line.split("\\|")[busquedas[k]];
                    if (compare.trim().equals(tocompare.trim())) {
                        counter++;
                    }
                }
                if (counter == llave.length) {
                    instances.add(linea);
                }
                counter = 0;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bitacora_lista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bitacora_lista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instances;
    }

    @Override
    public void Insertar(String value) {
        try {
            File = new RandomAccessFile(super.masterfile, "rw");
            long size = File.length();
            File.seek(size);
            File.writeBytes(value);
            File.writeBytes(System.lineSeparator());
            File.close();
            this.UpdateDescriptor(String.valueOf(RegistrosActivos()), String.valueOf(RegistrosInactivos()), new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
        } catch (IOException ex) {
            Logger.getLogger(Bitacora_lista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void UpdateRegister(String nuevo, String viejo) throws IOException {
        EliminacionLogica(viejo);
        Insertar(nuevo);
        this.UpdateDescriptor(String.valueOf(RegistrosActivos()), String.valueOf(RegistrosInactivos()), new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
    }

    @Override
    protected void EliminacionLogica(String viejo) throws FileNotFoundException, IOException {
        int position = PosicionRegistro(viejo);
        File = new RandomAccessFile(masterfile, "rw");
        for (int i = -1; i < position; i++) {
            File.readLine();
        }
        long rewriting = File.getFilePointer();
        File.seek(rewriting);
        String registroEliminado = viejo.substring(0, viejo.length() - 1) + "0";
        File.writeBytes(registroEliminado);
        File.close();
        this.UpdateDescriptor(String.valueOf(RegistrosActivos()), String.valueOf(RegistrosInactivos()), new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
    }

    @Override
    public void empty() throws IOException {
        FileChannel.open(Paths.get(masterfile.getPath()), StandardOpenOption.WRITE).truncate(0).close();
        this.UpdateDescriptor("0", "0", new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
    }

    @Override
    protected void UpdateDescriptor(String registrosA, String registrosI, String fechamod) throws FileNotFoundException, IOException {
        File = new RandomAccessFile(descriptor, "rw");
        String linea;
        while ((linea = File.readLine()) != null) {
            if (linea.contains("Creado")) {
                long mod = File.getFilePointer();
                File.seek(mod);
                String newsvalue = "Modificado:" + fechamod;
                File.writeBytes(newsvalue);
            }
        }
        linea = null;
        File.close();
        File = null;
        File = new RandomAccessFile(descriptor, "rw");
        while ((linea = File.readLine()) != null) {
            if (linea.contains("Separador de Campos")) {
                long aregis = File.getFilePointer();
                File.seek(aregis);
                String replace = "Registros Activos:" + rightpad(registrosA, 6);
                File.writeBytes(replace);
            }
        }
        linea = null;
        File.close();
        File = null;
        File = new RandomAccessFile(descriptor, "rw");
        while ((linea = File.readLine()) != null) {
            if (linea.contains("Registros Activos")) {
                long iregs = File.getFilePointer();
                File.seek(iregs);
                String newvalue = "Registros Inactivos:" + rightpad(registrosI, 6);
                File.writeBytes(newvalue);
            }
        }
    }

    @Override
    /**
     * Se vuelve despreciable, se realizadesde UpdateDescriptor
     */
    public void updateAutor(String autor) {
        //nothing
    }

    @Override
    public void Reorganizar() throws FileNotFoundException, IOException {
        Archivo = new RandomAccessFile(masterfile, "r");
        Queue<String> refactor = new LinkedList<>();
        //String keepath = masterfile.getPath();
        String linea;
        while ((linea = Archivo.readLine()) != null) {
            if (!linea.split("\\|")[linea.split("\\|").length - 1].equals("0")) {
                refactor.add(linea);
            }
        }
        Archivo.close();
        FileChannel.open(Paths.get(masterfile.getPath()), StandardOpenOption.WRITE).truncate(0).close();
        Archivo = new RandomAccessFile(masterfile, "rw");
        String decoy;
        decoy = refactor.poll();
        while (decoy != null) {
            Archivo.writeBytes(decoy);
            Archivo.writeBytes(System.lineSeparator());
            decoy = refactor.poll();
        }
        Archivo.close();
    }

    @Override
    public int getNoRegistros() {
        int registros = 0;
        try {
            Archivo = new RandomAccessFile(masterfile, "r");
            String linea;
            while ((linea = Archivo.readLine()) != null) {
                if (!linea.split("\\|")[linea.split("\\|").length - 1].contains("0")) {
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
}
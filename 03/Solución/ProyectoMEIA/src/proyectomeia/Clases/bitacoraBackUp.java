package proyectomeia.Clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bitacoraBackUp {

    private RandomAccessFile Archivo;
    private File descriptor;
    public File masterfile;

    public bitacoraBackUp(String masterpath, String Autor) {
        this.masterfile = new File(masterpath);
        this.descriptor = new File(this.masterfile.getParent() + "/" + "desc_" + this.masterfile.getName().replaceAll(".txt", "") + ".txt");
        if (!descriptor.exists()) {
            CrearDescriptor(Autor);
        }
    }

    private void CrearDescriptor(String Autor) {
        StringBuilder atributos = new StringBuilder();
        atributos.append("nombre_simbólico:" + masterfile.getPath());
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

    private void UpdateDescriptor(String Autor) throws IOException {
        Archivo = new RandomAccessFile(descriptor, "rw");
        String linea;
        while ((linea = Archivo.readLine()) != null) {
            if (linea.contains("usuario_creacion")) {
                long mod = Archivo.getFilePointer();
                Archivo.seek(mod);
                String newsvalue = "fecha_modificacion:" + new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime());
                Archivo.writeBytes(newsvalue);
            }
        }
        linea = null;
        Archivo.close();
        Archivo = null;
        Archivo = new RandomAccessFile(descriptor, "rw");
        while ((linea = Archivo.readLine()) != null) {
            if (linea.contains("fecha_modificacion")) {
                long aregis = Archivo.getFilePointer();
                Archivo.seek(aregis);
                String replace = "usuario_modificacion:" + rightpad(Autor, 20);
                Archivo.writeBytes(replace);
            }
        }
        linea = null;
        Archivo.close();
        Archivo = null;
        Archivo = new RandomAccessFile(descriptor, "rw");
        while ((linea = Archivo.readLine()) != null) {
            if (linea.contains("usuario_modificacion")) {
                long iregs = Archivo.getFilePointer();
                Archivo.seek(iregs);
                String newvalue = "#_registros:" + rightpad(String.valueOf(Countregisters()), 6);
                Archivo.writeBytes(newvalue);
            }
        }
        Archivo.close();
    }

    private String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    private int Countregisters() throws FileNotFoundException, IOException {
        int count = 0;
        RandomAccessFile counter = new RandomAccessFile(masterfile, "r");
        String linea;
        while ((linea = counter.readLine()) != null) {
            count++;
        }

        return count;
    }

    public void Insertar(String rutabs, String Autor) throws FileNotFoundException, IOException {
        StringBuilder str = new StringBuilder();
        str.append(rightpad(rutabs, 200));
        str.append("|");
        str.append(rightpad(Autor, 20));
        str.append("|");
        str.append(new SimpleDateFormat("yyyyMMdd.HH:mm").format(Calendar.getInstance().getTime()));
        Archivo = new RandomAccessFile(masterfile, "rw");
        long size = Archivo.length();
        Archivo.seek(size);
        Archivo.writeBytes(str.toString());
        Archivo.writeBytes(System.lineSeparator());
        Archivo.close();
        UpdateDescriptor(Autor);
    }
}
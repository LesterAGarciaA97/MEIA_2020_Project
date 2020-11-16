package proyectomeia.Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Singleton {

    public static final String pathArchivoApilo = Paths.get("C:/MEIA/bitacora_usuarios.txt").toString();
    public static final String pathArchivoUsuarios = Paths.get("C:/MEIA/usuarios.txt").toString();
    public static final String pathArchivoListas = Paths.get("C:/MEIA/lista.txt").toString();
    public static final String pathBlistas = Paths.get("C:/MEIA/bitacora_listas.txt").toString();
    public static final String pathIndice = Paths.get("C:/MEIA/Indice.txt").toString();
    public static final String pathdesInd = Paths.get("C:/MEIA/desc_Indice.txt").toString();
    public static final String pathdesLU = Paths.get("C:/MEIA/desc_Lista_usuario.txt").toString();
    public static final String pathListasUsuario = Paths.get("C:/MEIA/Lista_usuario.txt").toString();
    public static final String pathCorreos = Paths.get("C:/MEIA/correos.txt").toString();
    public static final String pathDescCorreos = Paths.get("C:/MEIA/desc_correos.txt").toString();

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    public Usuario current;
    public SequentialFile Usuarios;
    private ApiloFile bitacora;
    private Bitacora_lista Blista;
    public lista Listas;
    public SecuencialIndexado ListaUsuarios;
    public Binario arbol;

    public Singleton() {
        try {
            arbol = new Binario(pathCorreos, pathDescCorreos);
        } catch (IOException ex) {
            Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        current = new Usuario();
        bitacora = new ApiloFile(pathArchivoApilo, "Bitácora de Usuarios", "Archivo de datos", "", 5, new String[]{"Usuario"}, "Usuario|Nombre|Apellido|password|Rol"
                + "|Fecha_Nacimiento|Correo_alterno|Telefono|path_fotografia|Status");
        Usuarios = new SequentialFile(pathArchivoUsuarios, bitacora);
        if (!Usuarios.descriptorUsuario.exists()) {
            Usuarios.CrearDescriptor("", 5);
        }
        Blista = new Bitacora_lista(pathBlistas, "Bitácora Listas", "Archivo de datos", "", 5, new String[]{"Nombre_lista", "Usuario"}, "Nombre_lista|Usuario|Descripción|Número_Usuarios|"
                + "Fecha_creacion|Estatus");
        Listas = new lista(pathArchivoListas, Blista);
        if (!Listas.descriptorLista.exists()) {
            try {
                Listas.CrearDescriptor("", Listas.bitacora.ReturnMaxreg());
            } catch (IOException ex) {
                Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ListaUsuarios = new SecuencialIndexado(pathdesInd, pathIndice, pathdesLU, pathListasUsuario);
    }

    public boolean ExistsUser(String object) {
        File temp1 = new File(pathArchivoApilo);
        File temp2 = new File(pathArchivoUsuarios);
        boolean exists = false;
        if (!temp1.exists() && !temp2.exists()) {
            exists = false;
        } else if (temp1.exists()) {
            List<String> exist = Usuarios.bitacora.Busqueda(object);
            if (!exist.isEmpty()) {
                String line = "";
                for (int i = 0; i < exist.size(); i++) {
                    line = exist.get(i);
                    if (!line.contains("/0") && !line.split("\\|")[line.split("\\|").length - 1].contains("0")) {
                        line = line;
                    } else {
                        line = "";
                    }
                }
                if (line.equals("")) {
                    exists = false;
                } else {
                    exists = true;
                }
            } else if (!temp2.exists()) {
                exists = false;
            } else {

                String busqueda = Usuarios.Buscar(object);
                if (!busqueda.isEmpty() || !busqueda.equals("")) {
                    if (!busqueda.split("\\|")[busqueda.split("\\|").length - 1].contains("0")) {
                        exists = true;
                    } else {
                        exists = true;
                    }

                } else {
                    exists = false;
                }

            }
        }
        return exists;
    }

    public boolean ExistsLista(String object) {
        File temp1 = new File(pathBlistas);
        File temp2 = new File(pathArchivoListas);
        boolean exists = false;
        if (!temp1.exists() && !temp2.exists()) {
            exists = false;
        } else if (temp1.exists()) {
            List<String> exist = Listas.bitacora.Busqueda(object);
            if (!exist.isEmpty()) {
                int counter = 0;
                for (int i = 0; i < exist.size(); i++) {
                    String r = exist.get(i);
                    if (r.split("\\|")[r.split("\\|").length - 1].equals("0")) {
                        counter++;
                    }
                }
                if (counter == exist.size()) {
                    exists = false;
                } else {
                    exists = true;
                }
            } else if (!temp2.exists()) {
                exists = false;
            } else {
                try {
                    String busqueda = Listas.Buscar(object);
                    if (busqueda.isEmpty() || busqueda.equals("")) {
                        exists = false;
                    } else if (busqueda.split("\\|")[busqueda.split("\\|").length - 1].equals("1")) {
                        exists = true;
                    } else {
                        exists = false;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        return exists;
    }

    public String ExistsList(String object) {
        File temp1 = new File(pathBlistas);
        File temp2 = new File(pathArchivoListas);
        String exists = "";
        if (!temp1.exists() && !temp2.exists()) {
            return exists;
        } else if (temp1.exists()) {
            List<String> exist = Listas.bitacora.Busqueda(object);
            if (!exist.isEmpty()) {
                int counter = 0;
                for (int i = 0; i < exist.size(); i++) {
                    String r = exist.get(i);
                    if (r.split("\\|")[r.split("\\|").length - 1].equals("0")) {
                        counter++;
                    }
                }
                if (counter == exist.size()) {
                    exists = "";
                } else {
                    for (int j = 0; j < exist.size(); j++) {
                        String r = exist.get(j);
                        if (r.split("\\|")[r.split("\\|").length - 1].equals("1")) {
                            exists = r;
                        }
                    }

                }
            } else if (!temp2.exists()) {
                exists = "";
            } else {
                try {
                    String busqueda = Listas.Buscar(object);
                    if (busqueda.isEmpty() || busqueda.equals("")) {
                        exists = "";
                    } else if (busqueda.split("\\|")[busqueda.split("\\|").length - 1].equals("1")) {
                        exists = busqueda;
                    } else {
                        exists = "";
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        return exists;
    }

    public List<String> getUsers() throws FileNotFoundException, IOException, ParseException {
        List<String> users = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        File bit = new File(pathArchivoApilo);
        File master = new File(pathArchivoUsuarios);
        if (bit.length() == 0) {
            InputStream stream = new FileInputStream(master);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String input;
            String[] fields;
            while ((input = reader.readLine()) != null) {
                fields = input.split("\\|");
                if (fields[fields.length - 1].trim().equals("1")) {
                    temp.add(input);
                }
            }
            reader.close();
            for (int i = 0; i < temp.size(); i++) {
                Usuario fnd = new Usuario();
                fnd.CreatefromString(temp.get(i));
                users.add(fnd.getUsername().trim());
            }
        } else {
            InputStream stream = new FileInputStream(bit);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String input;
            String[] fields;
            while ((input = reader.readLine()) != null) {
                fields = input.split("\\|");
                if (fields[fields.length - 1].trim().equals("1")) {
                    temp.add(input);
                }
            }
            reader.close();
            if (master.length() > 0) {
                InputStream stream1 = new FileInputStream(master);
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(stream1));
                String input1;
                String[] fields1;
                while ((input1 = reader1.readLine()) != null) {
                    fields1 = input1.split("\\|");
                    if (fields1[fields1.length - 1].trim().equals("1")) {
                        temp.add(input1);
                    }
                }
                reader1.close();
            }
            for (int i = 0; i < temp.size(); i++) {
                Usuario fnd = new Usuario();
                fnd.CreatefromString(temp.get(i));
                users.add(fnd.getUsername().trim());
            }
        }

        return users;
    }

    public List<String> Lists(String user) throws FileNotFoundException, IOException {
        List<String> lists = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        File bit = new File(pathBlistas);
        File master = new File(pathArchivoListas);

        if (bit.length() == 0) {
            InputStream stream = new FileInputStream(master);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String input;
            String[] fields;
            while ((input = reader.readLine()) != null) {
                fields = input.split("\\|");
                if (fields[fields.length - 1].trim().equals("1")) {
                    temp.add(input);
                }
            }
            reader.close();

            for (int i = 0; i < temp.size(); i++) {
                ObjectLista lista = new ObjectLista();
                lista.CreateFromString(temp.get(i));
                if (lista.getUsuario().trim().equals(user) && lista.getNumero_usuarios() > 0) {
                    lists.add(lista.getNombre_lista().trim());
                }
            }

        } else {
            InputStream stream = new FileInputStream(bit);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String input;
            String[] fields;
            while ((input = reader.readLine()) != null) {
                fields = input.split("\\|");
                if (fields[fields.length - 1].trim().equals("1")) {
                    temp.add(input);
                }
            }
            reader.close();

            if (master.length() > 0) {
                InputStream stream1 = new FileInputStream(master);
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(stream1));
                String input1;
                String[] fields1;
                while ((input1 = reader1.readLine()) != null) {
                    fields1 = input1.split("\\|");
                    if (fields1[fields1.length - 1].trim().equals("1")) {
                        temp.add(input1);
                    }
                }
                reader1.close();

            }

            for (int i = 0; i < temp.size(); i++) {
                ObjectLista lista = new ObjectLista();
                lista.CreateFromString(temp.get(i));
                if (lista.getUsuario().trim().equals(user) && lista.getNumero_usuarios() > 0) {
                    lists.add(lista.getNombre_lista().trim());
                }
            }

        }
        return lists;
    }
}
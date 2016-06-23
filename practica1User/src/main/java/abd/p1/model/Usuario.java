package abd.p1.model;

import abd.p1.view.AvatarPanel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;

public class Usuario {
    private String nombre;
    //private Date fechanacimiento; Cambiar a fecha de nacimiento
    private Date fechanacimiento;
    private String email;
    private String contrasena;
    private String genero;
    private String opcionSexual;
    private Double latitud;
    private Double longitud;
    private String descripcion;
    private List<Aficion> aficiones;
    private Set<Usuario> amigos;
    
    //private byte[] foto; Es la forma buena
    private ImageIcon foto; //Para pruebas
    
    public Usuario(){
    List<Aficion> aficiones = new ArrayList<>();
        this.aficiones = aficiones;
        Date date = new Date();
        this.setFechacimiento(date);
        this.amigos = new HashSet<>();
    }
    
    
    public Usuario(String nombre, Date fechanacimiento, String email, String contrasena,
            String genero, String opcionsexual, String descripcion, List<Aficion> aficiones, ImageIcon foto, Set<Usuario> amigos){
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.contrasena = contrasena;
        this.genero = genero;
        this.opcionSexual = opcionsexual;
        this.descripcion = descripcion;
        this.aficiones = aficiones;
        this.foto = foto;
        this.amigos = amigos;
    }
    
    public Usuario (ImageIcon foto){
        List<Aficion> aficiones = new ArrayList<>();
        this.aficiones = aficiones;
        AvatarPanel avatar = new AvatarPanel(foto);
        this.setFoto(avatar.getIcon());
        Date date = new Date();
        this.setFechacimiento(date);
        this.amigos = new HashSet<>();
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
     * @return the fechanacimiento
     */
    public Date getFechaNacimiento() {
        return this.fechanacimiento;
    }

    /**
     * @param fechanacimiento the edad to set
     */
    public void setFechacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    
    public String getYears(){
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(this.getFechaNacimiento().getTime());
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);
        int years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        return Integer.toString(years);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the opcionSexual
     */
    public String getOpcionSexual() {
        return opcionSexual;
    }

    /**
     * @param opcionSexual the opcionSexual to set
     */
    public void setOpcionSexual(String opcionSexual) {
        this.opcionSexual = opcionSexual;
    }

    /**
     * @return the latitud
     */
    public Double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public Double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Set<Usuario> getAmigos() {
        if (amigos == null)
                amigos = new HashSet<>();
        return amigos;
	}

    public void setAmigos(Set<Usuario> amigos) {
            this.amigos = amigos;
    }

    /**
     * @return the Aficiones
     */
    public List<Aficion> getAficiones() {
        return aficiones;
    }

    /**
     * @param Aficiones the Aficiones to set
     */
    public void setAficiones(List<Aficion> aficiones) {
        this.aficiones = aficiones;
    }
    
    public void setAficion(Aficion aficion){
        this.aficiones.add(aficion);
    }
    
    public void borrarAficion(Aficion aficion){
        this.aficiones.remove(aficion);
    }

    /**
     * @return the foto
     */
    public ImageIcon getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
    
}

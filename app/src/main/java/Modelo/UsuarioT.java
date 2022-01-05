package Modelo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class UsuarioT {
    @NonNull
    String nombre;
    @PrimaryKey
    @NonNull
    String userName;
    @NonNull
    String contraseña;

    public UsuarioT(@NonNull String nombre, @NonNull String userName, @NonNull String contraseña) {
        this.nombre = nombre;
        this.userName = userName;
        this.contraseña = contraseña;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(@NonNull String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", userName='" + userName + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}

package DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Modelo.UsuarioT;

@Dao
public interface usuarioDAO {

    @Query("SELECT * FROM UsuarioT WHERE userName=:email")
    public UsuarioT usuarioDisponible(String email);

    @Query("SELECT * FROM UsuarioT WHERE userName=:email AND contraseña=:con")
    public UsuarioT usuarioLogin(String email,String con);

    @Insert
    public void insertarUsuario(UsuarioT usuarioT);


    //@Query("SELECT * FROM UsuarioT WHERE userName=:nomUser AND contraseña=:contraseña")
   // public UsuarioT buscarUsuario(String nomUser, String contraseña);

    //Altas

   // @Query("delete from UsuarioT where userName=:user")
    //public void eliminarUsuario(String user);

   // @Query("update UsuarioT set nombre=:nombreN,userName=:nomUser,contraseña=:con where userName=:nomUser")
   // public void modificarUsuario(String nombreN, String nomUser, String con);

}

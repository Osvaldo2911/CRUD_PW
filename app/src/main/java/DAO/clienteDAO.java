package DAO;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Modelo.ClienteT;

@Dao
public interface clienteDAO {

    @Insert
    public void insertarCliente(ClienteT client);

    @Query("SELECT * FROM ClienteT")
    public List<ClienteT> obtenerTodosClientes();

    @Query("SELECT * FROM ClienteT WHERE ClientNo LIKE :clientNo " +
            "OR fName LIKE :fName " +
            "OR lName LIKE :lName " +
            "OR telNo LIKE :telNo " +
            "OR prefType LIKE :prefType " +
            "OR maxRent LIKE :maxRent")
    public List<ClienteT> obtenerPersonalizado(String clientNo, String fName, String lName, String telNo, String prefType, String maxRent);

    @Query("SELECT * FROM ClienteT WHERE clientNo=:clNo")
    public ClienteT clModificar(String clNo);

    @Query("DELETE FROM ClienteT WHERE clientNo=:clNo")
    public void eliminarC (String clNo);

    @Query("UPDATE ClienteT SET fName = :fName , lName = :lName , telNo = :telNo , prefType = :prefType1 , maxRent = :maxRent WHERE clientNo = :clNo")
    public void modificarC (String clNo,String fName, String lName, String telNo, String prefType1, String maxRent);

    /*
    @Query("SELECT * FROM ClienteT WHERE clientNo=:clientNo")
    public ClienteT buscarCliente(String clientNo);

    //Altas


    @Query("delete from ClienteT where ClientNo=:clientNo")
    public void eliminarCliente(String clientNo);

    @Query("update ClienteT set fName=:fName,lName=:lName,telNo=:telNo,prefType=:prefType,maxRent=:maxRent where clientNo=:clientNo")
    public void modificarCliente(String clientNo, String fName, String lName, String telNo, String prefType, String maxRent);

    @Query("SELECT * FROM ClienteT")
    public List<ClienteT> obtenerTodosClientes();

    @Query("Select * from ClienteT where ClientNo LIKE '%' + ClientNo=:clientNo + '%' AND fName LIKE '%' + fName=:fName + '%' AND lName LIKE '%' + lName=:lName+'%' AND telNo LIKE '%'+ telNo=:telNo + '%' AND prefType LIKE '%'+ prefType=:prefType +'%' AND maxRent LIKE '%' + maxRent=:maxRent +'%';")
    public List<ClienteT> obtenerClientePersonalizado(String clientNo, String fName, String lName, String telNo, String prefType, String maxRent);
*/
}


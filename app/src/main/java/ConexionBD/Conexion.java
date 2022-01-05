package ConexionBD;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.crud_tbd.R;

import DAO.clienteDAO;
import DAO.historialDAO;
import DAO.usuarioDAO;
import Modelo.ClienteT;
import Modelo.HistorialT;
import Modelo.UsuarioT;


@Database(entities = {ClienteT.class, UsuarioT.class, HistorialT.class},version =1,exportSchema = false)

public abstract class Conexion extends RoomDatabase {

    public abstract usuarioDAO usuarioDAO();
    public abstract clienteDAO clienteDAO();
    public abstract historialDAO historialDAO();

    private static Conexion INSTANCE;

    private static RoomDatabase.Callback CALLBACK = null;

    public static Conexion gettAppDatabase(Context context){
        if(INSTANCE==null) {


            CALLBACK = new RoomDatabase.Callback() {
                @Override
                public void onCreate(SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    // -----------------------------------------

                    // Transaccion
                    db.execSQL("BEGIN TRANSACTION");

                    // Creacion de usuario
                    db.execSQL("INSERT INTO UsuarioT VALUES('admin','admin@.com','123')");

                    // Trigger
                    db.execSQL("CREATE TRIGGER IF NOT EXISTS tg_historial_acciones BEFORE DELETE ON ClienteT BEGIN INSERT INTO HistorialT(clientNo) VALUES(old.clientNo); END;");

                    // Confirmar transaccion
                    db.execSQL("COMMIT");

                    // -----------------------------------------

                }
            };
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    Conexion.class,"@Dramhome").addCallback(CALLBACK).build();
        }
     return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE=null;
    }


}


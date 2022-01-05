package Modelo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HistorialT {
    @PrimaryKey
    @NonNull
    String clientNo;

    public HistorialT(@NonNull String clientNo) {
        this.clientNo = clientNo;
    }

    @NonNull
    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(@NonNull String clientNo) {
        this.clientNo = clientNo;
    }
}

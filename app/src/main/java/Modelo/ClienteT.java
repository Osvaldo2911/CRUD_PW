package Modelo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ClienteT {
    @PrimaryKey
    @NonNull
    String clientNo;
    @NonNull
    public String fName;
    @NonNull
    public String lName;
    String telNo;
    @NonNull
    String prefType;
    @NonNull
    String maxRent;

    public ClienteT(@NonNull String clientNo, @NonNull String fName, @NonNull String lName, String telNo, @NonNull String prefType, @NonNull String maxRent) {
        this.clientNo = clientNo;
        this.fName = fName;
        this.lName = lName;
        this.telNo = telNo;
        this.prefType = prefType;
        this.maxRent = maxRent;
    }

    @NonNull
    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(@NonNull String clientNo) {
        this.clientNo = clientNo;
    }

    @NonNull
    public String getfName() {
        return fName;
    }

    public void setfName(@NonNull String fName) {
        this.fName = fName;
    }

    @NonNull
    public String getlName() {
        return lName;
    }

    public void setlName(@NonNull String lName) {
        this.lName = lName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    @NonNull
    public String getPrefType() {
        return prefType;
    }

    public void setPrefType(@NonNull String prefType) {
        this.prefType = prefType;
    }

    @NonNull
    public String getMaxRent() {
        return maxRent;
    }

    public void setMaxRent(@NonNull String maxRent) {
        this.maxRent = maxRent;
    }

    @Override
    public String toString() {
        return "\n\nclientNo= "+clientNo+"  fName= "+fName+"  lName= "+ lName +"\n" +
                "telNo= " + telNo +"  prefType= " + prefType +"  maxRent= " + maxRent;
    }
}

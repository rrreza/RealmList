package ir.giran.realmtest.DB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.Index;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class VG extends RealmObject {

    @SerializedName("idv")
    @Expose
    @PrimaryKey
    @Index
    private int idv;



    @SerializedName("name")
    @Expose
    private String name;


    public void setId(int idv) {
        this.idv = idv;
    }

    public void setName(String name) {
        this.name = name;
    }

}
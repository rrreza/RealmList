package ir.giran.realmtest.DB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class M_P extends RealmObject {
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private int id;

    @SerializedName("project_name")
    @Expose
    private String project_name;

    @SerializedName("vg")
    @Expose
    private RealmList<VG> vg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_name() {
        return project_name;
    }

    public RealmList<VG> getVg() {
        return vg;
    }

    public void setVg(RealmList<VG> vg) {
        this.vg = vg;
    }
}
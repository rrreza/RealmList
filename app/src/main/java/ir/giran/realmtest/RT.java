package ir.giran.realmtest;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * extend application class
 */
public class RT extends Application {

    public static volatile Context co;
    @Override
    public void onCreate() {
        super.onCreate();
        co = getApplicationContext();
        Realm.init(this);
    }

}

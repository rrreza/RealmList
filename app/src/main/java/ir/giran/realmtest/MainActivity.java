package ir.giran.realmtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import ir.giran.realmtest.DB.M_P;
import ir.giran.realmtest.DB.VG;

public class MainActivity extends AppCompatActivity {
Realm realm;
    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm=Realm.getDefaultInstance();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
         editText1=findViewById(R.id.editText);
        final EditText etid=findViewById(R.id.et_id);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number currentMax = realm.where(M_P.class).max("id");
                int nextid = 0;
                if (currentMax != null) {
                    nextid = currentMax.intValue() + 1;
                }
                M_P m_p=new M_P();
                Date date=new Date();
                if(etid.getText().toString().equals("New")){
                m_p.setId(nextid);}
                else {
                    m_p.setId(Integer.valueOf(etid.getText().toString()));
                }

                m_p.setProject_name("R"+date);
                List<VG> vgs=MakeVG();
                //RealmList<VG> vv=new RealmList<>(vgs.toArray(new VG[vgs.size()]));
                //m_p.vg.addAll(vv);
                m_p.setVg(new RealmList<>(vgs.toArray(new VG[vgs.size()])));

                realm.beginTransaction();
                realm.copyToRealmOrUpdate(m_p);
                //realm.insertOrUpdate(m_p);
                realm.commitTransaction();
/*                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/


                RealmResults<M_P> m_ps=realm.where(M_P.class).findAll();
                List<M_P> allprojects=realm.copyFromRealm(m_ps);

                allprojects.size();
            }
        });


        Button b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(MainActivity.this,IntroExampleActivity.class));
            }
        });

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    private List<VG> MakeVG(){
        List<VG> vs=new ArrayList<>();
        for(int i=0;i<10;i++){
            VG v=new VG();
            v.setId(i);
            v.setName(editText1.getText().toString()+i);
            vs.add(v);
        }
        return vs;
    }
}

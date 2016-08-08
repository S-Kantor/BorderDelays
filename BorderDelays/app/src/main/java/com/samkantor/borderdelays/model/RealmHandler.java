package com.samkantor.borderdelays.model;

import android.content.Context;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by SAM on 8/7/2016.
 */
public class RealmHandler  {

    Realm mRealm;
    RealmConfiguration mRealmConfig;

        public RealmHandler(Context context) {
        mRealmConfig = new RealmConfiguration.Builder(context).build();
        mRealm = Realm.getInstance(mRealmConfig);
    }

    public void insertPort (final String portName) {
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
            public void execute(Realm realm) {
                Port port = realm.createObject(Port.class);
                port.setName(portName);
            }
        });
    }

    public ArrayList<Port> getPortList()

    {
        RealmResults<Port> portList= mRealm.where(Port.class).findAll();
        ArrayList<Port> returnPortList = new ArrayList<>();

        for (Port port : portList) {
            returnPortList.add(port);
        }
        return returnPortList;
    }
}

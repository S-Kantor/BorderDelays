package com.samkantor.borderdelays;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by SAM on 25/06/2016.
 */
public class UserPreferences extends ActivityMain{

    private SharedPreferences mSharedPrefences = this.getPreferences(Context.MODE_PRIVATE);
    private SharedPreferences.Editor mEditor = mSharedPrefences.edit();

    public void saveInt(String tag, int toPutIn)  {
        mEditor.putInt(tag, toPutIn);
        mEditor.apply();
    }

    public int getInt(String tag) {
        return mSharedPrefences.getInt(tag, -1);
    }




}

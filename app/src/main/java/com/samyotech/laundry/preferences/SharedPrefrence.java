package com.samyotech.laundry.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.samyotech.laundry.interfaces.Consts;
import com.samyotech.laundry.model.CurrencyDTO;
import com.samyotech.laundry.model.RegisterNewDto;
import com.samyotech.laundry.model.UserDTO;

import java.lang.reflect.Type;

public class SharedPrefrence {
    public static SharedPreferences myPrefs;
    public static SharedPreferences.Editor prefsEditor;

    public static SharedPrefrence myObj;

    private SharedPrefrence() {

    }

    public static SharedPrefrence getInstance(Context ctx) {
        if (myObj == null) {
            myObj = new SharedPrefrence();
            myPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            prefsEditor = myPrefs.edit();
        }
        return myObj;
    }

    public void clearAllPreferences() {
        prefsEditor = myPrefs.edit();
        prefsEditor.clear();
        prefsEditor.commit();
    }

    public void clearPreferences(String key) {
        prefsEditor.remove(key);
        prefsEditor.commit();
    }


    public void setIntValue(String Tag, int value) {
        prefsEditor.putInt(Tag, value);
        prefsEditor.apply();
    }

    public int getIntValue(String Tag) {
        return myPrefs.getInt(Tag, 0);
    }

    public void setLongValue(String Tag, long value) {
        prefsEditor.putLong(Tag, value);
        prefsEditor.apply();
    }

    public long getLongValue(String Tag) {
        return myPrefs.getLong(Tag, 0);
    }


    public void setValue(String Tag, String token) {
        Log.d("LOC_", "setValue: " + token);
        prefsEditor.putString(Tag, token);
        prefsEditor.commit();
    }


    public String getValue(String Tag) {
        Log.d("LOC_", "getValue: " + Tag);
        if (Tag.equalsIgnoreCase(Consts.LATITUDE))
            return myPrefs.getString(Tag, "22.7497853");
        else if (Tag.equalsIgnoreCase(Consts.LONGITUDE))
            return myPrefs.getString(Tag, "75.8989044");
        return myPrefs.getString(Tag, "");
    }

    public boolean getBooleanValue(String Tag) {
        return myPrefs.getBoolean(Tag, false);

    }

    public void setBooleanValue(String Tag, boolean token) {
        prefsEditor.putBoolean(Tag, token);
        prefsEditor.commit();
    }

    public void setParentUserRegister(RegisterNewDto userDTO, String tag) {

        Gson gson = new Gson();
        String hashMapString = gson.toJson(userDTO);

        prefsEditor.putString(tag, hashMapString);
        prefsEditor.apply();
    }
    public RegisterNewDto getParentUserRegister(String tag) {
        String obj = myPrefs.getString(tag, "defValue");
        if (obj.equals("defValue")) {
            return new RegisterNewDto();
        } else {
            Gson gson = new Gson();
            String storedHashMapString = myPrefs.getString(tag, "");
            Type type = new TypeToken<RegisterNewDto>() {
            }.getType();
            RegisterNewDto testHashMap = gson.fromJson(storedHashMapString, type);
            return testHashMap;
        }
    }


    public void setParentUser(UserDTO userDTO, String tag) {

        Gson gson = new Gson();
        String hashMapString = gson.toJson(userDTO);

        prefsEditor.putString(tag, hashMapString);
        prefsEditor.apply();
    }

    public UserDTO getParentUser(String tag) {
        String obj = myPrefs.getString(tag, "defValue");
        if (obj.equals("defValue")) {
            return new UserDTO();
        } else {
            Gson gson = new Gson();
            String storedHashMapString = myPrefs.getString(tag, "");
            Type type = new TypeToken<UserDTO>() {
            }.getType();
            UserDTO testHashMap = gson.fromJson(storedHashMapString, type);
            return testHashMap;
        }
    }


    public void setSubscription(CurrencyDTO currencyDTO, String tag) {

        Gson gson = new Gson();
        String hashMapString = gson.toJson(currencyDTO);

        prefsEditor.putString(tag, hashMapString);
        prefsEditor.apply();
    }

    public CurrencyDTO getCurrency(String tag) {
        String obj = myPrefs.getString(tag, "defValue");
        if (obj.equals("defValue")) {
            return new CurrencyDTO();
        } else {
            Gson gson = new Gson();
            String storedHashMapString = myPrefs.getString(tag, "");
            Type type = new TypeToken<CurrencyDTO>() {
            }.getType();
            CurrencyDTO testHashMap = gson.fromJson(storedHashMapString, type);
            return testHashMap;
        }
    }

    public void setCurrency(String currency) {
        prefsEditor.putString("TAG_CURRENCY", currency);
        prefsEditor.commit();
    }

    public String getCurrency() {
        return myPrefs.getString("TAG_CURRENCY", "Rp");
    }

}

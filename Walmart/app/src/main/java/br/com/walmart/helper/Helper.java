package br.com.walmart.helper;

import android.content.res.Resources;

import java.io.IOException;
import java.io.InputStream;

import br.com.walmart.R;

/**
 * Created by amandalacanna on 1/9/17.
 */

public final class Helper {
    public static final String AUTONOMIA = "AUTONOMIA";
    public static final String VALOR = "VALOR";
    public static final String ORIGIN_POINT = "ORIGIN_POINT";
    public static final String DESTINATION_POINT = "DESTINATION_POINT";
    public static final String MAP = "MAP";

    public static String loadJsonFromRaw(Resources res){
        String json = null;
        try {
            InputStream inputStream = res.openRawResource(R.raw.map);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json= new String(buffer,"UTF-8");
        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}

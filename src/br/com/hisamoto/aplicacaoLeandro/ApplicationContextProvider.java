package br.com.hisamoto.aplicacaoLeandro;

import android.app.Application;
import android.content.Context;

/**
 * @author Leandro Shindi
 * @version 1.0 07/07/15.
 */
public class ApplicationContextProvider extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }

    public static Context getContext() {

        return context;
    }
}

/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2024    HORA: 08-09 HRS
:*
:*  Autor       : Ivanovicx Nuñez Perez         20130785
:*  Fecha       : 06/Marzo/2024
:*  Compilador  : Android Studio Iguana
:*  Descripción : Este activity despliega la imagen de carga de la aplicación y manda al activity
:*                principal después de 2 segundos
:*  Ultima modif:
:*==========================================================================================

:*------------------------------------------------------------------------------------------*/

package mx.itl.nc20130785.u3imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed ( new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent ( SplashActivity.this, MainActivity.class );
                startActivity ( intent );
                finish (); // Cerrar el Splash Activity
            }
        }, 2000);
    }
}
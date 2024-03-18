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
:*  Descripción : Este activity despliega dos campos de texto y dos botones: uno para hacer el cálculo
:*                del IMC y el segundo es para ver el Acerca De
:*  Ultima modif:
:*==========================================================================================

:*------------------------------------------------------------------------------------------*/

package mx.itl.nc20130785.u3imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtPeso;
    private EditText edtEstatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar las referencias a los EditText de la UI
        edtPeso = findViewById( R.id.edtPeso );
        edtEstatura = findViewById( R.id.edtEstatura );
    }

    public void btnCalcularClick ( View v ) {

        if ( !edtPeso.getText().toString().equals("") || !edtPeso.getText().toString().equals("") ) {
            float peso = Float.parseFloat( edtPeso.getText().toString() );
            float estatura = Float.parseFloat( edtEstatura.getText().toString() );

            float imc = peso / ( estatura * estatura );

            String condicion = determinarCondicionSalud( imc );

            AlertDialog.Builder builder = new AlertDialog.Builder( this );
            builder.setTitle( this.getString( R.string.siglas_app ) )
                    .setMessage( this.getString( R.string.leyenda_condicion_salud ) + imc +
                            "\n" + this.getString( R.string.leyenda_condicion_salud ) + condicion )
                    .setPositiveButton( this.getString( R.string.btn_aceptar ), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .setNegativeButton(this.getString( R.string.btn_recomendaciones ), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent intent = new Intent( MainActivity.this, RecomendacionesActivity.class );
                            startActivity( intent );
                        }
                    })
                    .setCancelable( false )
                    .create()
                    .show();
        } else {
            Toast.makeText(this, this.getString( R.string.aviso_campos ), Toast.LENGTH_LONG).show();
        }


    }

    public void btnAcercaDeClick ( View v ) {
        // Desplegar un AlertDialog con datos del alumno, logo itl, titulo "Acerca De"
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setView( R.layout.acerca_de )
                .setPositiveButton( this.getString( R.string.btn_aceptar ), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Cerrar
                        dialogInterface.dismiss ();
                    }
                })
                .setCancelable( false )
                .create()
                .show();
    }

    public String determinarCondicionSalud ( float imc ) {

        if ( imc <= 15.0 ) {
            return (String) this.getText( R.string.imc_delgadez_muy_severa );
        } else if ( imc <= 15.9 ) {
            return (String) this.getText( R.string.imc_delgadez_severa );
        } else if ( imc <= 18.4 ) {
            return (String) this.getText( R.string.imc_delgadez );
        } else if ( imc <= 24.9 ) {
            return (String) this.getText( R.string.imc_normal);
        } else if ( imc <= 29.9 ) {
            return (String) this.getText( R.string.imc_sobrepeso );
        } else if ( imc <= 34.9 ) {
            return (String) this.getText( R.string.imc_obesidad_moderada );
        } else if ( imc <= 39.9 ) {
            return (String) this.getText( R.string.imc_obesidad_severa );
        } else {
            return (String) this.getText( R.string.imc_obesidad_muy_severa );
        }
    }

    public void btnPlatoComer ( View v ) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setIcon( R.drawable.imc )
                .setView( R.layout.plato_buen_comer )
                .setPositiveButton( this.getText( R.string.btn_aceptar ), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setCancelable( false )
                .create()
                .show();
    }


}
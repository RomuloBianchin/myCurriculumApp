package com.example.mycurriculumapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

// Para que seja possível trabalhar com os sensores, é necessário implementar a classe SensorEventListener, para
// que seja possível realizar a escuta das interações com os sensores do disposítivo.

public class SensorAcelerometer extends AppCompatActivity implements SensorEventListener {

    //Declarando as variáveis para que possamos trabalhar com o sensor.
    public Sensor sensor;
    public SensorManager sensorManager;
    public Button proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_acelerometer);

        // Alterando os atríbutos, caracteristicas da actionBar que será exibida na MainActivity.
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#880352C5")));

        // Instanciando o objeto do tipo sensorManager, e passando como parâmetro a constante SENSOR_SERVICE.
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // null point exception gerado automáticamente, para evitar crash da aplicação.
        assert sensorManager != null;
        // Passando as caracteristicas do sensorManager para a variável sensor.
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        Button proximo = findViewById(R.id.btnProximo);

        // Método para caso o usuário não ative a tela seguinte com o sensor, e sim com o click no botão próximo.
        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método que irá executar a escuta, ou seja, quando o sensor for ativado, será nesse método que iremos informar qual ação
    // queremos que seja realizada, nesse caso, assim que o sensor for ativado, iremos invocar um novo layout.
    @Override
    public void onSensorChanged(SensorEvent event) {
        float valor = event.values[0];
        // Quanto maior for o valor, será mais forte o balanço do telemóvel, para que o sensor dispare.
        if (valor > 5) {
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            onStop();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    // Informando qual é a taxa de atualização do mesmo, nesse caso, podemos trabalhar com a normal.
    @Override
    protected void onResume() {
        super.onResume();
        if (sensor != null){
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    // Após o sensor ser executado conforme necessitado, iremos liberar o mesmo para evitar o uso desnecessário do sistema, como ex a bateria.
    @Override
    protected void onStop() {
        sensorManager.unregisterListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
        super.onStop();
    }
}

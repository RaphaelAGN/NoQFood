package com.example.android.noqfoodprototype.Activities;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import Adapters.CardapioAdapter;
import Adapters.EstabilishmentItemAdapter;
import Utils.StartSnapHelper;
import com.example.android.noqfoodprototype.GetList;
import com.example.android.noqfoodprototype.R;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CardapioAdapter.ItemClickListener {

    private EstabilishmentItemAdapter adapter;
    private CardapioAdapter adapterCardapio;

    private LinearLayoutManager horizontalLayoutManager;
    private LinearLayoutManager verticalLayout;
    private RecyclerView.SmoothScroller smoothScroller;


    private SensorManager sensorManager;
    private Sensor rotation;
    private SensorEventListener rotationListener;

    private int pos = 0;
    private int maxPos;
    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Actibity que será usada
        setContentView(R.layout.activity_establishments_itens);

        mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        smoothScroller = new LinearSmoothScroller(this) {
            @Override protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
        };

        //Lista de estabelecimentos
        //Set RecyclerView da lista de estabelecimentos
        ArrayList estabelecimentos =  GetList.getEstabelecimentos();
        maxPos = estabelecimentos.size() -1;

        final RecyclerView recyclerView = findViewById(R.id.establishmentsList);
        horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager( horizontalLayoutManager );
        adapter = new EstabilishmentItemAdapter(this, estabelecimentos);
        //Seta o scrolllistener do RecyclerView
        recyclerView.addOnScrollListener(onScrollListener);
        recyclerView.setAdapter(adapter);

        //Set SnapHelper para centralizar os items da lista de estabelecimentos
        SnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView( recyclerView );

        //Seta os itens do cardápio do primeiro estabelecimento da lista
        RecyclerView cardapioRecycler = findViewById(R.id.cardapioList);
        verticalLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        cardapioRecycler.setLayoutManager(verticalLayout);
        setCardapio( 0 );

        //Sensor
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        rotation = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        rotationListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                //Esquerda
                if ( event.values[2] > 0.25f ){
                    if ( pos >= 1 ){
                        pos -= 1;

                        smoothScroller.setTargetPosition( pos );
                        horizontalLayoutManager.startSmoothScroll(smoothScroller);
                    }
                }
                //Direita
                else if( event.values[2] < 0.15f ){
                    if ( pos < maxPos ){
                        pos += 1;

                        smoothScroller.setTargetPosition( pos );
                        horizontalLayoutManager.startSmoothScroll(smoothScroller);
                    }
                }
            }
        };

    }

    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(rotationListener, rotation, sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(rotationListener);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, ("Item clicado: " + adapterCardapio.getItem( position )), Toast.LENGTH_SHORT).show();
    }

    private void setCardapio(int position){
        //Adiciona novamente a recyclerView a lista atualizada
        RecyclerView cardapioRecycler = findViewById(R.id.cardapioList);
        //Adiciona o adapter a nova lista de elementos criada
        adapterCardapio = new CardapioAdapter(this, GetList.getItens( adapter.getItem( position ) ));
        adapterCardapio.setClickListener(this);
        cardapioRecycler.setAdapter(adapterCardapio);
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            //Se só houver um elemento sendo exibido na tela
            if ( (horizontalLayoutManager.getChildCount()) == 1 ){
                //Seta o cardapio para exibir os items dele
                setCardapio( horizontalLayoutManager.findFirstVisibleItemPosition() );
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuLogout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.action_add:
        }
        return true;
    }
}

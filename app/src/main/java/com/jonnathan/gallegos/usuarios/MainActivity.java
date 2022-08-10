package com.jonnathan.gallegos.usuarios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.jonnathan.gallegos.usuarios.Modelo.ModeloUsuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements UsuarioAdapter.ClickedItem{

    Toolbar toolbar;
    RecyclerView recyclerView;

    UsuarioAdapter usersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        usersAdapter = new UsuarioAdapter(this::ClickedUser);
        getAllUsers();
    }
    public void getAllUsers(){

        Call<List<ModeloUsuario>> userlist = ApiUsuario.getUserService().getAllUsers();

        userlist.enqueue(new Callback<List<ModeloUsuario>>() {
            @Override
            public void onResponse(Call<List<ModeloUsuario>> call, Response<List<ModeloUsuario>> response) {

                if(response.isSuccessful()){
                    List<ModeloUsuario> userResponses = response.body();
                    usersAdapter.setData(userResponses);
                    recyclerView.setAdapter(usersAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<ModeloUsuario>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());

            }
        });
    }

    @Override
    public void ClickedUser(ModeloUsuario userResponse) {
        startActivity(new Intent(this,UserDetailsActivity.class).putExtra("data",userResponse));
    }
}
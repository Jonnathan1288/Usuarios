package com.jonnathan.gallegos.usuarios.ApiServiceUser;

import com.jonnathan.gallegos.usuarios.Modelo.ModeloUsuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiUserService {

    @GET("/quotes")
    Call<List<ModeloUsuario>> getAllUsers();

}

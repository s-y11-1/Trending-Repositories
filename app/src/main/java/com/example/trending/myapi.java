package com.example.trending;

import retrofit2.Call;
import java.util.*;
import retrofit2.http.GET;

public interface myapi {

    @GET("posts")
    Call<List<model>> getmodels();
}

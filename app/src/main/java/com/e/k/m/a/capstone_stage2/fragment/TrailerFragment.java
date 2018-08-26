package com.e.k.m.a.capstone_stage2.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.e.k.m.a.capstone_stage2.DetailActivity;
import com.e.k.m.a.capstone_stage2.Models.Movie;
import com.e.k.m.a.capstone_stage2.Models.MoviesResponse;
import com.e.k.m.a.capstone_stage2.Models.Trailer;
import com.e.k.m.a.capstone_stage2.Models.TrailersResponse;
import com.e.k.m.a.capstone_stage2.Network.BaseUrls;
import com.e.k.m.a.capstone_stage2.Network.rest.ApiClient;
import com.e.k.m.a.capstone_stage2.Network.rest.ApiInteface;
import com.e.k.m.a.capstone_stage2.R;
import com.e.k.m.a.capstone_stage2.adapter.MovieAdatpter;
import com.e.k.m.a.capstone_stage2.adapter.TrailerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrailerFragment extends Fragment {


    private static final String TAG = TrailerFragment.class.getSimpleName();
    private final static String API_KEY = "41049e5d4f52d9922464f0055a20caaa";
    public static int MOVIE_ID;
    public static String MOVIE_POSTER;
    private BaseUrls baseUrls;
    private ApiInteface apiService;
    private List<Trailer> trailers = new ArrayList<>();
    private TrailerAdapter trailerAdapter;

    @BindView(R.id.trailer_recycler)
    RecyclerView trailerRecyclerView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view = inflater.inflate(R.layout.fragment_trailer, container, false);
     ButterKnife.bind(this,view);
        baseUrls = new BaseUrls();
        apiService = ApiClient.getClient().create(ApiInteface.class);
        getTrailersMovies(MOVIE_ID);
        return view;
    }

    private void initUi(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        trailerRecyclerView.setLayoutManager(linearLayoutManager);
        trailerAdapter = new TrailerAdapter(getContext(),trailers,MOVIE_POSTER);
        trailerRecyclerView.setAdapter(trailerAdapter);
    }
    public void getTrailersMovies(int id){
        Call<TrailersResponse> call = apiService.getTrailerMovies(id,API_KEY);
        call.enqueue(new Callback<TrailersResponse>() {
            @Override
            public void onResponse(Call<TrailersResponse> call, Response<TrailersResponse> response) {
                trailers = response.body().getResults();
                initUi();
                Toasty.success(getActivity(), "Similar Movies Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TrailersResponse> call, Throwable t) {
                Toasty.error(getActivity(), "Similar Movies Failed", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "" + t.getMessage());
            }
            });
    }
}

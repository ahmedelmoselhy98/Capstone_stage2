package com.e.k.m.a.capstone_stage2.Network;

public class BaseUrls {
    private String BASE_URL = "http://api.themoviedb.org/3/";
    private String IMAGE_BASE_URL ="http://image.tmdb.org/t/p/w185/";
    private String VIDEO_BASE_URL ="https://www.youtube.com/watch?v=";
    public BaseUrls() {
    }
    public String getBASE_URL(){
            return BASE_URL;
    }

    public String getIMAGE_BASE_URL() {
        return IMAGE_BASE_URL;
    }

    public String getVIDEO_BASE_URL() {
        return VIDEO_BASE_URL;
    }
    //    public String getPopularMovies(){
//            return "http://api.themoviedb.org/3/movie/popular?api_key=41049e5d4f52d9922464f0055a20caaa";
//    }
//    public String getTopRateMovies(){
//            return "http://api.themoviedb.org/3/movie/top_rated?api_key=41049e5d4f52d9922464f0055a20caaa";
//    }
//    public String getUpcomingMovies(){
//            return "http://api.themoviedb.org/3/movie/upcoming?api_key=41049e5d4f52d9922464f0055a20caaa";
//    }
//    public String getNowPlayingMovies(){
//            return "http://api.themoviedb.org/3/movie/now_playing?api_key=41049e5d4f52d9922464f0055a20caaa";
//    }
//    public String getSimilarMovies(){
//        return "http://api.themoviedb.org/3/movie/"+id+"/similar?api_key=41049e5d4f52d9922464f0055a20caaa";
//    }
//    public String getRecommendationsMovies(){
//        return "http://api.themoviedb.org/3/movie/"+id+"/recommendations?api_key=41049e5d4f52d9922464f0055a20caaa";
//    }
//    public String getMovieDetail(){
//            return "http://api.themoviedb.org/3/movie/"+id+"?api_key=41049e5d4f52d9922464f0055a20caaa";
//    }

}

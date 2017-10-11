package ml.ananthakumar.androidlabweek7.support;

/**
 * Created by theMachine on 27-08-2017.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("11s1rx")
    Call<List<String>> getBooks();
}
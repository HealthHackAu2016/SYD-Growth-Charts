package growth.garvan.com.au.growth.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import growth.garvan.com.au.growth.commons.Event;
import growth.garvan.com.au.growth.model.Account;
import growth.garvan.com.au.growth.model.DiagnosisMaster;
import growth.garvan.com.au.growth.model.Measurement;
import growth.garvan.com.au.growth.model.UserProfile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamad on 16/10/2016.
 */

public class GrowthService {

    private static GrowthService growthService = new GrowthService();

    private GrowthApi growthApi;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://149.171.26.164:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private GrowthService(){
        growthApi = retrofit.create(GrowthApi.class);
    }

    public static GrowthService getInstance(){
        return growthService;
    }

    public void authenticate(String username, String password) {
        growthApi.authenticate(username, password).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                EventBus.getDefault().post(new Event<Account>(200,response.body()));
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
            }
        });
    }

    public void register(Account account){
        growthApi.registerAccount(account).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {

            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {

            }
        });
    }

    public void updateAccount(Account account){
        growthApi.updateAccount(account).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {

            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {

            }
        });
    }

    public void crateProfile(UserProfile profile){
        growthApi.createProfile(profile).enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {

            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });
    }

    public void getProfiles( int accountId){
        growthApi.getProfiles(accountId).enqueue(new Callback<List<UserProfile>>() {
            @Override
            public void onResponse(Call<List<UserProfile>> call, Response<List<UserProfile>> response) {

            }

            @Override
            public void onFailure(Call<List<UserProfile>> call, Throwable t) {

            }
        });
    }

    public void updateProfile(int accountId, int profileId, UserProfile profile){
        growthApi.updateProfile(accountId,profileId, profile).enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {

            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });
    }

    public void crateMeasurement(int accountId, int profileId, Measurement measurement){
        growthApi.createMeasurement(accountId, profileId, measurement).enqueue(new Callback<Measurement>() {
            @Override
            public void onResponse(Call<Measurement> call, Response<Measurement> response) {

            }

            @Override
            public void onFailure(Call<Measurement> call, Throwable t) {

            }
        });
    }

    public void getMeasurementsByUserProfile(int accountId, int profileId, Measurement measurement){
        growthApi.getMeasurementsByUserProfile(accountId, profileId).enqueue(new Callback<List<Measurement>>() {
            @Override
            public void onResponse(Call<List<Measurement>> call, Response<List<Measurement>> response) {

            }

            @Override
            public void onFailure(Call<List<Measurement>> call, Throwable t) {

            }
        });
    }

    public void getMeasurementsByDiagnosisId(int diagnosisId){
        growthApi.getMeasurementsByDiagnosisId(diagnosisId).enqueue(new Callback<List<Measurement>>() {
            @Override
            public void onResponse(Call<List<Measurement>> call, Response<List<Measurement>> response) {

            }

            @Override
            public void onFailure(Call<List<Measurement>> call, Throwable t) {

            }
        });
    }

    public void getAllDiagnosis(){
        growthApi.getAllDiagnosis().enqueue(new Callback<List<DiagnosisMaster>>() {
            @Override
            public void onResponse(Call<List<DiagnosisMaster>> call, Response<List<DiagnosisMaster>> response) {

            }

            @Override
            public void onFailure(Call<List<DiagnosisMaster>> call, Throwable t) {

            }
        });
    }
    /*
    @PUT(value = "/accounts/{accountId}/userprofiles/{profileId}/measurements/{measurementId}")
    public Call<Measurement> updateMeasurement(@Path("accountId") int accountId,  @Path("profileId") int profileId, @Body UserProfile userProfile);
    * */
}

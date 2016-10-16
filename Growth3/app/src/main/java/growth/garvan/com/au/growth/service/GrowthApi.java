package growth.garvan.com.au.growth.service;

import android.provider.ContactsContract;

import java.util.List;

import growth.garvan.com.au.growth.model.Account;
import growth.garvan.com.au.growth.model.DiagnosisMaster;
import growth.garvan.com.au.growth.model.Measurement;
import growth.garvan.com.au.growth.model.UserProfile;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mohamad on 16/10/2016.
 */

public interface GrowthApi {

    @GET(value = "/accounts/authenticate")
    public Call<Account> authenticate(@Query("username") String username, @Query("password")  String password);
    @POST(value = "/accounts")
    public Call<Account> registerAccount(@Body Account account);
    @PUT(value = "/accounts")
    public Call<Account> updateAccount(@Body Account account);



    @POST(value = "/accounts/{accountId}/userprofiles")
    public Call<UserProfile> createProfile(@Body UserProfile userProfile);

    @GET(value = "/accounts/{accountId}/userprofiles")
    public Call<List<UserProfile>> getProfiles(@Path("accountId") int accountId);

    @PUT(value = "/accounts/{accountId}/userprofiles/{profileId}")
    public Call<UserProfile> updateProfile(@Path("accountId") int accountId, @Path("profileId") int profileId,@Body UserProfile userProfile);




    @POST(value = "/accounts/{accountId}/userprofiles/{profileId}/measurements")
    public Call<Measurement> createMeasurement(@Path("accountId") int accountId, @Path("profileId") int profileId,@Body Measurement userProfile);

    @GET(value = "/accounts/{accountId}/userprofiles/{profileId}/measurements")
    public Call<List<Measurement>> getMeasurementsByUserProfile(@Path("accountId") int accountId,  @Path("profileId") int profileId);

    @GET(value = "/measurements/diagnosisId/{diagnosisId}")
    public Call<List<Measurement>> getMeasurementsByDiagnosisId(@Path("diagnosisId") int diagnosisId);

    @PUT(value = "/accounts/{accountId}/userprofiles/{profileId}/measurements/{measurementId}")
    public Call<Measurement> updateMeasurement(@Path("accountId") int accountId,  @Path("profileId") int profileId, @Body UserProfile userProfile);


    @GET(value = "/diagnosis")
    public Call<List<DiagnosisMaster>> getAllDiagnosis();
}

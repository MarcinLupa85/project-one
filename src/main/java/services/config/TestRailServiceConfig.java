package services.config;

import com.circlekeurope.testrail.client.api.TestRailApi;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import services.interceptors.BasicAuthInterceptor;

public class TestRailServiceConfig {

    private final static String baseUrl = "https://circlekeurope.testrail.io/";

    private static  final OkHttpClient client = new OkHttpClient()
            .newBuilder()
            .addInterceptor(
                    new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                            .setLevel(HttpLoggingInterceptor.Level.BASIC))
            .addInterceptor(
                    new BasicAuthInterceptor(
                            System.getenv("TESTRAIL_USER"),
                            System.getenv("TESTRAIL_PASS")
                    )
            )
            .build();

    public static TestRailApi testRailApi() {
        return new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(
                        JacksonConverterFactory.create(
                                new ObjectMapper().configure(
                                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        )
                )
                .client(client)
                .build()
                .create(TestRailApi.class);
    }
}

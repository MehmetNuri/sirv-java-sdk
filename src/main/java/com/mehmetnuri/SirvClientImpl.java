package com.mehmetnuri;


import com.mehmetnuri.account.AccountClient;
import com.mehmetnuri.account.AccountClientImpl;
import com.mehmetnuri.files.FilesClient;
import com.mehmetnuri.files.FilesClientImpl;
import com.mehmetnuri.model.ApiTokenRequest;
import com.mehmetnuri.model.ApiTokenResponse;
import com.mehmetnuri.statistic.StatisticClient;
import com.mehmetnuri.statistic.StatisticClientImpl;
import com.mehmetnuri.user.UserClient;
import com.mehmetnuri.user.UserClientImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SirvClientImpl implements SirvClient {
    public static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    public static final String AUTHORIZATION_HEADER_VALUE_PREFIX = "Bearer ";
    public static final String CONTENT_TYPE_HEADER_KEY = "content-type";
    public static final String APPLICATION_JSON = "application/json";

    private String host;
    private String loginUrl;

    private String clientId;
    private String clientSecret;

    private AccountClient accountClient;
    private UserClient userClient;
    private StatisticClient statisticClient;
    private FilesClient filesClient;
    private RestClient restClient;
    private ApiTokenResponse token;

    public SirvClientImpl(String clientId, String clientSecret, RestClient restClient) {
        this(clientId, clientSecret, restClient, "https://api.sirv.com");
    }

    public SirvClientImpl(String clientId, String clientSecret, RestClient restClient, String host) {
        this.host = host;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.restClient = restClient;
        initUrls();
    }

    private void initUrls() {
        loginUrl = host + "/v2/token";
    }

    public AccountClient getAccountClient() {
        return accountClient != null ? accountClient : (accountClient = new AccountClientImpl(this, restClient, host));
    }

    @Override
    public UserClient getUserClient() {
        return userClient != null ? userClient : (userClient = new UserClientImpl(this, restClient, host));
    }

    @Override
    public StatisticClient getStatisticClient() {
        return statisticClient != null ? statisticClient : (statisticClient = new StatisticClientImpl(this, restClient, host));
    }

    @Override
    public FilesClient getFilesClient() {
        return filesClient != null ? filesClient : (filesClient = new FilesClientImpl(this, restClient, host));
    }

    public ApiTokenResponse getToken(boolean forceNew) {
        if (forceNew || token == null) {
            ApiTokenRequest request = new ApiTokenRequest(clientId, clientSecret);
            token = restClient.doPost(loginUrl, request, ApiTokenResponse.class, Collections.EMPTY_MAP);
        }
        return token;
    }

    public Map<String, String> getRequestHeaders(boolean forceNew) {
        ApiTokenResponse token = getToken(forceNew);
        Map<String, String> headers = new HashMap<>();

        headers.put(AUTHORIZATION_HEADER_KEY, AUTHORIZATION_HEADER_VALUE_PREFIX + token.getToken());
        headers.put(CONTENT_TYPE_HEADER_KEY, APPLICATION_JSON);

        return headers;
    }

}

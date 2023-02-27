package com.mehmetnuri;


import com.mehmetnuri.account.AccountClient;
import com.mehmetnuri.files.FilesClient;
import com.mehmetnuri.model.ApiTokenResponse;
import com.mehmetnuri.statistic.StatisticClient;
import com.mehmetnuri.user.UserClient;

import java.util.Map;

public interface SirvClient {
    AccountClient getAccountClient();

    UserClient getUserClient();

    StatisticClient getStatisticClient();

    FilesClient getFilesClient();

    ApiTokenResponse getToken(boolean forceNew);

    Map<String, String> getRequestHeaders(boolean forceNew);
}

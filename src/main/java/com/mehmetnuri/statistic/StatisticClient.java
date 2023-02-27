package com.mehmetnuri.statistic;


import com.mehmetnuri.statistic.model.SpinViewItem;
import com.mehmetnuri.statistic.model.StorageStatisticItem;
import com.mehmetnuri.statistic.model.TransferStatisticItem;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public interface StatisticClient {
    Map<String, TransferStatisticItem> getTransferStatistic(ZonedDateTime from, ZonedDateTime to);
    List<SpinViewItem> getSpinViews(ZonedDateTime from, ZonedDateTime to, String alias);
    Map<String, StorageStatisticItem> getStorageStatistic(ZonedDateTime from, ZonedDateTime to);
}

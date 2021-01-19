package com.markus.demo.node;

import io.prometheus.client.Collector;
import io.prometheus.client.CounterMetricFamily;

import java.util.ArrayList;
import java.util.List;

public class UserExports extends Collector {

    private void addUserMetrics(List<MetricFamilySamples> sampleFamilies) {
        sampleFamilies.add(new CounterMetricFamily(
                "user_register_count",
                "The count of user that are register",
                2));
    }

    @Override
    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> mfs = new ArrayList<>();
        addUserMetrics(mfs);
        return mfs;
    }
}
package com.ultimate.globalangles.repository.repos.base;

import com.ultimate.globalangles.repository.server.remote.UltimateApi;

import javax.inject.Inject;

public abstract class BaseRepo {
    @Inject
    protected UltimateApi api;
}

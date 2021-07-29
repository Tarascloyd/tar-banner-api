package com.taras.tarbannerapi.service;

import com.taras.tarbannerapi.entity.Banner;

import java.util.List;

public interface BannerService {

    public List<Banner> findAll();

    public Banner findById(Long theId);

    public Banner save(Banner theBanner);

    public void deleteById(Long theId);

    public List<Banner> searchBy(String theName);
}

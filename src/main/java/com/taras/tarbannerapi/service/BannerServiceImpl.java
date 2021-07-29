package com.taras.tarbannerapi.service;

import com.taras.tarbannerapi.entity.Banner;
import com.taras.tarbannerapi.repository.BannerRepository;

import java.util.List;

public class BannerServiceImpl implements BannerService {

    private BannerRepository bannerRepository;

    public BannerServiceImpl(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @Override
    public List<Banner> findAll() {
        return bannerRepository.findAll();
    }

    @Override
    public Banner findById(Long theId) {
        return bannerRepository.findById(theId)
                .orElseThrow(() -> new RuntimeException("Did not find banner id - " + theId));
    }

    @Override
    public Banner save(Banner theBanner) {
        return bannerRepository.save(theBanner);
    }

    @Override
    public void deleteById(Long theId) {
        bannerRepository.deleteById(theId);
    }

    @Override
    public List<Banner> searchBy(String theName) {
        return bannerRepository.findByNameContainsAllIgnoreCase(theName);
    }
}

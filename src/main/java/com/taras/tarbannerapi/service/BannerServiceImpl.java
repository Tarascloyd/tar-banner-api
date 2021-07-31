package com.taras.tarbannerapi.service;

import com.taras.tarbannerapi.entity.Banner;
import com.taras.tarbannerapi.exceptions.ResourceNotFoundException;
import com.taras.tarbannerapi.repository.BannerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
                .orElseThrow(ResourceNotFoundException::new);
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

package com.taras.tarbannerapi.controller;

import com.taras.tarbannerapi.entity.Banner;
import com.taras.tarbannerapi.entity.Category;
import com.taras.tarbannerapi.service.BannerService;
import com.taras.tarbannerapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/banners")
public class BannerController {
    private BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;

    }



    @GetMapping({"/", ""})
    public @ResponseBody
    Iterable<Banner> getAllBanners() {

        return bannerService.findAll();
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<Banner> getBannersSearchByName(
            @RequestParam("name") String name) {
        if (name.trim().isEmpty()) {
            return bannerService.findAll();
        }
        return bannerService.searchBy(name);
    }

    @GetMapping("/{id}")
    public Banner getBannerById(@PathVariable("id") Long id) {

        return bannerService.findById(id);
    }

    @PostMapping({"/", ""})
    @ResponseStatus(HttpStatus.CREATED)
    public Banner postBanner(@RequestBody final Banner banner) {

        return bannerService.save(banner);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Banner updateBanner(@PathVariable("id") Long id,
                                   @RequestBody final Banner banner) {

        return bannerService.save(banner);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBannerById(@PathVariable("id") Long id) {

        bannerService.deleteById(id);
    }
}

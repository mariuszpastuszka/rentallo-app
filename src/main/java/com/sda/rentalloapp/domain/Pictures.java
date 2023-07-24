package com.sda.rentalloapp.domain;

import lombok.Data;

import java.util.List;

@Data
public class Pictures {
    String mainPictureUrl;
    List<String> picturesUrls;
}

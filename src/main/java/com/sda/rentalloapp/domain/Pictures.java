package com.sda.rentalloapp.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class Pictures {

    String mainPictureUrl;

    @ElementCollection
    List<String> picturesUrls;
}

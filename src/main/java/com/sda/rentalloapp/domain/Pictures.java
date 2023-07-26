package com.sda.rentalloapp.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
public class Pictures {

    String mainPictureUrl;

    @ElementCollection
    List<String> picturesUrls;
}

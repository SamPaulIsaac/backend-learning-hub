package com.innoventes.jukebox.controller.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicianRequestDto {
    private String name;
    private String musicianType;
    private MusicAlbumRequestDto musicAlbumRequestDto;

}

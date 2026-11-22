package org.example.musicmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MusicDto {
    private Long id;
    @NotBlank(message = "Tên bài hát không được để trống!")
    @Size(max = 800, message = "Tên bài hát không được vượt quá 800 ký tự!")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\s]*$", message = "Tên bài hát không được chứa ký tự đặc biệt!")
    private String songTitle;
    @NotBlank(message = "Tên nghệ sĩ thể hiện không được để trống!")
    @Size(max = 300, message = "Tên nghệ sĩ thể hiện không được vượt quá 300 ký tự!")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\s]*$", message = "Tên nghệ sĩ thể hiện không được chứa ký tự đặc biệt!")
    private String performingArtist;
    @NotBlank(message = "Thể loại nhạc không được để trống")
    @Size(max = 1000, message = "Thể loại nhạc không được vượt quá 1000 ký tự!")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\s,]*$", message = "Thể loại nhạc chỉ được chứa chữ, số, khoảng trắng và dấu phẩy!")
    private String musicGenre;
}

package de.telran.springdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(
        name = "rgba_value",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "value_r",
                                "value_g",
                                "value_b",
                                "value_a"
                        })
        })
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class RgbaValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0) @Max(255)
    @NonNull
    @NotNull
    @Column(name = "value_r", nullable = false)
    private Integer r;  //целое число от 0 до 255

    @Min(0) @Max(255)
    @NonNull
    @NotNull
    @Column(name = "value_g", nullable = false)
    private Integer g;  //целое число от 0 до 255

    @Min(0) @Max(255)
    @NonNull
    @NotNull
    @Column(name = "value_b", nullable = false)
    private Integer b;  //целое число от 0 до 255

    @Min(0) @Max(255)
    @NonNull
    @NotNull
    @Column(name = "value_a", nullable = false)
    private Integer a;  //целое число от 0 до 255
}

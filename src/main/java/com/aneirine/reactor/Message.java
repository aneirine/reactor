package com.aneirine.reactor;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Message {

    @Id
    private Long id;
    private String data;
}

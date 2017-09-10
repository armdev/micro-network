package io.project.core.blockmodel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author armdev
 */
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Block {

    private String index;
    private String previousHash;
    private String timestamp;
    private String data;
    private String hash;

    public Block(String data) {
        this.data = data;
    }

// https://medium.com/@lhartikk/a-blockchain-in-200-lines-of-code-963cc1cc0e54
}

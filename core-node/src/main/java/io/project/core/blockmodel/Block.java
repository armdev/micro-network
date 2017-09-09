/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.core.blockmodel;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.codec.digest.DigestUtils;

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

   

    public Block generateNextBlock(String blockData) {
        Block previousBlock = this.getLatestBlock();
        String previousBlockIndex = previousBlock.getIndex();

        String nextIndex = previousBlockIndex + 1;
        Long nextTimestamp = new Date().getTime() / 1000;
        String nextHash = this.calculateHash(nextIndex, previousBlock.getHash(), nextTimestamp.toString(), blockData);

        return new Block(nextIndex, previousBlock.getHash(), nextTimestamp.toString(), blockData, nextHash);
    }

    public Block getLatestBlock() {
        Block block = new Block(data);

        return block;
    }
    
     public String calculateHash(String index, String previousHash, String timestamp, String data) {
        String sha256hex = DigestUtils.sha256Hex(index + previousHash + timestamp + data);
        return sha256hex;
    }

// https://medium.com/@lhartikk/a-blockchain-in-200-lines-of-code-963cc1cc0e54
}

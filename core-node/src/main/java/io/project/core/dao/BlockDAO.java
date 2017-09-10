/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.core.dao;

import io.project.core.blockmodel.Block;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author armdev
 */
public class BlockDAO {

    public Block generateNextBlock(String blockData) {
        Block previousBlock = this.getLatestBlock();
        String previousBlockIndex = previousBlock.getIndex();

        String nextIndex = previousBlockIndex + 1;
        Long nextTimestamp = new Date().getTime() / 1000;
        String nextHash = this.calculateHash(nextIndex, previousBlock.getHash(), nextTimestamp.toString(), blockData);

        return new Block(nextIndex, previousBlock.getHash(), nextTimestamp.toString(), blockData, nextHash);
    }

    public Block getLatestBlock() {
        Block block = new Block(null);

        return block;
    }

    public Block saveBlock(Block block) {

        //create genesis block
        //do some checks
        return block;
    }

    public String calculateHash(String index, String previousHash, String timestamp, String data) {
        String sha256hex = DigestUtils.sha256Hex(index + previousHash + timestamp + data);
        return sha256hex;
    }

}

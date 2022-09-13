package kbg.modu.moduproject.domain;


import lombok.Data;

@Data
public class ProfileImage {
    private int seq;
    private int memberSeq;
    private long fileSize;
    private String originFileName;
    private String storedFilePath;
    private char deletedYN;

}

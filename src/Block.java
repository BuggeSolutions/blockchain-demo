import java.util.Date;

public class Block{
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;

    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash(){
        String hash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data);
        return hash;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }
}
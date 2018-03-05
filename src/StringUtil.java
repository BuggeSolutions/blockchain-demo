import java.security.MessageDigest;

public class StringUtil{
    // Apply sha256 algorithm to a String and returns the result
    public static String applySha256(String input){
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Apply sha256 to input
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            return "";
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}

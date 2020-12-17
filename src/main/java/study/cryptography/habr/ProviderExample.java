package study.cryptography.habr;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class ProviderExample {
    /*
    Provider (Поставщик криптографии)
    Класс Provider (java.security.Provider) является центральным классом в Java crypto API. Для того чтобы использовать
    Java crypto API, вам нужно установить поставщика криптографии. Java SDK поставляется с собственным поставщиком
    криптографии. Если вы явно не установите поставщик криптографии, то будет использоваться поставщик по умолчанию.
    Однако этот поставщик криптографии может не поддерживать алгоритмы шифрования, которые вы хотите использовать.
    Поэтому вам, возможно, придется установить свой собственный поставщик криптографии.
    Один из самых популярных поставщиков криптографии для Java crypto API называется Bouncy Castle. Вот пример,
    где в качестве поставщика криптографии устанавливается BouncyCastleProvider:
    */
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        /*
        Cipher (Шифр)
        Класс Cipher (javax.crypto.Cipher) представляет криптографический алгоритм. Шифр может использоваться как для
        шифрования, так и для расшифровки данных. Класс Cipher объясняется более подробно в следующих разделах,
        ниже будет его краткое описание.
        Создание экземпляра класса шифр, который использует алгоритм шифрования AES для внутреннего использования:
        * */
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        byte[] keyBytes= new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        String algorithm = "RawBytes";
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, algorithm);
        try {
            if (cipher != null) {
                cipher.init(Cipher.ENCRYPT_MODE, keySpec);
                cipher.init(Cipher.DECRYPT_MODE,keySpec);
            }
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        byte[] plainText = "abcdefghijklmnopqrstuvwxyz".getBytes(StandardCharsets.UTF_8);
        byte[] cypherText;
        try {
            if (cipher != null) {
               cypherText = cipher.doFinal(plainText);
            }
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

    }
}

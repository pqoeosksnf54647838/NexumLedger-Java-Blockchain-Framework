package org.crypto;

import java.security.*;
import java.util.Base64;

public class CryptoEd25519 {
    private KeyPair keyPair;

    public void generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("Ed25519");
        keyGen.initialize(256);
        this.keyPair = keyGen.generateKeyPair();
    }

    public String signData(String data) throws SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance("Ed25519");
        signature.initSign(keyPair.getPrivate());
        signature.update(data.getBytes());
        byte[] signedBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signedBytes);
    }

    public boolean verifySignature(String data, String signatureStr) throws SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance("Ed25519");
        signature.initVerify(keyPair.getPublic());
        signature.update(data.getBytes());
        byte[] signatureBytes = Base64.getDecoder().decode(signatureStr);
        return signature.verify(signatureBytes);
    }

    public String getPublicKeyBase64() {
        return Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
    }
}

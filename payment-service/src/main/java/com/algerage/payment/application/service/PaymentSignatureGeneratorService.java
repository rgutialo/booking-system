package com.algerage.payment.application.service;

import com.algerage.payment.application.port.in.PaymentSignatureGeneratorPort;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PaymentSignatureGeneratorService implements PaymentSignatureGeneratorPort {

    @Override
    public String generateSignature() throws Exception{
        // Secret key provided by Redsys
        String secretKey = "sq7HjrUOBfKmC576ILgskD5srU870gJ7";//"sq7HjrUOBfKmC576ILgskD5srU870gJ7";
        String decodedMerchantParams = """
                {
                    "DS_MERCHANT_AMOUNT": "145",
                    "DS_MERCHANT_CURRENCY": "978",
                    "DS_MERCHANT_MERCHANTCODE": "263100000",
                    "DS_MERCHANT_MERCHANTURL": "http://www.prueba.com/urlNotificacion.php",
                    "DS_MERCHANT_ORDER": "1446068581",
                    "DS_MERCHANT_TERMINAL": "51",
                    "DS_MERCHANT_TRANSACTIONTYPE": "0",
                    "DS_MERCHANT_URLKO": "http://www.prueba.com/urlKO.php",
                    "DS_MERCHANT_URLOK": "http://www.prueba.com/urlOK.php"
                }
                """;

        // Base64-decoded Ds_MerchantParameters (your provided parameters)


        // Generate HMAC-SHA256 signature
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        mac.init(secretKeySpec);
        byte[] signatureBytes = mac.doFinal(decodedMerchantParams.getBytes());
        String merchant = createMerchantParameters(decodedMerchantParams);
        String merchantOld = Base64.getEncoder().encodeToString(decodedMerchantParams.getBytes());
        String merchantSignature = createMerchantSignature(secretKey, decodedMerchantParams);
        // Base64-encode the signature
        String signature = Base64.getEncoder().encodeToString(signatureBytes);
        String customSignature = encode(secretKey, "1446068581", merchant, false);
        System.out.println("Generated Ds_MerchantParams (new method): " + merchant);
        System.out.println("Generated Ds_MerchantParams (old method): " + merchantOld);
        System.out.println("Generated Ds_Signature (new method): " + merchantSignature);
        System.out.println("Generated Ds_Signature (new method): " + customSignature);
        System.out.println("Generated Ds_Signature (old method): " + signature);
        return signature;
    }

    public String createMerchantSignature(final String claveComercio, final String decodedMerchantParams)
            throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, IllegalStateException,
            NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        return Utils.encode(claveComercio, "1446068581", createMerchantParameters(decodedMerchantParams));
    }

    public String createMerchantParameters(final String merchantParams) throws UnsupportedEncodingException {
        return Utils.encodeB64String(merchantParams.getBytes("UTF-8"));
    }

    public static String encode(final String claveComercio, final String datos, final String params,
                                final Boolean urlSafe) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] clave = Base64.getDecoder().decode(claveComercio.getBytes("UTF-8"));
        String secretKc = DatatypeConverter.printBase64Binary(clave);
        byte[] secretKo = Utils.encrypt_3DES(secretKc, datos);

        // Se hace el MAC con la clave de la operación "Ko" y se codifica en BASE64
        byte[] hash = Utils.mac256(params, secretKo);
        byte[] res = urlSafe ? Utils.encodeB64UrlSafe(hash) : Utils.encodeB64(hash);
        return new String(res, "UTF-8");
    }
}

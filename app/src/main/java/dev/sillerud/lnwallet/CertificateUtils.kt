package dev.sillerud.lnwallet

import java.io.ByteArrayInputStream
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory


fun parseCertificate(bytes: ByteArray): X509Certificate {
    val certificateFactory = CertificateFactory.getInstance("X.509")
    return certificateFactory.generateCertificate(ByteArrayInputStream(bytes)) as X509Certificate
}

fun trustmanagerFor(certificateBytes: ByteArray): TrustManager {
    val certificate = parseCertificate(certificateBytes)

    val keystore = KeyStore.getInstance("pkcs12")
    keystore.load(null, "changeit".toCharArray())

    keystore.setCertificateEntry("main", certificate)

    //val keyManagerFactory = KeyManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
    //keyManagerFactory.init(keystore, "changeit".toCharArray())

    val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
    trustManagerFactory.init(keystore)

    return trustManagerFactory.trustManagers.first()
}
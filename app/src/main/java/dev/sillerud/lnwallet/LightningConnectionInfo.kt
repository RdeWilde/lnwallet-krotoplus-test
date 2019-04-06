package dev.sillerud.lnwallet

import android.os.Parcel
import android.os.Parcelable

data class LightningConnectionInfo(
    val connectionId: String,
    val host: String,
    val port: Int,
    val macaroon: ByteArray,
    val certificate: ByteArray,
    val network: Network?,
    val name: String?
) : Parcelable {
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(connectionId)
        dest.writeString(host)
        dest.writeInt(port)
        dest.writeInt(macaroon.size)
        dest.writeByteArray(macaroon)
        dest.writeInt(certificate.size)
        dest.writeByteArray(certificate)
        dest.writeString(network?.name)
        dest.writeString(name)
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LightningConnectionInfo> = object : Parcelable.Creator<LightningConnectionInfo> {
            override fun createFromParcel(source: Parcel): LightningConnectionInfo {
                val connectionId = source.readString()!!
                val host = source.readString()!!
                val port = source.readInt()
                val macaroonBytes = ByteArray(source.readInt())
                source.readByteArray(macaroonBytes)
                val certificateBytes = ByteArray(source.readInt())
                source.readByteArray(certificateBytes)
                val network = source.readString()?.let { Network.valueOf(it) }
                val name = source.readString()
                return LightningConnectionInfo(connectionId, host, port, macaroonBytes, certificateBytes, network, name)
            }

            override fun newArray(size: Int): Array<LightningConnectionInfo?> = arrayOfNulls(size)

        }
    }
}
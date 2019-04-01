package dev.sillerud.lnwallet

import android.os.Parcel
import android.os.Parcelable

data class LightningConnectionInfo(
    val host: String,
    val port: Int,
    val macaroon: ByteArray,
    val certificate: ByteArray,
    val name: String?
) : Parcelable {
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(host)
        dest.writeInt(port)
        dest.writeInt(macaroon.size)
        dest.writeByteArray(macaroon)
        dest.writeInt(certificate.size)
        dest.writeByteArray(certificate)
        dest.writeString(name)
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LightningConnectionInfo> = object : Parcelable.Creator<LightningConnectionInfo> {
            override fun createFromParcel(source: Parcel): LightningConnectionInfo {
                val host = source.readString()!!
                val port = source.readInt()
                val macaroonBytes = ByteArray(source.readInt())
                source.readByteArray(macaroonBytes)
                val certificateBytes = ByteArray(source.readInt())
                source.readByteArray(certificateBytes)
                val name = source.readString()
                return LightningConnectionInfo(host, port, macaroonBytes, certificateBytes, name)
            }

            override fun newArray(size: Int): Array<LightningConnectionInfo?> = arrayOfNulls(size)

        }
    }
}
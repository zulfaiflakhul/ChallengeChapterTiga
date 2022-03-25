package zulfa.binar.challengechaptertiga

import android.os.Parcel
import android.os.Parcelable

data class DataUser(val nama : String?, val umur : String?, val alamat : String?, val pekerjaan : String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(umur)
        parcel.writeString(alamat)
        parcel.writeString(pekerjaan)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataUser> {
        override fun createFromParcel(parcel: Parcel): DataUser {
            return DataUser(parcel)
        }

        override fun newArray(size: Int): Array<DataUser?> {
            return arrayOfNulls(size)
        }
    }
}

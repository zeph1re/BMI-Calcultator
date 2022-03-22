package binar.ganda.bmicalculator

import android.os.Parcel
import android.os.Parcelable

data class BMI(val bb: Int, val tb: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(bb)
        parcel.writeInt(tb)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BMI> {
        override fun createFromParcel(parcel: Parcel): BMI {
            return BMI(parcel)
        }

        override fun newArray(size: Int): Array<BMI?> {
            return arrayOfNulls(size)
        }
    }
}

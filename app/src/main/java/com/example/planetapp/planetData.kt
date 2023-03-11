package com.example.planetapp

import android.os.Parcel
import android.os.Parcelable
import android.view.Gravity

data class planetData(
    val id:Int?,
    val title:String?,
    val galaxy: String?,
    val distance: String?,
    val gravity : String?,
    val overview: String?
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(galaxy)
        parcel.writeString(distance)
        parcel.writeString(gravity)
        parcel.writeString(overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<planetData> {
        override fun createFromParcel(parcel: Parcel): planetData {
            return planetData(parcel)
        }

        override fun newArray(size: Int): Array<planetData?> {
            return arrayOfNulls(size)
        }
    }

}

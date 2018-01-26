package com.teng.zhihu.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by teng on 18/1/26.
 */
class Avatar : Parcelable{

    companion object {
        const val ID : String = "id"
        const val TEMPLATE : String = "template"

        var CREATOR : Parcelable.Creator<Avatar>  = object : Parcelable.Creator<Avatar>{
            override fun createFromParcel(parcel: Parcel): Avatar =  Avatar(parcel)
            override fun newArray(size: Int): Array<Avatar?> = arrayOfNulls(size)
        }
    }

    @SerializedName(ID)
    var id : String? = null

    @SerializedName(TEMPLATE)
    var template : String? = null

    constructor()

    constructor(p : Parcel){
        id = p.readString()
        template = p.readString()
    }


    override fun describeContents(): Int = 0

    override fun writeToParcel(p: Parcel?, flags: Int) {
        p!!.writeString(id)
        p!!.writeString(template)
    }

}
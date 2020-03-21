package com.selimbousbih.midiplayer.data

import org.json.JSONObject

data class Program(
    val group: String,
    val name: String,
    val value: Int
){
    companion object{
        fun fromJson(obj: JSONObject) : Program {
            return Program(obj.optString("group"), obj.optString("name"), obj.optInt("val"))
        }
    }
}
package com.selimbousbih.midiplayer.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selimbousbih.midiplayer.utils.Utils
import com.selimbousbih.midiplayer.data.Program
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class ProgramsDataSource {
    private val programs: MutableLiveData<ArrayList<Program>> by lazy {
        MutableLiveData<ArrayList<Program>>().also{
            it.value = ArrayList()
        }
    }

    fun getPrograms(context: Context): LiveData<ArrayList<Program>> {
        loadPrograms(context)
        return programs
    }

    private fun loadPrograms(context: Context) {
        val programs = ArrayList<Program>()
        val json = Utils.loadJSONFromAsset(context, "programs.json")
        try {
            val programsArray = JSONArray(json)
            for (i in 0 until programsArray.length()) {
                val programObj = programsArray.get(i) as JSONObject
                programs.add(Program.fromJson(programObj))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        this.programs.postValue(programs)
    }
}
package com.als.myapplication.domain.workers

import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.domain.MapperList
import com.als.myapplication.domain.TextHelper
import com.als.myapplication.domain.dto.WorkerShort
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class WorkerShortMapper : MapperList<WorkerDb, WorkerShort> {
    override fun map(from: List<WorkerDb>): List<WorkerShort> {
        val workers = ArrayList<WorkerShort>()
        for (item in from) {
            workers.add(
                WorkerShort(
                    workerId = item.workerId,
                    fio = "${item.name.toLowerCase().capitalize()} ${
                        item.fname.toLowerCase().capitalize()
                    }",
                    vozrast = getVozrast(item.dr),
                    url = item.url
                )
            )
        }
        return workers
    }

    private fun getVozrast(dr: String?): String {
        var res = "-"
        if (dr != null) {
            val inputFormat = if (dr.indexOf('-') == 4) "yyyy-MM-dd" else "dd-MM-yyyy"
            val dateFormat = SimpleDateFormat(inputFormat)
            res = try {
                val date = dateFormat.parse(dr)
                val now = Calendar.getInstance()
                val bd = Calendar.getInstance()
                bd.timeInMillis = date.time
                var age: Int = now.get(Calendar.YEAR) - bd.get(Calendar.YEAR)
                if (now.get(Calendar.DAY_OF_YEAR) <= bd.get(Calendar.DAY_OF_YEAR)) {
                    age--
                }
                return TextHelper.getSuffiks(age, "год", "года", "лет")
            } catch (e: Exception) {
                "-"
            }
        }

        return res
    }
}
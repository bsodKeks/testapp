package com.als.myapplication.domain.detail

import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.domain.MapperSingle
import com.als.myapplication.domain.dto.WorkerDetail
import java.lang.Exception
import java.text.SimpleDateFormat

class WorkerDetailMapper : MapperSingle<WorkerDb, WorkerDetail> {
    override fun map(from: WorkerDb) = WorkerDetail(
        workerId = from.workerId,
        fio = "${from.name.toLowerCase().capitalize()} ${from.fname.toLowerCase().capitalize()}",
        dr = formatterDr(from.dr),
        url = from.url
    )

    private fun formatterDr(dr: String?): String {
        var res = "-"
        if (dr != null) {
            val inputFormat = if (dr.indexOf('-') == 4) "yyyy-MM-dd" else "dd-MM-yyyy"
            val outputFormat = "dd.MM.yyyy"
            val dateFormat = SimpleDateFormat(inputFormat)
            res = try {
                val date = dateFormat.parse(dr)
                dateFormat.applyPattern(outputFormat)
                dateFormat.format(date)
            } catch (e: Exception) {
                "-"
            }
        }
        return res
    }
}
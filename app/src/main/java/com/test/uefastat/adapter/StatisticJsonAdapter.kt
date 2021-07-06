package com.test.uefastat.adapter

import Seasons
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import com.test.uefastat.model.Statistic
import com.test.uefastat.model.Winner

class StatisticJsonAdapter : TypeAdapter<Statistic>() {

    override fun write(out: JsonWriter?, value: Statistic?) {
    }

    override fun read(reader: JsonReader?): Statistic {
        val uefaInfo = Statistic()
        reader?.let {
            reader.beginObject()
            while (reader.hasNext()) {
                when (reader.nextName()) {
                    NAME -> uefaInfo.name = reader.nextString()
                    AREA -> uefaInfo.areaName = readArea(reader)
                    SEASONS -> uefaInfo.seasons = readSeasonsList(reader)
                    else -> reader.skipValue()
                }
            }
            reader.endObject()
        }
        return uefaInfo
    }


    private fun readSeasonsList(reader: JsonReader): MutableList<Seasons> {
        val list: MutableList<Seasons> = mutableListOf<Seasons>()

        reader.beginArray()
        while (reader.hasNext()) {
            list.add(readSeason(reader))
        }
        reader.endArray()
        return list
    }

    private fun readSeason(reader: JsonReader): Seasons {
        val season = Seasons()
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                START_DATE -> season.startDate = reader.nextString()
                END_DATE -> season.endDate = reader.nextString()
                WINNER -> {
                    if (reader.peek() != JsonToken.NULL)  season.winner = readWinner(reader)
                    else reader.skipValue()


                }
                else -> reader.skipValue()
            }
        }
        reader.endObject()

        return season
    }

    private fun readWinner(reader: JsonReader): Winner? {
        val winner = Winner()
        reader.beginObject()

        while (reader.hasNext()) {
            val name = reader.nextName()
            if (name == "name") {
                winner.name = reader.nextString()
            } else {
                reader.skipValue()
            }
        }
        reader.endObject()
        return winner
    }

    private fun readArea(reader: JsonReader): String? {
        var areaName: String? = null

        reader.beginObject()
        while (reader.hasNext()) {
            val name = reader.nextName()
            if (name == "name") {
                areaName = reader.nextString()
            } else {
                reader.skipValue()
            }
        }
        reader.endObject()
        return areaName
    }

    companion object {
        private const val NAME = "name"
        private const val AREA = "area"
        private const val WINNER = "winner"
        private const val END_DATE = "endDate"
        private const val START_DATE = "startDate"
        private const val SEASONS = "seasons"
    }
}
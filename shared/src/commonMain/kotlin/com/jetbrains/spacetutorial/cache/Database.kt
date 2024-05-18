package com.jetbrains.spacetutorial.cache

import com.jetbrains.spacetutorial.entity.Links
import com.jetbrains.spacetutorial.entity.Patch
import com.jetbrains.spacetutorial.entity.RocketLaunch

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearAndCreateLaunches(launches: List<RocketLaunch>) {
        dbQuery.transaction {
            dbQuery.removeAllLaunches()
            launches.forEach { launch ->
                dbQuery.insertLaunch(
                    flightNumber = launch.flightNumber.toLong(),
                    missionName = launch.missionName,
                    details = launch.details,
                    launchSuccess = launch.launchSuccess ?: false,
                    launchDateUTC = launch.launchDateUTC,
                    patchUrlSmall = launch.links.patch?.small,
                    patchUrlLarge = launch.links.patch?.large,
                    articleUrl = launch.links.article
                )
            }
        }
    }

    internal fun clearAndCreateLaunches(launches: List<RocketLaunch>) {
        dbQuery.transaction {
            dbQuery.removeAllLaunches()
            launches.forEach { launch ->
                dbQuery.insertLaunch(
                    flightNumber = launch.flightNumber.toLong(),
                    missionName = launch.missionName,
                    details = launch.details,
                    launchSuccess = launch.launchSuccess ?: false,
                    launchDateUTC = launch.launchDateUTC,
                    patchUrlSmall = launch.links.patch?.small,
                    patchUrlLarge = launch.links.patch?.large,
                    articleUrl = launch.links.article
                )
            }
        }
    }

}
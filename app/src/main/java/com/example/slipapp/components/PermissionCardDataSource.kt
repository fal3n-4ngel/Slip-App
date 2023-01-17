package com.example.slipapp.components

object PermissionCardDataSource {
    val permissions = listOf<Permission>(
        Permission(
            "Permission to leave early",
            "Dr. Tom Riddle",
            "15 Nov 2022",
            PermissionStatus.ACCEPTED
        ),
        Permission(
            "Hosting freshers day for juniors",
            "--",
            "18 Nov 2022",
            PermissionStatus.UNDER_REVIEW
        )
    )
}
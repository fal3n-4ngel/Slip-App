package com.example.slipapp.components

data class Permission(
    val content: String,
    val grantedBy: String,
    val date: String,
    val permissionStatus: PermissionStatus
)

enum class PermissionStatus {
    ACCEPTED,
    UNDER_REVIEW,
    REJECTED
}
package com.yahyagonder.journalapp.Model

data class AboutItem(val itemImage: Int, val itemTitle: String, val itemDescription: String, val actionType: ActionType)

enum class ActionType {
    NONE,
    LOGOUT
}

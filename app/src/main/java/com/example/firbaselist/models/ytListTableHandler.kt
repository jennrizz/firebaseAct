package com.example.firbaselist.models

import com.example.firbaselist.objectHandlers.ytList
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import java.util.*

class ytListTableHandler(){
    lateinit var db : FirebaseDatabase
    lateinit var ytRef : DatabaseReference
    init {
        db = FirebaseDatabase.getInstance()
        ytRef = db.getReference("ytLists")
    }

    fun create(ytList: ytList): Boolean{
        val id = ytRef.push().key
        ytList.id = id

        ytRef.child(id!!).setValue(ytList)
        return true
    }

    fun delete(ytId: String){
        ytRef.child(ytId).removeValue()
    }

    fun edit(ytList: ytList): Boolean{
        ytRef.child(ytList.id!!).setValue(ytList)
        return true
    }
}
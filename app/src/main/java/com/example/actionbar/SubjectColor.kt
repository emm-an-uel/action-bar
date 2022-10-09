package com.example.actionbar

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SubjectColor (
    val subject: String,
    val color: String
        ) : Parcelable

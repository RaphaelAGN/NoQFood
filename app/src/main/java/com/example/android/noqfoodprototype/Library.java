package com.example.android.noqfoodprototype;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Library{
    private static DatabaseReference firebase;
    private Library(){}
    public static DatabaseReference getFirebase(){
        if( firebase == null ){
            firebase = FirebaseDatabase.getInstance().getReference();
        }
        return( firebase );
    }
}

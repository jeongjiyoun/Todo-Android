package com.example.todoapp.ui.main

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import timber.log.Timber


class AuthAppRepository(application: Application?) {
    private var application: Application? = application

    private var firebaseAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    private var userLiveData: MutableLiveData<FirebaseUser?>? = MutableLiveData()
    private var loggedOutLiveData: MutableLiveData<Boolean>? = MutableLiveData()

    fun register(email: String?, password: String?) {
        firebaseAuth!!.createUserWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener(
                application!!.mainExecutor
            ) { task ->
                if (task.isSuccessful) {
                    userLiveData!!.postValue(firebaseAuth!!.currentUser)
                    sendEmailVerification()
                } else {
                    Toast.makeText(
                        application!!.applicationContext,
                        "Registration Failure: " + task.exception.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun sendEmailVerification() {
        lateinit var auth: FirebaseAuth
        val firebaseUser: FirebaseUser? = auth.currentUser

        firebaseUser!!.let {
            it.sendEmailVerification().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Timber.i("email sent to useremail")

                } else {
                    Timber.i("sendEmailVerification failed")

                }
            }
        }
    }

    fun login(email: String?, password: String?) {
        firebaseAuth!!.signInWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener(
                application!!.mainExecutor
            ) { task ->
                if (task.isSuccessful) {
                    userLiveData!!.postValue(firebaseAuth!!.currentUser)
                } else {
                    Toast.makeText(
                        application!!.applicationContext,
                        "Login Failure: " + task.exception.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun logOut() {
        firebaseAuth!!.signOut()
        loggedOutLiveData!!.postValue(true)
    }

    fun getUserLiveData(): MutableLiveData<FirebaseUser?>? {
        return userLiveData
    }

    fun getLoggedOutLiveData(): MutableLiveData<Boolean>? {
        return loggedOutLiveData
    }
}
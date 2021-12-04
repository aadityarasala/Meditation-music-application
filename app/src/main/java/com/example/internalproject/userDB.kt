package com.example.login_registration

class userDB {
    companion object{
        var Email:String=""
        var Password:String=""
        var Name:String=""

        var userLogin:Boolean= false

        //to validate user info
        fun Login(email:String,password:String):Boolean{
            userLogin = Email ==email && password== Password
            return userLogin
        }

        // when user press logout then userLogin variable value has been changed to True to False
        fun logout()
        {
            userLogin =false
        }

    }
}
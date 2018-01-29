package com.example.a16254836.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCadastro.setOnClickListener{
            startActivity <Cadastro>()
        }


        btnEntrar.setOnClickListener{

            val usuario =txtUser.text.toString()
            val senha = txtSenhap.text.toString()

            //toast("http://10.0.2.2/teste/apiLogin.php?usuario=$usuario&senha=$senha")

            doAsync {
                val resultado = URL("http://10.0.2.2/teste/apiLogin.php?usuario=$usuario&senha=$senha").readText()





                val retornoJson=JSONObject(resultado)



                val status = retornoJson.getBoolean("status1")


                uiThread {
                    if (status == true){
                        startActivity <Main>()
                    }else{
                        toast("Usuario ou Senha Incorretos")
                    }
                }



            }

//            if (txtSenha.text.toString() == "admin" && txtUser.text.toString() == "admin"){
//                startActivity <Main>()
//            }else{
//                toast("coisas erradas")
//            }
        }

    }
}

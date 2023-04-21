package com.example.filestorageexternal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //without any permission

        btnSave.setOnClickListener{
          //  var test="Anand"
            try{
                val file= File(getExternalFilesDir("CMPICA"),filename.text.toString())
                val fileWrite=BufferedWriter(FileOutputStream(file).bufferedWriter())
          //   fileWrite.write(filedata.text.toString())
            fileWrite.write("<?xml version='1.0' ?><geotagger id=\"geo_tagger_v2\"><DeviceId>911498104230481</DeviceId><Image>1488001128037.jpg</Image><Location>19.90372128 74.75839769 441.0 4.0</Location><Description>Mix crop\n" +
                     "</Description></geotagger>")


                fileWrite.close()
                Toast.makeText(this, "File Created", Toast.LENGTH_SHORT).show()
                filedata.text.clear()
            }catch (e:FileNotFoundException)
            {
                Toast.makeText(this, "File Not Found", Toast.LENGTH_SHORT).show()
            }
        }
        btnShow.setOnClickListener {
            try{
                val file= File(getExternalFilesDir("CMPICA"),filename.text.toString())
                val fileRead=BufferedReader(FileInputStream(file).bufferedReader())
                val data = StringBuffer()
                var line = fileRead.readLine()
                while (line!=null)
                {
                    data.append(line)
                    line= fileRead.readLine()


                }
                filedata.text.clear()
                filedata.setText(data.toString())
              //  Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show()

            }catch (e:FileNotFoundException)
            {
                Toast.makeText(this, "File Not Found", Toast.LENGTH_SHORT).show()
            }

        }



    }
}
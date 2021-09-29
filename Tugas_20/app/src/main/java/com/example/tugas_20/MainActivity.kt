package com.example.tugas_20
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var selectedImage: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Image_view.setOnClickListener {
            BukaPilihGambar()
        }
    }
    private fun BukaPilihGambar(){
        Intent(Intent.ACTION_PICK).also{
            it.type = "image/*"
            val mimeTypes = arrayOf("image/jpeg","image/png")
            it.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            startActivityForResult(it, REQUEST_CODE_IMAGE_PICKER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                REQUEST_CODE_IMAGE_PICKER ->{
                    selectedImage = data?.data
                    Image_view.setImageURI(selectedImage)
                }
            }
        }
    }
    companion object{
        private const val REQUEST_CODE_IMAGE_PICKER = 100
    }
}
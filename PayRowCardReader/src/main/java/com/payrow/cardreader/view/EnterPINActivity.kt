package com.payrow.cardreader.view

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.nfc.NfcAdapter
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.payrow.cardreader.R
import com.payrow.cardreader.SimpleCardReader
import com.payrow.cardreader.interfaces.GetCardDetails
import kotlinx.android.synthetic.main.activity_keypad.*

class EnterPINActivity : AppCompatActivity(), View.OnClickListener {
    var stringEnterPIN: String = ""
    private var nfcAdapter: NfcAdapter? = null
    var ring: MediaPlayer? = null
    val getCardDetails:GetCardDetails?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keypad)

        ring = MediaPlayer.create(this, R.raw.sound_button_click)

        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
        btnZero.setOnClickListener(this)
        btnClear.setOnClickListener(this)
        etEnterPin.setOnClickListener(this)

        btnConfirm.setOnClickListener {
            if (etEnterPin.text.toString().isNotEmpty()) {
                ring?.start()
                val intent= Intent()
                val bundle=Bundle()
                bundle.putString("CARDNUMBER","12345678")
                bundle.putString("EXPIRY","22/2022")
                intent.putExtras(bundle)
               // setResult(Activity.RESULT_OK,intent)
                getCardDetails?.showCardDetails("12345678","22/2022")
                setCardDetails("1234567")
                finish()
            } else {
                Toast.makeText(this, "Please enter PIN to proceed", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onClick(v: View?) {
        val id: Int = v!!.id
        when (id) {
            btnOne.id -> {
                stringEnterPIN = etEnterPin.text.toString() + "1"
                etEnterPin.text = stringEnterPIN
                ring?.start()
            }
            btnTwo.id -> {
                stringEnterPIN = etEnterPin.text.toString() + "2"
                etEnterPin.text = stringEnterPIN
                ring?.start()
            }
            btnThree.id -> {
                stringEnterPIN = etEnterPin.text.toString() + "3"
                etEnterPin.text = stringEnterPIN
                ring?.start()
            }
            btnFour.id -> {
                stringEnterPIN = etEnterPin.text.toString() + "4"
                etEnterPin.text = stringEnterPIN
                ring?.start()
            }
            btnFive.id -> {
                stringEnterPIN = etEnterPin.text.toString() + "5"
                etEnterPin.text = stringEnterPIN
                ring?.start()
            }
            btnSix.id -> {
                stringEnterPIN = etEnterPin.text.toString() + "6"
                etEnterPin.text = stringEnterPIN
                ring?.start()
            }
            btnSeven.id -> {
                stringEnterPIN = etEnterPin.text.toString() + "7"
                etEnterPin.text = stringEnterPIN
                ring?.start()
            }
            btnEight.id -> {
                stringEnterPIN = etEnterPin.text.toString() + "8"
                etEnterPin.text = stringEnterPIN
                ring?.start()
            }
            btnNine.id -> {
                stringEnterPIN = etEnterPin.text.toString() + "9"
                etEnterPin.text = stringEnterPIN
                ring?.start()
            }
            btnZero.id -> {
                stringEnterPIN = etEnterPin.text.toString() + "0"
                etEnterPin.setText(stringEnterPIN)
                ring?.start()
            }

            btnClear.id -> {
                ring?.start()
                etEnterPin.setText("")
            }

        }
    }
    companion object cardNumber {
        fun setCardDetails(cardNumber:String):String
        {
            return cardNumber
        }
    }
}
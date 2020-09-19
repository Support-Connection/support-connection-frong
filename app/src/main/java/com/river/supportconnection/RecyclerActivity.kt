package com.river.supportconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        // Bottom Sheet 클릭 이벤트
        val dialog = BottomSheetDialog(this)
        val SView = layoutInflater.inflate(R.layout.activity_shinchung, null)

        recycler_applybtn.setOnClickListener {
            val close = SView.findViewById<Button>(R.id.sc_close)
            close.setOnClickListener {
                dialog.dismiss()
            }

            val sc_text1 = SView.findViewById<TextView>(R.id.sc_text1)
            sc_text1.setOnClickListener {
                // 전화번호로 전화걸기 이벤트
            }

            val sc_text2 = SView.findViewById<TextView>(R.id.sc_text2)
            sc_text2.setOnClickListener {
                // 인터넷 사이트로 이동
            }

            val sc_text3 = SView.findViewById<TextView>(R.id.sc_text3)
            sc_text3.setOnClickListener {
                // 주소??????
            }
            dialog.setContentView(SView)
            dialog.show()
        }

        // 이미지 drawable 관련 코드 작성 필요
        val institution = intent.getStringExtra("institution")
        val specific = intent.getStringExtra("specific")
        val rate = intent.getStringExtra("rate")
        val saving = intent.getStringExtra("saving")

        // + - showing
        var a=0
        recycler_icon3.setOnClickListener {
            if(a==0) {
                recycler_icon3.setImageResource(R.drawable.ic_19)
                recycler_text8.visibility= View.VISIBLE
                a++
            } else {
                recycler_icon3.setImageResource(R.drawable.ic_16)
                recycler_text8.visibility= View.INVISIBLE
                a--
            }
        }

        var b=0
        recycler_icon4.setOnClickListener {
            if(b==0) {
                recycler_icon4.setImageResource(R.drawable.ic_19)
                recycler_text10.visibility= View.VISIBLE
                b++
            } else {
                recycler_icon4.setImageResource(R.drawable.ic_16)
                recycler_text10.visibility= View.INVISIBLE
                b--
            }
        }

        var c=0
        recycler_icon5.setOnClickListener {
            if(c==0) {
                recycler_icon5.setImageResource(R.drawable.ic_19)
                recycler_text12.visibility= View.VISIBLE
                recycler_text13.visibility= View.VISIBLE
                c++
            } else {
                recycler_icon5.setImageResource(R.drawable.ic_16)
                recycler_text12.visibility= View.INVISIBLE
                recycler_text13.visibility= View.INVISIBLE
                c--
            }
        }

    }
}
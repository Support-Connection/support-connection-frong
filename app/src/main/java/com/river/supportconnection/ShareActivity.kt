package com.river.supportconnection

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_share.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.startActivity

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)


        // 사용자 기본 data
        val name = intent.getStringExtra("name")
        val birth = intent.getStringExtra("birth")
        val sex = intent.getStringExtra("sex")

        // 이름 변경
        share_text1.text = "안녕하세요 " + name + "님,\n서폿커넥션에 잘오셨어요!"

        // -- Intent -- (Anko 사용)

        next_share.setOnClickListener {
            startActivity<RealMainActivity>(
                "name" to name,
                "birth" to birth,
                "sex" to sex,
            )

        }
    }
}
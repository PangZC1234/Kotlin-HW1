package com.example.lab3_kolin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edName: EditText = findViewById(R.id.ed_name)
        val tvText: TextView = findViewById(R.id.tv_text)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvWinner: TextView = findViewById(R.id.tv_winner)
        val tvMmora: TextView = findViewById(R.id.tv_mmora)
        val tvCmora: TextView = findViewById(R.id.tv_cmora)
        val btnScissor: RadioButton = findViewById(R.id.btn_scissor)
        val btnStone: RadioButton = findViewById(R.id.btn_stone)
        val btnPaper: RadioButton = findViewById(R.id.btn_paper)
        val btnMora: Button = findViewById(R.id.btn_mora)
        btnMora.setOnClickListener {
            if (edName.length() < 1)
                tvText.text = "請輸入玩家姓名"
            else {
                tvName.text = String.format("名字\n%s", edName.text.toString())
                if (btnScissor.isChecked)
                    tvMmora.text = "我方出拳\n剪刀"
                else if (btnStone.isChecked)
                    tvMmora.text = "我方出拳\n石頭"
                else
                    tvMmora.text = "我方出拳\n布"

                val computer = (Math.random() * 3).toInt()
                if (computer == 0)
                    tvCmora.text = "電腦出拳\n剪刀"
                else if (computer == 1)
                    tvCmora.text = "電腦出拳\n石頭"
                else
                    tvCmora.text = "電腦出拳\n布"

                //player won
                if (btnScissor.isChecked && computer == 2 ||
                    btnStone.isChecked && computer == 0 ||
                    btnPaper.isChecked && computer == 1
                ) {
                    tvWinner.text = "勝利者\n${edName.text}"
                    tvText.text = "恭喜你獲勝！！！"
                }

                //computer won
                else if (btnScissor.isChecked && computer == 1 ||
                    btnStone.isChecked && computer == 2 ||
                    btnPaper.isChecked && computer == 0
                ) {
                    tvWinner.text = "勝利者\n 電腦"
                    tvText.text = "可惜，電腦獲勝了！"
                }

                //DRAW
                else {
                    tvWinner.text = "勝利者\n平手"
                    tvText.text = "平局，請再試一次！"
                }
            }
        }
    }
}
package com.example.dama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout


class TwoPlayer : AppCompatActivity() {

    private lateinit var playerOneLayout: LinearLayout
    private lateinit var playerTwoLayout: LinearLayout
    private lateinit var image0: ImageView
    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView
    private lateinit var image4: ImageView
    private lateinit var image5: ImageView
    private lateinit var image6: ImageView
    private lateinit var image7: ImageView
    private lateinit var image8: ImageView


    private val combinationList: ArrayList<IntArray> = ArrayList()
    private var playerOneBoxPositions = intArrayOf(10, 10, 10)
    private var playerTwoBoxPositions = intArrayOf(10, 10, 10)
    private var playerTurn = 1
    private var totalSelectedBoxes = 0

    private var ilkSecim = 10


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_player)


        playerOneLayout = findViewById(R.id.playerOneLayout)
        playerTwoLayout = findViewById(R.id.playerTwoLayout)
        image0 = findViewById(R.id.image0)
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)
        image4 = findViewById(R.id.image4)
        image5 = findViewById(R.id.image5)
        image6 = findViewById(R.id.image6)
        image7 = findViewById(R.id.image7)
        image8 = findViewById(R.id.image8)


        combinationList.add(intArrayOf(0, 1, 2))
        combinationList.add(intArrayOf(3, 4, 5))
        combinationList.add(intArrayOf(6, 7, 8))
        combinationList.add(intArrayOf(0, 3, 6))
        combinationList.add(intArrayOf(1, 4, 7))
        combinationList.add(intArrayOf(2, 5, 8))


        image0.setOnClickListener {

            if(totalSelectedBoxes<6){ // bunu koymasan bile performActiondaki şartlardan doalyı 6 dan fazla seçemeyecek zaten ama kontrollü olsun mesele 6 yı geçmişse performa gitmesin boşuna else den devam etsni bir de ikisi çalışıp kutu renklenmio
                performActionPosition(image0, 0)
            }
            else{

                performAction(0,image0)

            }


        }
        image1.setOnClickListener {

            if( totalSelectedBoxes<6){
                performActionPosition(image1, 1)
            }
            else{

                performAction(1,image1)
            }


        }
        image2.setOnClickListener {

            if( totalSelectedBoxes<6){
                performActionPosition(image2, 2)
            }
            else{
                performAction(2, image2)
            }


        }
        image3.setOnClickListener {

            if(totalSelectedBoxes<6){
                performActionPosition(image3, 3)
            }
            else{
                performAction(3, image3)
            }
        }
        image4.setOnClickListener {

            if(totalSelectedBoxes<6){
                performActionPosition(image4, 4)
            }
            else{
                performAction(4, image4)
            }



        }
        image5.setOnClickListener {

            if(totalSelectedBoxes<6){
                performActionPosition(image5, 5)
            }
            else{
                performAction(5, image5)
            }

        }
        image6.setOnClickListener {

            if(totalSelectedBoxes<6){
                performActionPosition(image6, 6)
            }
            else{
                performAction(6, image6)
            }


        }
        image7.setOnClickListener {

            if(totalSelectedBoxes<6){
                performActionPosition(image7, 7)
            }
            else{
                performAction(7, image7)
            }
        }
        image8.setOnClickListener {

            if(totalSelectedBoxes<6){
                performActionPosition(image8, 8)
            }
            else{
                performAction(8, image8)
            }
        }

    }




    private fun checkPlayerWin(): Int {
        var response = 0 // Kimse kazanmadı

        for (combination in combinationList) {
            if (combinationList.any { it.toSet().containsAll(playerOneBoxPositions.toSet())}) {
                response = 1 // 1 kazandı
                changePlayerTurn(1)
            }
            else if (combinationList.any { it.toSet().containsAll(playerTwoBoxPositions.toSet())}) {
                response = 2 // 2 kazandı
                changePlayerTurn(2)
            }
        }


        return response
    }


    private fun changePlayerTurn(currentPlayerTurn : Int){

        playerTurn = currentPlayerTurn

        if (playerTurn == 1){

            playerOneLayout.setBackgroundResource(R.drawable.round_back_dark_blue_stroke)
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_dark_blue_20)
        }
        else{

            playerTwoLayout.setBackgroundResource(R.drawable.round_back_dark_blue_stroke)
            playerOneLayout.setBackgroundResource(R.drawable.round_back_dark_blue_20)

        }
    }

    fun restartMatch(){

        playerOneBoxPositions = intArrayOf(10, 10, 10)
        playerTwoBoxPositions = intArrayOf(10, 10, 10)
        totalSelectedBoxes = 0
        ilkSecim = 10

        image0.setImageResource(R.drawable.trasnparent)
        image1.setImageResource(R.drawable.trasnparent)
        image2.setImageResource(R.drawable.trasnparent)
        image3.setImageResource(R.drawable.trasnparent)
        image4.setImageResource(R.drawable.trasnparent)
        image5.setImageResource(R.drawable.trasnparent)
        image6.setImageResource(R.drawable.trasnparent)
        image7.setImageResource(R.drawable.trasnparent)
        image8.setImageResource(R.drawable.trasnparent)


    }


    private fun performActionPosition(imageView: ImageView, selectedBoxPosition : Int){

        if (playerTurn == 1){

            if (playerOneBoxPositions[0]==10){
                playerOneBoxPositions[0]=selectedBoxPosition
                imageView.setImageResource(R.drawable.bluecircle)
                changePlayerTurn(2)
                totalSelectedBoxes++
            }
            else if (playerOneBoxPositions[1]==10){
                playerOneBoxPositions[1]=selectedBoxPosition
                imageView.setImageResource(R.drawable.bluecircle)
                changePlayerTurn(2)
                totalSelectedBoxes++
            }
            else if (playerOneBoxPositions[2]==10){
                playerOneBoxPositions[2]=selectedBoxPosition
                imageView.setImageResource(R.drawable.bluecircle)
                changePlayerTurn(2)
                totalSelectedBoxes++
            }
        }
        else if (playerTurn == 2){

            if (playerTwoBoxPositions[0]==10){
                playerTwoBoxPositions[0]=selectedBoxPosition
                imageView.setImageResource(R.drawable.redcircle)
                changePlayerTurn(1)
                totalSelectedBoxes++
            }
            else if (playerTwoBoxPositions[1]==10){
                playerTwoBoxPositions[1]=selectedBoxPosition
                imageView.setImageResource(R.drawable.redcircle)
                changePlayerTurn(1)
                totalSelectedBoxes++
            }
            else if (playerTwoBoxPositions[2]==10){
                playerTwoBoxPositions[2]=selectedBoxPosition
                imageView.setImageResource(R.drawable.redcircle)
                changePlayerTurn(1)
                totalSelectedBoxes++

                if (checkPlayerWin() == 1)
                {
                    val winDialog = WinDialog(this@TwoPlayer, "Birinci Oyuncu Kazandı.", this@TwoPlayer)
                    winDialog.setCancelable(false)
                    winDialog.show()
                }
                else if (checkPlayerWin() == 2){
                    val winDialog = WinDialog(this@TwoPlayer, "İkinci Oyuncu Kazandı.", this@TwoPlayer)
                    winDialog.setCancelable(false)
                    winDialog.show()
                }

            }
        }

    }


    private fun performAction(boxPosition: Int, imageView: ImageView) {

        if (playerTurn==1){

            if (playerOneBoxPositions[0] == boxPosition || playerOneBoxPositions[1] == boxPosition || playerOneBoxPositions[2] == boxPosition) {

                if (ilkSecim == 10 ){
                    imageView.setBackgroundResource(R.drawable.round_back_dark_blue_stroke)
                    ilkSecim = boxPosition
                }
                else if (ilkSecim != boxPosition){
                    imageView.setBackgroundResource(R.drawable.round_back_dark_blue_stroke)

                    if (ilkSecim == 0)
                        image0.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 1)
                        image1.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 2)
                        image2.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 3)
                        image3.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 4)
                        image4.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 5)
                        image5.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 6)
                        image6.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 7)
                        image7.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 8)
                        image8.setBackgroundResource(R.drawable.round_back_dark_blue_20)

                    ilkSecim=boxPosition
                }
                else{

                }
            }


            if (playerOneBoxPositions[0] != boxPosition && playerOneBoxPositions[1] != boxPosition && playerOneBoxPositions[2] != boxPosition && playerTwoBoxPositions[0] != boxPosition && playerTwoBoxPositions[1] != boxPosition && playerTwoBoxPositions[2] != boxPosition){

                if ((ilkSecim != 10) && (boxPosition== ilkSecim-1 || boxPosition==ilkSecim+1 || boxPosition==ilkSecim-3 || boxPosition==ilkSecim+3)){

                    imageView.setImageResource(R.drawable.bluecircle)

                    if (ilkSecim == 0)
                    {
                        image0.setImageResource(R.drawable.trasnparent)
                        image0.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 1)
                    {
                        image1.setImageResource(R.drawable.trasnparent)
                        image1.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 2)
                    {
                        image2.setImageResource(R.drawable.trasnparent)
                        image2.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 3)
                    {
                        image3.setImageResource(R.drawable.trasnparent)
                        image3.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 4)
                    {
                        image4.setImageResource(R.drawable.trasnparent)
                        image4.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 5)
                    {
                        image5.setImageResource(R.drawable.trasnparent)
                        image5.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 6)
                    {
                        image6.setImageResource(R.drawable.trasnparent)
                        image6.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 7)
                    {
                        image7.setImageResource(R.drawable.trasnparent)
                        image7.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 8)
                    {
                        image8.setImageResource(R.drawable.trasnparent)
                        image8.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }

                    if (playerOneBoxPositions[0] == ilkSecim)
                        playerOneBoxPositions[0]= boxPosition
                    else if (playerOneBoxPositions[1] == ilkSecim)
                        playerOneBoxPositions[1]= boxPosition
                    else if (playerOneBoxPositions[2] == ilkSecim)
                        playerOneBoxPositions[2]= boxPosition

                    ilkSecim=10

                    changePlayerTurn(2)

                }


                if (checkPlayerWin() == 1)
                {
                    val winDialog = WinDialog(this@TwoPlayer, "Birinci Oyuncu Kazandı.", this@TwoPlayer)
                    winDialog.setCancelable(false)
                    winDialog.show()
                }
                else if (checkPlayerWin() == 2){
                    val winDialog = WinDialog(this@TwoPlayer, "İkinci Oyuncu Kazandı.", this@TwoPlayer)
                    winDialog.setCancelable(false)
                    winDialog.show()
                }

            }


        }
        else if ( playerTurn==2 ){

            if (playerTwoBoxPositions[0] == boxPosition || playerTwoBoxPositions[1] == boxPosition || playerTwoBoxPositions[2] == boxPosition) {

                if (ilkSecim == 10 ){
                    imageView.setBackgroundResource(R.drawable.round_back_dark_blue_stroke)
                    ilkSecim = boxPosition

                }
                else if (ilkSecim != boxPosition){
                    imageView.setBackgroundResource(R.drawable.round_back_dark_blue_stroke)

                    if (ilkSecim == 0)
                        image0.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 1)
                        image1.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 2)
                        image2.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 3)
                        image3.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 4)
                        image4.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 5)
                        image5.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 6)
                        image6.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 7)
                        image7.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    if (ilkSecim == 8)
                        image8.setBackgroundResource(R.drawable.round_back_dark_blue_20)

                    ilkSecim=boxPosition
                }
                else{

                }
            }


            if (playerOneBoxPositions[0] != boxPosition && playerOneBoxPositions[1] != boxPosition && playerOneBoxPositions[2] != boxPosition && playerTwoBoxPositions[0] != boxPosition && playerTwoBoxPositions[1] != boxPosition && playerTwoBoxPositions[2] != boxPosition){ // seçtiği yer boşsa

                if ((ilkSecim != 10) && (boxPosition== ilkSecim-1 || boxPosition==ilkSecim+1 || boxPosition==ilkSecim-3 || boxPosition==ilkSecim+3)){

                    imageView.setImageResource(R.drawable.redcircle)


                    if (ilkSecim == 0)
                    {
                        image0.setImageResource(R.drawable.trasnparent)
                        image0.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 1)
                    {
                        image1.setImageResource(R.drawable.trasnparent)
                        image1.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 2)
                    {
                        image2.setImageResource(R.drawable.trasnparent)
                        image2.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 3)
                    {
                        image3.setImageResource(R.drawable.trasnparent)
                        image3.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 4)
                    {
                        image4.setImageResource(R.drawable.trasnparent)
                        image4.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 5)
                    {
                        image5.setImageResource(R.drawable.trasnparent)
                        image5.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 6)
                    {
                        image6.setImageResource(R.drawable.trasnparent)
                        image6.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 7)
                    {
                        image7.setImageResource(R.drawable.trasnparent)
                        image7.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }
                    if (ilkSecim == 8)
                    {
                        image8.setImageResource(R.drawable.trasnparent)
                        image8.setBackgroundResource(R.drawable.round_back_dark_blue_20)
                    }

                    if (playerTwoBoxPositions[0] == ilkSecim)
                        playerTwoBoxPositions[0]= boxPosition
                    else if (playerTwoBoxPositions[1] == ilkSecim)
                        playerTwoBoxPositions[1]= boxPosition
                    else if (playerTwoBoxPositions[2] == ilkSecim)
                        playerTwoBoxPositions[2]= boxPosition

                    ilkSecim=10
                    changePlayerTurn(1)
                }


                if (checkPlayerWin() == 1)
                {
                    val winDialog = WinDialog(this@TwoPlayer, "Birinci Oyuncu Kazandı.", this@TwoPlayer)
                    winDialog.setCancelable(false)
                    winDialog.show()
                }
                else if (checkPlayerWin() == 2){
                    val winDialog = WinDialog(this@TwoPlayer, "İkinci Oyuncu Kazandı.", this@TwoPlayer)
                    winDialog.setCancelable(false)
                    winDialog.show()
                }

            }




        }

    }










}
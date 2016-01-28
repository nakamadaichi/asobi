/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asobi;

/**
 *
 * @author Daichi n
 */
public class AsobiMain {
    
     /*
   //定数     
   */
 private static  final int OUTCOUNTMAX = 3;
 private static  final int STRIKECOUNTMAX = 3;
 private static  final int BAALCOUNTMAX = 4;
 private static  final int TURNMAX = 9;//今のところだけ、いずれ9回にする
 private static  final int OMOTE = 1;
 private static  final int URA = 2;
 private static  final int CHANGE = 3;
  /*
   //変数
   */
  private static int turnCount = 1;
  private static int strikeCount = 0;
  private static int outCount = 0;
  private static int ballCount = 0;
  private static int hitCount = 0;
  private static int tokuten = 0;
  private static int changeCount = 1;
  private static int teamAPoint;
  private static int teamBPoint;    
  private static int turnPoint;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  
        
        
        
        
  //メインループフラグを立てる
   boolean outLoop = true;
  
   
   
   ///////////////////////////////////////////
   //試合処理
   ///////////////////////////////////////////
   //開始
   ///////////////////////////////////////////
        System.out.println("試合開始");
   while(outLoop){
       if(changeCount==OMOTE){System.out.println(turnCount+"回表開始");//確認用
       }
       if(changeCount==URA){System.out.println(turnCount+"回裏開始");
       }
      boolean strikeLoop = true;//打席ループフラグ
       while(strikeLoop){
        //ヒット判定処理
        int hit = (int)(Math.random()*20);//打率：*以降の数字が少ないほど打つ
        if(hit<=2){
           hitCount++;
        System.out.println("ヒット！");
         strikeCount = 0;
         if(hitCount==4){
             turnPoint++;
             System.out.println("得点！");
             hitCount=0;
         }
        
        
        }else{
            strikeCount++;
            System.out.println(strikeCount+"ストライク！");
           
         
        }if(strikeCount>=STRIKECOUNTMAX){
           /////////////////////////////
           //ストライクが3になったらアウト数を加算・表示
           /////////////////////////////
            outCount++;
            System.out.println(outCount+"アウト！");
            //////////////////////////
            //ストライクカウントを初期化
            //////////////////////////
            strikeCount = 0;  
           


        /////////////////////////////////
        //ストライク数加算・表示
        /////////////////////////////////
       
          
             
     if(outCount>=OUTCOUNTMAX){
          if(changeCount==OMOTE){
              changeCount = URA;
              teamAPoint+=turnPoint;
              turnPoint=0;
               outCount = 0;//アウトカウントを初期化
               hitCount=0;
          strikeLoop = false;//ループを抜ける
          }
          }
      
      if(outCount>=OUTCOUNTMAX){
          if(changeCount==URA){
                teamBPoint+=turnPoint;
                turnPoint=0;
                outCount = 0;//アウトカウントを初期化
                  
                changeCount=OMOTE;
                hitCount=0;
                turnCount++;
                System.out.println("チェンジ！");
                strikeLoop = false;//ループを抜ける
          }
          }
    
          
          
        
        
        
        
        
          
         
            }
       }
     if(turnCount>TURNMAX){
         /////////////////////////////
         //九回が終わった段階でループを抜ける
         /////////////////////////////
         outLoop = false;
         
         
     }
    }
   
   
        System.out.println("ゲームセット");
        //テスト
        
        System.out.println(teamAPoint+"－"+teamBPoint+"で");
        if(teamAPoint>teamBPoint){
            System.out.println("Aチームの勝ち！");           
        }else if(teamAPoint<teamBPoint){
           System.out.println("Bチームの勝ち！");  
        }else if(teamAPoint==teamBPoint){
             System.out.println("ドロー！");
        }
   
   
  
    
}
}
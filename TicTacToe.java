package Game;
import java.util.Scanner;

class TicTacToeGame{
    static char [][] GameBoard;
    public TicTacToeGame(){
        GameBoard=new char [3][3];
        FillBoard();
    }
    void FillBoard(){
        for(int i=0;i<GameBoard.length;i++){
            for(int j=0;j<GameBoard[i].length;j++){
              GameBoard[i][j]=' ';
            }
            System.out.println();
        }
    }
    static void display(){
        System.out.println("------------");
        for(int i=0;i<GameBoard.length;i++) {
            System.out.print("|");
            for (int j = 0; j < GameBoard[i].length; j++) {
                System.out.print(GameBoard[i][j]+" | ");
            }
            System.out.println();
            System.out.println("------------");
        }
    }
   static void placeXO(int r,int c,char ch){
        if(r>=0&&r<3&&c>=0&&c<3){
            GameBoard[r][c]=ch;
        }else{
            System.out.println("invalid input");
        }

    }
   static boolean CheakColWin(){
        for(int j=0;j<3;j++){
            if(GameBoard[0][j]!=' '&&GameBoard[0][j]== GameBoard[1][j]&&GameBoard[1][j]== GameBoard[2][j]){
                return true;
            }
        }
        return false;
    }
  static boolean CheakRowWin(){
        for(int i=0;i<3;i++){
            if(GameBoard[i][0]!=' '&&GameBoard[i][0]== GameBoard[i][1]&&GameBoard[i][1]== GameBoard[i][2]){
                return true;
            }
        }
        return false;
    }
  static boolean CheakDiagonalWin(){
            if(GameBoard[0][0]!=' '&&GameBoard[0][0]== GameBoard[1][1]&&GameBoard[1][1]== GameBoard[2][2]
                    ||GameBoard[0][2]!=' '&&GameBoard[0][2]== GameBoard[1][1]&&GameBoard[1][1]== GameBoard[2][0]){
                return true;
            }else {
                return false;
            }
    }
    static boolean CheakDraw(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
              if(GameBoard[i][j]==' '){
                  return false;
              }
            }
        }
        return true;
    }
}
class HumanPlayer{
    String name;
    char mark;
    HumanPlayer(String name,char mark){
        this.name=name;
        this.mark=mark;
    }
    void Move(){
        Scanner sc=new Scanner(System.in);
        int r;
        int c;
       do{
           System.out.println("Enetr the Row and Col :");
            r=sc.nextInt();
            c=sc.nextInt();
       }while (!isValidMove(r,c));
       TicTacToeGame.placeXO( r, c,mark);
    }
    boolean isValidMove(int r,int c){
     if(r>=0&&r<3&&c>=0&&c<3) {
         if(TicTacToeGame.GameBoard[r][c]==' '){
             return true;
         }
     }
     return false;
    }
}

public class FirstGame {
    public static void main(String[] args) {
       TicTacToeGame G=new TicTacToeGame();

      HumanPlayer player1= new HumanPlayer("Mayank",'X');
      HumanPlayer player2= new HumanPlayer("Divya",'O');

        HumanPlayer cp;
        cp=player1;
       while (true){
           System.out.println(cp.name+" : turn");
           cp.Move();
           TicTacToeGame.display();

           if(TicTacToeGame.CheakColWin()||TicTacToeGame.CheakRowWin()||TicTacToeGame.CheakDiagonalWin()){
               System.out.println(cp.name+" has won !!");
               break;
           }else if(TicTacToeGame.CheakDraw()){
               System.out.println("Game is Draw !!");
               break;
           }
           else{
               if(cp==player1){
                   cp=player2;
               }else{
                   cp=player1;
               }
           }
       }

    }
}

import java.util.Scanner;
import java.io.IOException;

public class assignment4{

   // main method. DO NOT MODIFY
 public static void main(String args[]) {
  Scanner keyboard = new Scanner( System.in );
    
  System.out.println("Welcome to Memory Game");
  
  int board_side;
  
  //this loop obtains the board size, or more specifically 
  // the length of the side of the board
  do{
   System.out.println("\n For 2x2 board game press 2"+
    "\n For 4x4 board game press 4"+
     "\n For 6x6 board game press 6");
   
  }while(board_side!=2 && board_side!=4 && board_side!=6);
  
  char[][] board = createBoard(board_side);

  // a call the the shuffle method
  shuffleBoard(board);
  // a call to the game playing method
  playGame(board); 
    
 }
  
 
  
  
 // The following method should shuffle the input 2D array caled board 
 public static void shuffleBoard(char[][] board)
 {
  // This creates a 1D array whose size is equal to the size of the board   
  int N = board.length*board.length;
  char[] board1D = new char[N];
   
  // Copy the elements of 2D array into that 1D array here

int j = 0;
for (int a = 0; a < board.length; a++) 
{
  for (int b = 0; b < board.length; b++)
  {
    board1D[j] = board[a][b];
    j++;
  }
}

  // Shuffle 1D array here 
 
for (int i = 0; i < board1D.length; i++)
    {
      int index = (int)(Math.random() * board1D.length);
      char tmp = board1D[i];
      board1D[i] = board1D[index];
      board1D[index] = tmp;
    }

  //Copy shuffled 1D array back into 2D array, i.e., back to the board
  
int f = 0;
  for (int a = 0; a < board.length; a++)
{
  for (int b = 0; b < board.length; b++)
  {
    board[a][b] = board1D[f];
    f++;
}
}
char arr[][] = new char[board.length][board.length];
  int d = 0;
  for (int a = 0; a < board.length; a++)
{
  for (int b = 0; b < board.length; b++)
  {
    arr[a][b] = '*';
    d++;
  System.out.print(arr[a][b]);
  }
  System.out.print("\n");
 }
 }

 // a game playing method
 public static void playGame(char[][] board)
 {
  Scanner keyboard = new Scanner( System.in );
    
  // this createst a 2D array indicating what locations are paired, i.e., discovered
  // at the begining none are, so default initializaiton to false is ok 
  boolean[][]discovered=new boolean[board.length][board[0].length]; 
   char star[][] = new char[board.length][board.length];
 
 for (int g=0;g<board.length;g++){
   for(int f=0; f <board.length;f++){
     star[g][f]='*';
     System.out.print(star[g][f]);
   }
   System.out.print("\n");
 }

  int A;
  int B;
  int C;
  int D;
  boolean flag1=true;
  boolean flag2=false;
  int counter = ((board.length)*(board.length))/2;
    while(counter >0){
      System.out.println("Enter the first location");
      A=keyboard.nextInt();
      B=keyboard.nextInt();
      System.out.println("Enter the second location");
      C=keyboard.nextInt();
      D=keyboard.nextInt();
      A=A-1;
      B=B-1;
      C=C-1;
      D=D-1;
      if ((A >= board.length) || (A < 0) || (B >= board.length) || (B < 0) || (C >= board.length) || (C <0) || (D >= board.length) || (D <0))
            {
        System.out.println("You have made an invalid choice.");
      }
      else if(A==C && B==D){
        System.out.println("You have inserted an invalid selection. Please input another coordinate"); 
      }
      else if(discovered[A][B]== true && discovered[C][D]== true){
        System.out.println("The location is invalid.It is already discovered");
      }
      else {
      if(board[A][B] == board[C][D] && discovered[A][B]==false && discovered [C][D]==false){
        star[A][B] = board[A][B];
        star[C][D]= board[C][D];
        discovered[A][B]=true;
        discovered[C][D] = true;
        flag2=true;
        printer(board,star,discovered,A,B,C,D);
      }
      else if (board[A][B] < board[C][D]){
        star[A][B]=board[A][B];
        star[C][D]=board[C][D];
        printer(board,star,discovered,A,B,C,D);
      }
      else if (board[A][B] > board[C][D]){
        star[A][B] = board[A][B];
        star[C][D] = board[C][D];
        printer(board,star,discovered,A,B,C,D);
      }
      if(flag2){
        counter--;
        flag2=false;
      }
    }
  }
    System.out.println("You finished the game! Congratulations!");
 }
 
 public static void printer(char[][]board,char[][]star,boolean[][] discovered,int a,int b,int c,int d){
   Scanner keyboard = new Scanner(System.in);
   if(discovered[a][b] == true && discovered[c][d]==true){
 for (int x=0;x < board.length;x++){
   for(int y=0; y < board.length;y++){
     System.out.print(star[x][y]);
   }
   System.out.print("\n");
 }
}
   else
     for(int x=0;x<board.length;x++){
     for(int y=0;y < board.length;y++){
       System.out.print(star[x][y]);
     }
   System.out.print("\n");
   }
   waitForPlayer();
   for(int k=0; k < board.length;k++){
     for(int h=0; h < board.length;h++){
       if(discovered[k][h]==false){
     star[k][h]='*';
   }
 }
 }
 }

    // createBoard method. DO NOT MODIFY!
 /* this method, createBoard, creates the board filled with letters of alphabet, 
  where each letter appears exactly 2 times
  e.g., for 4 x 4, the returned board would look like:
  A B C D 
  E F G H
  A B C D 
  E F G H */    
 public static char[][] createBoard(int side) 
 {
  char[][] tmp = new char[side][side];
  int letter_count=0;
  for (int row = 0; row < tmp.length/2; row++){
   for(int col = 0; col < tmp[row].length; col++)
   {
    tmp[row][col]=(char)('A'+letter_count);
    tmp[row+tmp.length/2 ][col]=tmp[row][col];
    letter_count++;
   }
  }
  return tmp;
 }

 
   // waitForPlayer method. Do not modify! 
 public static void waitForPlayer()
 {
  System.out.print("Press enter to continue");
  try {
   System.in.read();
  }
  catch (IOException e){
   System.out.println("Error reading from user");
  }
 }
  
}

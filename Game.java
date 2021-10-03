import java.util.Scanner;
import java.util.Random;
class Game
{
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("enter 0 for rock , enter 1 for paper , enter 2 for scissors");
        int userinput = sc.nextInt();

        Random random= new Random();
        int computerinput = random.nextInt(3);

                if (userinput == computerinput)
                {
                    System.out.println("DRAW");
                }


                    else if (userinput==0 && computerinput==2 || userinput==1 && computerinput==0 ||
                        userinput==2 && computerinput==1)
                    {
                        System.out.println("you win");
                    }
else {
                    System.out.println("you lost");
    }
}}
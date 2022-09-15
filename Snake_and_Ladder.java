// package Project;
import java.util.*;
class Snake_and_Ladder
{
    int snake[]={97,92,85,54,43,25};
    int snakeput[]={47,27,40,23,7,10};
    int ladder[]={9,20,48,63,69,34};
    int ladderput[]={50,95,83,90,82,64};
    int pd=0,cd=0;
    public static int dice()
    {
        int min = 1;
        int max = 6;
        double a= Math.floor(Math.random() * (max - min)) + min;
        int d=(int)a;
        return d;
    }

    public static void main(String... arrrr)
    {
        Scanner sc=new Scanner(System.in);
        Snake_and_Ladder ob = new Snake_and_Ladder();
        System.out.println ("\t\t\t\t\t\tWelcome To Snakes And Ladders\n\n");
        System.out.println ("\t\t\t\t\t\t\tInstructions:");
        System.out.println ("\t\t\t This program will simulate a regular snakes and ladders game, where you will be");
        System.out.println ("\t\t\t facing the computer. You and the computer start at square 1, and the first one to");
        System.out.println ("\t\t\t reach square 100 wins, however, there will be preset squares which will be the snakes or ladders.");
        System.out.println ("\t\t\t Once you land on top of a snake you go down a few squares, and move up if you land");
        System.out.println ("\t\t\t on the bottom of a ladder. Good Luck and Have FUN!!!");        
        System.out.print("\nEnter player's name: ");
        String name=sc.next();
        do
        {
            System.out.println("\nReady "+name+"! Press 0 to begin. and 1 to exit");
            int press=sc.nextInt();
            if(press==1)
                break;
            else if(press==0)
                ob.game(press,name);
            else
                System.out.println("Wrong input try again!");
        }while(true);
    }

    public void game(int press,String name)
    {
        Scanner sc=new Scanner(System.in);
        int up=0,cp=0,dice=0;
        for(;;)
        {
            System.out.println("\nPress 1 to play move");
            int move=sc.nextInt();
            System.out.println("\f");    
            if(move==1)
            {
                pd=dice();
                if(up+pd<=100)
                    up+=pd;
                cd=dice();
                if(cp+cd<=100)
                    cp+=cd;
                for(int i=0;i<=5;i++)
                {
                    if(up==snake[i])
                    {
                        up=snakeput[i];                            
                        System.out.println ("\n\n\t\t\t\t~~~~~~~~~~~~~You Got Bit By A Snake, GO DOWN!!!~~~~~~~~~~~~~");
                        break;
                    }
                    else if(up==ladder[i])
                    {
                        up=ladderput[i];                            
                        System.out.println ("\n\n\t\t\t\t~~~~~~~~~~~~~You Got A Ladder!! GO UP!!!~~~~~~~~~~~~~");
                        break;
                    }
                }
                for(int i=0;i<=5;i++)
                {
                    if(cp==snake[i])
                    {
                        cp=snakeput[i];                            
                        System.out.println("\n\n\t\t\t\t~~~~~~~~~~~~~Computer Got Bit By A Snake, HE WENT DOWN!!!~~~~~~~~~~~~~");
                        break;
                    }
                    else if(cp==ladder[i])
                    {
                        cp=ladderput[i];
                        System.out.println("\n\n\t\t\t\t~~~~~~~~~~~~~Computer Got A Ladder!! HE WENT UP!!!~~~~~~~~~~~~~");
                        break;
                    }
                }
                if(up+pd>100)
                    System.out.println ("\n\n\t\t\t\t~~~~~~~~~~~~~OHHH You cant jump, you must land on a 100!!!~~~~~~~~~~~~~");
                else if(cp+cd>100)
                    System.out.println ("\n\n\t\t\t\t~~~~~~~~~~~~~THE COMPUTER CAN'T JUMP!!! He must land on a 100!!!~~~~~~~~~~~~~");
                System.out.println("\n\nYou rolled a "+pd);                    
                System.out.println("Computer rolled a "+cd);
                System.out.println("\t\t\t*************************************************************************");
                System.out.println ("\t\t\t*\t\tYou are currently on square " + up+ "\t\t\t\t*"); 
                System.out.println ("\t\t\t*\t\tThe Computer is currently on square " + cp + "\t\t\t*"); 
                System.out.println("\t\t\t*************************************************************************");
                board(up,cp);
            }
            else if(move!=1)
                System.out.println("Wrong Input");
            if(up==100)
            {
                System.out.println ("\n\n"+name.toUpperCase()+" YOU WON, GOOD JOB!!!");
                break;
            }
            else if(cp==100)
            {
                System.out.println("\n\nTHE COMPUTER WON, YOU FAILED!!! BETTER LUCK NEXT TIME!!!");
                board(up,cp);
                break; 
            }
        }
    }

    public void board(int p1,int p2)
    {
        int a=100, x=a;
        int b=81, y=b;
        for(int j=1;j<=5;j++)
        {
            for(int i=1;i<=10;i++)
            {
                if(x==p1)
                    System.out.print("P1\t");
                else if(x==p2)
                    System.out.print("C1\t");
                else
                    System.out.print(x+"\t");
                x--;
            }
            System.out.println();
            for(int i=1;i<=10;i++)
            {
                if(y==p1)
                    System.out.print("P1\t");
                else if(y==p2)
                    System.out.print("C1\t");
                else
                    System.out.print(y+"\t");
                y++;
            }   
            if(j!=5)
                System.out.println();
            x=x-10;
            y=b;
            y=y-20;
            b-=20;
        }
    }
}


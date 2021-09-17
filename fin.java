package RUSHABH;

/**
 * This program is built for a cinema system which helps to book movie tickets & helps to add & modify the details of the shows..
 */

import java.util.*;

public class fin
{
    //MASTER FILE.

    String mov_name[]={"IT","ANABELLE","DADDY","SIMRAN","AMERICAN ASSASIN","THE HITMAN'S BODYGUARD","BADSHAO","LOGAN LUCKY","TERMINATOR 2","THE NUT JOB 2","","","","",""};
    int hit_rate[]={74,80,75,65,73,94,61,73,75,80,0,0,0,0,0};
    String nature[]={"  HORROR","  HORROR","   CRIME","  ACTION","  ACTION","  ACTION","  ACTION","  ACTION","  ACTION","ANIMATED","","","","",""};
    String allow[]={"UA","AD","UA","AD","UA","UA","AD","AD","UA","UA","","","","",""};
    String lang[]={"ENG","ENG","HIN","HIN","ENG","ENG","HIN","ENG","ENG","ENG","","","","",""};
    String time[]={"6:30pm","1:00pm","5:30pm","9:00am","1:00pm","7:00pm","1:45pm","3:00pm","3:45pm","6:00pm","","","","",""};
    int th_no[]={1,4,2,3,4,4,1,2,5,10,0,0,0,0,0};
    int price[]={250,300,350,100,245,450,320,260,200,400,0,0,0,0,0};
    int no_of_t_avail[]={45,56,78,50,32,46,77,80,21,34,0,0,0,0,0};
    int mov_id[]={1,2,3,4,5,6,7,8,9,10,0,0,0,0,0};

    int conti=0;
    int out=0;
    
    //THE GLOBAL VARIABLES.
    
    String name;            /*To store the name of the customer*/
    String mbno;           /*To store the mobile number*/
    int u=0;                   /*To store the length of the mobile number of the customer*/
    int sx=0;                 /*For city selection*/
    int sy=0;                 /*For cinema category selection*/  
    int date=0;              /*For date selection*/
    int month=0;          /*for month selection*/
    int quantity=0;       /*For no of tickets*/
    int y=0;                  /*For year*/
    int m=0;                /*For month*/
    int d=0;                 /*For date*/
    int sm=0;              /*For selecting the movie*/
    int bill=0;             /*For calculating the bill of the movie*/
    String nm="";      /*For storing the name of the customer*/
    String show_time="";   /*For storing the time of the movie*/

    Scanner in = new Scanner(System.in);

    public static void main()
    {
        int ch;

        fin ob = new fin();

        ob.display_start_1();
        ob.display_start_2();

        do
        {
            System.out.println("\t\t\t\t\t WELCOME TO MAIN MENU");
            System.out.println();
            System.out.println("\t\tPLEASE SELECT YOUR CHOICE");
            System.out.println("\t1. ENQUIRY(ONLY SHOWS THE AVAILABLE MOVIES)");
            System.out.println("\t2. BOOKING");
            System.out.println("\t3. ADD NEW MOVIE");
            System.out.println("\t4. REMOVE OLD MOVIE");
            System.out.println("\t5. MODIFY THE DETAILS OF THE MOVIE");
            System.out.println("\t6. REPORT(BILL DISPLAY)");
            System.out.println("\t7. CANCEL TICKETS");
            System.out.println("\t8. EXIT");

            System.out.print("\tENTER YOUR CHOICE --> ");
            ch = ob.in.nextInt();

            switch(ch)
            {
                case 1:
                ob.enquiry();
                break;

                case 2:
                ob.booking();
                break;

                case 3:
                ob.add_movie();
                break;

                case 4:
                ob.remove();
                break;

                case 5:
                ob.modify();
                break;

                case 6:
                ob.bill();
                break;

                case 7:
                ob.cancel();
                break;

                case 8:
                ob.out=1;
                ob.conti=0;     
                System.out.println("\f");
                System.out.println("\t\t\t\tYOU HAVE EXITED THE SYSTEM.");
                System.out.println("\t\t\t\t   PLEASE VISIT AGAIN.");
                System.out.println("\t\t\t\t        THANK YOU");
                break;

                default:
                System.out.println("SORRY WRONG CHOICE PLEASE SELECT AGAIN");
            }

            if(ob.out==0)
            {
                System.out.println();
                System.out.println();
                
                System.out.println("\t\t\tPRESS 1 TO CONTINUE");
                ob.in.nextInt();
                ob.conti=1;
                
                System.out.println("\f");
            }
        }
        while(ob.conti==1);
    }

    public void delay()
    {
        // Delay loop.
        
        for(double k=1;k<=100000000;k++)
        {

        }
    }

    public void display_start_1()
    {
        //To display the start.

        System.out.println("\f");
        System.out.println("GOLD CINEMAS & EVENTS");
        delay();

        System.out.println("\f");
        System.out.println("     GOLD CINEMAS & EVENTS");
        delay();

        System.out.println("\f");
        System.out.println("             GOLD CINEMAS & EVENTS");
        delay();

        System.out.println("\f");
        System.out.println("                         GOLD CINEMAS & EVENTS");
        delay();

        System.out.println("\f");
        System.out.println("                                      GOLD CINEMAS & EVENTS");
        delay();

    }

    public void display_start_2()
    {
        //To display the start.

        System.out.println("\t\t\t\t WELCOME TO INOX TICKETING SYSTEM");
        System.out.println();
        System.out.println("\t\t\t\t BOOKINGS NOW MADE EASY THROUGH OUR MOBILE APP :");
        System.out.println("\t\t\t*********************MOVIE ZONE**************************");
        System.out.println("\t\t\t\t INTERNET BOOKING ALSO AVAILABLE.");
        System.out.println("\t\t\t\t FOR MORE DETAILS CONTACT 9876532965 FROM YOUR MOBILE");
        System.out.println("\t\t\t\t YOU CAN EASILY CANCEL YOUR TICKETS WITH FULL REFUND");
        System.out.println("\t\t\t\t CATCH THE LATEST MOVIES AT GOLD CINEMAS NEAR YOU");
        System.out.println();
        System.out.println("\t\t\t\t WATCH THE TRAILERS OF ALL LATEST MOVIES AT \"youtube.com\"");
        System.out.println("\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        
    }

    public void enquiry()
    {
        //To display the details of the movies

        int i;

        System.out.println();
        System.out.println("UA --> ADULTS & CHILDREN");
        System.out.println("AD --> ADULTS ONLY");
        System.out.println();

        System.out.println("\f");
        
        System.out.println("MOVIE ID\tUA/A/U\t\tLANG\tTIME\tCOST\t\tNO OF SEATS AVAILABLE\t MOVIE");
        System.out.println();

        for(i=0;i<15;i++)
        {
            if(mov_id[i]!=0)
            {
                System.out.println(mov_id[i]+"\t\t"+allow[i]+"\t\t"+lang[i]+"\t"+time[i]+"\t"+price[i]+"\t\t"+no_of_t_avail[i]+"\t\t\t"+mov_name[i]);
            }
        } 
        
        System.out.println();
        System.out.println();
        
        System.out.println("NOTE : AFTER QUITTING BOOKING THE TICKETS,PRESS 6 IN THE MAIN MENU");
    }

    public void booking()
    {
        // Booking part of the program.
        
        System.out.println("\f");
        System.out.println("\t\t\t\t*****WELCOME TO THE BOOKING SECTION*****");
        System.out.println();

        boolean flag=true;
        String ch="";

        do
        {
            flag=true;

            //city choice

            System.out.println("ENTER YOUR CITY");
            System.out.println("ENTER 1 FOR MUMBAI");
            System.out.println("ENTER 2 FOR KOLKATA");
            System.out.println("ENTER 3 FOR PUNJAB");
            System.out.println("ENTER 4 FOR CHENNAI");
            System.out.println("ENTER 5 FOR DELHI");
            System.out.println("ENTER 6 FOR UTTAR PRADESH");
            System.out.println("ENTER 7 FOR CHANDIGARH");
            System.out.println("ENTER 8 FOR BANGLORE");
            System.out.println("ENTER 9 FOR HYDERABAD");
            System.out.println("ENTER 10 FOR AHEMDABAD");
            System.out.println("ENTER YOUR CHOICE");

            sx=in.nextInt();

            switch(sx)
            {
                case 1:
                System.out.println("MUMBAI");
                break;
                
                case 2:
                System.out.println("KOLKATA");
                break;
                
                case 3:
                System.out.println("PUNJAB");
                break;
                
                case 4:
                System.out.println("CHENNAI");
                break;
                
                case 5:
                System.out.println("DELHI");
                break;
                
                case 6:
                System.out.println("UTTAR PRADESH");
                break;
                
                case 7:
                System.out.println("CHANDIGARH");
                break;
                
                case 8:
                System.out.println("BANGLORE");
                break;
                
                case 9:
                System.out.println("HYDERABAD");
                break;
                
                case 10:
                System.out.println("AHEMDABAD");
                break;
                
                default:
                System.out.println("SORRY WRONG CHOICE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                flag=false;
                break;
            }        
            
            if(flag==true)
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                System.out.println("PLEASE PRESS 'FS' TO CLEAR SCREEN FOR NEXT WINDOW");    
                String f1=in.next(); 
                if(f1.equalsIgnoreCase("FS"))
                {
                    System.out.println("\f");
                }

                //cinema type choice

                System.out.println("\t\t\t\tWELCOME TO CATEGORY SELECTION\t\t\t\t\t");
                System.out.println();
                System.out.println("ENTER 1 FOR GOLD CINEMAS");
                System.out.println("ENTER 2 FOR CLASSIC CINEMAS");
                System.out.println("ENTER YOUR CHOICE");

                sy=in.nextInt();

                switch(sy)
                {
                    case 1:
                    System.out.println("YOU CHOSE GOLD CINEMAS");
                    break;
                    
                    case 2:
                    System.out.println("YOU CHOSE CLASSIC CINEMAS ");
                    break;
                    
                    default:
                    System.out.println("SORRY WRONG CHOICE!!");
                    flag=false;
                    break;
                }

            }
            
            if(flag==true)
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                System.out.println("PLEASE PRESS 'FS' TO CLEAR SCREEN FOR NEXT WINDOW");
                String f2=in.next();
                if(f2.equalsIgnoreCase("FS"))
                {
                    System.out.println("\f");
                }

                // date selection.
                
                System.out.println("\t\t\t\tWELCOME TO DATE SELECTION\t\t\t\t\t");
                
                System.out.println();
                
                System.out.println("ENTER THE YEAR IN yyyy FORMAT");
                y=in.nextInt();
                System.out.println("ENTER THE MONTH IN mm FORMAT");
                m=in.nextInt();
                System.out.println("ENTER THE DATE IN dd FORMAT");
                d=in.nextInt();
                
                if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)
                {
                    if(d<0||d>32)
                    {
                        System.out.println("You have entered an invalid date");
                        
                        flag= false;
                    }
                }
                
                if(m==2)
                {
                    if(d<0||d>30&&y%4!=0)
                    {
                        System.out.println("You have entered an invalid date");
                        
                        flag= false;
                    }
                    
                    if(d<0||d>29&&y%4==0)        
                    {
                        System.out.println("You have entered an invalid date");
                        
                        flag= false;
                    }
                }
                
                if(m==4||m==6||m==9||m==11)
                {
                    if(d<0||d>31)
                    {
                        System.out.println("You have entered an invalid date");
                        
                        flag= false;
                    }
                }
                
            }
            
            if(flag==true)
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                
                in.nextLine();
                System.out.println("PLEASE PRESS 'FS' TO CLEAR SCREEN FOR NEXT WINDOW");
                String f3=in.nextLine();
                
                if(f3.equalsIgnoreCase("FS"))
                {
                    System.out.println("\f");
                }

                // Movie selection

                int i=0;
                
                System.out.println("\t\t\t\t<<<<<< WELCOME TO MOVIE SELECTION >>>>>>");
                System.out.println();
                System.out.println("\t\t\t******************** NOW SHOWING ********************");
                System.out.println();
                System.out.println("MOVIE ID\tUA/A/U\t\tLANG\tTIME\tCOST\t\tNO OF SEATS AVAILABLE\t MOVIE");
                System.out.println();

                for(i=0;i<15;i++)
                {
                    if(mov_id[i]!=0)
                    {
                        System.out.println(mov_id[i]+"\t\t"+allow[i]+"\t\t"+lang[i]+"\t"+time[i]+"\t"+price[i]+"\t\t"+no_of_t_avail[i]+"\t\t\t"+mov_name[i]);
                    }
                }
                System.out.println();
                
                System.out.println("ENTER THE MOVIE ID");
                m=in.nextInt();
                
                if(mov_id[m-1]==0)
                {
                    flag=false;
                }
                
                if(flag==true)
                {
                    nm=mov_name[m-1];
                    show_time=time[m-1];
                    bill=price[m-1];

                    // Enter no of tickets.
                    
                    System.out.println();
                    System.out.println();
                    
                    System.out.println("\t\t\t\t<<<<<       PLEASE ENTER THE NUMBER OF TICKETS YOU WANT       >>>>>");
                    System.out.println();
                    System.out.println("ENTER THE NUMBER OF TICKETS YOU WANT");
                    System.out.println("THE NUMBER OF TICKETS CAN BE BETWEEN 1 TO 20");
                    quantity=in.nextInt();

                    if(quantity>=21)
                    {
                        System.out.println("SORRY YOU CANNOT GET MORE THAN 20 TICKETS ");
                        System.out.println("IF YOU WANT MORE THAN 20 TICKETS THEN CONTACT <<9876532965>>");
                    }
                    
                    if(no_of_t_avail[m-1]<quantity)
                    {
                        System.out.println("SORRY THERE ARE LESS TICKETS LEFT");
                    }   

                    while(quantity>21||no_of_t_avail[m-1]<quantity)
                    {
                        System.out.println("PLEASE ENTER THE NUMBER OF TICKETS YOU WANT");
                        System.out.println("THE NUMBER OF TICKETS CAN BE BETWEEN 1 TO 20");
                        quantity=in.nextInt();
                    }

                    no_of_t_avail[m-1]=no_of_t_avail[m-1]-quantity;
                    bill=bill*quantity;
                    
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    
                    in.nextLine();
                    System.out.println("PLEASE PRESS 'FS' TO CLEAR SCREEN FOR NEXT WINDOW");
                    String f4=in.nextLine();
                    
                    if(f4.equalsIgnoreCase("FS"))
                    {
                        System.out.println("\f");
                    }
                }
                
            }  
            
            if(flag==true)
            {   
                //enter details.
                
                System.out.println("PLEASE ENTER YOUR NAME");            
                name=in.nextLine();                     //To accept the name.
                name=name.toUpperCase();
                
                while(true)
                {
                    System.out.println("PLEASE ENTER YOU MOBILE NUMBER");
                    mbno = in.nextLine();               //To accept the mobile number.

                    u=mbno.length();
                    
                    if(u>10 || u<10)
                    {
                        System.out.println();
                        System.out.println("\t\tINVALID PHONE NUMBER.");
                        System.out.println("\t\tYOUR PHONE NUMBER SHOULD HAVE EXACTLY 10 DIGITS.");
                        System.out.println("\t\tPLEASE RE ENTER YOUR PHONE NUMBER.");
                        continue;
                    }
                    else
                    {
                        break;
                    }
                }

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                
                System.out.println("PLEASE PRESS 'FS' TO CLEAR SCREEN FOR NEXT WINDOW");
                String f6=in.nextLine();
                
                if(f6.equalsIgnoreCase("FS"))
                {
                    System.out.println("\f");
                }

                // collect bill.

                System.out.println("****************THIS IS YOUR ROUGH BIL****************");
                System.out.println("NAME OF THE MOVIE : "+nm);
                System.out.println("DATE : "+d+"/"+m+"/"+y);
                System.out.println("TIME : "+show_time);
                System.out.println("NAME OF THE PERSON : "+name);
                System.out.println("MOBILE NUMBER : "+mbno);
                System.out.println("YOU CAN NOW UPGRADE YOUR MOVIE TO 3D BY PAYING RUPEES 100 EXTRA");
                System.out.println("DO YOU WANT TO UPGRADE TO 3D(YES/NO)");
                String u=in.nextLine();

                if(u.equalsIgnoreCase("YES"))
                {
                    bill=bill+(quantity*100);
                }
                System.out.println("TOTAL BILL = RUPEES "+bill);

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                System.out.println("PLEASE PRESS 'FS' TO CLEAR SCREEN FOR NEXT WINDOW");
                String f7=in.nextLine();
                
                if(f7.equalsIgnoreCase("FS"))
                {
                    System.out.println("\f");
                }

                System.out.println("\t\t<<<<<<< UPCOMING MOVIES >>>>>>>");

                System.out.println("PRESS KEY    NAME                                 LANGUAGE        RATING");
                System.out.println("    1.      MAATR                                  HINDI            U/A ");
                System.out.println("    2.     JISM 4                                  HINDI             A ");
                System.out.println("    3.     LOGAAN                                 ENGLISH            A  ");
                System.out.println("    4.     A DOG'S PURPOSE                        ENGLISH           U/A ");
                System.out.println("    5.     DEADPOOL 2                             ENGLISH            A ");
                System.out.println("    6.     AISI                                   TELEGU             A  ");
                System.out.println("    7.     AADHVAN 2                               TAMIL            U/A ");
                System.out.println("    8.     SPIDER MAN                             ENGLISH           U/A ");
                System.out.println();

                System.out.println("YOU CAN NOW WATCH THE TRAILERS OF THESE MOVIES ON OUR SITE: ");
                System.out.println("<<<<<<<<<<<<<<<<<www.GOLD CINEMA.com>>>>>>>>>>>>>>>>>");

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();

                System.out.println("PLEASE PRESS 'FS' TO CLEAR SCREEN FOR NEXT WINDOW");
                String f8=in.nextLine();
                
                if(f8.equalsIgnoreCase("FS"))
                {
                    System.out.println("\f");
                }

                bill();

                System.out.println("DO YOU WANT TO BUY MORE TICKETS Y/N");
                ch=in.nextLine();
            } 
            
            if(flag==false)
            {   
                System.out.println("DUE TO INVALID ENTRY RESTARTING THE SYSTEM");
                System.out.print("RESTARTING **");
                for(int i=0;i<1000000000;i++)
                {
                    if(i%100000000==0)
                    {
                        System.out.print("*");
                    }
                }
            }
            
            System.out.println("\f");
            
        }while(flag==false||ch.equalsIgnoreCase("y"));

        System.out.println();
    }     

    public void add_movie()
    { 
        System.out.println("\f");
        
        System.out.println("\t\t\t\tWELCOME TO ADD MOVIE SECTION");

        int m_id;         //To store new movie id.
        String m_name;    //To store new movie name.
        int h_r;          //To store new hit rate.
        String nat;       //To store the new nature.
        String all;       //To storte the new allowance.
        String language;  //To store the new language.
        String time_1;    //To store the new time.
        int thno;         //To store the new theatre number.
        int price__;      //To store the new price.
        int no_of_avail;  //To store the new no of seats available.

        int i;
        
        for(i=0;i<mov_id[i];i++)
        {
            if(mov_id[i]==0)
            {
                break;
            }
        }

        System.out.println("YOUR NEW MOVIE ID = "+(i+1));
        m_id=(i+1);
        mov_id[i+1]=m_id;
        
        in.nextLine();
        System.out.println("ENTER THE MOVIE NAME");
        m_name=in.nextLine();
        m_name=m_name.toUpperCase();
        
        System.out.println("ENTER THE MOVIE HIT RATE");
        h_r=in.nextInt();

        in.nextLine();
        System.out.println("ENTER THE MOVIE NATURE");
        nat=in.nextLine();
        nat=nat.toUpperCase();
        
        System.out.println("ENTER THE ALLOWANCE");
        all=in.nextLine();
        all=all.toUpperCase();
        
        System.out.println("ENTER THE LANGUAGE");
        language=in.nextLine();
        language=language.toUpperCase();
        
        System.out.println("ENTER THE MOVIE TIME");
        time_1=in.nextLine();
        time_1=time_1.toUpperCase();
        
        System.out.println("ENTER THE THEATRE NO");
        thno=in.nextInt();

        System.out.println("ENTER THE PRICE");
        price__=in.nextInt();

        System.out.println("ENTER THE NO OF TICKETS AVAILABLE");
        no_of_avail=in.nextInt();

        mov_name[m_id]=m_name;
        hit_rate[m_id]=h_r;
        nature[m_id]=nat;
        allow[m_id]=all;
        lang[m_id]=language;
        time[m_id]=time_1;
        th_no[m_id]=thno;
        price[m_id]=price__;
        no_of_t_avail[m_id]=no_of_avail;
        
        System.out.println("\f");
        System.out.println("MOVIES AFTER ADDITION");
        System.out.println("MOVIE ID\tUA/A/U\t\tLANG\tTIME\tCOST\t\tNO OF SEATS AVAILABLE\t MOVIE");
        
        System.out.println();

        for(i=0;i<15;i++)
        {
            if(mov_id[i]!=0)
            {
                System.out.println(mov_id[i]+"\t\t"+allow[i]+"\t\t"+lang[i]+"\t"+time[i]+"\t"+price[i]+"\t\t"+no_of_t_avail[i]+"\t\t\t"+mov_name[i]);
            }
        }        
    }

    public void bill()
    {
        // BILL COLLECTION.

        System.out.println("\f");

        System.out.println("\t\t\t\t***********PLEASE COLLECT YOUR BILL************");
        System.out.println();
        System.out.println("\t\tNAME OF THE CUSTOMER : "+name);
        System.out.println("\t\tNAME OF THE MOVIE : "+nm);
        System.out.println("\t\tDATE : "+d+"/"+m+"/"+y);
        System.out.println("\t\tTIME : "+show_time);
        System.out.println("\t\tMOBILE NUMBER : "+mbno);
        System.out.println("\t\tYOUR SEAT NUMBER'S ARE :");
        System.out.println();

        int i;
        for(i=1;i<=quantity;i++)
        {
            System.out.println("\t\t\tLG"+(30+i)+" ");
        }
        
        System.out.println("\t\tPRICE EXCLUDING GST : "+bill);
        System.out.println("\t\tC GST : "+(bill)*9.0/100);
        System.out.println("\t\tS GST : "+(bill)*9.0/100);
        System.out.println("\t\tTOTAL GST : "+(bill)*18.0/100);
        System.out.println("\t\tPRICE INCLUDING GST : "+(bill+(bill)*18.0/100));
        System.out.println("\t\tCATCH THE LATEST MOVIES AND SHOWS AT GOLD CINEMAS NEAR YOU");
        System.out.println("\t\tYOU CAN EVEN BOOK YOUR TICKETS USING OUR MOBILE APP");
        System.out.println("\t\tTHANK YOU .  PLEASE VISIT AGAIN");
        System.out.println();
        System.out.println("\t\tTERMS & CONDITIONS ....");        
        System.out.println("\t\t50% OF THE AMOUNT WILL BE REEFUNDED ON CANCELATION");
        System.out.println("\t\tYOU CANNOT CANCEL THE TICKETS.");
        System.out.println("\t\tTHIS TICKETING SYSTEM IS ACCORDING TO THE LATEST GST MODIFICATIONS");
        System.out.println("\t\tYOU CANNOT AVAIL ANY DISCOUNT ON THE PRICES.");
        System.out.println("\t\tPLEASE PRINT THE HARD COPY OF THE BILL AFTER BOOKING");     
        System.out.println();
        System.out.println("\t\t\t\tTHANK YOU");
    }

    public void remove()
    {
        System.out.println("\f");
        
        System.out.println("\t\t\t\tWELCOME TO REMOVE MOVIE SECTION");
        System.out.println("MOVIE ID \tUA/A/U\t\tLANG\tTIME\tCOST\t\tNO OF SEATS AVAILABLE\t MOVIE");
        System.out.println();
        
        int i=0;
        
        for(i=0;i<15;i++)
        {
            if(mov_id[i]!=0)
            {
                System.out.println(mov_id[i]+"\t\t"+allow[i]+"\t\t"+lang[i]+"\t"+time[i]+"\t"+price[i]+"\t\t"+no_of_t_avail[i]+"\t\t\t"+mov_name[i]);
            }
        }      
        
        int dm;
        
        in.nextLine();
        System.out.println("ENTER THE MOVIE ID");
        dm=in.nextInt();
        
        dm=dm-1;
        
        mov_name[dm]="";
        hit_rate[dm]=0;
        nature[dm]=" ";
        allow[dm]=" ";
        lang[dm]=" ";
        time[dm]=" ";
        th_no[dm]=0;
        price[dm]=0;
        no_of_t_avail[dm]=0;
        mov_id[dm]=0;
        
        System.out.println("\f");
        System.out.println("MOVIES AFTER REMOVAL");
        System.out.println("MOVIE ID\tUA/A/U\t\tLANG\tTIME\tCOST\t\tNO OF SEATS AVAILABLE\t MOVIE");
        System.out.println();
        for(i=0;i<15;i++)
        {
            if(mov_id[i]!=0)
            {
                System.out.println(mov_id[i]+"\t\t"+allow[i]+"\t\t"+lang[i]+"\t"+time[i]+"\t"+price[i]+"\t\t"+no_of_t_avail[i]+"\t\t\t"+mov_name[i]);
            }
        }        
    }

    public void modify()
    {
        System.out.println("\f");
        System.out.println("\t\t\t\tWELCOME TO MODIFY MOVIE DETAILS SECTION");
        int i=0;
        
        System.out.println("MOVIE ID\tUA/A/U\t\tLANG\tTIME\tCOST\t\tNO OF SEATS AVAILABLE\t MOVIE");
        System.out.println();
        for(i=0;i<15;i++)
        {
            if(mov_id[i]!=0)
            {
                System.out.println(mov_id[i]+"\t\t"+allow[i]+"\t\t"+lang[i]+"\t"+time[i]+"\t"+price[i]+"\t\t"+no_of_t_avail[i]+"\t\t\t"+mov_name[i]);
            }
        }
        
        String m;
        int pr;   // To store the new price of the movie.
        int t;    // To store the new no of tickets available.
        int x;    // To store the id.
        String l; // To store the laguage.
        String a; // To store UA/A.
        
        System.out.println("ENTER THE MOVIE ID");
        x=in.nextInt();
        
        System.out.println("ENTER THE MOVIE NAME");
        m=in.nextLine();
        m=in.nextLine();
        m=m.toUpperCase();
        
        System.out.println("ENTER THE PRICE");
        pr=in.nextInt();
        
        System.out.println("ENTER THE LANGUAGE");
        l=in.nextLine();
        l=in.nextLine();
        l=l.toUpperCase();
        
        System.out.println("ENTER THE ALLOWANCE");
        a=in.nextLine();
        a=a.toUpperCase();
        
        System.out.println("ENTER THE NO OF TICKETS AVAILABLE");
        t=in.nextInt();
        
        i=x-1;
        
        mov_name[i]=m;                
        price[i]=pr;
        no_of_t_avail[i]=t;
        lang[i]=l;
        allow[i]=a;
        
        System.out.println("\f");
        System.out.println("DETAILS OF THE MOVIES AFTER MODIFICATION");
        System.out.println("MOVIE ID\tUA/A/U\t\tLANG\tTIME\tCOST\t\tNO OF SEATS AVAILABLE\t MOVIE");
        System.out.println();
        
        for(i=0;i<15;i++)
        {
            if(mov_id[i]!=0)
            {
                System.out.println(mov_id[i]+"\t\t"+allow[i]+"\t\t"+lang[i]+"\t"+time[i]+"\t"+price[i]+"\t\t"+no_of_t_avail[i]+"\t\t\t"+mov_name[i]);
            }
        }        
    }

    public void cancel()
    {
        System.out.println("\f");
        System.out.println("\t\t\t\tWELCOME TO CANCEL MOVIE DETAILS SECTION");
        
        int i=0;
        
        System.out.println("MOVIE ID\tUA/A/U\t\tLANG\tTIME\tCOST\t\tNO OF SEATS AVAILABLE\t MOVIE");
        System.out.println();
        
        for(i=0;i<15;i++)
        {
            if(mov_id[i]!=0)
            {
                System.out.println(mov_id[i]+"\t\t"+allow[i]+"\t\t"+lang[i]+"\t"+time[i]+"\t"+price[i]+"\t\t"+no_of_t_avail[i]+"s\t\t\t"+mov_name[i]);
            }
        }
        
        System.out.println();
        System.out.println("ENTER THE ID OF THE MOVIE WHICH YOU WANT TO CANCEL TICKETS");
        int id=in.nextInt();
        
        System.out.println("ENTER THE NO OF TICKETS YOU WANT TO CANCEL");
        int z=in.nextInt();
        
        no_of_t_avail[id-1]=no_of_t_avail[id-1]+z;
        
        System.out.println("ENTER YOUR NAME");
        String nam=in.next();
        nam=nam.toUpperCase();
        
        String mno;
        while(true)
        {
            System.out.println("PLEASE ENTER YOU MOBILE NUMBER");
            mno=in.nextLine();               //To accept the mobile number from the user.
            mno=in.nextLine();
            int len=mno.length();
            
            if(len>10 || len<10 )
            {
                System.out.println();
                System.out.println("\t\tINVALID PHONE NUMBER.");
                System.out.println("\t\tYOUR PHONE NUMBER SHOULD HAVE EXACTLY 10 DIGITS.");
                System.out.println("\t\tPLEASE RE ENTER YOUR PHONE NUMBER.");
                
                continue;
            }
            else
            {
                break;
            }
        }
        
        double refund=(price[id-1]/2)*z;
        
        System.out.println("\f");
        System.out.println("\t\t\t\t<<<<< REFUND BILL >>>>>");
        System.out.println();
        System.out.println("\t\t\t\tNAME          :"+nam);
        System.out.println("\t\t\t\tMOBILE NO     :"+mno);
        System.out.println("\t\t\t\tMOVIE         :"+mov_name[id]);
        System.out.println("\t\t\t\tTIME          :"+time[id]);
        System.out.println("\t\t\t\tREFUND AMOUNT :"+refund);
    }
}


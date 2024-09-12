import java.util.Scanner;

//An interface is created to take the account details  from the main class to check the details
interface Account_details{
    public int getdetails(int acc_no,int pin_no);
}
//A class CheckDetails is made to implement the interface and take the input of the account details to check
class CheckDetails implements Account_details{
    int c = 0;
    //The function getdetails get the details from the user and verifies them using the database given. Here only five different accounts
    //are considered for simplicity of the code. the account number is first verified and if it matches to the given database 
    //then the pin number corresponding to the account number is verified using if else conditional statement.
    public int getdetails(int acc_no, int pin_no){
        if(acc_no == 12345){
            if(pin_no == 23456){
                c = 1;
            }
        }
        else if(acc_no == 23456){
            if(pin_no == 34567){
                c = 1;
            }
        }
        else if(acc_no == 34567){
            if(pin_no == 45678){
                c = 1;
            }
        }
        else if(acc_no == 45678){
            if(pin_no == 56789){
                c = 1;
            }
        }
        else if(acc_no == 56789){
            if(pin_no == 67891){
                c = 1;
            }
        }
        //After verification the status is returned to the main class.
        if(c == 1){
            return 1;
        }
        else{
            return 0;
        }
    }
}
//the class money is made to find the amount required for the user to either withdraw or deposit and for different denominations
class money{
    Scanner s = new Scanner(System.in);
    public int total(){
        System.out.println("enter number of 100 rupee notes");
        int x = s.nextInt();
        System.out.println("enter number of 500 rupee notes");
        int y = s.nextInt();
        System.out.println("enter number of 1000 rupee notes");
        int z = s.nextInt();
        //The total amount is returned to the main class 
        return x*100 + y*500 + z*1000 ;
    }
}

public class ATM{
    public static void main(String [] args){
        
        try (Scanner s = new Scanner(System.in)) {
            int balance =0;
            int acc_no = 0;
            int pin_no =0;
            int[] arr = {10000, 10000, 10000, 10000, 10000 };
            //the code is made to run for the five default users and the bank balance will be updated accordingly
            for(int j=0; j<5; j++){
                //the main class first takes the user details i.e account number and pin number
                int check = 1;
                while(check <= 5){
                    
                    System.out.println("WELCOME");
                    System.out.println("PLEASE ENTER YOUR ACCOUNT DETAILS");
                    System.out.println("ACCOUNT NUMBER:");
                    acc_no = s.nextInt();
                    System.out.println("PIN NUMBER");
                    pin_no = s.nextInt();
                    //The class checkdetails is declared to check the details of the user
                    CheckDetails a = new CheckDetails();
                    //the status of the account details is returned from the method getdetails that is called.
                    //If the user didn't enter the right details then display is shown as invalid and the process repeates again to enter valid details
                    //The user can enter wrong details only 5 times 
                    if(a.getdetails(acc_no, pin_no)!= 1){
                        System.out.println("invalid user details.please try again");
                        check = check + 1;
                    }
                    else{
                        check = 7;
                    }
                }
                //If the user enters wrong details for 5 times then the user cannot access the atm and it is displayed that they have invalid account.
                if(check == 6){
                    System.out.println("USER HAVE A INVALID ACCOUNT");
                }
                //After verifying the account details the user can access their account and do the actions they want to do with their account
                else{     
                    //the user needs to choose their account type and if the account type is correct then they can proceed for furthur operations
                    System.out.println("choose your account type");
                    System.out.println("1.Savings account");
                    System.out.println("2.Current account");
                    System.out.println("3.Fixed deposit account");
                    int check_type = s.nextInt();
                    int acc_type = 0;
                    if(acc_no == 12345){
                        acc_type = 1;
                    }
                    else if(acc_no == 23456){
                        acc_type = 2;
                    }
                    else if(acc_no == 34567){
                        acc_type = 3;
                    }
                    else if(acc_no == 45678){
                        acc_type = 1;
                    }
                    else if(acc_no == 56789){
                        acc_type = 2;
                    }
                    if(check_type == acc_type){
                        int k = 1;
                        while(k>0){
                            if(acc_type == 1 || acc_type == 2 || acc_type == 3){
                                //The user can do the following actions to their account
                                //1.View their balance
                                //2.withdraw the amount
                                //3.deposit their funds
                                System.out.println("choose what you want to do with the account");
                                System.out.println("1. View my balance");
                                System.out.println("2. Withdrawal amount");
                                System.out.println("3. Deposit funds");
                                int action = s.nextInt();
                                //A default amount of 10000Rs is considered as initial balance of all 5 users
                                //the users are given order and the balance of the user account is taken from the array initially
                                // given as default
                                if(acc_no == 12345){
                                    balance = arr[0];
                                }
                                else if(acc_no == 23456){
                                    balance = arr[1];
                                }
                                else if(acc_no == 34567){
                                    balance = arr[2];
                                }
                                else if(acc_no == 45678){
                                    balance = arr[3];
                                }
                                else if(acc_no == 56789){
                                    balance = arr[4];
                                }
                                //After the action is chosen the process will be run accordingly
                                if(action == 1){
                                    System.out.println(balance);
                                }
                                else{
                                    //The class money is run to take number of notes for different denominations and add the amount to either withdraw or deposit 
                                    money b = new money();
                                    int sum = b.total();
                                    if(action == 2){
                                        if(sum> balance){
                                            // If the amount needed to be withdrawn is more than the balance of the user they are given alert of the condition.
                                            System.out.println("Invalid amount. Cannot withdraw the amount!");
                                        }
                                        else{
                                            //if the amount user needs to withdraw is less than the balance then a confirmation message is displayed.
                                            System.out.println("an amount of "+sum + " has been withdrawn successfully");
                                            balance = balance - sum;
                                        }
                                    }
                                    else if(action == 3){
                                        System.out.println("an amount of "+sum + " has been deposited successfully");
                                        balance = balance + sum;
                                    }
                                }
                                //later the balance of the particular user is updated into the array of balance of the users
                                if(acc_no == 12345){
                                    arr[0] = balance;
                                }
                                else if(acc_no == 23456){
                                    arr[1] = balance;
                                }
                                else if(acc_no == 34567){
                                    arr[2] = balance;
                                }
                                else if(acc_no == 45678){
                                    arr[3] = balance;
                                }
                                else if(acc_no == 56789){
                                    arr[4] = balance;
                                }
                            }
                            //The user of the account is asked if they want to continue working with their account or not and the process can be repeated again.
                            System.out.println("press 1 if you want to continue/ press 0 if you want to end");
                            int repeat = s.nextInt();
                            if(repeat == 1){
                                k = 1;
                                continue;
                            }
                            else{
                                System.out.println("THANK YOU!");
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("INVALID ACCOUNT TYPE");
                    }
                }
            }
        }
    }
}


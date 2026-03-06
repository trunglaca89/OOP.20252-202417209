import java.util.Scanner;

public class DaysInMonth{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        boolean isValidInput = false;

        while (!isValidInput){
            System.out.print("Enter a month: ");
            String monthInput = keyboard.next().toLowerCase();
            
            System.out.print("Enter a year: ");
            if (keyboard.hasNextInt()){
                int year = keyboard.nextInt();
                
                if(year >= 0){
                    // Chuyển chuỗi nhập vào thành số tháng ngay trong main
                    int month = -1;
                    switch (monthInput){
                        case "1": case "january": case "jan.": case "jan": month = 1; break;
                        case "2": case "february": case "feb.": case "feb": month = 2; break;
                        case "3": case "march": case "mar.": case "mar": month = 3; break;
                        case "4": case "april": case "apr.": case "apr": month = 4; break;
                        case "5": case "may": month = 5; break;
                        case "6": case "june": case "jun": month = 6; break;
                        case "7": case "july": case "jul": month = 7; break;
                        case "8": case "august": case "aug.": case "aug": month = 8; break;
                        case "9": case "september": case "sept.": case "sep": month = 9; break;
                        case "10": case "october": case "oct.": case "oct": month = 10; break;
                        case "11": case "november": case "nov.": case "nov": month = 11; break;
                        case "12": case "december": case "dec.": case "dec": month = 12; break;
                    }
                    
                    if(month != -1){
                        isValidInput = true; // Input đúng thì thoát vòng lặp
                        
                        // Kiểm tra năm nhuận
                        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                        int days = 0;
                        
                        // Tính ngày
                        if(month == 2){
                            days = isLeapYear ? 29 : 28;
                        }else if(month == 4 || month == 6 || month == 9 || month == 11){
                            days = 30;
                        }else{
                            days = 31;
                        }
                        
                        System.out.println("The month " + monthInput + " in year " + year + " has " + days + " days.");
                    }else{
                        System.out.println("Please try again.\n");
                    }
                }else{
                    System.out.println("Please try again.\n");
                }
            }else{
                System.out.println("Please try again.\n");
                keyboard.next();
            }
        }
        keyboard.close();
    }
}

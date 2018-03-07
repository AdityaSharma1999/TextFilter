import java.util.Scanner;
public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); System.out.println("Welcome to TextFilter!");boolean keepFiltering;
        do{ System.out.println("Please select one of the following filtering options: \n");
            System.out.println("1. Filter Word\n" +"2. Find-And-Replace\n"+"3. Censor Information"); int choice = scanner.nextInt();
            scanner.nextLine();String passage="";
            if (choice == 1) {
                System.out.println("Please enter the passage you would like filtered: "); passage=scanner.nextLine(); String word; 
                System.out.println("Please enter the word you would like to censor: "); word=scanner.nextLine();
                System.out.println("Uncensored: "); System.out.println(passage); String parsedPassage="";
                for(int j=0;j<word.length();j++) { parsedPassage=parsedPassage+"X"; } passage=" "+passage+" ";
                String pehlaWord=" "+word+"."; String dosraWord=" "+word+"?"; String teesraWord=" "+word+","; String chauthaWord=" "+word+"!"; String pachwaWord=" "+word+" ";
                if(passage.contains(pachwaWord)) { passage=passage.replace(pachwaWord," "+parsedPassage); }
                if(passage.contains(pehlaWord)) { passage=passage.replace(pehlaWord," "+parsedPassage+"."); }
                if(passage.contains(dosraWord)){ passage=passage.replace(dosraWord," "+parsedPassage+"?"); }
                if(passage.contains(teesraWord)) { passage=passage.replace(teesraWord," "+parsedPassage+","); }
                if(passage.contains(chauthaWord)) { passage=passage.replace(chauthaWord," "+parsedPassage+"!"); } passage=passage.trim();
                System.out.println("Censored: "); System.out.println(passage);
            } else if (choice == 2) {
                System.out.println("Please enter the passage you would like filtered: "); passage=scanner.nextLine();String replace;  
                System.out.println("Please enter the word you would like to replace: "); replace=scanner.nextLine();String insert;  
                System.out.println("Please enter word you would like to insert: "); insert=scanner.nextLine();
                System.out.println("Uncensored: "); System.out.println(passage);passage=passage.replaceAll(replace,insert);
                System.out.println("Censored: "); System.out.println(passage);
            } else if (choice == 3) {
                System.out.println("Please enter the phrase you would like to censor information from: ");
                while (true) { String temp = scanner.nextLine(); if (!passage.isEmpty() && temp.isEmpty()) { break; }
                    else if (passage.isEmpty() && temp.isEmpty()) { continue; } passage += temp;passage += '\n'; }
                System.out.println("Uncensored: "); System.out.println(passage); String newPassage=""; String arr[]=passage.split("\\n+");
                for(int i=0;i<arr.length;i++) { if(arr[i].charAt(0)=='N') { char arr1[]=arr[i].toCharArray();
                        for(int j=7;j<arr1.length-1;j++) { if(arr1[j]!=' ') { arr1[j]='*'; } } arr[i]="";
                        for(int x=0;x<arr1.length;x++) { arr[i]=arr[i]+arr1[x]; } }
                    if(arr[i].charAt(0)=='E') { char arr2[]=arr[i].toCharArray();int attherate=0; int dot=0;
                        for(int j=8;j<arr2.length-4;j++) { if(arr2[j]=='@') { attherate=j; } }
                        for(int j=8;j<arr2.length;j++) { if(arr2[j]=='.') { dot=j; } }
                        for(int j=8;j<dot;j++) { if(!(j==attherate||j==attherate+1)) {  arr2[j]='*'; } } arr[i]="";
                        for(int x=0;x<arr2.length;x++) { arr[i]=arr[i]+arr2[x]; } }
                    if(arr[i].charAt(0)=='P') {  char arr3[]=arr[i].toCharArray();
                        for(int t=7;t<arr3.length-5;t++) { if(arr3[t]!='-') {  arr3[t]='*'; } }arr[i]="";
                        for(int x=0;x<arr3.length;x++) { arr[i]=arr[i]+arr3[x]; } }
                    newPassage=newPassage+arr[i]+"\n"; }
                System.out.println("Censored: "); System.out.println(newPassage);
            } else { System.out.println("The option you chose was invalid!"); }
            System.out.println("Would you like to keep filtering? Yes/No"); String reply="";
            do { keepFiltering = false; reply=scanner.nextLine().toLowerCase();
                if(reply.equals("yes")) { keepFiltering=true; } }while(reply.length()==0);
        }while (keepFiltering);
        System.out.println("Thank you for using TextFilter!"); 
} }

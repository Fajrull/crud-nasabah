package com.enigmacamp.utils;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public void inputHandler(Scanner scanner){
        this.scanner = scanner;
    }

    //Input Number atau input string
    public int GetInt(String prompt){ // Input price, data will be calculate in the future
        System.out.println(prompt);
        //Lakukan Validasi karena input harus berupa angka
        while (!scanner.hasNextInt()){
            System.out.println("Input harus berupa angka !");
            scanner.next();
            System.out.print("Masukkan input angka lagi : ");
            System.out.println(prompt);
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public String getString(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }
}

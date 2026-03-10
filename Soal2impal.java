/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.soal2impal;

/**
 *
 * @author adsan
 */
import java.util.Scanner;

public class Soal2impal {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== COMPUTER SERVICE FEE CALCULATOR ===");
            System.out.print("Jumlah komputer yang diservis: ");
            int computerAmount = sc.nextInt();
            
            double baseFee;
            double additionalFee;
            int peripheralAmount = 0;
            
            if (computerAmount == 1 || computerAmount == 2) {
                baseFee = 50.0;
                additionalFee = 0.0;
                System.out.printf("Base fee: $%.2f, Additional fee: $%.2f%n", baseFee, additionalFee);
                
            } else if (computerAmount >= 3 && computerAmount <= 10) {
                baseFee = 100.0;
                System.out.print("Jumlah peripheral: ");
                peripheralAmount = sc.nextInt();
                additionalFee = 10.0 * peripheralAmount;
                System.out.printf("Base fee: $%.2f, Additional fee: $%.2f (per peripheral)%n", baseFee, additionalFee);
                
            } else if (computerAmount > 10) {
                baseFee = 500.0;
                System.out.print("Jumlah peripheral: ");
                peripheralAmount = sc.nextInt();
                additionalFee = 10.0 * peripheralAmount;
                System.out.printf("Base fee: $%.2f, Additional fee: $%.2f (per peripheral)%n", baseFee, additionalFee);
                
            } else {
                System.out.println("Jumlah komputer tidak valid.");
                sc.close();
                return;
            }
            
            System.out.print("Apakah servis dalam jam kerja? (1=Ya, 0=Tidak): ");
            int inBusinessHours = sc.nextInt();
            
            if (inBusinessHours == 0) {
                baseFee = baseFee * 2;
                System.out.printf("Servis di luar jam kerja, base fee digandakan: $%.2f%n", baseFee);
            }
            
            double totalBaseFee = baseFee + additionalFee;
            
            System.out.print("Apakah pelanggan bersedia antar-jemput sendiri? (1=Ya, 0=Tidak): ");
            int dropOff = sc.nextInt();
            
            if (dropOff == 1) {
                totalBaseFee = totalBaseFee / 2;
                System.out.println("Pelanggan antar-jemput sendiri, total base fee dikurangi setengah.");
            }
            
            System.out.println();
            System.out.println("--- HASIL PERHITUNGAN ---");
            System.out.println("Jumlah komputer    : " + computerAmount);
            System.out.printf("Base fee           : $%.2f%n", baseFee);
            System.out.printf("Additional fee     : $%.2f%n", additionalFee);
            System.out.printf("Total biaya servis : $%.2f%n", totalBaseFee);
        }
    }
}


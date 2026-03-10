/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.soal3impal;

/**
 *
 * @author adsan
 */
import java.util.Scanner;

public class Soal3impal {
    static class Account {
        int accountNumber;
        String statusCode;
        String customerName;

        Account(int accountNumber, String statusCode, String customerName) {
            this.accountNumber = accountNumber;
            this.statusCode = statusCode;
            this.customerName = customerName;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Account[] ACCOUNTS = {
                new Account(1001, "valid",   "Alice"),
                new Account(1002, "valid",   "Bob"),
                new Account(1003, "invalid", "Charlie"),
                new Account(1004, "valid",   "Diana"),
                new Account(1005, "invalid", "Eve")
            };
            
            System.out.println("=== COMPUTER SERVICE - ACCOUNT VALIDATION ===");
            System.out.print("Masukkan account number: ");
            int inputAccountNumber = sc.nextInt();
            
            boolean found = false;
            Account validAccount = null;
            
            for (Account acc : ACCOUNTS) {
                if (acc.accountNumber == inputAccountNumber) {
                    found = true;
                    if (acc.statusCode.equals("valid")) {
                        validAccount = acc;
                    }
                    break;
                }
            }
            
            if (found && validAccount != null) {
                System.out.print("Masukkan jumlah tagihan (amount of sale): $");
                double amountOfSale = sc.nextDouble();
                
                System.out.println();
                System.out.println("========== INVOICE ==========");
                System.out.println("Account Number : " + validAccount.accountNumber);
                System.out.println("Customer Name  : " + validAccount.customerName);
                System.out.println("Status         : " + validAccount.statusCode);
                System.out.printf("Amount of Sale : $%.2f%n", amountOfSale);
                System.out.println("==============================");
                System.out.println("Invoice berhasil dibuat.");
                
            } else {
                if (!found) {
                    System.out.println("\nERROR: Account number " + inputAccountNumber
                            + " tidak ditemukan di ACCOUNTS.");
                } else {
                    System.out.println("\nERROR: Account number " + inputAccountNumber
                            + " ditemukan, tetapi status-code bukan 'valid'.");
                }
                System.out.println("Transaksi tidak dapat diproses.");
            }
        }
    }
}

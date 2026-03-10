/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.soal1impal;

/**
 *
 * @author adsan
 */
import java.util.Scanner;

public class Soal1impal {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== DETERMINE TRIANGLE ===");
            System.out.print("Masukkan 3 bilangan bulat (a b c): ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.println("Tidak ada segitiga yang dapat dibangun (ada bilangan <= 0).");
                sc.close();
                return;
            }
            
            int[] sisi = {a, b, c};
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2 - i; j++) {
                    if (sisi[j] > sisi[j + 1]) {
                        int temp = sisi[j];
                        sisi[j] = sisi[j + 1];
                        sisi[j + 1] = temp;
                    }
                }
            }
            int min = sisi[0];
            int mid = sisi[1];
            int max = sisi[2];
            
            if (max >= (mid + min)) {
                System.out.println("Tidak ada segitiga yang dapat dibangun.");
                sc.close();
                return;
            }
            
            if (a == b && b == c) {
                System.out.println("Segitiga SAMA SISI (EQUILATERAL)");
            } else if (a == b || b == c || a == c) {
                System.out.println("Segitiga SAMA KAKI (ISOSCELES)");
            } else if ((max * max) == (mid * mid + min * min)) {
                System.out.println("SEGITIGA SIKU-SIKU (RIGHT TRIANGLE)");
            } else {
                System.out.println("SEGITIGA BEBAS (SCALENE)");
            }
        }
    }
}


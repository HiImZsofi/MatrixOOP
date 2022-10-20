package hu.petrik.matrixoop;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private int sor;
    private int oszlop;
    private int[][] m;
    private static final Random rnd = new Random();

    public Matrix(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
        this.m = new int[sor][oszlop];
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                this.m[i][j] = rnd.nextInt(150) - 1;
            }
        }
    }

    public int getElementOsszege() {
        int osszeg = 0;

        for (int[] sor : this.m) {
            for (int elem : sor) {
                osszeg += elem;
            }
        }

        return osszeg;
    }

    public int getpozitivelemekszama() {
        int db = 0;

        for (int[] sor : this.m) {
            for (int elem : sor) {
                if (elem > 0) {
                    db++;
                }
            }
        }

        return db;
    }

    public int getLegnagyobbElem() {
        int max = this.m[0][0];

        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                if (max < this.m[i][j]) {
                    max = this.m[i][j];
                }
            }
        }

        return max;
    }

    public int[] getElsoPozitivElem() {
        int sorindex = 0;
        int oszlopindex = 0;
        while (sorindex < this.m.length && this.m[sorindex][oszlopindex] < 1) {
            oszlopindex = 0;
            while (oszlopindex < this.m[sorindex].length && this.m[sorindex][oszlopindex] < 1) {
                oszlopindex++;
            }
            if (oszlopindex == this.m[sorindex].length) {
                sorindex++;
                oszlopindex = 0;
            }
        }
        if (sorindex == this.m.length) {
            return new int[]{-1, -1};
        }
        return new int[]{sorindex, oszlopindex};
    }

    public double sorOsszeg(int sor) {
        double sum = 0;

        for (int i = sor; i < sor + 1; i++) {
            for (int j = 0; j < this.m[sor].length; j++) {
                sum += this.m[i][j];
            }
        }

        return sum;
    }

    public double maxElemOszlop(int oszlop) {
        int osum = 0;
        for (int i = 0; i < this.m.length; i++) {
            for (int j = oszlop; j < oszlop + 1; j++) {
                osum += this.m[i][j];
            }
        }
        return osum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] sor : this.m) {
            for (int elem : sor) {
                sb.append(String.format("%3d ", elem));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

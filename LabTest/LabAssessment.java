package LabTest;

import java.util.*;
import java.sql.*;
import java.util.*;

class Loan_Mela {
    int total_loan_amount = 1000000;
}

class Cashier extends Thread {
    int total_loan_amount, amountDeducted;
    String branchName, loanApplicant;

    Cashier(String branchName) {
        this.branchName = branchName;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Applicant Name:");
        this.loanApplicant = in.nextLine();
        System.out.println("Enter Loan Amount:");
        this.amountDeducted = in.nextInt();
    }

    public void run(Loan_Mela loan) {
        if (loan.total_loan_amount > 0) {
            synchronized (loan) {
                if (this.amountDeducted > loan.total_loan_amount) {
                    System.out.println("Invalid please input another");
                    while (this.amountDeducted > loan.total_loan_amount) {
                        Scanner in = new Scanner(System.in);
                        System.out.println("Invalid please input another between " + loan.total_loan_amount);
                        this.amountDeducted = in.nextInt();
                    }
                }
                loan.total_loan_amount -= this.amountDeducted;
                System.out.println(this.branchName);
                System.out.println("Loan Applicant: " + this.loanApplicant);
                System.out.println("Amount Sanctioned: " + this.amountDeducted);
                System.out.println("Total Loan Amount = " + loan.total_loan_amount);

            }
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/labtest?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                        "root", "password");
                Statement s = conn.createStatement();
                PreparedStatement stmt = conn.prepareStatement("insert into transaction (name, amount) values(?,?)");
                stmt.setString(1, this.loanApplicant);
                stmt.setString(2, this.amountDeducted + "");
                int i = stmt.executeUpdate();
                System.out.println(i + " records inserted");
                String query = "select * from transaction;";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("name") + "  " + rs.getString("amount"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void start(Loan_Mela loan) {
        run(loan);
    }

    public void report() {
        System.out.println(this.branchName + " sold " + this.total_loan_amountSold);
    }

}

public class LabAssessment {

    public static void main(String[] args) {
        char b = 'B';
        char a = 'A';
        char i = 'I';
        int B = (int) b;
        int A = (int) a;
        int I = (int) i;
        System.out.println("Author Code: 19" + ":" + B + ":" + A + ":" + I + ":" + "11");
        Scanner in = new Scanner(System.in);
        Loan_Mela loan = new Loan_Mela();
        System.out.println("Total Loan Amount =" + loan.total_loan_amount);
        Cashier c1 = new Cashier("Sanction Thread 1");
        Cashier c2 = new Cashier("Sanction Thread 2");
        Cashier c3 = new Cashier("Sanction Thread 3");

        c1.run(loan);
        c2.run(loan);
        c3.run(loan);
        System.out.println(loan.total_loan_amount);
    }
}

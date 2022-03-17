package dev.bank.bankstatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.bankstatement.data.BankStatementTSVParser;
import dev.bank.bankstatement.model.BankTransaction;

public class BankStatementAnlayzer {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        // 파일 입출력
        final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
        final List<String> lines = Files.readAllLines(path);

        // 데이터 파싱
        BankStatementTSVParser bankStatementTSVParser = new BankStatementTSVParser();
        List<BankTransaction> bankTransactions = bankStatementTSVParser.parseLinesFromTSV(lines);
        System.out.println(bankTransactions);

        System.out.println("입출금 내역의 총합은 : " + calculateTotalAmout(bankTransactions) + "입니다.");

        System.out.println("1월의 입출금 내역은 : " + selectInMonth(bankTransactions, Month.JANUARY));
    }

    // 요구사항 1. 입출금 내역 연산 및 출력 메소드
    public static double calculateTotalAmout(List<BankTransaction> bankTransactions) {
        double total = 0d;

        for(BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    // 요구사항 2. 월별 입출금 내역 구하기(객체형태로)
    public static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {
        final List<BankTransaction> bankTransactionInMonth = new ArrayList<>();

        for(BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) bankTransactionInMonth.add(bankTransaction);
        }

        return bankTransactionInMonth;
    }
}

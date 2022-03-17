package dev.bank.bankstatement.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.bankstatement.model.BankTransaction;

public class BankStatementTSVParser {
    // 날짜 데이터에서 '월'만 찾아 내기 위한 포맷 생성
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
    // 한줄 파싱 TSV파일 -> LocalDate, Double, String으로 파싱
    private BankTransaction parseFromTSV(final String line) {
        String[] columns = line.split("\t");
        System.out.println(columns);
        // DTO의 클래스에서 세개의 인자를 받게 하기 위해 생성
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        System.out.println(date);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        // 해당 라인에 분리된 세개의 인자를 DTO 객체에 넣어 BankTransaction 객체 타입으로 저장 하는 변수 생성
        BankTransaction bankTransaction = new BankTransaction(date, amount, description);
        return bankTransaction; 
    }
    
    // 한줄씩 파싱후 리스트에 추가
    public List<BankTransaction> parseLinesFromTSV(List<String> lines) {
        List<BankTransaction> bankTransactions = new ArrayList<>();
        
        for(String line : lines){
            bankTransactions.add(parseFromTSV(line));
        }
        return bankTransactions;
    }
}

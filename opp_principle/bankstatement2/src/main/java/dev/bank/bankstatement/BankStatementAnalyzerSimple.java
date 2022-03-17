package dev.bank.bankstatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        // phase 1
        // 경로 인식
        final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
        // System.out.println(path);

        // 지정된 경로 path를 통해 파일 읽기
        // List<> 를 사용하기 위한 임포트 단축키 [Shift+Alt+O]
        // Files.readAllLines(path); 에러 처리를 위한 단축키 [Ctrl+.]
        // Add throws declaration 선택
        final List<String> lines = Files.readAllLines(path);
        // System.out.println(lines);

        // 요구사항 1. 총 입출금 내역 합 구하기
        double total = 0d;
        for (String line : lines) {
            final String[] columns = line.split("\t");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }
        // 실행 단축키 [F5]
        // 요구사항 1. 출력
        System.out.println("총 입출금 금액은 " + total + " 입니다.");
        // 요구사항 2. 출력
        System.out.println("1월의 총 사용 금액 : " + findTransactionsInJanuary() + "입니다.");
    }

    // 요구사항 2. 1월에 발생한 총 입출금 내역 조회
    public static double findTransactionsInJanuary() throws IOException {
        
        final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
        final List<String> lines = Files.readAllLines(path);

        double total = 0d;

        // 포맷팅 설정
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
    
        for(String line: lines) {
            final String[] columns = line.split("\t");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            // System.out.println(date);
            // break;
            
            if(date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }
        return total;
    }
}


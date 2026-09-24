package vn.edu.rikkei.session16.ex03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        
        // Định dạng mốc thời gian theo chuẩn yyyy-MM-dd HH:mm:ss[cite: 52]
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Tạo nguồn cung cấp thời gian thực bằng Supplier<String>[cite: 51]
        Supplier<String> timeSupplier = () -> LocalDateTime.now().format(formatter);

        // Tạo bộ tiêu thụ tin nhắn log bằng Consumer<String> kết hợp Lambda expression[cite: 51, 53]
        Consumer<String> logger = msg -> System.out.printf("| -> %-48s |\n", msg);

        // In tiêu đề bảng xuất ASCII[cite: 52, 53]
        System.out.println("+----------------------------------------------------+");
        System.out.println("|         NHẬT KÝ HỆ THỐNG CONSUMER SUPPLIER         |");
        System.out.println("+----------------------------------------------------+");

        try {
            // Thử nghiệm ghi 3 sự kiện theo yêu cầu[cite: 52]
            
            // Sự kiện 1
            AuditLogger.logEvent(timeSupplier, logger, "USER_LOGIN");
            
            // Tạm dừng 1 giây để kiểm chứng sự kiện log kèm mốc thời gian động từ Supplier[cite: 53]
            Thread.sleep(1000); 
            
            // Sự kiện 2
            AuditLogger.logEvent(timeSupplier, logger, "UPDATE_DATABASE");
            Thread.sleep(1000);
            
            // Sự kiện 3
            AuditLogger.logEvent(timeSupplier, logger, "SYSTEM_BACKUP");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("+----------------------------------------------------+");
        
    }
}

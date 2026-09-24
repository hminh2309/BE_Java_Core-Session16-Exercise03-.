package vn.edu.rikkei.session16.ex03;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class AuditLogger {
    
    // Viết phương thức tĩnh public static void logEvent(...)[cite: 51]
    public static void logEvent(Supplier<String> timeSupplier, Consumer<String> logger, String eventName) {
        // Lấy thời gian từ timeSupplier.get()[cite: 51]
        String timestamp = timeSupplier.get();
        
        // Tạo chuỗi thông điệp theo định dạng yêu cầu[cite: 51]
        String fullMessage = "[" + timestamp + "] - SỰ KIỆN: " + eventName;
        
        // Chuyển thông điệp cho logger.accept() để xử lý đầu ra[cite: 51, 52]
        logger.accept(fullMessage);
    }
}

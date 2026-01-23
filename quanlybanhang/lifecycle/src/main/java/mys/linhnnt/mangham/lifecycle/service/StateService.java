package mys.linhnnt.mangham.lifecycle.service;

import org.springframework.stereotype.Service;

@Service
public class StateService {

    // --- PHẦN 1: MẢNG VÀ HÀM ---
    
    // Hàm nhận vào một mảng số nguyên, trả về tổng (Xử lý logic thuần túy)
    public int tinhTongMang(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // --- PHẦN 2: STATELESS (Nên dùng) ---
    // Không có biến toàn cục nào lưu dữ liệu riêng tư.
    // Dữ liệu vào (a, b) -> Xử lý -> Trả ra.
    public int congHaiSo(int a, int b) {
        return a + b; 
    }

    // --- PHẦN 3: STATEFUL (Nguy hiểm trong Singleton) ---
    // Biến này sẽ được dùng chung cho TẤT CẢ User vì Service là Singleton
    private int count = 0; 

    public int tangDem() {
        this.count++;
        return this.count;
    }
}

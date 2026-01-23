package mys.linhnnt.mangham.lifecycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mys.linhnnt.mangham.lifecycle.component.StatefulBean;
import mys.linhnnt.mangham.lifecycle.service.StateService;

@RestController
@RequestMapping("/demo")
public class StateController {

    @Autowired
    private StateService stateService;

    @Autowired
    private ApplicationContext context;

    // 1. Demo Mảng & Hàm
    // Gọi: /demo/mang?numbers=1,2,3,4,5
    @GetMapping("/mang")
    public String demoMang(@RequestParam(defaultValue = "0") int[] numbers) {
        int tong = stateService.tinhTongMang(numbers);
        return "Tổng mảng nhận được là: " + tong;
    }

    // 2. Demo Stateless (An toàn)
    // Dù gọi bao nhiêu lần, kết quả chỉ phụ thuộc input, không nhớ gì cũ
    @GetMapping("/stateless")
    public String demoStateless(@RequestParam int a, @RequestParam int b) {
        int ketqua = stateService.congHaiSo(a, b);
        return "Kết quả cộng (Stateless): " + ketqua;
    }

    // 3. Demo Stateful bị lỗi (Do dùng Singleton Service)
    // Hãy mở 2 trình duyệt ẩn danh (coi như 2 user khác nhau) cùng gọi link này.
    // Bạn sẽ thấy con số tăng chung cho cả 2 người -> SAI LOGIC
    @GetMapping("/stateful-wrong")
    public String demoStatefulWrong() {
        int count = stateService.tangDem();
        return "Số lượt truy cập (Bị dùng chung - Sai): " + count;
    }

    // 4. Demo Stateful đúng (Dùng Prototype)
    // Mỗi lần request này chạy, ta tạo 1 bean mới hoàn toàn
    @GetMapping("/stateful-correct")
    public String demoStatefulCorrect() {
        // Lấy 1 bean mới từ kho
        StatefulBean myBean = context.getBean(StatefulBean.class);
        return "Đếm riêng tư: " + myBean.click(); // Luôn luôn là 1
    }
}

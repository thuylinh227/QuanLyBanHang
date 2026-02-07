package mys.linhnnt.mangham.lifecycle.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Quan trọng: Mỗi lần gọi sẽ tạo ra 1 object mới tinh
public class StatefulBean {
    private int myCount = 0;

    public int click() {
        myCount++;
        return myCount;
    }
}
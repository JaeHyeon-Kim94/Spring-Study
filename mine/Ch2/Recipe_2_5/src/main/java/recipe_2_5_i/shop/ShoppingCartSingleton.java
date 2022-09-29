package recipe_2_5_i.shop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
/*
    @Component는 scan을 통해 주입될 bean 후보임을 나타내는 것이지,
    어떤 bean 인스턴스인지를 정의하는 것이 아님.
    IoC 컨테이너 당 하나의 인스턴스를 생성할 때는 singleton,
    요청(호출)시마다 인스턴스를 새로 만들 때는 prototype,
    HTTP request당 하나를 새로 만들 때는 request,
    HTTP session당 하나를 새로 만들 때는 session,
    전체 HTTP session당 하나를 생성할 때에는 globalsession
    thread당 하나를 생성할 때는 thread

    스프링 빈은 기본적으로 모든 빈을 싱글톤으로 생성하여 관리한다.
*/
@Scope("singleton")
public class ShoppingCartSingleton implements ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product item) { items.add(item); }

    public List<Product> getItems() {
        return items;
    }
}

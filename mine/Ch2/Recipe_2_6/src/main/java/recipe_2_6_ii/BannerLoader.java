package recipe_2_6_ii;

import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BannerLoader {
    private Resource banner;

    public void setBanner(Resource banner) {
        this.banner = banner;
    }

    //스프링이 빈을 생성한 후 이 메서드를 자동으로 실행하도록 한다.
    //IoC 컨테이너 구성 시점에 배너가 출력됨.
    @PostConstruct
    public void showBanner() throws IOException{
        //banner에 할당된 파일에 있는 내용을 차례대로 읽어 콘솔에 한 줄씩 출력한다.
        Files.lines(Paths.get(banner.getURI()), Charset.forName("UTF-8"))
                .forEachOrdered(System.out::println);
    }

}

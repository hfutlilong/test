package dubbo.provider;

import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-01-08 21:40
 */
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}

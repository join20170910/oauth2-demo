import com.ws.auth.common.StartUpApplication;
import com.ws.auth.common.redislock.DistributedLocker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName RedisTest
 * @Deacription TODO
 * @Author apple
 * @Date 2020/7/29 20:24
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartUpApplication.class)
public class RedisTest {

    @Autowired
    private DistributedLocker distributedLocker;
    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void set() {
        // 设置字符串
        RBucket<String> keyObj = redissonClient.getBucket("name");
        keyObj.set("v1236");
    }
    @Test
    public void redisTest() {
        // redis存储数据
        String key = "name";
        RLock rLock = distributedLocker.lock(key);
        rLock.getName();

    }
}

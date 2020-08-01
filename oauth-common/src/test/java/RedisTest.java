import com.ws.auth.common.StartUpApplication;
import com.ws.auth.common.redislock.DistributedLocker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

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

        String lockKey = "lockKey";
        RLock redissonLock = redissonClient.getLock(lockKey);
        try{
            redissonLock.lock();
            System.out.println("-----------------");
        }catch (Exception e){

        }finally {
            redissonLock.unlock();
        }

    }

    @Test
    public void distributedLockerTest(){

        String lockKey = "lockKey";
        RLock redissonLock = distributedLocker.lock(lockKey);

        String keyVal = UUID.randomUUID().toString();
        try{
            redissonLock.lock();
            System.out.println("------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            redissonLock.unlock();
        }
    }
}

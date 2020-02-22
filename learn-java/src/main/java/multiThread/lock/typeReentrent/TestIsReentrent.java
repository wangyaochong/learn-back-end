package multiThread.lock.typeReentrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class TestIsReentrent {
    @Test
    public void test() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        lock.unlock();
        lock.unlock();
        log.info("ss");
    }
}

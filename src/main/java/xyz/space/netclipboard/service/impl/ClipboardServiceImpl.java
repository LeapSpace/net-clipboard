package xyz.space.netclipboard.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import xyz.space.netclipboard.service.ClipboardService;
import xyz.space.netclipboard.utils.Constant;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * Created By space on 2018/8/21
 */
@Service
public class ClipboardServiceImpl implements ClipboardService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     *
     * @param msg
     * @return
     */
    @Override
    public String put(String msg) {
        String pass = RandomStringUtils.randomAlphanumeric(Constant.CLIPBOARD_KEY_LENGTH);
        String key = Constant.CLIPBOARD_KEY + pass;
        stringRedisTemplate.opsForValue().set(key, msg, Constant.CLIPBOARD_KEY_EXPIRE, TimeUnit.SECONDS);
        return pass;
    }

    @Override
    public String get(String pass) {
        String key = Constant.CLIPBOARD_KEY + pass;
        return stringRedisTemplate.opsForValue().get(key);
    }
}

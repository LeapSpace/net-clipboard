package xyz.space.netclipboard.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import xyz.space.netclipboard.service.ClipboardService;
import xyz.space.netclipboard.utils.ResultBuilder;

import javax.annotation.Resource;
import javax.validation.constraints.Size;

/**
 * Created By space on 2018/8/21
 */

@RestController
@RequestMapping("/clipboard")
public class ClipBoardController {
    @Resource
    private ClipboardService clipboardService;

    @PostMapping("/set.json")
    public ResultBuilder setValue(@RequestParam @Size(max = 65535, min = 4) String msg) {
        if (StringUtils.isBlank(msg)) {
            return ResultBuilder.builder();
        }
        String pass = clipboardService.put(msg);
        return ResultBuilder.builder(pass);
    }

    @GetMapping("/get.json")
    public ResultBuilder getValue(@RequestParam String pass) {
        if (StringUtils.isBlank(pass)) {
            return ResultBuilder.builder();
        }
        String msg = clipboardService.get(pass);
        return ResultBuilder.builder(msg);
    }

}

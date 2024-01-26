package com.pn.controller;

import com.pn.model.dto.LikeRecordFormDTO;
import com.pn.service.ILikedRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 点赞记录表 控制器
 * </p>
 * @author pn
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
@Tag(name = "点赞业务相关接口")
public class LikedRecordController {

    private final ILikedRecordService likedRecordService;

    @PostMapping
    @Operation(summary = "点赞或取消点赞")
    public void addLikeRecord(@Valid @RequestBody LikeRecordFormDTO recordDTO) {
        likedRecordService.addLikeRecord(recordDTO);
    }

    @GetMapping("list")
    @Operation(summary = "查询指定业务id的点赞状态")
    public Set<Long> isBizLiked(@RequestParam("bizIds") List<Long> bizIds){
        return likedRecordService.isBizLiked(bizIds);
    }
}

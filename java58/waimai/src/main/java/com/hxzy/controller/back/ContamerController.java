package com.hxzy.controller.back;

import com.github.pagehelper.PageHelper;
import com.hxzy.common.controller.BaseController;
import com.hxzy.common.dto.PageDTO;
import com.hxzy.common.vo.PageVO;
import com.hxzy.common.vo.R;
import com.hxzy.dto.back.ContamerSearchDTO;
import com.hxzy.entity.Contamer;
import com.hxzy.service.ContamerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wy
 * @Description TODO
 * @Date 2023/4/8 9:13
 * @Version 1.0
 */
@Api(tags = "前端用户API")
@RestController
@RequestMapping(value = "/api/contamer")
public class ContamerController  extends BaseController {

    @Autowired
    private ContamerService contamerService;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/data")
    public R<PageVO<Contamer>> search(ContamerSearchDTO searchDTO){
        PageHelper.startPage(searchDTO.getPage(),searchDTO.getSize());

        List<Contamer> list=this.contamerService.search(searchDTO);

        return super.pageToPageVO(list);
    }


}

package com.hxzy.controller.back;

import com.github.pagehelper.PageHelper;
import com.hxzy.common.controller.BaseController;
import com.hxzy.dto.ContamerSearchDTO;
import com.hxzy.entity.Cont;
import com.hxzy.service.ContService;
import com.hxzy.vo.PageVO;
import com.hxzy.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/13-0:23
 * @description TODO
 */
@Api(tags = "前端用户API")
@RestController
@RequestMapping(value = "/api/contamer")
public class ContamerController  extends BaseController {

    @Autowired
    private ContService contamerService;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/data")
    public Result<PageVO<Cont>> search(ContamerSearchDTO searchDTO){
        PageHelper.startPage(searchDTO.getPageNum(),searchDTO.getPageSize());

        List<Cont> list=this.contamerService.search(searchDTO);

        return super.pageToPageVO(list);
    }


}

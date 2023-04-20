package com.hxzy.controller.back;

import cn.hutool.core.util.StrUtil;
import com.hxzy.common.eunms.AckCode;
import com.hxzy.dto.TableNameSaveDTO;
import com.hxzy.service.OracleTableService;
import com.hxzy.service.TplAutocolumnService;
import com.hxzy.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/18-13:43
 * @description TODO
 */
@Api(tags = "代码生成工具API")
@RestController
@RequestMapping(value = "/api/code")
public class CodeController {
    @Autowired
    private OracleTableService oracleTableService;

    @Autowired
    private TplAutocolumnService tplAutocolumnService;

    @ApiOperation(value = "得到当前用户所有表名")
    @GetMapping(value = "/tables")
    public Result searchAllTables(){
        List<Map<String, Object>> maps = this.oracleTableService.searchAllTables();
        return Result.okHasData(maps);
    }


    @ApiOperation(value = "得到表名得到数据库列信息")
    @GetMapping(value = "/columns/{tableName}")
    public Result searchColumnByTable(@PathVariable(value = "tableName") String tableName){
        if(StrUtil.isBlank(tableName)){
            return Result.build(AckCode.USER_PARAM_IS_NOT_NULL);
        }

        Map<String, Object> objectMap = this.oracleTableService.columnsForTableName(tableName);
        return Result.okHasData(objectMap);
    }

    @PostMapping(value = "/tplcolumn/save")
    @ApiOperation(value = "保存表配置字段")
    public Result add(@RequestBody TableNameSaveDTO saveDTO){
        if(saveDTO.getColumns()==null && saveDTO.getColumns().size()==0){
            return Result.build(AckCode.SYSTEM_PARAM_FAIL);
        }

        boolean result=this.tplAutocolumnService.save(saveDTO);

        return result? Result.ok(): Result.build(AckCode.FAIL);
    }

    /**
     * 生成文件,输出到客户端固定死的代码
     */
    private void genCode(HttpServletResponse response, String tableName, byte[] data) throws IOException {
        //response.reset();

        response.setHeader("content-type", "application/octet-stream");

        response.addHeader("Access-Control-Allow-Origin", "*");
        // 告诉浏览器，这个数据是一个文件
        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
        // 这个文件叫什么
        response.setHeader("Content-Disposition", "attachment; filename=\""+tableName+".zip\"");
        //告诉浏览器文件大小
        response.addHeader("Content-Length", "" + data.length);
        //告诉浏览器文件类型
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

    @ApiOperation(value = "生成代码")
    @PostMapping(value = "/gen")
    public void generatorCode( @RequestBody Map<String,Object> params ,HttpServletResponse response) throws IOException {
        String tableName= params.get("tableName").toString();
        String tableDesc=params.get("tableDesc").toString();

        byte[] data=this.oracleTableService.generatorCode(tableName,tableDesc);
        genCode(response,tableName,data);
    }
}

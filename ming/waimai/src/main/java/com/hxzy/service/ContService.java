package com.hxzy.service;

import com.hxzy.dto.ContamerSearchDTO;
import com.hxzy.entity.Cont;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/13-0:27
 * @description TODO
 */

public interface ContService extends BaseService<Cont,Long>{
    List<Cont> search(ContamerSearchDTO searchDTO);
}

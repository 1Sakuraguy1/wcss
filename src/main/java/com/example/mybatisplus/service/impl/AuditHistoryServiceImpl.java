package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.AuditHistory;
import com.example.mybatisplus.mapper.AuditHistoryMapper;
import com.example.mybatisplus.service.AuditHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审核历史表 服务实现类
 * </p>
 *
 * @author lxp
 * @since 2022-09-27
 */
@Service
public class AuditHistoryServiceImpl extends ServiceImpl<AuditHistoryMapper, AuditHistory> implements AuditHistoryService {

}

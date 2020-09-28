package com.xzy.service;

import com.xzy.dto.ContractProductResult;
import com.xzy.dto.Page;
import com.xzy.entity.Contract;

import java.util.Date;
import java.util.List;

public interface ContractService {

    void addContract(Contract contract);

    void deleteContract(Integer contractId);

    Page getContractPages(int pageNo, int pageSize, String keyword);

    ContractProductResult getContractByContractId(Integer contractId);

    List<Contract> getContractListByEmployeeId(Integer employeeId);

    /**
     * 改合同状态
     * @param flag: 合同状态
     * @param employeeId:审批人id
     * @param contractId:合同id
     * @param status:是审批人1还是审批人2
     */
    void updateContractFlag(Integer flag,Integer employeeId,Integer contractId,Integer status);

    /**
     * 查询某时间段内合同交易额
     * @param startTime
     * @param endTime
     * @return
     */
    double getContractMoney(Date startTime, Date endTime);
}

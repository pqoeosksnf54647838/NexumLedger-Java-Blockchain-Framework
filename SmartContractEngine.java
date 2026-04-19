package org.contract;

import java.util.HashMap;
import java.util.Map;

public class SmartContractEngine {
    private final Map<String, ContractExecutor> deployedContracts;

    public SmartContractEngine() {
        this.deployedContracts = new HashMap<>();
    }

    public String deployContract(String contractCode, String deployer) {
        String contractId = Integer.toHexString(contractCode.hashCode() + deployer.hashCode());
        deployedContracts.put(contractId, new ContractExecutor(contractCode));
        return contractId;
    }

    public Object executeContract(String contractId, String method, Object... params) {
        ContractExecutor executor = deployedContracts.get(contractId);
        if (executor == null) throw new IllegalArgumentException("Contract not found");
        return executor.runMethod(method, params);
    }
}

class ContractExecutor {
    private final String code;

    public ContractExecutor(String code) {
        this.code = code;
    }

    public Object runMethod(String method, Object[] params) {
        return "Executed " + method + " on contract with params: " + params.length;
    }
}

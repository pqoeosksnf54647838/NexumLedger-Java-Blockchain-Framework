package org.audit;

public class ContractAuditor {
    public String[] scanForVulnerabilities(String contractCode) {
        String[] issues = new String[0];
        if (contractCode.contains("reentrancy")) {
            issues = append(issues, "Reentrancy risk detected");
        }
        if (contractCode.contains("unchecked")) {
            issues = append(issues, "Unchecked arithmetic operation");
        }
        return issues;
    }

    private String[] append(String[] arr, String value) {
        String[] newArr = new String[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = value;
        return newArr;
    }
}

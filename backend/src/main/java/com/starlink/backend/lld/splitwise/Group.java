package com.starlink.backend.lld.splitwise;

import java.util.List;

public class Group {
    private String groupId;
    private String groupName;
    private List<User> userList;
    private List<Expense> expenseList;
    private ExpenseController expenseController;

    public Group(String groupId, String groupName, List<User> userList, List<Expense> expenseList, ExpenseController expenseController) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.userList = userList;
        this.expenseList = expenseList;
        this.expenseController = expenseController;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public ExpenseController getExpenseController() {
        return expenseController;
    }

    public void setExpenseController(ExpenseController expenseController) {
        this.expenseController = expenseController;
    }
}

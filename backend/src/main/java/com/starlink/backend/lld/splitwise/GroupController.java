package com.starlink.backend.lld.splitwise;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> listGroup;

    public GroupController() {
        this.listGroup = new ArrayList<>();
    }

    // ✅ Business Logic: Create new group
    public Group createGroup(String groupId, String groupName, List<User> users) {
        Group group = new Group(groupId, groupName, users, new ArrayList<>(), new ExpenseController());
        listGroup.add(group);
        return group;
    }

    // ✅ Business Logic: Add expense to group
    public void addExpenseToGroup(Group group, Expense expense) {
        group.getExpenseList().add(expense);
    }

    // ✅ Business Logic: Get group by ID
    public Group getGroup(String groupId) {
        return listGroup.stream()
                .filter(g -> g.getGroupId().equals(groupId))
                .findFirst()
                .orElse(null);
    }

    // ✅ Business Logic: Get all groups
    public List<Group> getAllGroups() {
        return listGroup;
    }
}
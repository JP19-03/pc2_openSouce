package com.genericstrentals.platform.u202014511.inventories.domain.model.entities;

import com.genericstrentals.platform.u202014511.inventories.domain.model.valueobjects.Groups;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "category_groups")
public class Group {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(unique = true, length = 20)
    private Groups name;

    public Group() {}

    public Group(Groups name) {
        this.name = name;
    }

    public String getStringName() { return name.toString(); }

    public static Group getDefaultGroup() { return new Group(Groups.FARMING);}

    public static Group toRoleFromName(String name) {
        return new Group(Groups.valueOf(name));
    }

    public static List<Group> validateGroupSet(List<Group> groups) {
        if (groups == null || groups.isEmpty()) return List.of(getDefaultGroup());
        return groups;
    }
}

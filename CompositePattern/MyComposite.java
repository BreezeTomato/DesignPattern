/**
 * 组合模式代码设计

 * 小明所在的公司内部有多个部门，每个部门下可能有不同的子部门或者员工。
 * 请你设计一个组合模式来管理这些部门和员工，实现对公司组织结构的统一操作。
 * 部门和员工都具有一个通用的接口，可以获取他们的名称以及展示公司组织结构。

 * 输入描述

 * 第一行是一个整数 N（1 <= N <= 100），表示后面有 N 行输入。
 * 接下来的 N 行，每行描述一个部门或员工的信息。部门的信息格式为 D 部门名称，
 * 员工的信息格式为 E 员工名称，其中 D 或 E 表示部门或员工。

 * 输出描述

 * 输出公司的组织结构，展示每个部门下的子部门和员工
 */

package CompositePattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyComposite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String CompanyName = sc.nextLine();
        Company company = new Company(CompanyName);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.nextLine().trim();

            if ("D".equals(type)) {
                Department department = new Department(name);
                company.add(department);
            } else if ("E".equals(type)) {
                Employee employee = new Employee(name);
                company.add(employee);
            }
        }

        company.display();
    }
}

interface Component {
    void display(int depth);
}

class Department implements Component {
    private String name;
    private List<Component> children;

    public Department(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void display(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append(" ");
        }
        System.out.println(indent + name);
        for (Component c : children) {
            c.display(depth + 1);
        }
    }
}

class Employee implements Component {
    private String name;
    public Employee(String name) {
        this.name = name;
    }


    @Override
    public void display(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append(" ");
        }
        System.out.println(indent + "   " + name);
    }
}

class Company {
    private String name;
    private Department root;

    public Company(String name) {
        this.name = name;
        this.root = new Department(name);
    }

    public void add(Component c) {
        root.add(c);
    }

    public void display() {
        System.out.println("Company Structure:");
        root.display(0);
    }
}
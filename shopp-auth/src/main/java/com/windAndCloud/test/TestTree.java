package com.windAndCloud.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xiongfeng
 * @email fj0120@yeah.net
 * @date 2020/9/4 0004 16:47
 */
public class TestTree {
    private static List<Tree> treeList;

    static {
        Tree dept1 = new Tree(2, 1, "数学");
        Tree dept5 = new Tree(5, 2, "立体几何");
        Tree dept6 = new Tree(6, 5, "体积计算");
        Tree dept7 = new Tree(7, 6, "圆柱体");
        treeList = new ArrayList<Tree>();
        treeList.add(dept1);
        treeList.add(dept5);
        treeList.add(dept6);
        treeList.add(dept7);
    }

    private static List<Tree> buildTree(List<Tree> deptList,int pid){
        List<Tree> treeList = new ArrayList<Tree>();
        for (Tree dept : deptList) {
            if (dept.getParentId() == pid) {
                dept.setChild(buildTree(deptList, dept.getId()));
                treeList.add(dept);
            }
        }
        return treeList;
    }

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", buildTree(treeList, 1));
        JSONObject json = new JSONObject(map);
        System.out.println("Json对象是：" + json);

    }
}


@Data
@ToString
class Tree {

    private int id;//当前id 例如：平面几何
    private int parentId;//父级id 例如：数学
    private String name;//当前名称 平面几何
    private List<Tree> child=new ArrayList<Tree>();//子集参数
    public Tree() {
        super();
    }
    public Tree(int id, int parentId, String name) {
        super();
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }
}


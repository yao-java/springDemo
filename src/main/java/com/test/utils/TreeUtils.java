package com.test.utils;





import com.test.base.entity.TreeEntity;
import com.test.base.entity.TreeNode;
import com.test.base.vo.BaseTreeVO;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 树工具类
 * @author root
 */
public class TreeUtils {
    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @return
     */
    public static <T extends TreeNode> List<T> bulid(List<T> treeNodes, Object root) {

        List<T> trees = new ArrayList<T>();

        for (T treeNode : treeNodes) {

            if (root.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }

            for (T it : treeNodes) {
                if (it.getParentId() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<TreeNode>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId() == it.getParentId()) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<TreeNode>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

    /**
     * 为树形结构实体类重新排序
     *
     * @param treeEntities
     * @param <T>
     */
    public static <T extends TreeEntity> void sortTreeEntities(List<T> treeEntities) {
        if (CollectionUtils.isEmpty(treeEntities)) {
            return;
        }
        treeEntities.sort(new TreeEntityComparator<>());
    }

    /**
     * 为树形结构数据重新排序，并重新返回一个TreeVO列表对象
     *
     * @param trees
     * @return
     */
    public static <T extends BaseTreeVO<T>> List<T> sortTrees(List<T> trees) {
        if (CollectionUtils.isEmpty(trees)) {
            return null;
        }
        Map<String, T> map = new LinkedHashMap<>();
        for (T tree : trees) {
            String id = tree.getId();
            map.put(id, tree);
        }
        List<T> newTrees = new ArrayList<>();
        for (T tree : trees) {
            String id = tree.getId();
            String parentId = tree.getParentId();
            if (!map.containsKey(parentId)) {
                map.put(id, tree);
                newTrees.add(tree);
            } else {
                T parent = map.get(parentId);
                List<T> children = parent.getChildren();
                if (children == null) {
                    children = new ArrayList<>();
                    parent.setChildren(children);
                }
                children.add(tree);
            }
        }
        return newTrees;
    }

}

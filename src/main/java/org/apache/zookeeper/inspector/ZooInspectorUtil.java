package org.apache.zookeeper.inspector;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.TreePath;

public class ZooInspectorUtil
{
  /**
   * convert TreePath to ZNodePath
   * @param treePath
   * @return
   */
  public static String treePathToZnodePath(TreePath treePath)
  {
    if (treePath == null) {
      return null;
    }

    Object[] objects = treePath.getPath();
    if (objects.length == 1) {
      return "/";
    }

    String znodePath = "";
    for (int i = 1; i < objects.length; i++)
    {
      znodePath += ("/" + objects[i].toString());
    }
    return znodePath;
  }

  public static List<String> treePathToZnodePath(TreePath[] treePaths)
  {
    if (treePaths == null || treePaths.length == 0) {
      return Collections.emptyList();
    }

    List<String> znodePaths = new ArrayList<String>();
    for (TreePath treePath : treePaths) {
      znodePaths.add(treePathToZnodePath(treePath));
    }
    return znodePaths;
  }

  public static String beautifyNodeData(String data)
  {
      try {
          return prettyJson(data);
      } catch (Exception e) {
          // In future, it should import more way to beautify data
          return data;
      }
  }

  public static String prettyJson(String json)
  {
      if (json == null || json.isEmpty()) {
          return json;
      }
      JSONObject jsonObject = new JSONObject(json); // Convert text to object
      return jsonObject.toString(4);
  }
}

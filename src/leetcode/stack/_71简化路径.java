package leetcode.stack;

import java.util.ArrayList;

/**
 * @author onion
 * @date 2020/4/26 -2:26 下午
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 */
public class _71简化路径 {
    public String simplifyPath(String path) {
        String[] p = path.split("/");
        for(String s: p){
            System.out.println(s);
        }
        ArrayList<String> list = new ArrayList<>();
        for(String s : p){
            if(".".equals(s) || "".equals(s))
                continue;
            if("..".equals(s)){
                if(list.size() > 0)
                    list.remove(list.size()-1);
            }
            else
                list.add(s);
        }
        if(list.size() == 0)
            return "/";
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }
}

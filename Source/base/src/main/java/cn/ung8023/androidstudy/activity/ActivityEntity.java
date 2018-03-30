package cn.ung8023.androidstudy.activity;

/**
 * @author feilang-liuyansong
 * @date 2018/3/16 11:16
 * @description
 */

public class ActivityEntity {
    private String name;
    private Class targetClass;

    public ActivityEntity(String name, Class targetClass) {
        this.name = name;
        this.targetClass = targetClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }
}

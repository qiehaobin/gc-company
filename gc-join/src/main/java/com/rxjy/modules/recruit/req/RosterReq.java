package com.rxjy.modules.recruit.req;

import java.io.Serializable;
import java.util.List;

/**
 *  保存 花名册
 *
 * @author mfL
 * @date 2018-12-12 14:22:38
 */

public class RosterReq implements Serializable {
    private  String courseid;
    private  String  classuuid;
    private  String uniqueCourseId;
    private List<String>  userCardEs;

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getClassuuid() {
        return classuuid;
    }

    public void setClassuuid(String classuuid) {
        this.classuuid = classuuid;
    }

    public List<String> getUserCardEs() {
        return userCardEs;
    }

    public void setUserCardEs(List<String> userCardEs) {
        this.userCardEs = userCardEs;
    }

    public String getUniqueCourseId() {
        return uniqueCourseId;
    }

    public void setUniqueCourseId(String uniqueCourseId) {
        this.uniqueCourseId = uniqueCourseId;
    }
}

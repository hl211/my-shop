package cn.binux.pojo.sys;

public class SysLogWithBLOBs extends SysLog {
    private String reqUrl;

    private String args;

    private String returnVal;

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl == null ? null : reqUrl.trim();
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args == null ? null : args.trim();
    }

    public String getReturnVal() {
        return returnVal;
    }

    public void setReturnVal(String returnVal) {
        this.returnVal = returnVal == null ? null : returnVal.trim();
    }
}
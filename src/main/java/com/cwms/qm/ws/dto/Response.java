package com.cwms.qm.ws.dto;

public class Response
{
    private String code;

    private String message;

    private String ext1;

    private String ext2;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getExt1()
    {
        return ext1;
    }

    public void setExt1(String ext1)
    {
        this.ext1 = ext1;
    }

    public String getExt2()
    {
        return ext2;
    }

    public void setExt2(String ext2)
    {
        this.ext2 = ext2;
    }

    @Override
    public String toString()
    {
        return "Response{" +
            "code='" + code + '\'' +
            ", message='" + message + '\'' +
            ", ext1='" + ext1 + '\'' +
            ", ext2='" + ext2 + '\'' +
            '}';
    }
}
